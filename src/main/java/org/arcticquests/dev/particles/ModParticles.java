package org.arcticquests.dev.particles;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, PerfectParityPG.MODID);

    public static final Supplier<SimpleParticleType> PALE_OAK_LEAVES =
            PARTICLE_TYPES.register("pale_oak_leaves", () -> new SimpleParticleType(true));

    public static final DeferredHolder<ParticleType<?>, ParticleType<TrailParticleOption>> TRAIL =
            PARTICLE_TYPES.register("trail", () -> new ParticleType<>(false) {
                @Override
                public MapCodec<TrailParticleOption> codec() {
                    return TrailParticleOption.CODEC;
                }

                @Override
                public StreamCodec<? super RegistryFriendlyByteBuf, TrailParticleOption> streamCodec() {
                    return TrailParticleOption.STREAM_CODEC;
                }
            });

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
