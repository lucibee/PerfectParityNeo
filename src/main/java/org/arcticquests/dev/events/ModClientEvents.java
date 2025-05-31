package org.arcticquests.dev.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import org.arcticquests.dev.PerfectParityPG;

@EventBusSubscriber(modid = PerfectParityPG.MODID, bus = EventBusSubscriber.Bus.GAME, value =  Dist.CLIENT)
public class ModClientEvents {
}