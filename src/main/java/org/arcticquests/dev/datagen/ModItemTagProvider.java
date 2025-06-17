package org.arcticquests.dev.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public static final TagKey<Item> PALE_OAK_LOGS = createTag("pale_oak_logs");
    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID, name));
    }

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, PerfectParityPG.MODID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaTags();

        tag(PALE_OAK_LOGS).add(
                ModBlocks.PALE_OAK_LOG.asItem(),
                ModBlocks.STRIPPED_PALE_OAK_LOG.asItem(),
                ModBlocks.PALE_OAK_WOOD.asItem(),
                ModBlocks.STRIPPED_PALE_OAK_WOOD.asItem()
        );

        tag(ItemTags.SLABS).add(ModBlocks.RESIN_BRICK_SLAB.asItem());
        tag(ItemTags.WALLS).add(ModBlocks.RESIN_BRICK_WALL.asItem());
        tag(ItemTags.STAIRS).add(ModBlocks.RESIN_BRICK_STAIRS.asItem());
        this.tag(ItemTags.TRIM_MATERIALS).add(ModItems.RESIN_BRICK.get());

        tag(ItemTags.LOGS_THAT_BURN).addTag(PALE_OAK_LOGS);

        tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.PALE_OAK_BUTTON.asItem());
        tag(ItemTags.WOODEN_DOORS).add(ModBlocks.PALE_OAK_DOOR.asItem());
        tag(ItemTags.WOODEN_FENCES).add(ModBlocks.PALE_OAK_FENCE.asItem());
        tag(ItemTags.WOODEN_SLABS).add(ModBlocks.PALE_OAK_SLAB.asItem());
        tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.PALE_OAK_STAIRS.asItem());
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PALE_OAK_PRESSURE_PLATE.asItem());
        tag(ItemTags.FENCE_GATES).add(ModBlocks.PALE_OAK_FENCE_GATE.asItem());

/*        tag(ItemTags.SIGNS).add(ModItems.PALE_OAK_SIGN.get());
        tag(ItemTags.HANGING_SIGNS).add(ModItems.PALE_OAK_HANGING_SIGN.get());
        tag(ItemTags.BOATS).add(ModItems.PALE_OAK_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(ModItems.PALE_OAK_CHEST_BOAT.get());*/


        tag(ItemTags.LEAVES).add(ModBlocks.PALE_OAK_LEAVES.asItem());

        tag(ItemTags.PLANKS).add(ModBlocks.PALE_OAK_PLANKS.asItem());
    }

    protected void addVanillaTags() {
    }
}

