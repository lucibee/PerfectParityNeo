package org.arcticquests.dev.block;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.block.custom.*;
import org.arcticquests.dev.block.wood.ModBlockSetTypes;
import org.arcticquests.dev.block.wood.ModWoodTypes;
import org.arcticquests.dev.item.ModItems;
import org.arcticquests.dev.sounds.ModSounds;
import org.arcticquests.dev.worldgen.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PerfectParityPG.MODID);

    public static final DeferredBlock<Block> RESIN_CLUMP = registerBlock("resin_clump",()->
            new ResinClumpBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .replaceable().noCollission()
                    .sound(ModSounds.RESIN)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RESIN_BLOCK = registerBlock("resin_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(ModSounds.RESIN)));

    public static final DeferredBlock<Block> RESIN_BRICKS = registerBlock("resin_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .sound(ModSounds.RESIN_BRICKS)
                    .strength(1.5F, 6.0F)));


    public static final DeferredBlock<StairBlock> RESIN_BRICK_STAIRS = registerBlock("resin_brick_stairs",
            ()-> new StairBlock(
                    RESIN_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties
                            .ofFullCopy(RESIN_BRICKS.get())));

    public static final DeferredBlock<SlabBlock> RESIN_BRICK_SLAB = registerBlock("resin_brick_slab",
            ()->new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.TERRACOTTA_ORANGE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .sound(ModSounds.RESIN_BRICKS)
                            .strength(1.5F, 6.0F)));

    public static final DeferredBlock<WallBlock> RESIN_BRICK_WALL= registerBlock("resin_brick_wall",()->
            new WallBlock(BlockBehaviour.Properties.of().mapColor
                    (MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS)
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> CHISELED_RESIN_BRICKS = registerBlock(
            "chiseled_resin_bricks",()->new Block(BlockBehaviour.Properties.of().
                    mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).
                    requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS)
                    .strength(1.5F, 6.0F)));


    public static final DeferredBlock<Block> PALE_OAK_WOOD = registerBlock("pale_oak_wood", ()-> new
            RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));;

    public static final DeferredBlock<Block>  PALE_OAK_PLANKS = registerBlock("pale_oak_planks",()->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));


    public static final DeferredBlock<Block> PALE_OAK_SAPLING = registerBlock("pale_oak_sapling",()->
            new SaplingBlock(ModTreeGrowers.PALE_OAK,
                    BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ)
                            .noCollission().randomTicks().instabreak()
                            .sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> PALE_OAK_LOG=registerBlock("pale_oak_log",()-> new RotatedPillarBlock(
            BlockBehaviour.Properties.of()
                .mapColor(PALE_OAK_PLANKS.get().defaultMapColor())
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_PALE_OAK_LOG= registerBlock("stripped_pale_oak_log",()-> new RotatedPillarBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(PALE_OAK_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_PALE_OAK_WOOD= registerBlock("stripped_pale_oak_wood",()->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> PALE_OAK_LEAVES = registerBlock("pale_oak_leaves", ()->
            new PaleOakLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot)
                    .isSuffocating((state, getter, pos) -> false)
                    .isViewBlocking((state, getter, pos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor((state, getter, pos) -> false)));


    public static final DeferredBlock<StandingSignBlock> PALE_OAK_SIGN = registerBlock("pale_oak_sign",
            () -> new StandingSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));

    public static final DeferredBlock<WallSignBlock> PALE_OAK_WALL_SIGN = registerBlockOnly("pale_oak_wall_sign",
            () -> new WallSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));

    public static final DeferredBlock<CeilingHangingSignBlock> PALE_OAK_HANGING_SIGN = registerBlock("pale_oak_hanging_sign",
            () -> new CeilingHangingSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));

    public static final DeferredBlock<WallHangingSignBlock> PALE_OAK_WALL_HANGING_SIGN = registerBlockOnly("pale_oak_wall_hanging_sign",
            () -> new WallHangingSignBlock(ModWoodTypes.PALE_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));


    //Non Block Blocks
    public static final DeferredBlock<PressurePlateBlock> PALE_OAK_PRESSURE_PLATE =
            registerBlock("pale_oak_pressure_plate",()->
                    new PressurePlateBlock(ModBlockSetTypes.PALE_OAK,
                            BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollission()
                                    .strength(0.5F)
                                    .ignitedByLava()
                                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<TrapDoorBlock> PALE_OAK_TRAPDOOR = registerBlock("pale_oak_trapdoor", ()->
            new TrapDoorBlock(ModBlockSetTypes.PALE_OAK,
                    BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get()
                            .defaultMapColor()).instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava()));


    public static final DeferredBlock<ButtonBlock> PALE_OAK_BUTTON =
            registerBlock("pale_oak_button",
                    ()->new ButtonBlock( ModBlockSetTypes.PALE_OAK,
                            30,
                            BlockBehaviour.Properties.of().noCollission()
                                    .strength(0.5F).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<StairBlock>
            PALE_OAK_STAIRS = registerBlock("pale_oak_stairs",()-> new StairBlock(PALE_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.PALE_OAK_PLANKS.get())));

    public static final DeferredBlock<SlabBlock> PALE_OAK_SLAB = registerBlock("pale_oak_slab",()-> new SlabBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<FenceGateBlock> PALE_OAK_FENCE_GATE = registerBlock("pale_oak_fence_gate",()-> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava()));

    public static final DeferredBlock<FenceBlock> PALE_OAK_FENCE = registerBlock("pale_oak_fence", ()->new FenceBlock(BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));

    public static final DeferredBlock<DoorBlock> PALE_OAK_DOOR = registerBlock("pale_oak_door",()-> new DoorBlock(ModBlockSetTypes.PALE_OAK, BlockBehaviour.Properties.of().mapColor(PALE_OAK_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> CREAKING_HEART = registerBlock("creaking_heart",()-> new CreakingHeartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0F).sound(ModSounds.CREAKING_HEART)));

    public static final DeferredBlock<Block> PALE_MOSS_BLOCK = registerBlock("pale_moss_block", ()->new ModPaleMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",()-> new ModPaleModCarpet(BlockBehaviour.Properties.of().ignitedByLava().mapColor(PALE_MOSS_BLOCK.get().defaultMapColor()).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final DeferredBlock<Block> PALE_HANGING_MOSS = registerBlock("pale_hanging_moss", ()-> new HangingMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> OPEN_EYEBLOSSOM = registerBlock("open_eyeblossom", ()->new EyeblossomBlock(EyeblossomBlock.Type.OPEN, BlockBehaviour.Properties.of().mapColor(CREAKING_HEART.get().defaultMapColor()).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));

    public static final DeferredBlock<Block> CLOSED_EYEBLOSSOM = registerBlock("closed_eyeblossom", ()-> new EyeblossomBlock(EyeblossomBlock.Type.CLOSED, BlockBehaviour.Properties.of().mapColor(PALE_OAK_LEAVES.get().defaultMapColor()).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));

    public static final DeferredBlock<Block> POTTED_OPEN_EYEBLOSSOM =
            registerBlockOnly("potted_open_eyeblossom", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    OPEN_EYEBLOSSOM, BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final DeferredBlock<Block> POTTED_CLOSED_EYEBLOSSOM =
            registerBlockOnly("potted_closed_eyeblossom", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    CLOSED_EYEBLOSSOM, BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final DeferredBlock<Block> POTTED_PALE_OAK_SAPLING =
            registerBlockOnly("potted_pale_oak_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    PALE_OAK_SAPLING, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

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
