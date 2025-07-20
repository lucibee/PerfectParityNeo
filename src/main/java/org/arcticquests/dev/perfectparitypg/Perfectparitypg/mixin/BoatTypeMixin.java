package org.arcticquests.dev.perfectparitypg.Perfectparitypg.mixin;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.ModBlocks;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.item.ModItems;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.level.block.Block;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.util.PaleOakBoatType;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(Boat.Type.class)
public class BoatTypeMixin {
    /*
     * This file looks very scary and ugly, but what it basically does is add our boat into the vanilla enum found in BoatEntity.java
     *
     * While it works and should work with any other mod that does the same thing, adding to enums is not recommended.
     * For any future situations where you are required to add to an enum, look into Fabric-ASM: https://github.com/Chocohead/Fabric-ASM
     */

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Boat.Type newType(
            String internalName,
            int internalId,
            java.util.function.Supplier<Block> planksSupplier,
            String name,
            java.util.function.Supplier<Item> boatItem,
            java.util.function.Supplier<Item> chestBoatItem,
            java.util.function.Supplier<Item> stickItem,
            boolean raft
    ) {
        throw new AssertionError();
    }


    @SuppressWarnings("ShadowTarget")
    @Final
    @Shadow
    @Mutable
    private static Boat.Type[] $VALUES;

    @Inject(method = "<clinit>", at = @At(value = "FIELD",
            opcode = Opcodes.PUTSTATIC,
            target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/Boat$Type;",
            shift = At.Shift.AFTER))
    private static void addCustomBoatType(CallbackInfo ci) {
        var types = new ArrayList<>(Arrays.asList($VALUES));
        var last = types.getLast();

        var pale_oak = newType(
                "PALE_OAK",
                last.ordinal() + 1,
                ModBlocks.PALE_OAK_PLANKS::get,
                "pale_oak",
                ModItems.PALE_OAK_BOAT::get,
                ModItems.PALE_OAK_CHEST_BOAT::get,
                () -> Items.STICK,
                false
        );
        PaleOakBoatType.PALE_OAK = pale_oak;
        types.add(pale_oak);

        $VALUES = types.toArray(new Boat.Type[0]);
    }
}