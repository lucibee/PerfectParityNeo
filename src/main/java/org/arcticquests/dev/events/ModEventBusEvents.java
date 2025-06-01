package org.arcticquests.dev.events;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.entity.Creaking;
import org.arcticquests.dev.entity.ModEntities;
import org.arcticquests.dev.entity.ModModelLayers;
import org.arcticquests.dev.entity.client.CreakingModel;
import org.arcticquests.dev.entity.client.CreakingRenderer;

@EventBusSubscriber(modid = PerfectParityPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CreakingModel.LAYER_LOCATION, CreakingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CREAKING.get(), Creaking.createAttributes().build());
    }
}