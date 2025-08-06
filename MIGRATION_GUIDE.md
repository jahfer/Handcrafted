# Minecraft 1.21.3 Block Registry Migration Guide

## Overview

This guide documents the migration strategy for fixing the "NullPointerException: Block id not set" errors when upgrading the Handcrafted mod from Minecraft 1.21.1 to 1.21.3. The solution involves migrating all block registrations to use ResourcefulLib's factory pattern with the main `BLOCKS` registry.

## Problem Context

Starting with Minecraft 1.21.2, the Fabric mod loader requires all blocks to have proper registry keys set during initialization. The legacy supplier pattern used with child registries doesn't automatically set these registry keys, causing crashes during mod initialization.

### Error Symptoms

- `java.lang.NullPointerException: Block id not set`
- Crash occurs during block registration in `ModBlocks.<clinit>`
- Progressive failure through child registry blocks (CUSHIONS, BENCHES, etc.)

### Root Cause

Child registries using `ResourcefulRegistry<Block>` don't support the factory pattern that automatically injects registry keys via `properties.setId(key)`.

## Solution: Option 2 - Unified Main Registry Pattern

**Strategy**: Migrate all blocks from child registries to the main `BLOCKS` registry using ResourcefulLib's factory pattern.

### Why Option 2 is Superior

1. **Proven Solution**: Already validated with OVEN, KITCHEN_HOOD, etc.
2. **Consistency**: Single pattern for all ~300+ blocks
3. **Reliability**: No compatibility issues with child registries
4. **Maintainability**: Easier to debug and maintain
5. **Future-Proof**: More likely to remain compatible as libraries evolve

## Technical Implementation

### Current Working Pattern (SUCCESS ✅)

```java
// Main registry with factory pattern support
public static final ResourcefulBlockRegistry BLOCKS = ResourcefulRegistries.createForBlocks(Handcrafted.MOD_ID);

// Working block registration
public static final RegistryEntry<Block> OVEN = BLOCKS.register("oven",
    properties -> new OvenBlock(properties),
    () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SMOKER));
```

### Legacy Pattern (FAILING ❌)

```java
// Child registry without factory pattern support
public static final ResourcefulRegistry<Block> CUSHIONS = ResourcefulRegistries.create(BLOCKS);

// Failing block registration
public static final RegistryEntry<Block> BLACK_CUSHION = CUSHIONS.register("black_cushion",
    () -> new CushionBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
```

## Migration Strategy

### Phase 1: Pattern Analysis ✅ COMPLETE

**Status**: Complete

- ✅ OVEN block successfully migrated and tested
- ✅ KITCHEN_HOOD, KITCHEN_HOOD_PIPE, BERRY_JAM_JAR, STACKABLE_BOOK also migrated
- ✅ Factory pattern confirmed working
- ✅ Crash progression validates approach (moved from OVEN to BLACK_CUSHION)

### Phase 2: Systematic Migration (IN PROGRESS)

#### Current Crash Point

- **Block**: `BLACK_CUSHION` (first block in CUSHIONS registry)
- **Registry**: `CUSHIONS` child registry
- **Line**: `ModBlocks.java:66`

#### Child Registries to Migrate

1. **CUSHIONS** (16 blocks) - CURRENT TARGET
   - BLACK_CUSHION, BLUE_CUSHION, BROWN_CUSHION, etc.
2. **BENCHES hierarchy** (13 blocks total)
   - WOODEN_BENCHES (11 blocks): ACACIA_BENCH, BAMBOO_BENCH, etc.
   - METAL_BENCHES (2 blocks): BENCH, FROZEN_BENCH
3. **COUCHES** (11 blocks)
   - ACACIA_COUCH, BAMBOO_COUCH, etc.
4. **CHAIRS** (11 blocks)
   - ACACIA_CHAIR, BAMBOO_CHAIR, etc.
5. **DINING_BENCHES** (11 blocks)
   - ACACIA_DINING_BENCH, BAMBOO_DINING_BENCH, etc.
6. **SIDE_TABLES** (11 blocks)
   - ACACIA_SIDE_TABLE, BAMBOO_SIDE_TABLE, etc.
7. **DESKS** (11 blocks)
   - ACACIA_DESK, BAMBOO_DESK, etc.
8. **NIGHTSTANDS** (11 blocks)
   - ACACIA_NIGHTSTAND, BAMBOO_NIGHTSTAND, etc.
