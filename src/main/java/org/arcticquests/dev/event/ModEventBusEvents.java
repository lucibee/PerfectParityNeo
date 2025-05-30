package org.arcticquests.dev.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.entity.ModEntities;
import org.arcticquests.dev.entity.creakng.Creaking;
import org.arcticquests.dev.entity.monster.CreakingModel;

@EventBusSubscriber(modid = PerfectParityPG.MODID , bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(CreakingModel.LAYER_LOCATION,CreakingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.CREAKING.get(), Creaking.createAttributes().build());
    }
}
