package org.arcticquests.dev.block.wood;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.arcticquests.dev.PerfectParityPG;

public class ModWoodTypes {
    private static final WoodTypeBuilder woodTypeBuilder = new WoodTypeBuilder();
    public static final WoodType  PALE_OAK = woodTypeBuilder.register(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak"), ModBlockSetTypes.PALE_OAK);

}
