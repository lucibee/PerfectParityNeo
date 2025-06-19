package org.arcticquests.dev.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.Enumss;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.entity.ModEntities;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PerfectParityPG.MODID);

    public static final DeferredItem<Item> RESIN_BRICK = ITEMS.register("resin_brick", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CREAKING_SPAWN_EGG = ITEMS.register("creaking_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.CREAKING, 0x5F5F5F, 0xFC7812, new Item.Properties()));
/*
    public static final DeferredItem<Item> PALE_OAK_SIGN = ITEMS.register("pale_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.PALE_OAK_SIGN.get(), ModBlocks.PALE_OAK_WALL_SIGN.get()));

    public static final DeferredItem<Item> PALE_OAK_HANGING_SIGN = ITEMS.register("pale_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PALE_OAK_HANGING_SIGN.get(), ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final DeferredHolder<Item, Item> PALE_OAK_BOAT_I = DeferredHolder.create(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, "pale_oak_boat")));
    public static final DeferredHolder<Item, Item> PALE_OAK_CHEST_BOAT_I = DeferredHolder.create(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_chest_boat")));
    public static final DeferredHolder<Block, Block> PALE_OAK_PLANKS_I = DeferredHolder.create(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, "pale_oak_planks")));

    public static final DeferredItem<BoatItem> PALE_OAK_BOAT = ITEMS.register(
            PALE_OAK_BOAT_I.getId().getPath(),
            () -> new BoatItem(false, Enumss.PALE_OAK_BOAT_TYPE.get(), new Item.Properties().stacksTo(1))
    );

    public static final DeferredItem<BoatItem> PALE_OAK_CHEST_BOAT = ITEMS.register(
            PALE_OAK_CHEST_BOAT_I.getId().getPath(),
            () -> new BoatItem(true, Enumss.PALE_OAK_BOAT_TYPE.get(), new Item.Properties().stacksTo(1))
    );*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}