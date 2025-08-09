# Minecraft 1.21.3 Recipe/Data Generator Migration Plan for Handcrafted

## Problem Context

- **Error:** Recipe JSONs are being generated in a format that is no longer accepted by Minecraft 1.21.3 (e.g., key values as objects instead of strings, missing or incorrect fields).
- **Root Cause:** Minecraft 1.21.3 and ResourcefulLib 3.3.1 have changed how recipes, registries, and data generators work. The API now expects Holder/RegistryEntry types, Optionals, and new builder signatures. The recipe system is reworked, and registry lookups no longer return direct Item instances.
- **Symptoms:**
  - Recipe loading errors (e.g., "Failed to parse either. First: Input does not contain a key [fabric:type]...")
  - Data generator code using outdated builder signatures and registry lookups
  - Generated JSON does not match new expected format

## Key Changes in 1.21.3/Fabric

- **Recipes:**
  - Identified by `RegistryKey<? extends Recipe>`, not `Identifier`.
  - `Ingredient` is now a list of items, not item stacks.
  - Recipe builder APIs require Holder/RegistryEntry or ItemStack, not just Item.
  - Data generator should override `getRecipeGenerator` instead of `buildRecipes` (if using Fabric's generator).
- **Registries:**
  - Registry lookups return Optionals or RegistryEntry/Holder types, not direct Item instances.
  - Use `getOrThrow`, `getOptional`, or similar methods to extract values.
- **Block/Item Settings:**
  - Must set registry keys explicitly for all blocks/items.
  - Use `.registryKey(key)` in settings.

## Migration Steps

### 1. Audit and Update Registry Lookups

- [x] Replace all `BuiltInRegistries.ITEM.get(...)` usages:
  - Use `getOrThrow` or `getOptional` to get a Holder/RegistryEntry.
  - Extract the Item as needed, or pass the Holder/RegistryEntry to builder methods.
- [x] Update helper methods (e.g., `getPlanks`, `getSlab`, `getWool`) to return the correct type (Holder/RegistryEntry<Item> or Optional<Holder<Item>>).

### 2. Update Recipe Builder Calls

- [ ] Refactor all usages of `ShapedRecipeBuilder.shaped(...)` and `ShapelessRecipeBuilder.shapeless(...)`:
  - Use the new API signatures (likely requiring Holder/RegistryEntry or ItemStack, not just Item/int).
  - Update `.define()` and `.requires()` calls to use `Ingredient.of(holder)` or similar, as required.
- [ ] Update all custom recipe provider methods to match the new builder signatures.

### 3. Update Data Generator Entrypoint

- [ ] If using Fabric's data generator, override `getRecipeGenerator` instead of `buildRecipes`.
- [ ] Ensure the new method is used to register and generate recipes.

### 4. Validate Block/Item Registry Keys

- [ ] Ensure all blocks and items have their registry keys set explicitly in their settings.
- [ ] Use `.registryKey(key)` in all block/item settings as needed.

### 5. Regenerate and Test Recipes

- [ ] Run the data generator to produce new recipe JSONs.
- [ ] Check that the generated JSON matches the expected format for 1.21.3 (keys as strings, correct fields, etc.).
- [ ] Fix any remaining errors in the generated files.

### 6. Test in Minecraft

- [ ] Run the mod in a 1.21.3 environment.
- [ ] Verify that all recipes load and function correctly.
- [ ] Check for any remaining errors or warnings in the logs.

## References

- [Fabric 1.21.2/1.21.3 Update Notes](https://fabricmc.net/2024/10/14/1212.html)
- [ResourcefulLib 3.3.1 Changelog]
- [Handcrafted MIGRATION_GUIDE.md]

## Notes

- This migration will likely require iterative testing and adjustment, as some API changes may not be fully documented.
- Focus on one block/item group at a time to isolate issues.
- Commit after each successful migration step for easier rollback.

---

**Checklist:**

- [ ] Registry lookups updated
- [ ] Recipe builder calls updated
- [ ] Data generator entrypoint updated
- [ ] Registry keys set for all blocks/items
- [ ] Recipes regenerated and validated
- [ ] Mod tested in-game

---

# 1.21.3 Migration Progress & Findings (Status as of 2025-08-09)

This section documents all investigative work and implementation attempts completed so far, why certain approaches were abandoned, the current failure modes, and concrete next steps for continuation.

## Summary Timeline

1. Initial symptom after updating to 1.21.3: Hundreds of recipe parse errors (invalid fields `result.item`, injected `fabric:type`, missing `id`).
2. Determined original (NeoForge-generated) recipe JSONs in `common/src/main/generated/resources/data/**/recipe/` were being post-processed incorrectly for Fabric.
3. Implemented a Fabric-side Gradle task `transpileRecipes` (first version) to rewrite recipes (mistakenly converting `result.id -> result.item` and injecting `fabric:type`). This worsened errors (`Unknown custom ingredient serializer minecraft:item`).
4. Identified resource duplication: original recipes from `common` still loaded alongside transformed ones. Stopped extending `developmentFabric` with the custom `common` configuration to avoid double inclusion.
5. Removed / replaced brittle `@ExpectPlatform` usages that crashed at runtime (block entity type + client renderer registration) with reflection-based Fabric calls — client now launches to title/world.
6. Rewrote transpiler (current version) to sanitize instead of augment: strip `fabric:type`, ensure `result.id` exists (normalize if `item` present), recursively clean ingredients.
7. After sanitation pass and client run: New error set persists, now dominated by:

- `List is too short: 0, expected range [1-9]`
- `Map entry '#' : Failed to parse either. First: Input does not contain a key [fabric:type] ...`

## Current Implementation Details

Fabric module `build.gradle.kts` defines:

- Task `transpileRecipes` (lines ~36–110) reading every JSON file under `common/.../data/**/recipe/` and emitting to `fabric/build/generated/transpiled-recipes/...` (directory name inferred by variable but NOTE: directory does not appear in search results yet — see "Outstanding Questions").
- Logic performed:
  - Loads JSON via `JsonSlurper`.
  - For `result`: if `{ "item": X }` but no `id`, moves to `id`.
  - Removes stray `fabric:type` fields anywhere (result + ingredient objects).
  - For shaped recipes: iterates `key` map values, calling `sanitizeIngredient` (which only strips `fabric:type`).
  - For shapeless: maps `ingredients` list through the same sanitizer.
  - Writes pretty-printed JSON.
  - Forces rerun with `outputs.upToDateWhen { false }` both on transpile and processResources.
- `processResources` depends on the task and includes transpiled output.

## Findings / Root Cause Hypotheses (Updated)

1. Remaining parse errors reference two distinct validation failures:

- `List is too short: 0, expected range [1-9]` — Likely refers to a shaped recipe `pattern` array being empty OR an empty `ingredients` list for a shapeless recipe after transformation. Since the transpiler never touches `pattern`, possibility: some recipes are **not** shaped/shapeless standard types or rely on an ingredient form now invalid in 1.21.3 causing the parsed list to collapse to empty. Need to inspect one failing JSON (e.g. `blue_bowl.json`) directly from the sanitized output actually being loaded.
- `Map entry '#' : Failed to parse either. First: Input does not contain a key [fabric:type]` — Implies the deserializer tried multiple codecs; one expects a discriminating `fabric:type` key (custom ingredient serializer path), the fallbacks failed (string / array). This suggests the value associated with `'#'` is a JSON object that **does not** match the vanilla ingredient object schema now expected in 1.21.3 (schema change vs 1.21.1) OR the ingredient system now requires a wrapper object when more than one alternative form exists.

2. The earlier assumption that adding `fabric:type` was wrong _may be only partially true_ — some custom ingredient forms introduced by ResourcefulLib or Fabric 1.21.3 might indeed require a type discriminator; removing it may cause ambiguous decoding.
3. The sanitized output directory not appearing in repo searches (`**/transpiled-recipes`) suggests either:

- Output path differs from expectation (typo vs variable usage when writing?); OR
- The task writes under `fabric/build/generated/transpiled-recipes/...` (which is inside `build/`) but the quick search pattern used earlier did not capture it (possible because workspace listing was truncated). A direct filesystem inspection is needed to confirm actual emitted JSONs match what the game loaded (the game DID load something, generating errors referencing `handcrafted:recipe/...`).

4. Some recipe namespaces shown as `minecraft:<handcrafted item>_from_<color>_dye` — indicating data pack injection / advancement bridging generating a vanilla-namespace variant; ensure those are valid or exclude them during transpilation if spurious.

## What Has _Not_ Yet Been Done

- No direct comparison against **vanilla 1.21.3** recipe JSON for a simple shaped recipe (e.g., wooden_planks) to confirm expected ingredient object form.
- No inspection of one failing post-sanitization recipe file content as actually packaged inside the dev run jar / runtime classpath.
- No regeneration of recipes with updated (1.21.3-compliant) data generator API; the current pipeline still relies on legacy generator output from `common` then patching.
- No update of registry lookup / recipe builder usages in code per the initial migration checklist (still unchecked items in the plan above).

## Abandoned / Replaced Approaches

| Attempt                                                   | Result                                                                | Reason Abandoned                                        |
| --------------------------------------------------------- | --------------------------------------------------------------------- | ------------------------------------------------------- |
| Inject `fabric:type` + convert `result.id -> result.item` | Produced `Unknown custom ingredient serializer minecraft:item` errors | Misinterpreted schema; broke vanilla parsing            |
| Leave original recipes + transformed side-by-side         | Double-load & conflicting forms                                       | Pollution & ambiguous parse errors                      |
| `@ExpectPlatform` for block entity & renderer             | Runtime crashes due to signature mismatches after API shifts          | Faster to replace with reflection for Fabric-only scope |

## Current Blockers

1. Unclear correct ingredient JSON encoding for shaped key values in 1.21.3 when using objects like `{ "item": "minecraft:oak_planks" }` (why decoder requests `fabric:type`).
2. Potential mismatch between ResourcefulLib-generated ingredient structure and Fabric expectations (might need a different generator version or adaptation layer).
3. Still relying on legacy data generation — may be fundamentally incompatible with 1.21.3 without code changes (the checklist items about builder APIs remain).

## Recommended Next Steps (Prioritized)

1. Sample Inspection:

- Extract one failing packaged recipe JSON (e.g., `oak_bench.json`) from the built Fabric jar (`fabric/build/libs/handcrafted-fabric-<ver>.jar`) or the run directory and paste it alongside a vanilla shaped recipe for diff.

2. Determine Expected Schema:

- Open a vanilla 1.21.3 recipe (e.g., `data/minecraft/recipes/crafting_table.json`) from the game jar to confirm ingredient object grammar (string vs object vs array) and whether any discriminator keys now exist.

3. Minimal Reproduction:

- Manually author a tiny test recipe in `fabric/src/main/resources/data/handcrafted/recipe/test_dummy.json` with the simplest shaped recipe referencing a vanilla item. Verify if it parses; adjust until successful. Use that as a canonical template.

4. Adjust Transpiler:

- If ingredients must now be arrays (e.g. `[ { "item": "minecraft:oak_planks" } ]`), wrap singletons.
- If a discriminator (like `type` or `fabric:type`) truly required for certain custom forms, reintroduce selectively based on detection (e.g., when object has `item` or `tag` only, maybe wrap differently vs when it includes custom keys).

5. Decide Strategic Direction:

- Either continue patch-transforming legacy JSON OR update the common data generator code to 1.21.3 APIs (preferred longer-term — eliminates fragile transpile layer).

6. Implement Checklist Items:

- Update registry lookups & recipe builder calls (start with 1-2 representative recipes to unblock generation).

7. Replace Forcing Rebuilds:

- Once stable, remove `outputs.upToDateWhen { false }` and use normalized inputs.

8. Clean Up Legacy Files:

- Remove unused Fabric-specific impl classes replaced by reflection if confirmed not needed.

## Quick Diagnostic Commands (Suggested for Next Session)

1. Inspect a failing transformed recipe (adjust path if needed):

- `jar tf fabric/build/libs/handcrafted-fabric-*.jar | grep oak_bench.json`
- `jar xf ... <path>` then view contents.

2. View vanilla recipe for comparison (adjust to your local Minecraft client jar path):

- `jar tf ~/.gradle/caches/.../client-1.21.3.jar | grep crafting_table.json`
- Extract and open.

3. Insert a handcrafted test recipe with known-good vanilla syntax; run client to confirm parse.

## Hand-Off Checklist

- [ ] Capture & attach one failing packaged recipe JSON content.
- [ ] Capture a vanilla working shaped recipe JSON content.
- [ ] Decide wrap vs discriminator approach based on comparison.
- [ ] Modify transpiler accordingly (wrap objects or reintroduce minimal discriminator).
- [ ] Re-run client; confirm error count reduction.
- [ ] Begin migrating at least one recipe builder in code to new API (to validate eliminating transpiler is viable).

## Open Questions

1. Does 1.21.3 (with Fabric API) introduce a new canonical ingredient codec requiring a `type` key unless the value is a string/array? (Evidence: decoder probing for `fabric:type`.)
2. Do ResourcefulLib 3.3.1 generators emit an intermediate ingredient form expecting a follow-up adaptation layer per loader that we have bypassed?
3. Are some advancement / dye conversion recipes under `minecraft:` namespace purposely generated — should they be renamed or filtered?

---

Prepared for hand-off. See next steps above to resume.
