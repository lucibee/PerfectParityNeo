package org.arcticquests.dev.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PerfectParityPG.MODID);

    public static final Supplier<EntityType<Creaking>> CREAKING =
            ENTITY_TYPES.register("creaking", () -> EntityType.Builder.of(Creaking::new, MobCategory.CREATURE)
                    .sized(0.9f, 2.7f).build("creaking"));


    public static final Supplier<EntityType<ModBoatEntity>> PALE_OAK_BOAT =
            ENTITY_TYPES.register("pale_oak_boat", () ->
                    EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .clientTrackingRange(10)
                            .build("pale_oak_boat")
            );

    public static final Supplier<EntityType<ModChestBoatEntity>> PALE_OAK_CHEST_BOAT =
            ENTITY_TYPES.register("pale_oak_chest_boat", () ->
                    EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .clientTrackingRange(10)
                            .build("pale_oak_chest_boat")
            );


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
