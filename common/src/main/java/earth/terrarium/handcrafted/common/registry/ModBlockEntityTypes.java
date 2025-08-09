package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blockentities.ContainerBlockEntity;
import earth.terrarium.handcrafted.common.blockentities.OvenBlockEntity;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
// Temporarily inlined Fabric implementation while multi-loader ExpectPlatform injection
// is disabled for the Fabric-only migration.

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ModBlockEntityTypes {
        public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Handcrafted.MOD_ID);

        public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(
                        BiFunction<BlockPos, BlockState, T> factory, net.minecraft.world.level.block.Block... blocks) {
                try {
                        // Try Fabric builder with Factory interface
                        Class<?> builderClazz = Class.forName(
                                        "net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder");
                        Class<?> factoryInterface = Class.forName(
                                        "net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder$Factory");

                        // Create a Factory wrapper for the BiFunction
                        Object fabricFactory = java.lang.reflect.Proxy.newProxyInstance(
                                        factoryInterface.getClassLoader(),
                                        new Class[] { factoryInterface },
                                        (proxy, method, args) -> {
                                                if ("create".equals(method.getName()) && args.length == 2) {
                                                        BlockPos pos = (BlockPos) args[0];
                                                        BlockState state = (BlockState) args[1];
                                                        return factory.apply(pos, state);
                                                }
                                                throw new UnsupportedOperationException(
                                                                "Method not supported: " + method.getName());
                                        });

                        java.lang.reflect.Method create = builderClazz.getMethod("create", factoryInterface,
                                        net.minecraft.world.level.block.Block[].class);
                        Object fabricBuilder = create.invoke(null, fabricFactory, blocks);
                        java.lang.reflect.Method build = fabricBuilder.getClass().getMethod("build");
                        @SuppressWarnings("unchecked")
                        BlockEntityType<T> type = (BlockEntityType<T>) build.invoke(fabricBuilder);
                        return type;
                } catch (ClassNotFoundException e) {
                        throw new RuntimeException(
                                        "Fabric BlockEntityType builder not available - this branch targets Fabric only",
                                        e);
                } catch (Throwable t) {
                        throw new RuntimeException("Failed to create BlockEntityType via Fabric builder", t);
                }
        }

        public static final RegistryEntry<BlockEntityType<OvenBlockEntity>> OVEN = BLOCK_ENTITY_TYPES.register("oven",
                        () -> createBlockEntityType(OvenBlockEntity::new, ModBlocks.OVEN.get()));
        public static final RegistryEntry<BlockEntityType<CrockeryBlockEntity>> CROCKERY = BLOCK_ENTITY_TYPES
                        .register("crockery", () -> createBlockEntityType(CrockeryBlockEntity::new,
                                        ModBlocks.CROCKERY_COMBOS.stream().map(RegistryEntry::get)
                                                        .toArray(net.minecraft.world.level.block.Block[]::new)));
        public static final RegistryEntry<BlockEntityType<ContainerBlockEntity>> CONTAINER;

        static {
                List<RegistryEntry<net.minecraft.world.level.block.Block>> entries = new ArrayList<>();

                entries.addAll(ModBlocks.COUNTERS.getEntries());
                entries.addAll(ModBlocks.CUPBOARDS.getEntries());
                entries.addAll(ModBlocks.DESKS.getEntries());
                entries.addAll(ModBlocks.DRAWERS.getEntries());
                entries.addAll(ModBlocks.NIGHTSTANDS.getEntries());
                entries.addAll(ModBlocks.SHELVES.getEntries());
                entries.addAll(ModBlocks.SIDE_TABLES.getEntries());

                CONTAINER = BLOCK_ENTITY_TYPES.register("container",
                                () -> createBlockEntityType(ContainerBlockEntity::new,
                                                entries.stream().map(RegistryEntry::get).toArray(
                                                                net.minecraft.world.level.block.Block[]::new)));
        }
}
