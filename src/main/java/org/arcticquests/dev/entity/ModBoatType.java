package org.arcticquests.dev.entity;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.item.ModItems;

import java.util.function.Supplier;

public enum ModBoatType {
    PALE_OAK("pale_oak", ModBlocks.PALE_OAK_PLANKS.get(), ModItems.PALE_OAK_BOAT.get(), ModItems.PALE_OAK_CHEST_BOAT.get());

    private final String name;
    private final Block planks;
    private final Item boatItem;
    private final Item chestBoatItem;

    ModBoatType(String name, Block planks, Item boatItem, Item chestBoatItem) {
        this.name = name;
        this.planks = planks;
        this.boatItem = boatItem;
        this.chestBoatItem = chestBoatItem;
    }

    public String getName() {
        return name;
    }

    public Block getPlanks() {
        return planks;
    }

    public Item getBoatItem() {
        return boatItem;
    }

    public Item getChestBoatItem() {
        return chestBoatItem;
    }

    public static ModBoatType byName(String name) {
        for (ModBoatType type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return PALE_OAK;
    }
}