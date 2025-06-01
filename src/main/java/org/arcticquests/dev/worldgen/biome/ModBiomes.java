package org.arcticquests.dev.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.sounds.ModSounds;
import org.arcticquests.dev.worldgen.ModPlacedFeatures;

public class ModBiomes {
    public static final ResourceKey<Biome> PALE_GARDEN = register("pale_garden");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, name));
    }

    public static Biome paleGarden(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(builder);
        BiomeGenerationSettings.Builder builder2 = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //globalOverworldGeneration(builder2);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PALE_GARDEN_VEGETATION);

        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PALE_MOSS_PATCH);
        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PALE_GARDEN_FLOWERS);


        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);


        builder2.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FLOWER_PALE_GARDEN);


        BiomeDefaultFeatures.addForestGrass(builder2);

        BiomeDefaultFeatures.addDefaultExtraVegetation(builder2);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(7768221).waterFogColor(5597568).fogColor(8484720).skyColor(12171705).grassColorOverride(7832178).foliageColorOverride(8883574).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic((Music) ModSounds.NO_MUSIC).build()).mobSpawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }

}
