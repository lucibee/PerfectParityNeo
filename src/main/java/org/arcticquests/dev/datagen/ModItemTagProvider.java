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
        LOGGER.info("Starting Item Tag generation...");
        this.tag(PALE_OAK_LOGS).add(ModBlocks.PALE_OAK_LOG.get().asItem(), ModBlocks.STRIPPED_PALE_OAK_LOG.get().asItem(), ModBlocks.PALE_OAK_WOOD.get().asItem(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get().asItem());
        LOGGER.info("Tagging resin brick structures...");
        this.tag(ItemTags.SLABS).add(ModBlocks.RESIN_BRICK_SLAB.get().asItem());
        this.tag(ItemTags.WALLS).add(ModBlocks.RESIN_BRICK_WALL.get().asItem());
        this.tag(ItemTags.STAIRS).add(ModBlocks.RESIN_BRICK_STAIRS.get().asItem());
        this.tag(ItemTags.TRIM_MATERIALS).add(ModItems.RESIN_BRICK.get());
        this.tag(ItemTags.LEAVES).add(ModBlocks.PALE_OAK_LEAVES.get().asItem());
        this.tag(ItemTags.PLANKS).add(ModBlocks.PALE_OAK_PLANKS.get().asItem());

    }

}
/*
// Pale Oak Logs
tag(PALE_OAK_LOGS).add(
        ModBlocks.PALE_OAK_LOG.get().asItem(),
                ModBlocks.STRIPPED_PALE_OAK_LOG.get().asItem(),
                ModBlocks.PALE_OAK_WOOD.get().asItem(),
                ModBlocks.STRIPPED_PALE_OAK_WOOD.get().asItem()
        );

*/
/*        // Basic tag syncing (faster with copy)
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.FENCES, ItemTags.WOODEN_FENCES);*//*


tag(ItemTags.TRIM_MATERIALS).add(ModItems.RESIN_BRICK.get());

//        tag(ItemTags.SIGNS).add(ModItems.PALE_OAK_SIGN.get());
//        tag(ItemTags.HANGING_SIGNS).add(ModItems.PALE_OAK_HANGING_SIGN.get());
//        tag(ItemTags.BOATS).add(ModItems.PALE_OAK_BOAT.get());
//        tag(ItemTags.CHEST_BOATS).add(ModItems.PALE_OAK_CHEST_BOAT.get());

// Redundant fallback: add Pale Oak to logs that burn if copy fails
tag(ItemTags.LOGS_THAT_BURN).addTag(PALE_OAK_LOGS);*/
