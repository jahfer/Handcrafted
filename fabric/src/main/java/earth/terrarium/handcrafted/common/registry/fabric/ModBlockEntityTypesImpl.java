package earth.terrarium.handcrafted.common.registry.fabric;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;

public class ModBlockEntityTypesImpl {
    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BiFunction<BlockPos, BlockState, T> factory, net.minecraft.world.level.block.Block... blocks) {
        FabricBlockEntityTypeBuilder.Factory<T> fabricFactory = (pos, state) -> factory.apply(pos, state);
        var builder = FabricBlockEntityTypeBuilder.create(fabricFactory, blocks);
        return builder.build();
    }
}