9. **TABLES** (11 blocks)
   - ACACIA_TABLE, BAMBOO_TABLE, etc.
10. **FANCY_BEDS** (11 blocks)
    - ACACIA_FANCY_BED, BAMBOO_FANCY_BED, etc.
11. **COUNTERS** (11 blocks)
    - ACACIA_COUNTER, BAMBOO_COUNTER, etc.
12. **CUPBOARDS** (11 blocks)
    - ACACIA_CUPBOARD, BAMBOO_CUPBOARD, etc.
13. **DRAWERS** (11 blocks)
    - ACACIA_DRAWER, BAMBOO_DRAWER, etc.
14. **SHELVES** (11 blocks)
    - ACACIA_SHELF, BAMBOO_SHELF, etc.
15. **TRIMS hierarchy** (54 blocks total)
    - PILLAR_TRIMS (27 blocks)
    - CORNER_TRIMS (27 blocks)
16. **POTS** (13 blocks)
    - TERRACOTTA_THIN_POT, WHITE_GLAZED_THIN_POT, etc.
17. **TROPHIES hierarchy** (0 blocks visible in current file)
    - WALL_TROPHIES, HANGING_TROPHIES, STATUE_TROPHIES
18. **CROCKERY hierarchy** (0 blocks visible in current file)
    - CUPS, PLATES, BOWLS, CROCKERY_COMBOS

**Total Estimated Blocks**: ~300+ blocks to migrate

### Phase 3: Transformation Rules

#### Pattern Transformation

**FROM (Child Registry Supplier Pattern):**

```java
public static final RegistryEntry<Block> BLOCK_NAME = CHILD_REGISTRY.register("block_name",
    () -> new BlockClass(BlockBehaviour.Properties.ofFullCopy(BaseBlock).additionalProperties()));
```

**TO (Main Registry Factory Pattern):**

```java
public static final RegistryEntry<Block> BLOCK_NAME = BLOCKS.register("block_name",
    properties -> new BlockClass(properties),
    () -> BlockBehaviour.Properties.ofFullCopy(BaseBlock).additionalProperties());
```

#### Key Changes

1. **Registry**: `CHILD_REGISTRY.register` → `BLOCKS.register`
2. **Pattern**: Supplier `() -> new Block(props)` → Factory `properties -> new Block(properties), () -> props`
3. **Properties**: Move from constructor to separate supplier
4. **Injection**: Factory automatically receives `properties` with registry key set

### Phase 4: Implementation Steps

#### For Each Block Group:

1. **Identify Pattern**

   ```java
   // Current pattern
   REGISTRY.register("name", () -> new Block(Properties.ofFullCopy(Base).extras()))
   ```

2. **Extract Properties**

   ```java
   // Properties supplier
   () -> BlockBehaviour.Properties.ofFullCopy(Base).extras()
   ```

3. **Create Factory Function**

   ```java
   // Factory function
   properties -> new Block(properties)
   ```

4. **Apply Transformation**
   ```java
   // New pattern
   BLOCKS.register("name", properties -> new Block(properties), () -> Properties.ofFullCopy(Base).extras())
   ```

#### Special Cases

**Complex Properties (e.g., DESKS, NIGHTSTANDS):**

```java
// Before
() -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()
    .isRedstoneConductor((state, getter, pos) -> false))

// After
properties -> new DeskBlock(properties),
() -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()
    .isRedstoneConductor((state, getter, pos) -> false)
```

**Constructor Arguments (e.g., POTS, FANCY_BEDS):**

```java
// Before
() -> new PotBlock(PotBlock.PotSize.THIN, BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion())

// After
properties -> new PotBlock(PotBlock.PotSize.THIN, properties),
() -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion()
```

**Sound Types (e.g., FANCY_BEDS):**

```java
// Before
() -> new FancyBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.BAMBOO_WOOD))

// After
properties -> new FancyBedBlock(properties),
() -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.BAMBOO_WOOD)
```

### Phase 5: Validation Strategy

#### After Each Migration Batch:

1. **Compile Check**: Ensure code compiles without errors
2. **Run Test**: Execute `./gradlew :fabric:runClient`
3. **Crash Analysis**: Verify crash progresses to next unmigrated block
4. **Registry Verification**: Confirm blocks load without "Block id not set" error

