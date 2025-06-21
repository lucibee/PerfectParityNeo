package org.arcticquests.dev.util;

import net.minecraft.world.entity.vehicle.Boat;

public class ModBoatTypes {
    public static Boat.Type PALE_OAK;

    public static void init() {
        PALE_OAK = Boat.Type.valueOf("PERFECTPARITYPG_PALE_OAK");
    }
}