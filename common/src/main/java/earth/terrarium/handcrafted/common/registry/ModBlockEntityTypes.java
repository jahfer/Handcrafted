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
import dev.architectury.injectables.annotations.ExpectPlatform;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ModBlockEntityTypes {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries
            .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Handcrafted.MOD_ID);

    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BiFunction<BlockPos, BlockState, T> factory, net.minecraft.world.level.block.Block... blocks) {
        throw new AssertionError("This method should be replaced by platform-specific implementation");
    }

    public static final RegistryEntry<BlockEntityType<OvenBlockEntity>> OVEN = BLOCK_ENTITY_TYPES.register("oven",
            () -> createBlockEntityType(OvenBlockEntity::new, ModBlocks.OVEN.get()));
    public static final RegistryEntry<BlockEntityType<CrockeryBlockEntity>> CROCKERY = BLOCK_ENTITY_TYPES
            .register("crockery", () -> createBlockEntityType(CrockeryBlockEntity::new, 
                    ModBlocks.CROCKERY_COMBOS.stream().map(RegistryEntry::get).toArray(net.minecraft.world.level.block.Block[]::new)));
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

        CONTAINER = BLOCK_ENTITY_TYPES.register("container", () -> 
                createBlockEntityType(ContainerBlockEntity::new,
                        entries.stream().map(RegistryEntry::get).toArray(net.minecraft.world.level.block.Block[]::new)));
    }
}
