package org.arcticquests.dev.worldgen;


import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.mixin.TreeDecoratorTypeInvoker;

import static org.arcticquests.dev.PerfectParityPG.LOGGER;


public class ModTreeDecoratorTypes {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, PerfectParityPG.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<PaleMossDecorator>> PALE_MOSS =
            TREE_DECORATOR_TYPES.register("pale_moss",
                    () -> new TreeDecoratorType<>(PaleMossDecorator.CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<CreakingHeartDecorator>> CREAKING_HEART =
            TREE_DECORATOR_TYPES.register("creaking_heart",
                    () -> new TreeDecoratorType<>(CreakingHeartDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATOR_TYPES.register(eventBus);
        LOGGER.info("Registering Tree features...");

    }

}