#### Success Indicators:

- ✅ Compilation succeeds
- ✅ Crash moves to next child registry
- ✅ No "Block id not set" errors for migrated blocks
- ✅ Minecraft client starts successfully (final goal)

### Phase 6: Cleanup (Post-Migration)

#### Remove Unused Child Registries

Once all blocks are migrated to main registry:

```java
// These can be removed:
public static final ResourcefulRegistry<Block> CUSHIONS = ResourcefulRegistries.create(BLOCKS);
public static final ResourcefulRegistry<Block> BENCHES = ResourcefulRegistries.create(BLOCKS);
// ... etc for all child registries
```

#### Organize Main Registry

Consider grouping blocks with comments for maintainability:

```java
// ============================================================================
// CUSHIONS (migrated from CUSHIONS registry)
// ============================================================================
public static final RegistryEntry<Block> BLACK_CUSHION = BLOCKS.register("black_cushion", ...);
// ... other cushions

// ============================================================================
// WOODEN BENCHES (migrated from WOODEN_BENCHES registry)
// ============================================================================
public static final RegistryEntry<Block> ACACIA_BENCH = BLOCKS.register("acacia_bench", ...);
// ... other wooden benches
```

## Risk Mitigation

### Backup Strategy

- Work on feature branch
- Commit after each successful block group migration
- Keep migration guide for rollback reference

### Testing Strategy

- Incremental testing after each group
- Validate crash progression confirms fix
- Final end-to-end test with full mod functionality

### Error Handling

- If compilation fails: Check constructor compatibility
- If crash persists: Verify factory pattern syntax
- If new errors appear: Check for missing imports

## Progress Tracking

### ✅ Completed

- [x] Main BLOCKS registry converted to ResourcefulBlockRegistry
- [x] OVEN block migration (proof of concept)
- [x] KITCHEN_HOOD, KITCHEN_HOOD_PIPE, BERRY_JAM_JAR, STACKABLE_BOOK migrations
- [x] Pattern validation and testing

### 🔄 In Progress

- [ ] CUSHIONS registry (16 blocks) - NEXT TARGET

### 📋 Pending

- [ ] BENCHES hierarchy (13 blocks)
- [ ] COUCHES (11 blocks)
- [ ] CHAIRS (11 blocks)
- [ ] DINING_BENCHES (11 blocks)
- [ ] SIDE_TABLES (11 blocks)
- [ ] DESKS (11 blocks)
- [ ] NIGHTSTANDS (11 blocks)
- [ ] TABLES (11 blocks)
- [ ] FANCY_BEDS (11 blocks)
- [ ] COUNTERS (11 blocks)
- [ ] CUPBOARDS (11 blocks)
- [ ] DRAWERS (11 blocks)
- [ ] SHELVES (11 blocks)
- [ ] TRIMS hierarchy (54 blocks)
- [ ] POTS (13 blocks)
- [ ] Any remaining TROPHIES/CROCKERY blocks

## Implementation Priority

### Priority 1: Direct Child Registries

Start with registries that inherit directly from BLOCKS:

- CUSHIONS, COUCHES, CHAIRS, etc.

### Priority 2: Nested Child Registries

Handle registries that inherit from other child registries:

- WOODEN_BENCHES (inherits from BENCHES)
- METAL_BENCHES (inherits from BENCHES)
- PILLAR_TRIMS (inherits from TRIMS)
- CORNER_TRIMS (inherits from TRIMS)

### Priority 3: Deep Nested Registries

Handle registries with complex inheritance:

- CUPS, PLATES, BOWLS, CROCKERY_COMBOS (inherit from CROCKERY)
- WALL_TROPHIES, HANGING_TROPHIES, STATUE_TROPHIES (inherit from TROPHIES)

## Expected Outcome

Upon successful completion:

- All ~300+ blocks use the main BLOCKS registry with factory pattern
- Registry keys are automatically set for all blocks
- "Block id not set" errors completely eliminated
- Minecraft 1.21.3 compatibility fully restored
- Handcrafted mod loads and functions normally

## Notes

- Factory pattern automatically handles registry key injection
- Properties supplier separation is crucial for proper initialization
- ResourcefulBlockRegistry only works with main registry, not child registries
- Migration must be done systematically to track progress via crash progression
- Each successful migration moves the crash to the next unmigrated block, confirming progress
