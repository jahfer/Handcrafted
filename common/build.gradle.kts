architectury {
    val enabledPlatforms: String by rootProject
    common(enabledPlatforms.split(","))
}

dependencies {
    // We need these for mixins to work in the common module
    modCompileOnly("net.fabricmc:fabric-loader:0.16.7")
    
    modCompileOnly(group = "tech.thatgravyboat", name = "commonats", version = "2.0")
}

// Exclude generated recipe JSONs from the common module artifact so that
// loader-specific modules (e.g. fabric) can supply their transformed versions
// without the invalid original schema causing parse errors at runtime.
tasks.named<ProcessResources>("processResources") {
    exclude("data/**/recipe/*.json")
}

// Also exclude at the sourceSet level so dev runtime (which uses source dirs)
// does not see the original recipe JSONs.
sourceSets {
    named("main") {
        resources {
            exclude("data/**/recipe/*.json")
        }
    }
}
