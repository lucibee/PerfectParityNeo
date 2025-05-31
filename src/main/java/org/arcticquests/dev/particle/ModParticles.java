package org.arcticquests.dev.particle;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, PerfectParityPG.MODID);

    public static final Supplier<SimpleParticleType> BISMUTH_PARTICLES =
            PARTICLE_TYPES.register("bismuth_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}

/*
public class ModParticles {
    public static final SimpleParticleType PALE_OAK_LEAVES = registerParticle("pale_oak_leaves", FabricParticleTypes.simple(true));
    public static final ParticleType<TrailParticleOption> TRAIL = registerParticle("trail", false, (particleType) -> TrailParticleOption.CODEC, (particleType) -> TrailParticleOption.STREAM_CODEC);


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.withDefaultNamespace(name), particleType);
    }

    private static <T extends ParticleOptions> ParticleType<T> registerParticle(
            String string,
            boolean bl,
            Function<ParticleType<T>, MapCodec<T>> function,
            Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> function2
    ) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,  ResourceLocation.tryBuild(ResourceLocation.DEFAULT_NAMESPACE, string), new ParticleType<T>(bl) {
            @Override
            public MapCodec<T> codec() {
                return (MapCodec<T>)function.apply(this);
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return (StreamCodec<? super RegistryFriendlyByteBuf, T>)function2.apply(this);
            }
        });
    }

    public static void registerParticles(){

    }
}*/
