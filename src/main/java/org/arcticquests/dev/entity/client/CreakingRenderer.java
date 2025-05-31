package org.arcticquests.dev.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.arcticquests.dev.entity.Creaking;
import org.arcticquests.dev.entity.ModModelLayers;

@OnlyIn(Dist.CLIENT)
public class CreakingRenderer<T extends Creaking> extends MobRenderer<Creaking, CreakingModel<Creaking>> {
    private static final ResourceLocation EYES_TEXTURE_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/creaking/creaking_eyes.png");
    private static final ResourceLocation TEXTURE_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/creaking/creaking.png");

    public CreakingRenderer(EntityRendererProvider.Context context) {
        super(context, new CreakingModel<>(context.bakeLayer(ModModelLayers.CREAKING)), 0.6F);
        this.addLayer(new CreakingEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Creaking creaking) {
        return TEXTURE_LOCATION;
    }
}