package earth.terrarium.handcrafted.client.renderer.fancypainting;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class FancyPaintingRenderState extends EntityRenderState {
    public PaintingVariant variant;
    public Direction direction;

    public FancyPaintingRenderState() {
    }
}