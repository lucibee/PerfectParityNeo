package org.arcticquests.dev.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.arcticquests.dev.PerfectParityPG;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends BiomeTagsProvider {
    public static final TagKey<Biome> SPAWNS_WARM_VARIANT_FARM_ANIMALS = create("spawns_warm_variant_farm_animals");
    public static final TagKey<Biome> SPAWNS_COLD_VARIANT_FARM_ANIMALS = create("spawns_cold_variant_farm_animals");

    private static TagKey<Biome> create(String string) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,string));
    }

    public ModBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookuprovider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookuprovider, PerfectParityPG.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaTags();
    }

    protected void addVanillaTags() {
        tag(SPAWNS_WARM_VARIANT_FARM_ANIMALS).add(
                        Biomes.DESERT,
                        Biomes.WARM_OCEAN,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.LUKEWARM_OCEAN
                )
                .addTag(
                        BiomeTags.IS_NETHER
                ).addTag(
                        BiomeTags.IS_SAVANNA
                ).addTag(
                        BiomeTags.IS_JUNGLE
                ).addTag(
                        BiomeTags.IS_BADLANDS
                );

        tag(SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(
                        Biomes.SNOWY_PLAINS,
                        Biomes.ICE_SPIKES,
                        Biomes.FROZEN_PEAKS,
                        Biomes.JAGGED_PEAKS,
                        Biomes.SNOWY_SLOPES,
                        Biomes.FROZEN_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.GROVE,
                        Biomes.DEEP_DARK,
                        Biomes.FROZEN_RIVER,
                        Biomes.SNOWY_TAIGA,
                        Biomes.SNOWY_BEACH,
                        Biomes.COLD_OCEAN,
                        Biomes.DEEP_COLD_OCEAN,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.TAIGA,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.STONY_PEAKS
                )
                .addTag(
                        BiomeTags.IS_END
                );


    }
}
