package org.arcticquests.dev.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;
import org.arcticquests.dev.PerfectParityPG;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PALE_OAK = new TreeGrower(PerfectParityPG.MODID +"pale_oak",Optional.empty(), Optional.of(ModConfiguredFeatures.PALE_OAK), Optional.empty());
}
