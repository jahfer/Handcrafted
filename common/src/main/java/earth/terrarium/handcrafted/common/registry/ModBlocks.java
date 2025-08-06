package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blocks.*;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryComboBlock;
import earth.terrarium.handcrafted.common.blocks.misc.*;
import earth.terrarium.handcrafted.common.blocks.trims.CornerTrimBlock;
import earth.terrarium.handcrafted.common.blocks.trims.PillarTrimBlock;
import earth.terrarium.handcrafted.common.blocks.trophies.HangingTrophyBlock;
import earth.terrarium.handcrafted.common.blocks.trophies.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.blocks.trophies.WallTrophyBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final ResourcefulBlockRegistry BLOCKS = ResourcefulRegistries.createForBlocks(Handcrafted.MOD_ID);

    public static final ResourcefulRegistry<Block> CUSHIONS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> BENCHES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> WOODEN_BENCHES = ResourcefulRegistries.create(BENCHES);
    public static final ResourcefulRegistry<Block> METAL_BENCHES = ResourcefulRegistries.create(BENCHES);
    public static final ResourcefulRegistry<Block> COUCHES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CHAIRS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> DINING_BENCHES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> SIDE_TABLES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> DESKS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> NIGHTSTANDS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> TABLES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> FANCY_BEDS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> COUNTERS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CUPBOARDS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> DRAWERS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> SHELVES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> POTS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> TRIMS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> PILLAR_TRIMS = ResourcefulRegistries.create(TRIMS);
    public static final ResourcefulRegistry<Block> CORNER_TRIMS = ResourcefulRegistries.create(TRIMS);
    public static final ResourcefulRegistry<Block> TROPHIES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> WALL_TROPHIES = ResourcefulRegistries.create(TROPHIES);
    public static final ResourcefulRegistry<Block> HANGING_TROPHIES = ResourcefulRegistries.create(TROPHIES);
    public static final ResourcefulRegistry<Block> STATUE_TROPHIES = ResourcefulRegistries.create(TROPHIES);
    public static final ResourcefulRegistry<Block> CROCKERY = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CUPS = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Block> PLATES = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Block> BOWLS = ResourcefulRegistries.create(CROCKERY);
    public static final ResourcefulRegistry<Block> CROCKERY_COMBOS = ResourcefulRegistries.create(CROCKERY);

    public static final RegistryEntry<Block> OVEN = BLOCKS.register("oven",
            properties -> new OvenBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SMOKER));
    public static final RegistryEntry<Block> KITCHEN_HOOD = BLOCKS.register("kitchen_hood",
            properties -> new KitchenHoodBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> KITCHEN_HOOD_PIPE = BLOCKS.register("kitchen_hood_pipe",
            properties -> new KitchenHoodPipeBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> BERRY_JAM_JAR = BLOCKS.register("berry_jam_jar",
            properties -> new StackableJarBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> STACKABLE_BOOK = BLOCKS.register("stackable_book",
            properties -> new StackableBookBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));

    public static final RegistryEntry<Block> BLACK_CUSHION = BLOCKS.register("black_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> BLUE_CUSHION = BLOCKS.register("blue_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> BROWN_CUSHION = BLOCKS.register("brown_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> CYAN_CUSHION = BLOCKS.register("cyan_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> GRAY_CUSHION = BLOCKS.register("gray_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> GREEN_CUSHION = BLOCKS.register("green_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> LIGHT_BLUE_CUSHION = BLOCKS.register("light_blue_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> LIGHT_GRAY_CUSHION = BLOCKS.register("light_gray_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> LIME_CUSHION = BLOCKS.register("lime_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> MAGENTA_CUSHION = BLOCKS.register("magenta_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> ORANGE_CUSHION = BLOCKS.register("orange_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> PINK_CUSHION = BLOCKS.register("pink_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> PURPLE_CUSHION = BLOCKS.register("purple_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> RED_CUSHION = BLOCKS.register("red_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> WHITE_CUSHION = BLOCKS.register("white_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));
    public static final RegistryEntry<Block> YELLOW_CUSHION = BLOCKS.register("yellow_cushion",
            properties -> new CushionBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL));

    public static final RegistryEntry<Block> ACACIA_BENCH = BLOCKS.register("acacia_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_BENCH = BLOCKS.register("bamboo_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_BENCH = BLOCKS.register("birch_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_BENCH = BLOCKS.register("cherry_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_BENCH = BLOCKS.register("crimson_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_BENCH = BLOCKS.register("dark_oak_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_BENCH = BLOCKS.register("jungle_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_BENCH = BLOCKS.register("mangrove_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_BENCH = BLOCKS.register("oak_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_BENCH = BLOCKS.register("spruce_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_BENCH = BLOCKS.register("warped_bench",
            properties -> new BenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> BENCH = BLOCKS.register("bench",
            properties -> new MetalBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> FROZEN_BENCH = BLOCKS.register("frozen_bench",
            properties -> new MetalBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_COUCH = BLOCKS.register("acacia_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_COUCH = BLOCKS.register("bamboo_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_COUCH = BLOCKS.register("birch_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_COUCH = BLOCKS.register("cherry_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_COUCH = BLOCKS.register("crimson_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_COUCH = BLOCKS.register("dark_oak_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_COUCH = BLOCKS.register("jungle_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_COUCH = BLOCKS.register("mangrove_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_COUCH = BLOCKS.register("oak_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_COUCH = BLOCKS.register("spruce_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_COUCH = BLOCKS.register("warped_couch",
            properties -> new CouchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_CHAIR = BLOCKS.register("acacia_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_CHAIR = BLOCKS.register("bamboo_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_CHAIR = BLOCKS.register("birch_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_CHAIR = BLOCKS.register("cherry_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_CHAIR = BLOCKS.register("crimson_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_CHAIR = BLOCKS.register("jungle_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_CHAIR = BLOCKS.register("mangrove_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_CHAIR = BLOCKS.register("oak_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_CHAIR = BLOCKS.register("spruce_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_CHAIR = BLOCKS.register("warped_chair",
            properties -> new ChairBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_DINING_BENCH = BLOCKS.register("acacia_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_DINING_BENCH = BLOCKS.register("bamboo_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_DINING_BENCH = BLOCKS.register("birch_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_DINING_BENCH = BLOCKS.register("cherry_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_DINING_BENCH = BLOCKS.register("crimson_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_DINING_BENCH = BLOCKS.register("dark_oak_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_DINING_BENCH = BLOCKS.register("jungle_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_DINING_BENCH = BLOCKS.register("mangrove_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_DINING_BENCH = BLOCKS.register("oak_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_DINING_BENCH = BLOCKS.register("spruce_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_DINING_BENCH = BLOCKS.register("warped_dining_bench",
            properties -> new DiningBenchBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_SIDE_TABLE = BLOCKS.register("acacia_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_SIDE_TABLE = BLOCKS.register("bamboo_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_SIDE_TABLE = BLOCKS.register("birch_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_SIDE_TABLE = BLOCKS.register("cherry_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_SIDE_TABLE = BLOCKS.register("crimson_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_SIDE_TABLE = BLOCKS.register("dark_oak_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_SIDE_TABLE = BLOCKS.register("jungle_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_SIDE_TABLE = BLOCKS.register("mangrove_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_SIDE_TABLE = BLOCKS.register("oak_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_SIDE_TABLE = BLOCKS.register("spruce_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_SIDE_TABLE = BLOCKS.register("warped_side_table",
            properties -> new SideTableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_DESK = BLOCKS.register("acacia_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_DESK = BLOCKS.register("bamboo_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_DESK = BLOCKS.register("birch_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_DESK = BLOCKS.register("cherry_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_DESK = BLOCKS.register("crimson_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_DESK = BLOCKS.register("dark_oak_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_DESK = BLOCKS.register("jungle_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_DESK = BLOCKS.register("mangrove_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_DESK = BLOCKS.register("oak_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_DESK = BLOCKS.register("spruce_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_DESK = BLOCKS.register("warped_desk",
            properties -> new DeskBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_NIGHTSTAND = BLOCKS.register("acacia_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_NIGHTSTAND = BLOCKS.register("bamboo_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_NIGHTSTAND = BLOCKS.register("birch_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_NIGHTSTAND = BLOCKS.register("cherry_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_NIGHTSTAND = BLOCKS.register("crimson_nightstand",
            properties -> new NightstandBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_NIGHTSTAND = BLOCKS.register("dark_oak_nightstand",
            properties -> new NightstandBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_NIGHTSTAND = BLOCKS.register("jungle_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_NIGHTSTAND = BLOCKS.register("mangrove_nightstand",
            properties -> new NightstandBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_NIGHTSTAND = BLOCKS.register("oak_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_NIGHTSTAND = BLOCKS.register("spruce_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_NIGHTSTAND = BLOCKS.register("warped_nightstand",
            properties -> new NightstandBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion().isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_TABLE = BLOCKS.register("acacia_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_TABLE = BLOCKS.register("bamboo_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_TABLE = BLOCKS.register("birch_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_TABLE = BLOCKS.register("cherry_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_TABLE = BLOCKS.register("crimson_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_TABLE = BLOCKS.register("jungle_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_TABLE = BLOCKS.register("mangrove_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_TABLE = BLOCKS.register("oak_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_TABLE = BLOCKS.register("spruce_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_TABLE = BLOCKS.register("warped_table",
            properties -> new TableBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> ACACIA_FANCY_BED = BLOCKS.register("acacia_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> BAMBOO_FANCY_BED = BLOCKS.register("bamboo_fancy_bed",
            properties -> new FancyBedBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.BAMBOO_WOOD));
    public static final RegistryEntry<Block> BIRCH_FANCY_BED = BLOCKS.register("birch_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> CHERRY_FANCY_BED = BLOCKS.register("cherry_fancy_bed",
            properties -> new FancyBedBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.CHERRY_WOOD));
    public static final RegistryEntry<Block> DARK_OAK_FANCY_BED = BLOCKS.register("dark_oak_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> CRIMSON_FANCY_BED = BLOCKS.register("crimson_fancy_bed",
            properties -> new FancyBedBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.NETHER_WOOD));
    public static final RegistryEntry<Block> JUNGLE_FANCY_BED = BLOCKS.register("jungle_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> MANGROVE_FANCY_BED = BLOCKS.register("mangrove_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> OAK_FANCY_BED = BLOCKS.register("oak_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> SPRUCE_FANCY_BED = BLOCKS.register("spruce_fancy_bed",
            properties -> new FancyBedBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED));
    public static final RegistryEntry<Block> WARPED_FANCY_BED = BLOCKS.register("warped_fancy_bed",
            properties -> new FancyBedBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_BED).sound(SoundType.NETHER_WOOD));

    public static final RegistryEntry<Block> ACACIA_COUNTER = BLOCKS.register("acacia_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_COUNTER = BLOCKS.register("bamboo_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_COUNTER = BLOCKS.register("birch_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_COUNTER = BLOCKS.register("cherry_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_COUNTER = BLOCKS.register("crimson_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CRIMSON_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_COUNTER = BLOCKS.register("dark_oak_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DARK_OAK_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_COUNTER = BLOCKS.register("jungle_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_COUNTER = BLOCKS.register("mangrove_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.MANGROVE_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_COUNTER = BLOCKS.register("oak_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_COUNTER = BLOCKS.register("spruce_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_COUNTER = BLOCKS.register("warped_counter",
            properties -> new CounterBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_CUPBOARD = BLOCKS.register("acacia_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.ACACIA_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_CUPBOARD = BLOCKS.register("bamboo_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BAMBOO_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_CUPBOARD = BLOCKS.register("birch_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_CUPBOARD = BLOCKS.register("cherry_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_CUPBOARD = BLOCKS.register("crimson_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CRIMSON_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_CUPBOARD = BLOCKS.register("dark_oak_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DARK_OAK_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_CUPBOARD = BLOCKS.register("jungle_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.JUNGLE_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_CUPBOARD = BLOCKS.register("mangrove_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.MANGROVE_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_CUPBOARD = BLOCKS.register("oak_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_CUPBOARD = BLOCKS.register("spruce_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SPRUCE_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_CUPBOARD = BLOCKS.register("warped_cupboard",
            properties -> new CupboardBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.WARPED_PLANKS).isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_DRAWER = BLOCKS.register("acacia_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_DRAWER = BLOCKS.register("bamboo_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_DRAWER = BLOCKS.register("birch_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_DRAWER = BLOCKS.register("cherry_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_DRAWER = BLOCKS.register("crimson_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_DRAWER = BLOCKS.register("dark_oak_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DARK_OAK_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_DRAWER = BLOCKS.register("jungle_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_DRAWER = BLOCKS.register("mangrove_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties
                    .ofFullCopy(Blocks.MANGROVE_PLANKS).isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_DRAWER = BLOCKS.register("oak_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_DRAWER = BLOCKS.register("spruce_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_DRAWER = BLOCKS.register("warped_drawer",
            properties -> new DrawerBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_SHELF = BLOCKS.register("acacia_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BAMBOO_SHELF = BLOCKS.register("bamboo_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> BIRCH_SHELF = BLOCKS.register("birch_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CHERRY_SHELF = BLOCKS.register("cherry_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> CRIMSON_SHELF = BLOCKS.register("crimson_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> DARK_OAK_SHELF = BLOCKS.register("dark_oak_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> JUNGLE_SHELF = BLOCKS.register("jungle_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> MANGROVE_SHELF = BLOCKS.register("mangrove_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> OAK_SHELF = BLOCKS.register("oak_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> SPRUCE_SHELF = BLOCKS.register("spruce_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));
    public static final RegistryEntry<Block> WARPED_SHELF = BLOCKS.register("warped_shelf",
            properties -> new ShelfBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
                    .isRedstoneConductor((state, getter, pos) -> false));

    public static final RegistryEntry<Block> ACACIA_PILLAR_TRIM = BLOCKS.register("acacia_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> ACACIA_CORNER_TRIM = BLOCKS.register("acacia_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_PILLAR_TRIM = BLOCKS.register("bamboo_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BAMBOO_CORNER_TRIM = BLOCKS.register("bamboo_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_PILLAR_TRIM = BLOCKS.register("birch_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BIRCH_CORNER_TRIM = BLOCKS.register("birch_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_PILLAR_TRIM = BLOCKS.register("cherry_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CHERRY_CORNER_TRIM = BLOCKS.register("cherry_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_PILLAR_TRIM = BLOCKS.register("crimson_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> CRIMSON_CORNER_TRIM = BLOCKS.register("crimson_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_PILLAR_TRIM = BLOCKS.register("dark_oak_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> DARK_OAK_CORNER_TRIM = BLOCKS.register("dark_oak_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_PILLAR_TRIM = BLOCKS.register("jungle_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> JUNGLE_CORNER_TRIM = BLOCKS.register("jungle_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_PILLAR_TRIM = BLOCKS.register("mangrove_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> MANGROVE_CORNER_TRIM = BLOCKS.register("mangrove_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_PILLAR_TRIM = BLOCKS.register("oak_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> OAK_CORNER_TRIM = BLOCKS.register("oak_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_PILLAR_TRIM = BLOCKS.register("spruce_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPRUCE_CORNER_TRIM = BLOCKS.register("spruce_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_PILLAR_TRIM = BLOCKS.register("warped_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WARPED_CORNER_TRIM = BLOCKS.register("warped_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> ANDESITE_PILLAR_TRIM = BLOCKS.register("andesite_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).noOcclusion());
    public static final RegistryEntry<Block> ANDESITE_CORNER_TRIM = BLOCKS.register("andesite_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).noOcclusion());
    public static final RegistryEntry<Block> BLACKSTONE_PILLAR_TRIM = BLOCKS.register("blackstone_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion());
    public static final RegistryEntry<Block> BLACKSTONE_CORNER_TRIM = BLOCKS.register("blackstone_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion());
    public static final RegistryEntry<Block> BRICKS_PILLAR_TRIM = BLOCKS.register("bricks_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion());
    public static final RegistryEntry<Block> BRICKS_CORNER_TRIM = BLOCKS.register("bricks_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion());
    public static final RegistryEntry<Block> CALCITE_PILLAR_TRIM = BLOCKS.register("calcite_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).noOcclusion());
    public static final RegistryEntry<Block> CALCITE_CORNER_TRIM = BLOCKS.register("calcite_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).noOcclusion());
    public static final RegistryEntry<Block> DEEPSLATE_PILLAR_TRIM = BLOCKS.register("deepslate_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion());
    public static final RegistryEntry<Block> DEEPSLATE_CORNER_TRIM = BLOCKS.register("deepslate_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion());
    public static final RegistryEntry<Block> DIORITE_PILLAR_TRIM = BLOCKS.register("diorite_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).noOcclusion());
    public static final RegistryEntry<Block> DIORITE_CORNER_TRIM = BLOCKS.register("diorite_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).noOcclusion());
    public static final RegistryEntry<Block> DRIPSTONE_PILLAR_TRIM = BLOCKS.register("dripstone_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> DRIPSTONE_CORNER_TRIM = BLOCKS.register("dripstone_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> GRANITE_PILLAR_TRIM = BLOCKS.register("granite_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).noOcclusion());
    public static final RegistryEntry<Block> GRANITE_CORNER_TRIM = BLOCKS.register("granite_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).noOcclusion());
    public static final RegistryEntry<Block> QUARTZ_PILLAR_TRIM = BLOCKS.register("quartz_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> QUARTZ_CORNER_TRIM = BLOCKS.register("quartz_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> STONE_PILLAR_TRIM = BLOCKS.register("stone_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final RegistryEntry<Block> STONE_CORNER_TRIM = BLOCKS.register("stone_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final RegistryEntry<Block> SANDSTONE_PILLAR_TRIM = BLOCKS.register("sandstone_pillar_trim",
            properties -> new PillarTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion());
    public static final RegistryEntry<Block> SANDSTONE_CORNER_TRIM = BLOCKS.register("sandstone_corner_trim",
            properties -> new CornerTrimBlock(true, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion());
    public static final RegistryEntry<Block> RED_SANDSTONE_PILLAR_TRIM = BLOCKS.register("red_sandstone_pillar_trim",
            properties -> new PillarTrimBlock(false, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion());
    public static final RegistryEntry<Block> RED_SANDSTONE_CORNER_TRIM = BLOCKS.register("red_sandstone_corner_trim",
            properties -> new CornerTrimBlock(false, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion());

    public static final RegistryEntry<Block> TERRACOTTA_THIN_POT = BLOCKS.register("terracotta_thin_pot",
            properties -> new PotBlock(PotBlock.PotSize.THIN, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_MEDIUM_POT = BLOCKS.register("terracotta_medium_pot",
            properties -> new PotBlock(PotBlock.PotSize.MEDIUM, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_WIDE_POT = BLOCKS.register("terracotta_wide_pot",
            properties -> new PotBlock(PotBlock.PotSize.WIDE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_THICK_POT = BLOCKS.register("terracotta_thick_pot",
            properties -> new PotBlock(PotBlock.PotSize.THICK, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> WHITE_GLAZED_THIN_POT = BLOCKS.register("white_glazed_thin_pot",
            properties -> new PotBlock(PotBlock.PotSize.THIN, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> WHITE_GLAZED_MEDIUM_POT = BLOCKS.register("white_glazed_medium_pot",
            properties -> new PotBlock(PotBlock.PotSize.MEDIUM, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> WHITE_GLAZED_WIDE_POT = BLOCKS.register("white_glazed_wide_pot",
            properties -> new PotBlock(PotBlock.PotSize.WIDE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> WHITE_GLAZED_THICK_POT = BLOCKS.register("white_glazed_thick_pot",
            properties -> new PotBlock(PotBlock.PotSize.THICK, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> BLUE_GLAZED_THIN_POT = BLOCKS.register("blue_glazed_thin_pot",
            properties -> new PotBlock(PotBlock.PotSize.THIN, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> BLUE_GLAZED_MEDIUM_POT = BLOCKS.register("blue_glazed_medium_pot",
            properties -> new PotBlock(PotBlock.PotSize.MEDIUM, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> BLUE_GLAZED_WIDE_POT = BLOCKS.register("blue_glazed_wide_pot",
            properties -> new PotBlock(PotBlock.PotSize.WIDE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> BLUE_GLAZED_THICK_POT = BLOCKS.register("blue_glazed_thick_pot",
            properties -> new PotBlock(PotBlock.PotSize.THICK, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> GOLDEN_THIN_POT = BLOCKS.register("golden_thin_pot",
            properties -> new PotBlock(PotBlock.PotSize.THIN, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> GOLDEN_MEDIUM_POT = BLOCKS.register("golden_medium_pot",
            properties -> new PotBlock(PotBlock.PotSize.MEDIUM, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> GOLDEN_WIDE_POT = BLOCKS.register("golden_wide_pot",
            properties -> new PotBlock(PotBlock.PotSize.WIDE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion());
    public static final RegistryEntry<Block> GOLDEN_THICK_POT = BLOCKS.register("golden_thick_pot",
            properties -> new PotBlock(PotBlock.PotSize.THICK, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion());

    public static final RegistryEntry<Block> BEAR_TROPHY = BLOCKS.register("bear_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> BLAZE_TROPHY = BLOCKS.register("blaze_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> FOX_TROPHY = BLOCKS.register("fox_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> GOAT_TROPHY = BLOCKS.register("goat_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> PUFFERFISH_TROPHY = BLOCKS.register("pufferfish_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SALMON_TROPHY = BLOCKS.register("salmon_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SILVERFISH_TROPHY = BLOCKS.register("silverfish_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SKELETON_HORSE_TROPHY = BLOCKS.register("skeleton_horse_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SPIDER_TROPHY = BLOCKS.register("spider_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TROPICAL_FISH_TROPHY = BLOCKS.register("tropical_fish_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WITHER_SKELETON_TROPHY = BLOCKS.register("wither_skeleton_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> WOLF_TROPHY = BLOCKS.register("wolf_trophy",
            properties -> new WallTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> PHANTOM_TROPHY = BLOCKS.register("phantom_trophy",
            properties -> new HangingTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());

    public static final RegistryEntry<Block> CREEPER_TROPHY = BLOCKS.register("creeper_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> SKELETON_TROPHY = BLOCKS.register("skeleton_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> EVOKER_TROPHY = BLOCKS.register("evoker_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final RegistryEntry<Block> PILLAGER_TROPHY = BLOCKS.register("pillager_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final RegistryEntry<Block> VINDICATOR_TROPHY = BLOCKS.register("vindicator_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());
    public static final RegistryEntry<Block> WITCH_TROPHY = BLOCKS.register("witch_trophy",
            properties -> new StatueTrophyBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion());

    public static final RegistryEntry<Block> WHITE_CUP = BLOCKS.register("white_cup",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> YELLOW_CUP = BLOCKS.register("yellow_cup",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> BLUE_CUP = BLOCKS.register("blue_cup",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> WOOD_CUP = BLOCKS.register("wood_cup",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_CUP = BLOCKS.register("terracotta_cup",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion());

    public static final RegistryEntry<Block> WHITE_PLATE = BLOCKS.register("white_plate",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> YELLOW_PLATE = BLOCKS.register("yellow_plate",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> BLUE_PLATE = BLOCKS.register("blue_plate",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> WOOD_PLATE = BLOCKS.register("wood_plate",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_PLATE = BLOCKS.register("terracotta_plate",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion());

    public static final RegistryEntry<Block> WHITE_BOWL = BLOCKS.register("white_bowl",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> YELLOW_BOWL = BLOCKS.register("yellow_bowl",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> BLUE_BOWL = BLOCKS.register("blue_bowl",
            properties -> new CrockeryBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> WOOD_BOWL = BLOCKS.register("wood_bowl",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_BOWL = BLOCKS.register("terracotta_bowl",
            properties -> new CrockeryBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion());

    public static final RegistryEntry<Block> WHITE_CROCKERY_COMBO = BLOCKS.register("white_crockery_combo",
            properties -> new CrockeryComboBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> YELLOW_CROCKERY_COMBO = BLOCKS.register("yellow_crockery_combo",
            properties -> new CrockeryComboBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> BLUE_CROCKERY_COMBO = BLOCKS.register("blue_crockery_combo",
            properties -> new CrockeryComboBlock(properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final RegistryEntry<Block> WOOD_CROCKERY_COMBO = BLOCKS.register("wood_crockery_combo",
            properties -> new CrockeryComboBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final RegistryEntry<Block> TERRACOTTA_CROCKERY_COMBO = BLOCKS.register("terracotta_crockery_combo",
            properties -> new CrockeryComboBlock(properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion());
}
