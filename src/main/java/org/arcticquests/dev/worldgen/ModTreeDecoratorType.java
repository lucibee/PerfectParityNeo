package org.arcticquests.dev.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

public class ModTreeDecoratorType {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, PerfectParityPG.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<PaleMossDecorator>> PALE_MOSS =
            TREE_DECORATORS.register("pale_moss", () -> new TreeDecoratorType<>(PaleMossDecorator.CODEC));

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<CreakingHeartDecorator>> CREAKING_HEART =
            TREE_DECORATORS.register("creaking_heart", () -> new TreeDecoratorType<>(CreakingHeartDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}