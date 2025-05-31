package org.arcticquests.dev.world.level.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.arcticquests.dev.PerfectParityPG;

public class ModBlockSetTypes {
    public static final BlockSetType PALE_OAK;

    static {
        PALE_OAK = new BlockSetType(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak").toString());
    }
}
