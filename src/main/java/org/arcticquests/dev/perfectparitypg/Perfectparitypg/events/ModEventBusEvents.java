package org.arcticquests.dev.perfectparitypg.Perfectparitypg.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.Creaking;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.ModEntities;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.client.CreakingModel;

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