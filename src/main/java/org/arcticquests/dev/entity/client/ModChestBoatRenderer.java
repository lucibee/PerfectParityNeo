package org.arcticquests.dev.entity.client;


import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.entity.ModChestBoatEntity;

@OnlyIn(Dist.CLIENT)
public class ModChestBoatRenderer extends BoatRenderer {

    public ModChestBoatRenderer(EntityRendererProvider.Context context, boolean b) {
        super(context, true);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (boat instanceof ModChestBoatEntity modChestBoat) {
            Pair<ResourceLocation, ListModel<Boat>> vanillaPair = super.getModelWithLocation(boat);
            ResourceLocation customTexture = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,
                    "textures/entity/chest_boat/" + modChestBoat.getModWoodType().getName() + ".png");
            return Pair.of(customTexture, vanillaPair.getSecond());
        }
        return super.getModelWithLocation(boat);
    }
}