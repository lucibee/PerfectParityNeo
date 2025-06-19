package org.arcticquests.dev.block.wood;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.arcticquests.dev.PerfectParityPG;

public class ModWoodTypes {
    public static final WoodType PALE_OAK = WoodType.register(new WoodType(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak").toString(),ModBlockSetTypes.PALE_OAK));
}
