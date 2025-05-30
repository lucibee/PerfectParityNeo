package org.arcticquests.dev.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.arcticquests.dev.PerfectParityPG;

public class ModModelLayers {
    public static final ModelLayerLocation CREAKING = registerLayer("creaking");

    private static ModelLayerLocation registerLayer(String name) {
        // “main” is the layer variant—most models just use “main”
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,name), "main");
    }
}