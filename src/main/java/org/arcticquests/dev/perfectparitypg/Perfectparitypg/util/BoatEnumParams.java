package org.arcticquests.dev.perfectparitypg.Perfectparitypg.util;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.ModBlocks;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.item.ModItems;

import java.util.function.Supplier;

public class BoatEnumParams {
    public static final EnumProxy<Boat.Type> BOAT_TYPE = new EnumProxy<>(
            Boat.Type.class,
            ModBlocks.PALE_OAK_PLANKS,
            "perfectparitypg:pale_oak",
            (Supplier<Item>) ModItems.PALE_OAK_BOAT::get,
            (Supplier<Item>) ModItems.PALE_OAK_CHEST_BOAT::get,
            (Supplier<Item>) () -> Items.STICK,
            false
    );
}