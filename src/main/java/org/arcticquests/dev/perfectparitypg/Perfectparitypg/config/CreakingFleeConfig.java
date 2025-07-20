package org.arcticquests.dev.perfectparitypg.Perfectparitypg.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import java.util.List;

public class CreakingFleeConfig {
    public static final ModConfigSpec CONFIG;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> FLEE_ENTITIES;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        FLEE_ENTITIES = builder
            .comment("List of entity types or tags that should flee from Creaking. Prefix with '#' for tags. Example: 'minecraft:vindicator', '#minecraft:raiders'")
            .defineList(
                "fleeEntities",
                List.of(
                    "minecraft:vindicator",
                    "minecraft:evoker",
                    "minecraft:pillager"
                ),
                o -> o instanceof String
            );

        CONFIG = builder.build();
    }
}
