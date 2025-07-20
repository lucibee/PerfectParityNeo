package org.arcticquests.dev.perfectparitypg.Perfectparitypg.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.trim.ModTrimMaterials;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.ModConfiguredFeatures;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of("minecraft"));
    }
}