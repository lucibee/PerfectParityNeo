package org.arcticquests.dev.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.block.wood.ModBlockFamilies;
import org.arcticquests.dev.item.ModItems;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;
import static net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookuprovider) {
        super(output, lookuprovider);
    }

    @Override
    protected void buildRecipes(RecipeOutput exporter) {
        woodRecipes(exporter);

        shapeless(RecipeCategory.MISC, Items.GRAY_DYE)
                .requires(ModBlocks.CLOSED_EYEBLOSSOM.get())
                .unlockedBy(getHasName(ModBlocks.CLOSED_EYEBLOSSOM.get()), has(ModBlocks.CLOSED_EYEBLOSSOM.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"gray_dye_from_closed_eyeblossom"));

        shapeless(RecipeCategory.MISC, Items.ORANGE_DYE)
                .requires(ModBlocks.OPEN_EYEBLOSSOM.get())
                .unlockedBy(getHasName(ModBlocks.OPEN_EYEBLOSSOM.get()), has(ModBlocks.OPEN_EYEBLOSSOM.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"orange_dye_from_closed_eyeblossom"));


        shaped(RecipeCategory.MISC, ModBlocks.CREAKING_HEART.get())
                .define('#', ModBlocks.PALE_OAK_LOG.get())
                .define('O', ModBlocks.RESIN_BLOCK.get())
                .pattern("#")
                .pattern("O")
                .pattern("#")
                .unlockedBy(getHasName(ModBlocks.RESIN_BLOCK.get()), has(ModBlocks.RESIN_BLOCK.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"creaking_heart"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BLOCK.get())
                .define('#', ModBlocks.RESIN_CLUMP.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_CLUMP.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_block"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICKS.get())
                .define('#', ModItems.RESIN_BRICK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_CLUMP.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_bricks"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_STAIRS, 4)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_BRICKS.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_brick_stairs"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_SLAB.get(), 6)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_CLUMP.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_brick_slab"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RESIN_BRICK_WALL.get(), 6)
                .define('#', ModBlocks.RESIN_BRICKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_CLUMP.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_brick_wall"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RESIN_BRICKS.get())
                .define('#', ModBlocks.RESIN_BRICK_SLAB.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(ModBlocks.RESIN_CLUMP.get()), has(ModBlocks.RESIN_CLUMP.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"chiseled_resin_bricks"));

        shapeless(RecipeCategory.MISC, ModBlocks.RESIN_CLUMP.get(), 9)
                .requires(ModBlocks.RESIN_BLOCK)
                .unlockedBy(getHasName(ModBlocks.RESIN_BLOCK.get()), has(ModBlocks.RESIN_BLOCK.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"resin_clump_from_block"));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.RESIN_BRICK_SLAB.get(), ModBlocks.RESIN_BRICKS.get(), 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.RESIN_BRICK_WALL.get(), ModBlocks.RESIN_BRICKS.get());
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.RESIN_BRICK_STAIRS.get(), ModBlocks.RESIN_BRICKS.get());
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CHISELED_RESIN_BRICKS.get(), ModBlocks.RESIN_BRICKS.get());
    }


    private void woodRecipes(RecipeOutput exporter) {
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_PLANKS.get(), 4)
                .requires(ModItemTagProvider.PALE_OAK_LOGS)
                .unlockedBy("has_pale_oak_logs", has(ModItemTagProvider.PALE_OAK_LOGS))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_planks"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_STAIRS.get(), 4)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_stairs"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_SLAB, 6)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("###")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_slab"));

        shaped(RecipeCategory.MISC, ModBlocks.PALE_OAK_FENCE, 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("#S#")
                .pattern("#S#")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_fence"));

        shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_FENCE_GATE.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S',  Items.STICK)
                .pattern("S#S")
                .pattern("S#S")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_fence_gate"));

       /* shaped(RecipeCategory.REDSTONE, ModItems.PALE_OAK_SIGN.get(), 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .define('S',  Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" S ")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_sign"));
*/
        shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_DOOR.get(), 3)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_door"));

        shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_TRAPDOOR.get(), 2)
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_trapdoor"));

      /*  shaped(RecipeCategory.DECORATIONS, ModItems.PALE_OAK_HANGING_SIGN.get(), 6)
                .define('#', ModBlocks.STRIPPED_PALE_OAK_LOG.get())
                .define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_log", has(ModBlocks.STRIPPED_PALE_OAK_LOG.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_hanging_sign"));
*/
/*        shaped(RecipeCategory.TRANSPORTATION, ModItems.PALE_OAK_BOAT.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("# #")
                .pattern("###")
                .unlockedBy("in_water", insideOf(Blocks.WATER))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_boat"));*/

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), 3)
                .define('#', ModBlocks.STRIPPED_PALE_OAK_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_log", has(ModBlocks.STRIPPED_PALE_OAK_LOG.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"stripped_pale_oak_wood"));

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_WOOD.get(), 3)
                .define('#', ModBlocks.PALE_OAK_LOG.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_log", has(ModBlocks.PALE_OAK_PLANKS))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_wood"));

/*        shapeless(RecipeCategory.DECORATIONS, ModItems.PALE_OAK_CHEST_BOAT.get())
                .requires(ModItems.PALE_OAK_BOAT.get())
                .requires(Items.CHEST)
                .unlockedBy("has_boat", has(ModItems.PALE_OAK_BOAT.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_chest_boat"));*/

        shapeless(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_BUTTON.get())
                .requires(ModBlocks.PALE_OAK_PLANKS.get())
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_button"));

        shaped(RecipeCategory.REDSTONE, ModBlocks.PALE_OAK_PRESSURE_PLATE.get())
                .define('#', ModBlocks.PALE_OAK_PLANKS.get())
                .pattern("##")
                .unlockedBy("has_planks", has(ModBlocks.PALE_OAK_PLANKS.get()))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"pale_oak_pressure_plate"));

        generateRecipes(exporter, ModBlockFamilies.PALE_OAK, FeatureFlagSet.of());
    }



}
