package org.arcticquests.dev.world.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

public class ModItems {


    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PerfectParityPG.MODID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
