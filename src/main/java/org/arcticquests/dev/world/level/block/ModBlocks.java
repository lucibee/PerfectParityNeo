package org.arcticquests.dev.world.level.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.arcticquests.dev.PerfectParityPG;
import org.arcticquests.dev.sounds.ModSounds;
import org.arcticquests.dev.world.item.ModItems;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    private static final ResourceLocation PALE_OAK_SIGN_TEXTURE = ResourceLocation.withDefaultNamespace("entity/signs/pale_oak");
    private static final ResourceLocation PALE_OAK_HANGING_SIGN_TEXTURE = ResourceLocation.withDefaultNamespace("entity/signs/hanging/pale_oak");
    private static final ResourceLocation PALE_OAK_HANGING_SIGN_GUI_TEXTURE = ResourceLocation.withDefaultNamespace("textures/gui/hanging_signs/pale_oak");


    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> CREAKING_HEART;

    static {
        CREAKING_HEART = registerBlock("creaking_heart",()->
                new CreakingHeartBlock(
                        BlockBehaviour.Properties.of()
                                .strength(10.0F)
                                .mapColor(MapColor.COLOR_ORANGE)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .sound(ModSounds.CREAKING_HEART)));
    }


    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PerfectParityPG.MODID);


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
