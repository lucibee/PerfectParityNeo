package org.arcticquests.dev.perfectparitypg.Perfectparitypg.mixin;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.item.ModItems;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.util.PaleOakBoatType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public class BoatItemDropsMixin {
    @Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
    public void getDropItem(CallbackInfoReturnable<Item> ci) {
        if (((Boat)(Object)this).getVariant() == PaleOakBoatType.PALE_OAK) {
            ci.setReturnValue(ModItems.PALE_OAK_BOAT.get());
        }
    }
}