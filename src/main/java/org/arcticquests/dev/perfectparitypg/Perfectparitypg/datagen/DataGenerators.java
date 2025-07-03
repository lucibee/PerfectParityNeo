package org.arcticquests.dev.perfectparitypg.Perfectparitypg.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = PerfectParityPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(packOutput, lookupProvider, fileHelper);
        // Server data
        if (event.includeServer()) {
            generator.addProvider(true, blockTagProvider);
            generator.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), fileHelper));
            generator.addProvider(true, new ModRecipeProvider(packOutput, lookupProvider));
            generator.addProvider(true, new ModBiomeTagProvider(packOutput, lookupProvider, PerfectParityPG.MODID, fileHelper));
            generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));
            // generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
            // generator.addProvider(true, new ModAdvancementProvider(packOutput, lookupProvider, fileHelper));

        }

        if (event.includeClient()) {
            generator.addProvider(true, new ModItemModelProvider(packOutput, fileHelper));
        }
    }
}