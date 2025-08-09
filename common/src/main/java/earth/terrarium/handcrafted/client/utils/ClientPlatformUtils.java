package earth.terrarium.handcrafted.client.utils;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;

public class ClientPlatformUtils {

    // Fabric-only implementation via reflection to avoid direct compile dep in
    // common
    public static <T extends Entity> void registerRenderer(Supplier<EntityType<T>> entity,
            EntityRendererProvider<T> provider) {
        try {
            Class<?> registryClass = Class
                    .forName("net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry");
            java.lang.reflect.Method register = registryClass.getMethod("register", EntityType.class,
                    EntityRendererProvider.class);
            register.invoke(null, entity.get(), provider);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Fabric EntityRendererRegistry not present (Fabric-only runtime expected)",
                    e);
        } catch (Throwable t) {
            throw new RuntimeException("Failed to register entity renderer via reflection", t);
        }
    }

    @FunctionalInterface
    public interface BlockRendererRegistry {
        <T extends BlockEntity> void register(RegistryEntry<? extends BlockEntityType<? extends T>> type,
                BlockEntityRendererProvider<T> factory);
    }

    @FunctionalInterface
    public interface LayerDefinitionRegistry {
        void register(ModelLayerLocation location, Supplier<LayerDefinition> definition);
    }
}
