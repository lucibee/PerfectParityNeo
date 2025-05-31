package org.arcticquests.dev.item;


import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.entity.ModEntities;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PerfectParityPG.MODID);

    public static final DeferredItem<Item> CREAKING_SPAWN_EGG = ITEMS.register("creaking_spawn_egg",()-> new DeferredSpawnEggItem(ModEntities.CREAKING, 0x5F5F5F, 0xFC7812,new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
