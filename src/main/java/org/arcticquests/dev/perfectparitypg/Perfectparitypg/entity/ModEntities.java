package org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE,"minecraft");

    public static final Supplier<EntityType<Creaking>> CREAKING =
            ENTITY_TYPES.register("creaking", () -> EntityType.Builder.of(Creaking::new, MobCategory.CREATURE)
                    .sized(0.9f, 2.7f).build("creaking"));


    public static final Supplier<EntityType<Boat>> PALE_OAK_BOAT =
ENTITY_TYPES.register("pale_oak_boat", () ->
                    EntityType.Builder.<Boat>of(PaleOakBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
.clientTrackingRange(10)
                            .build("pale_oak_boat")
            );

    public static final Supplier<EntityType<ChestBoat>> PALE_OAK_CHEST_BOAT =
            ENTITY_TYPES.register("pale_oak_chest_boat", () ->
                    EntityType.Builder.<ChestBoat>of(PaleOakChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .clientTrackingRange(10)
                            .build("pale_oak_chest_boat")
            );


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
