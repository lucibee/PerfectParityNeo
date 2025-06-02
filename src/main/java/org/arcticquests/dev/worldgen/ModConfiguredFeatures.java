package org.arcticquests.dev.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.arcticquests.dev.PerfectParityPG;

import static org.arcticquests.dev.PerfectParityPG.LOGGER;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_OAK = registerKey("pale_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_BONEMEAL = registerKey("pale_moss_patch_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH = registerKey("pale_moss_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PALE_GARDEN = registerKey("flower_pale_garden");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_FOREST_FLOWERS = registerKey("pale_forest_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_GARDEN_VEGETATION = registerKey("pale_garden_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_VEGETATION = registerKey("pale_moss_vegetation");
    public static final ResourceKey<ConfiguredFeature<?,?>> PALE_GARDEN_FLOWERS = registerKey("pale_garden_flowers") ;


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> lookup = context.lookup(Registries.CONFIGURED_FEATURE);

        // Touch each key to register it
        lookup.getOrThrow(PALE_OAK);
        lookup.getOrThrow(PALE_MOSS_PATCH_BONEMEAL);
        lookup.getOrThrow(PALE_MOSS_PATCH);
        lookup.getOrThrow(FLOWER_PALE_GARDEN);
        lookup.getOrThrow(PALE_FOREST_FLOWERS);
        lookup.getOrThrow(PALE_GARDEN_VEGETATION);
        lookup.getOrThrow(PALE_MOSS_VEGETATION);
        lookup.getOrThrow(PALE_GARDEN_FLOWERS);
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, name));
    }


    public static void registerModConfiguredFeatures() {
        LOGGER.info("Registering vegetation features...");

        LOGGER.debug("Vegetation feature keys: {}", PALE_OAK.location());
    }

}
