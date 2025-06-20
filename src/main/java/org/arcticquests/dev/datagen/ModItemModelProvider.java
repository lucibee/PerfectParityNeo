package org.arcticquests.dev.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.item.ModItems;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PerfectParityPG.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.CREAKING_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}