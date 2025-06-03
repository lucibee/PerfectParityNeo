package org.arcticquests.dev.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import org.arcticquests.dev.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RESIN_CLUMP.get());
        dropSelf(ModBlocks.RESIN_BLOCK.get());
        dropSelf(ModBlocks.RESIN_BRICKS.get());
        dropSelf(ModBlocks.RESIN_BRICK_STAIRS.get());
        dropSelf(ModBlocks.RESIN_BRICK_WALL.get());
        dropSelf(ModBlocks.CHISELED_RESIN_BRICKS.get());
        dropSelf(ModBlocks.RESIN_BLOCK.get());
        add(ModBlocks.RESIN_BRICK_SLAB.get(), block -> createSlabItemTable(ModBlocks.RESIN_BRICK_SLAB.get()));
        dropSelf(ModBlocks.PALE_OAK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        dropSelf(ModBlocks.PALE_OAK_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        dropSelf(ModBlocks.PALE_OAK_SAPLING.get());
        this.add(ModBlocks.PALE_OAK_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.PALE_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ModBlocks.PALE_OAK_PLANKS.get());

        this.add(ModBlocks.PALE_HANGING_MOSS.get(), block -> createDoublePlantShearsDrop(ModBlocks.PALE_HANGING_MOSS.get()));

        this.add(ModBlocks.OPEN_EYEBLOSSOM.get(), block ->  createPotFlowerItemTable(ModBlocks.OPEN_EYEBLOSSOM.get()));

        this.add(ModBlocks.CLOSED_EYEBLOSSOM.get(),block ->  createPotFlowerItemTable(ModBlocks.CLOSED_EYEBLOSSOM.get()));

        this.dropSelf(ModBlocks.OPEN_EYEBLOSSOM.get());
        this.dropSelf(ModBlocks.CLOSED_EYEBLOSSOM.get());
        this.dropSelf(ModBlocks.PALE_MOSS_BLOCK.get());
        this.dropSelf(ModBlocks.PALE_MOSS_CARPET.get());

   /*     dropSelf(ModBlocks.PALE_OAK_SLAB.get());
        dropSelf(ModBlocks.PALE_OAK_STAIRS.get());
        dropSelf(ModBlocks.PALE_OAK_FENCE.get());
        dropSelf(ModBlocks.PALE_OAK_FENCE_GATE.get());
        createDoorTable(ModBlocks.PALE_OAK_DOOR.get());
        dropSelf(ModBlocks.PALE_OAK_TRAPDOOR.get());
        dropSelf(ModBlocks.PALE_OAK_BUTTON.get());
        dropSelf(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        dropOther(ModBlocks.PALE_OAK_SIGN, ModItems.PALE_OAK_SIGN.get());
        dropOther(ModBlocks.PALE_OAK_WALL_SIGN, ModItems.PALE_OAK_SIGN.get());
        dropOther(ModBlocks.PALE_OAK_HANGING_SIGN, ModItems.PALE_OAK_HANGING_SIGN.get());
        dropOther(ModBlocks.PALE_OAK_WALL_HANGING_SIGN, ModItems.PALE_OAK_HANGING_SIGN.get());*/
/*
        createPotFlowerItemTable(ModBlocks.POTTED_PALE_OAK_SAPLING.get());
*/

    }

}
