package org.arcticquests.dev;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.entity.ModEntities;
import org.arcticquests.dev.item.ModItems;

import java.util.function.Supplier;

public class Enumss {

    public static final Supplier<Boat.Type> PALE_OAK_BOAT_TYPE =
            () -> Boat.Type.valueOf("PERFECTPARITYPG_PALE_OAK");

    // Don't use EnumProxy here!
    public static Object getPaleOakBoatParams(int idx, Class<?> type) {
        return switch (idx) {
            case 0 -> type.cast(ModEntities.paleOakBoat());          // Supplier<Boat>
            case 1 -> type.cast("perfectparitypg:pale_oak");         // String
            case 2 -> type.cast((Supplier<Item>) ModItems.PALE_OAK_BOAT::get);
            case 3 -> type.cast((Supplier<Item>) ModItems.PALE_OAK_CHEST_BOAT::get);
            case 4 -> type.cast((Supplier<Block>) ModBlocks.PALE_OAK_PLANKS::get);
            case 5 -> type.cast(false);                              // hasChest
            default -> throw new IllegalArgumentException("Unexpected index: " + idx);
        };
    }
}