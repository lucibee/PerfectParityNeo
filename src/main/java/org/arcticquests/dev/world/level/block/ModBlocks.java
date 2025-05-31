package org.arcticquests.dev.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.sounds.ModSounds;
import org.arcticquests.dev.world.item.ModItems;


import java.util.function.Supplier;

import static net.minecraft.world.entity.animal.WolfVariants.PALE;

public class ModBlocks {
    private static final ResourceLocation PALE_OAK_SIGN_TEXTURE = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"entity/signs/pale_oak");
    private static final ResourceLocation PALE_OAK_HANGING_SIGN_TEXTURE = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"entity/signs/hanging/pale_oak");
    private static final ResourceLocation PALE_OAK_HANGING_SIGN_GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(PerfectParityPG.MODID,"textures/gui/hanging_signs/pale_oak");

    public static final DeferredBlock<Block> RESIN_CLUMP;
    public static final DeferredBlock<Block> RESIN_BLOCK;
    public static final DeferredBlock<Block> RESIN_BRICKS;
    public static final DeferredBlock<Block> RESIN_BRICK_STAIRS;
    public static final DeferredBlock<Block> RESIN_BRICK_SLAB;
    public static final DeferredBlock<Block> RESIN_BRICK_WALL;
    public static final DeferredBlock<Block> CHISELED_RESIN_BRICKS;

    public static final DeferredBlock<Block> PALE_OAK_WOOD;
    public static final DeferredBlock<Block> PALE_OAK_PLANKS;
    public static final DeferredBlock<Block> PALE_OAK_SAPLING;
    public static final DeferredBlock<Block> PALE_OAK_LOG;
    public static final DeferredBlock<Block> STRIPPED_PALE_OAK_LOG;
    public static final DeferredBlock<Block> STRIPPED_PALE_OAK_WOOD;
    public static final DeferredBlock<Block> PALE_OAK_LEAVES;
    public static final DeferredBlock<Block> PALE_OAK_SIGN;
    public static final DeferredBlock<Block> PALE_OAK_WALL_SIGN;
    public static final DeferredBlock<Block> PALE_OAK_HANGING_SIGN;
    public static final DeferredBlock<Block> PALE_OAK_WALL_HANGING_SIGN;
    public static final DeferredBlock<Block> PALE_OAK_PRESSURE_PLATE;
    public static final DeferredBlock<Block> PALE_OAK_TRAPDOOR;
    public static final DeferredBlock<Block> POTTED_PALE_OAK_SAPLING;
    public static final DeferredBlock<Block> PALE_OAK_BUTTON;
    public static final DeferredBlock<Block> PALE_OAK_STAIRS;
    public static final DeferredBlock<Block> PALE_OAK_SLAB;
    public static final DeferredBlock<Block> PALE_OAK_FENCE_GATE;
    public static final DeferredBlock<Block> PALE_OAK_FENCE;
    public static final DeferredBlock<Block> PALE_OAK_DOOR;

    public static final DeferredBlock<Block> PALE_MOSS_BLOCK;
    public static final DeferredBlock<Block> PALE_MOSS_CARPET;
    public static final DeferredBlock<Block> PALE_HANGING_MOSS;

    public static final DeferredBlock<Block> OPEN_EYEBLOSSOM;
    public static final DeferredBlock<Block> CLOSED_EYEBLOSSOM;
    public static final DeferredBlock<Block> POTTED_OPEN_EYEBLOSSOM;
    public static final DeferredBlock<Block> POTTED_CLOSED_EYEBLOSSOM;

    public static final DeferredBlock<Block> CREAKING_HEART;
    static {
        RESIN_CLUMP = registerBlock("resin_clump", ()->new ResinClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).replaceable().noCollission().sound(ModSounds.RESIN).ignitedByLava().pushReaction(PushReaction.DESTROY)));
        RESIN_BRICKS = registerBlock("resin_bricks", ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
        RESIN_BLOCK = registerBlock("resin_block", ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).sound(ModSounds.RESIN)));

        RESIN_BRICK_STAIRS = registerBlock("resin_brick_stairs", ()-> legacyStair(RESIN_BRICKS));
        RESIN_BRICK_SLAB = registerBlock("resin_brick_slab", ()->new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
        RESIN_BRICK_WALL = registerBlock("resin_brick_wall", ()->new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
        CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks",()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));

        PALE_OAK_WOOD = registerBlock("pale_oak_wood", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
        PALE_OAK_PLANKS = registerBlock("pale_oak_planks", ()->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));

        PALE_OAK_SAPLING = registerBlock("pale_oak_sapling", ()->new SaplingBlock(PaleOakTreeGrower.PALE_OAK, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

        PALE_OAK_LOG = registerBlock("pale_oak_log",()-> log(PALE_OAK_PLANKS.get().defaultMapColor(), PALE_OAK_WOOD.get().defaultMapColor()));
        STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",()->  log(PALE_OAK_PLANKS.get().defaultMapColor(), PALE_OAK_PLANKS.get().defaultMapColor(), SoundType.WOOD));
        STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood", ()->new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
        PALE_OAK_LEAVES = registerBlock("pale_oak_leaves", ()->new PaleOakLeavesBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.TERRACOTTA_GREEN).strength(0.2F)
                .randomTicks().sound(SoundType.GRASS)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating((state, getter, pos) -> false)
                .isViewBlocking((state, getter, pos) -> false)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor((state, getter, pos) -> false)));
        PALE_OAK_SIGN = registerBlock("pale_oak_sign", ()->new SignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()) {
            @Override
            protected MapCodec<? extends SignBlock> codec() {
                return null;
            }

            @Override
            public float getYRotationDegrees(BlockState p_277705_) {
                return 0;
            }
        });
        PALE_OAK_WALL_SIGN = registerBlock("pale_oak_wall_sign", ()->new WallHangingSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
        //PALE_OAK_HANGING_SIGN = registerBlock("pale_oak_hanging_sign", ()->new HangingSignItem(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
        PALE_OAK_WALL_HANGING_SIGN = registerBlock("pale_oak_wall_hanging_sign", ()->new WallHangingSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
        PALE_OAK_PRESSURE_PLATE = registerBlock("pale_oak_pressure_plate", ()->new PressurePlateBlock(ModBlockSetTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY)));
        PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor", ()->new TrapDoorBlock(ModBlockSetTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava()));
        POTTED_PALE_OAK_SAPLING = registerBlockOnly("potted_pale_oak_sapling", ()->new FlowerPotBlock(ModBlocks.PALE_OAK_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

        PALE_OAK_BUTTON = registerBlock("pale_oak_button", ()-> new ButtonBlock(ModBlockSetTypes.PALE_OAK, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)));
        PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",()-> legacyStair(PALE_OAK_PLANKS));
        PALE_OAK_SLAB = registerBlock("pale_oak_slab", ()->new SlabBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
        PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate", ()->new FenceGateBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava()));
        PALE_OAK_FENCE = registerBlock("pale_oak_fence", ()->new FenceBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
        PALE_OAK_DOOR = registerBlock("pale_oak_door", ()->new DoorBlock(ModBlockSetTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));

        CREAKING_HEART = registerBlock("creaking_heart", ()->new CreakingHeartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0F).sound(ModSounds.CREAKING_HEART)));

        PALE_HANGING_MOSS = registerBlock("pale_hanging_moss", ()->new HangingMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));
        PALE_MOSS_BLOCK = registerBlock("pale_moss_block", ()->new ModPaleMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
        PALE_MOSS_CARPET = registerBlock("pale_moss_carpet", ()->new ModPaleModCarpet(BlockBehaviour.Properties.of().ignitedByLava().mapColor(PALE_MOSS_BLOCK.get().defaultMapColor()).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY).noOcclusion()));

        OPEN_EYEBLOSSOM = registerBlock("open_eyeblossom", ()->new EyeblossomBlock(EyeblossomBlock.Type.OPEN, BlockBehaviour.Properties.of().mapColor(CREAKING_HEART.get().defaultMapColor()).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));
        CLOSED_EYEBLOSSOM = registerBlock("closed_eyeblossom", ()->new EyeblossomBlock(EyeblossomBlock.Type.CLOSED, BlockBehaviour.Properties.of().mapColor(PALE_OAK_LEAVES.get().defaultMapColor()).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));


        POTTED_OPEN_EYEBLOSSOM = registerBlockOnly("potted_open_eyeblossom", ()->new FlowerPotBlock(ModBlocks.OPEN_EYEBLOSSOM.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
        POTTED_CLOSED_EYEBLOSSOM = registerBlockOnly("potted_closed_eyeblossom", ()->new FlowerPotBlock(ModBlocks.CLOSED_EYEBLOSSOM.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));


    }

    private static Block log(MapColor p_285370_, MapColor p_285126_) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_285370_ : p_285126_)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }

    private static Block log(MapColor p_285425_, MapColor p_285292_, SoundType p_285418_) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(p_258972_ -> p_258972_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_285425_ : p_285292_)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(p_285418_)
                        .ignitedByLava()
        );
    }

    private static Block legacyStair(DeferredBlock<Block> block) {
        return new StairBlock(block.get().defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(block.get()));
    }

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PerfectParityPG.MODID);

    private static <T extends Block> DeferredBlock<T> registerBlockOnly(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
