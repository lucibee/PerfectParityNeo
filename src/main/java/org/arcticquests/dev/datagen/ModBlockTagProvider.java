package org.arcticquests.dev.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public static final TagKey<Block> PALE_OAK_LOGS = create("pale_oak_logs");

    private static TagKey<Block> create(String string) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,string));
    }

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PerfectParityPG.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addVanillaTags();
        // Resin Clump
        tag(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(ModBlocks.RESIN_CLUMP.get());
        // Resin bricks
        tag(BlockTags.WALLS).add(ModBlocks.RESIN_BRICK_WALL.get());
        tag(BlockTags.SLABS).add(ModBlocks.RESIN_BRICK_SLAB.get());
        tag(BlockTags.STAIRS).add(ModBlocks.RESIN_BRICK_STAIRS.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(PALE_OAK_LOGS);
        tag(BlockTags.LEAVES).add(ModBlocks.PALE_OAK_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(ModBlocks.PALE_OAK_SAPLING.get());
        tag(BlockTags.PLANKS).add(ModBlocks.PALE_OAK_PLANKS.get());
        this.tag(PALE_OAK_LOGS).add(ModBlocks.PALE_OAK_LOG.get(), ModBlocks.STRIPPED_PALE_OAK_LOG.get(), ModBlocks.PALE_OAK_WOOD.get(), ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RESIN_BRICKS.get(), ModBlocks.CHISELED_RESIN_BRICKS.get(), ModBlocks.RESIN_BRICK_SLAB.get(), ModBlocks.RESIN_BLOCK.get(), ModBlocks.RESIN_BRICK_STAIRS.get(), ModBlocks.RESIN_BRICK_WALL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.CREAKING_HEART.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.PALE_MOSS_BLOCK.get(), ModBlocks.PALE_MOSS_CARPET.get());
        this.tag(BlockTags.FLOWERS).add(ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.OPEN_EYEBLOSSOM.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(ModBlocks.CLOSED_EYEBLOSSOM.get(), ModBlocks.OPEN_EYEBLOSSOM.get());

        /*tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.PALE_OAK_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS).add(ModBlocks.PALE_OAK_DOOR.get());
        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.PALE_OAK_FENCE.get());
        tag(BlockTags.WOODEN_SLABS).add(ModBlocks.PALE_OAK_SLAB.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.PALE_OAK_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.PALE_OAK_STAIRS.get());
        tag(BlockTags.STANDING_SIGNS).add(ModBlocks.PALE_OAK_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(ModBlocks.PALE_OAK_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.PALE_OAK_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.PALE_OAK_WALL_HANGING_SIGN.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.PALE_OAK_FENCE_GATE.get());*/

    }

    protected void addVanillaTags() {
    }

}
