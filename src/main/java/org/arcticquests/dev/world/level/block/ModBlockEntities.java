package org.arcticquests.dev.world.level.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PerfectParityPG.MODID);


    public static final Supplier<BlockEntityType<CreakingHeartBlockEntity>> CREAKING_HEART =
            BLOCK_ENTITIES.register("creaking_heart", () -> BlockEntityType.Builder.of(
                    CreakingHeartBlockEntity::new, ModBlocks.CREAKING_HEART.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}