package org.arcticquests.dev.item;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.entity.ModEntities;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PerfectParityPG.MODID);

    public static final DeferredItem<Item> RESIN_BRICK = ITEMS.register("resin_brick", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CREAKING_SPAWN_EGG = ITEMS.register("creaking_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CREAKING, 0x5F5F5F, 0xFC7812, new Item.Properties()));

    public static final DeferredItem<SignItem> PALE_OAK_SIGN = ITEMS.register("pale_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.PALE_OAK_SIGN.get(), ModBlocks.PALE_OAK_WALL_SIGN.get()));

    public static final DeferredItem<HangingSignItem> PALE_OAK_HANGING_SIGN = ITEMS.register("pale_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));


    public static final DeferredItem<BoatItem> PALE_OAK_BOAT = ITEMS.register("pale_oak_boat",
            () -> new BoatItem(false, Boat.Type.valueOf("PERFECTPARITYPG_PALE_OAK"), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<BoatItem> PALE_OAK_CHEST_BOAT = ITEMS.register("pale_oak_chest_boat",
            () -> new BoatItem(true,Boat.Type.valueOf("PERFECTPARITYPG_PALE_OAK"), new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}