package org.arcticquests.dev.sounds;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PerfectParityPG.MODID);


    public static final Supplier<SoundEvent> RESIN_BREAK = registerSoundEvent("block.resin.break");
    public static final Supplier<SoundEvent> RESIN_FALL = registerSoundEvent("block.resin.fall");
    public static final Supplier<SoundEvent> RESIN_PLACE = registerSoundEvent("block.resin.place");
    public static final Supplier<SoundEvent> RESIN_STEP = registerSoundEvent("block.resin.step");
    public static final Supplier<SoundEvent> RESIN_BRICKS_BREAK = registerSoundEvent("block.resin_bricks.break");
    public static final Supplier<SoundEvent> RESIN_BRICKS_FALL = registerSoundEvent("block.resin_bricks.fall");
    public static final Supplier<SoundEvent> RESIN_BRICKS_HIT = registerSoundEvent("block.resin_bricks.hit");
    public static final Supplier<SoundEvent> RESIN_BRICKS_PLACE = registerSoundEvent("block.resin_bricks.place");
    public static final Supplier<SoundEvent> RESIN_BRICKS_STEP = registerSoundEvent("block.resin_bricks.step");

    public static final Supplier<SoundEvent> CREAKING_HEART_BREAK = registerSoundEvent("block.creaking_heart.break");
    public static final Supplier<SoundEvent> CREAKING_HEART_FALL = registerSoundEvent("block.creaking_heart.fall");
    public static final Supplier<SoundEvent> CREAKING_HEART_HIT = registerSoundEvent("block.creaking_heart.hit");
    public static final Supplier<SoundEvent> CREAKING_HEART_HURT = registerSoundEvent("block.creaking_heart.hurt");
    public static final Supplier<SoundEvent> CREAKING_HEART_PLACE = registerSoundEvent("block.creaking_heart.place");
    public static final Supplier<SoundEvent> CREAKING_HEART_STEP = registerSoundEvent("block.creaking_heart.step");
    public static final Supplier<SoundEvent> CREAKING_HEART_IDLE = registerSoundEvent("block.creaking_heart.idle");
    public static final Supplier<SoundEvent> CREAKING_HEART_SPAWN = registerSoundEvent("block.creaking_heart.spawn");

    public static final Supplier<SoundEvent> CREAKING_AMBIENT = registerSoundEvent("entity.creaking.ambient");
    public static final Supplier<SoundEvent> CREAKING_ACTIVATE = registerSoundEvent("entity.creaking.activate");
    public static final Supplier<SoundEvent> CREAKING_DEACTIVATE = registerSoundEvent("entity.creaking.deactivate");
    public static final Supplier<SoundEvent> CREAKING_ATTACK = registerSoundEvent("entity.creaking.attack");
    public static final Supplier<SoundEvent> CREAKING_DEATH = registerSoundEvent("entity.creaking.death");
    public static final Supplier<SoundEvent> CREAKING_STEP = registerSoundEvent("entity.creaking.step");
    public static final Supplier<SoundEvent> CREAKING_FREEZE = registerSoundEvent("entity.creaking.freeze");
    public static final Supplier<SoundEvent> CREAKING_UNFREEZE = registerSoundEvent("entity.creaking.unfreeze");
    public static final Supplier<SoundEvent> CREAKING_SPAWN = registerSoundEvent("entity.creaking.spawn");
    public static final Supplier<SoundEvent> CREAKING_SWAY = registerSoundEvent("entity.creaking.sway");
    public static final Supplier<SoundEvent> CREAKING_TWITCH = registerSoundEvent("entity.creaking.twitch");
    public static final Supplier<SoundEvent> EYEBLOSSOM_OPEN_LONG = registerSoundEvent("block.eyeblossom.open_long");
    public static final Supplier<SoundEvent> EYEBLOSSOM_OPEN = registerSoundEvent("block.eyeblossom.open");
    public static final Supplier<SoundEvent> EYEBLOSSOM_CLOSE_LONG = registerSoundEvent("block.eyeblossom.close_long");
    public static final Supplier<SoundEvent> EYEBLOSSOM_CLOSE = registerSoundEvent("block.eyeblossom.close");
    public static final Supplier<SoundEvent> EYEBLOSSOM_IDLE = registerSoundEvent("block.eyeblossom.idle");


    public static final Supplier<SoundEvent> PALE_HANGING_MOSS_IDLE = registerSoundEvent("block.pale_hanging_moss.idle");

    public static final DeferredSoundType RESIN = new DeferredSoundType(1.0F, 1.0F, RESIN_BREAK, RESIN_STEP, RESIN_PLACE, RESIN_PLACE, RESIN_FALL); // The Second Reson Place is suppose to be resin hit but who cares when you fall and die.
    public static final DeferredSoundType RESIN_BRICKS = new DeferredSoundType(1.0F, 1.0F, ModSounds.RESIN_BRICKS_BREAK, ModSounds.RESIN_BRICKS_STEP, ModSounds.RESIN_BRICKS_PLACE, ModSounds.RESIN_BRICKS_HIT, ModSounds.RESIN_BRICKS_FALL);
    public static final DeferredSoundType CREAKING_HEART = new DeferredSoundType(1.0F, 1.0F, ModSounds.CREAKING_HEART_BREAK, ModSounds.CREAKING_HEART_STEP, ModSounds.CREAKING_HEART_PLACE, ModSounds.CREAKING_HEART_HIT, ModSounds.CREAKING_HEART_FALL);

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}