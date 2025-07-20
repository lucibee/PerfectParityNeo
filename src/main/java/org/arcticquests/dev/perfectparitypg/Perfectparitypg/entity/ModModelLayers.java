package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CREAKING = registerLayer();

    private static ModelLayerLocation registerLayer() {
        // “main” is the layer variant—most models just use “main”
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minecraft", "creaking"), "main");
    }
}