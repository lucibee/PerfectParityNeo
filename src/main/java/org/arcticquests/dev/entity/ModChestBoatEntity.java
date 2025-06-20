package org.arcticquests.dev.entity;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.arcticquests.dev.item.ModItems;
import org.arcticquests.dev.util.WoodTypeVariant;

public class ModChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<String> DATA_ID_WOOD_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.STRING);

    public ModChestBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public ModChestBoatEntity(EntityType<? extends Boat> entityType, Level level, WoodTypeVariant woodType) {
        this(entityType, level);
        setModWoodType(woodType);
    }

    @Override
    public Boat.Type getVariant() {
        return ModBoatType.valueOf(getModWoodType().name());
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326198_) {
        super.defineSynchedData(p_326198_);
        p_326198_.define(DATA_ID_WOOD_TYPE, WoodTypeVariant.PALE_OAK.getName());

    }

    public WoodTypeVariant getModWoodType() {
        try {
            String woodTypeName = this.entityData.get(DATA_ID_WOOD_TYPE);
            return WoodTypeVariant.valueOf(woodTypeName.toUpperCase());
        } catch (Exception e) {
            return WoodTypeVariant.PALE_OAK;
        }
    }

    public void setModWoodType(WoodTypeVariant woodType) {
        this.entityData.set(DATA_ID_WOOD_TYPE, woodType.getName());
    }

    @Override
    public Item getDropItem() {
        return ModItems.PALE_OAK_CHEST_BOAT.get();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("ModWoodType", getModWoodType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("ModWoodType")) {
            try {
                setModWoodType(WoodTypeVariant.valueOf(tag.getString("ModWoodType").toUpperCase()));
            } catch (IllegalArgumentException e) {
                setModWoodType(WoodTypeVariant.PALE_OAK);
            }
        }
    }
}