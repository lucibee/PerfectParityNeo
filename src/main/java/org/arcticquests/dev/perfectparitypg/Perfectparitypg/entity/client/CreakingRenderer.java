package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.Creaking;

@OnlyIn(Dist.CLIENT)
public class CreakingRenderer<T extends Creaking> extends MobRenderer<Creaking, CreakingModel<Creaking>> {
    private static final ResourceLocation EYES_TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, "textures/entity/creaking/creaking_eyes.png");
    private static final ResourceLocation TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, "textures/entity/creaking/creaking.png");

    public CreakingRenderer(EntityRendererProvider.Context context) {
        super(context, new CreakingModel<>(context.bakeLayer(CreakingModel.LAYER_LOCATION)), 0.6F);
        this.addLayer(new CreakingEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Creaking creaking) {
        return TEXTURE_LOCATION;
    }
}