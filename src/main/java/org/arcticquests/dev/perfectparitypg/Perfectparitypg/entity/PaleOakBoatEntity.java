package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;

public class PaleOakBoatEntity extends Boat {
    public PaleOakBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    @Override
    public Boat.Type getVariant() {
        return Boat.Type.valueOf("PERFECTPARITYPG_PALE_OAK");
    }
}
