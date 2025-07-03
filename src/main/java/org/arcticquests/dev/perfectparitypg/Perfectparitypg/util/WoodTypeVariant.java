package org.arcticquests.dev.perfectparitypg.Perfectparitypg.util;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;

public enum WoodTypeVariant {
    PALE_OAK("pale_oak");
    private final String name;
    private final WoodType woodType;

    WoodTypeVariant(String name) {
        this.name = name;
        this.woodType = WoodType.register(new WoodType(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,name).toString(), BlockSetTypeVariant.valueOf(name.toUpperCase()).getBlockSetType()));
    }


    public String getName() {
        return name;
    }

    public WoodType getWoodType() {
        return woodType;
    }
}