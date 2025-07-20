package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.util.CustomBoatType;
import org.jetbrains.annotations.NotNull;

public class PaleOakBoatEntity extends Boat {
    public PaleOakBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    @Override
    public Boat.@NotNull Type getVariant() {
        return CustomBoatType.PALE_OAK;
    }
}