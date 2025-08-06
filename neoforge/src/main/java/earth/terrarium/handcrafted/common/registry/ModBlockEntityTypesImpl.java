package earth.terrarium.handcrafted.common.registry;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;

public class ModBlockEntityTypesImpl {
    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BiFunction<BlockPos, BlockState, T> factory, net.minecraft.world.level.block.Block... blocks) {
        return BlockEntityType.Builder.of((pos, state) -> factory.apply(pos, state), blocks).build(null);
    }
}
