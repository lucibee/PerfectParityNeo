package org.arcticquests.dev.util;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public enum WoodTypeVariant {
    PALE_OAK("pale_oak");
    private final String name;
    private final WoodType woodType;

    WoodTypeVariant(String name) {
        this.name = name;
        this.woodType = WoodType.register(new WoodType(name, BlockSetTypeVariant.valueOf(name.toUpperCase()).getBlockSetType()));
    }

    public String getName() {
        return name;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public ResourceLocation getTexture(String type) {
        return ResourceLocation.fromNamespaceAndPath("perfectparitypg", "block/" + name + "_" + type);
    }
}