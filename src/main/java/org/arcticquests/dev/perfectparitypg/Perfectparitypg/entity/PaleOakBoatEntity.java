package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import static org.arcticquests.dev.perfectparitypg.Perfectparitypg.item.ModItems.PALE_OAK_BOAT;

public class PaleOakBoatEntity extends Boat {
    private static final EntityDataAccessor<Boolean> PALE_OAK = SynchedEntityData.defineId(PaleOakBoatEntity.class, EntityDataSerializers.BOOLEAN);

    public PaleOakBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public PaleOakBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.PALE_OAK_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PALE_OAK, true);
    }

    @Override
    public @NotNull Item getDropItem() {
        // Replace with your actual Pale Oak Boat item reference
        return PALE_OAK_BOAT.get();
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("PaleOak", true);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        // Always true for Pale Oak
    }

    @Override
    public @NotNull ItemStack getPickResult() {
        return new ItemStack(this.getDropItem());
    }
}