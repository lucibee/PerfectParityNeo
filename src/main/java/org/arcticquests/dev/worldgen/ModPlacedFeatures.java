package org.arcticquests.dev.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.arcticquests.dev.PerfectParityPG;

import java.util.List;

import static org.arcticquests.dev.PerfectParityPG.LOGGER;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> FLOWER_PALE_GARDEN = registerKey("flower_pale_garden");
    public static final ResourceKey<PlacedFeature> PALE_GARDEN_VEGETATION = registerKey("pale_garden_vegetation");
    public static final ResourceKey<PlacedFeature> PALE_GARDEN_FLOWERS = registerKey("pale_garden_flowers");
    public static final ResourceKey<PlacedFeature> PALE_MOSS_PATCH = registerKey("pale_moss_patch");
    public static final ResourceKey<PlacedFeature> PALE_OAK_CHECKED = registerKey("pale_oak_checked");
    public static final ResourceKey<PlacedFeature> PALE_OAK_CREAKING_CHECKED = registerKey("pale_oak_creaking_checked");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<PlacedFeature> lookup = context.lookup(Registries.PLACED_FEATURE);

        lookup.getOrThrow(FLOWER_PALE_GARDEN);
        lookup.getOrThrow(PALE_GARDEN_VEGETATION);
        lookup.getOrThrow(PALE_GARDEN_FLOWERS);
        lookup.getOrThrow(PALE_MOSS_PATCH);
        lookup.getOrThrow(PALE_OAK_CHECKED);
        lookup.getOrThrow(PALE_OAK_CREAKING_CHECKED);

        LOGGER.info("Registered all placed features for mod.");
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, name));
    }

    public static void registerModPlacedFeatures() {
        LOGGER.info("Registering Placed features...");
        LOGGER.debug("Placed feature keys: {}, {}, {}, {}",
                FLOWER_PALE_GARDEN.location(),
                PALE_GARDEN_VEGETATION.location(),
                PALE_GARDEN_FLOWERS.location(),
                PALE_MOSS_PATCH.location());
    }
}