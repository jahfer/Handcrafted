architectury {
    fabric()
}

val common: Configuration by configurations.creating {
    configurations.compileClasspath.get().extendsFrom(this)
    configurations.runtimeClasspath.get().extendsFrom(this)
    // Do NOT extend developmentFabric to avoid loading original common resources (recipes)
    // into the dev runtime. We ship transpiled recipes from this module instead.
    // configurations["developmentFabric"].extendsFrom(this)
}

dependencies {
    common(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) {
        isTransitive = false
    }

    val minecraftVersion: String by project
    val fabricLoaderVersion: String by project
    val fabricApiVersion: String by project
    val modMenuVersion: String by project

    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = fabricLoaderVersion)
    modApi(group = "net.fabricmc.fabric-api", name = "fabric-api", version = "$fabricApiVersion+$minecraftVersion")

    modApi(group = "com.terraformersmc", name = "modmenu", version = modMenuVersion)
}

// Transpile NeoForge-generated recipes to Fabric schema and include them in Fabric resources
val transpiledRecipesDir = layout.buildDirectory.dir("generated/transpiled-recipes")
val commonGeneratedDir = rootProject.layout.projectDirectory.dir("common/src/main/generated/resources")

tasks.register("transpileRecipes") {
    description = "Sanitize generated recipe JSONs for Fabric (ensure result.id, strip fabric:type)"
    group = "build"
    inputs.dir(commonGeneratedDir)
    outputs.dir(transpiledRecipesDir)
    // Always run to reflect transformer tweaks without needing a clean
    outputs.upToDateWhen { false }
    doLast {
        val slurper = groovy.json.JsonSlurper()
        val outDir = transpiledRecipesDir.get().asFile
        val inDir = commonGeneratedDir.asFile
        if (!inDir.exists()) return@doLast

        fun sanitizeIngredient(node: Any?): Any? {
            return when (node) {
                is String -> node
                is List<*> -> node.map { sanitizeIngredient(it) }
                is Map<*, *> -> {
                    @Suppress("UNCHECKED_CAST")
                    val m = node.toMutableMap() as MutableMap<String, Any?>
                    // Strip legacy key
                    m.remove("fabric:type")
                    // NEW 1.21.3 NORMALIZATION:
                    // Ingredient object forms like {"item":"minecraft:oak_planks"} or {"tag":"minecraft:planks"}
                    // are rejected by the new codec chain (errors show it now expects either:
                    //  - string (single item id)
                    //  - string starting with '#' for a tag
                    //  - array of the above
                    // Any object form without a discriminator (e.g. fabric:type) fails the first branch,
                    // then fails the fallback (string/array) producing current errors.
                    // So collapse the simple map into its canonical string representation.
                    if (m.size == 1) {
                        val onlyKey = m.keys.first()
                        val v = m[onlyKey]
                        if (v is String) {
                            return when (onlyKey) {
                                "item" -> v
                                "tag" -> "#$v"
                                else -> m
                            }
                        }
                    }
                    m
                }
                else -> node
            }
        }
        var count = 0
        var simpleConverted = 0
        // 1) Transform recipes
        inDir.walkTopDown()
            .filter { it.isFile && it.extension == "json" && it.path.contains("/data/") && it.path.contains("/recipe/") }
            .forEach { file ->
                val rel = file.relativeTo(inDir)
                val target = outDir.resolve(rel)
                target.parentFile.mkdirs()
                val obj = slurper.parse(file) as Map<*, *>
                @Suppress("UNCHECKED_CAST")
                val mutable = obj.toMutableMap() as MutableMap<String, Any?>
                val resultVal = mutable["result"]
                if (resultVal is Map<*, *>) {
                    val resMap = resultVal.toMutableMap() as MutableMap<String, Any?>
                    if (resMap.containsKey("item") && !resMap.containsKey("id")) {
                        resMap["id"] = resMap.remove("item")!!
                    }
                    resMap.remove("fabric:type")
                    mutable["result"] = resMap
                }
                val keyVal = mutable["key"]
                if (keyVal is Map<*, *>) {
                    @Suppress("UNCHECKED_CAST")
                    val keyMap = keyVal.toMutableMap() as MutableMap<String, Any?>
                    keyMap.keys.toList().forEach { sym ->
                        val before = keyMap[sym]
                        val after = sanitizeIngredient(before)
                        if (before !== after && after is String) simpleConverted++
                        keyMap[sym] = after
                    }
                    mutable["key"] = keyMap
                }
                val ingredientsVal = mutable["ingredients"]
                if (ingredientsVal is List<*>) {
                    val fixed = ingredientsVal.map {
                        val before = it
                        val after = sanitizeIngredient(before)
                        if (before !== after && after is String) simpleConverted++
                        after
                    }
                    mutable["ingredients"] = fixed
                }
                val json = groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(mutable))
                target.writeText(json)
                count++
            }

        // 2) Pass-through required generated data (tags, advancements, loot tables, etc.) EXCLUDING original recipes
        var copied = 0
        inDir.walkTopDown()
            .filter { it.isFile && it.extension == "json" && it.path.contains("/data/") && !it.path.contains("/recipe/") }
            .forEach { file ->
                // Only copy selected directories we need for correct recipe resolution (tags first)
                val rel = file.relativeTo(inDir).path
                val include = rel.contains("/tags/") || rel.contains("/advancement/") || rel.contains("/loot_table/")
                if (!include) return@forEach
                val target = outDir.resolve(file.relativeTo(inDir))
                if (!target.exists()) {
                    target.parentFile.mkdirs()
                    target.writeText(file.readText())
                    copied++
                }
            }

        println("[transpileRecipes] Transpiled $count recipe JSON(s) (collapsed $simpleConverted simple ingredient objects); copied $copied supplemental data file(s) into ${outDir.relativeTo(project.projectDir)}")
    }
}

tasks.named<ProcessResources>("processResources") {
    dependsOn("transpileRecipes")
    // Make transpiled directory an explicit input so changes trigger rerun
    inputs.dir(transpiledRecipesDir)
    // Include transpiled recipes
    from(transpiledRecipesDir)
    // Temporarily force re-run until incremental inputs/outputs refined so recipes actually copy
    outputs.upToDateWhen { false }
    doLast { println("[processResources] Included transpiled recipes from ${transpiledRecipesDir.get().asFile.relativeTo(project.projectDir)}") }
}
