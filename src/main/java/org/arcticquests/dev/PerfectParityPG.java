package org.arcticquests.dev;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.arcticquests.dev.block.ModBlocks;
import org.arcticquests.dev.block.custom.entity.ModBlockEntities;
import org.arcticquests.dev.block.wood.ModBlockFamilies;
import org.arcticquests.dev.block.wood.ModWoodTypes;
import org.arcticquests.dev.entity.ModEntities;
import org.arcticquests.dev.entity.client.CreakingRenderer;
import org.arcticquests.dev.item.ModItems;
import org.arcticquests.dev.particles.ModParticles;
import org.arcticquests.dev.particles.PaleOakParticle;
import org.arcticquests.dev.particles.TrailParticle;
import org.arcticquests.dev.sounds.ModSounds;
import org.arcticquests.dev.worldgen.ModConfiguredFeatures;
import org.arcticquests.dev.worldgen.ModPlacedFeatures;
import org.arcticquests.dev.worldgen.biome.ModOverworldRegion;
import org.arcticquests.dev.worldgen.ModTreeDecoratorTypes;
import org.slf4j.Logger;
import terrablender.api.Regions;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(PerfectParityPG.MODID)
public class PerfectParityPG {
    // Define mod id in a common place for everything to reference

    public static final String MODID = "perfectparitypg";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is     the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public PerfectParityPG(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModItems.register(modEventBus);

        ModSounds.register(modEventBus);

        ModParticles.register(modEventBus);

        ModEntities.register(modEventBus);

        ModTreeDecoratorTypes.register(modEventBus);

        ModConfiguredFeatures.registerModConfiguredFeatures();
        ModPlacedFeatures.registerModPlacedFeatures();

        NeoForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        modEventBus.addListener(ModBlockEntities::registerTileExtensions);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.PALE_OAK);
            Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(MODID, "palegarden"), 2));
            ModBlockFamilies.createBlockFamilies();
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.OPEN_EYEBLOSSOM.getId(), ModBlocks.POTTED_OPEN_EYEBLOSSOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PALE_OAK_SAPLING.getId(), ModBlocks.POTTED_PALE_OAK_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CLOSED_EYEBLOSSOM.getId(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {   if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
        event.accept(ModItems.CREAKING_SPAWN_EGG);
    }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
         event.accept(ModItems.RESIN_BRICK);
    }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.RESIN_CLUMP);
            event.accept(ModBlocks.RESIN_BLOCK);
            event.accept(ModBlocks.RESIN_BRICKS);
            event.accept(ModBlocks.RESIN_BRICK_STAIRS);
            event.accept(ModBlocks.RESIN_BRICK_SLAB);
            event.accept(ModBlocks.RESIN_BRICK_WALL);
            event.accept(ModBlocks.CHISELED_RESIN_BRICKS);
            event.accept(ModBlocks.PALE_OAK_PLANKS);
            event.accept(ModBlocks.PALE_OAK_LOG);
            event.accept(ModBlocks.PALE_OAK_WOOD);
            event.accept(ModBlocks.STRIPPED_PALE_OAK_LOG);
            event.accept(ModBlocks.STRIPPED_PALE_OAK_WOOD);
            event.accept(ModBlocks.CREAKING_HEART);
            event.accept(ModBlocks.PALE_OAK_STAIRS);
            event.accept(ModBlocks.PALE_OAK_SLAB);
            event.accept(ModBlocks.PALE_OAK_FENCE);
            event.accept(ModBlocks.PALE_OAK_FENCE_GATE);
            event.accept(ModBlocks.PALE_OAK_DOOR);
            event.accept(ModBlocks.PALE_OAK_PRESSURE_PLATE);
            event.accept(ModBlocks.PALE_OAK_TRAPDOOR);
            event.accept(ModBlocks.PALE_OAK_BUTTON);
            event.accept(ModBlocks.PALE_MOSS_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.PALE_OAK_SAPLING);
            event.accept(ModBlocks.PALE_OAK_LEAVES);
            event.accept(ModBlocks.PALE_MOSS_CARPET);
            event.accept(ModBlocks.PALE_HANGING_MOSS);
            event.accept(ModBlocks.OPEN_EYEBLOSSOM);
            event.accept(ModBlocks.CLOSED_EYEBLOSSOM);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.PALE_OAK_SIGN);
            event.accept(ModItems.PALE_OAK_HANGING_SIGN);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.PALE_OAK_BOAT);
            event.accept(ModItems.PALE_OAK_CHEST_BOAT);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            event.enqueueWork(() -> {Sheets.addWoodType(ModWoodTypes.PALE_OAK);});

            EntityRenderers.register(ModEntities.CREAKING.get(), CreakingRenderer::new);

            EntityRenderers.register(ModEntities.PALE_OAK_BOAT.get(), context -> new BoatRenderer(context, false));
            EntityRenderers.register(ModEntities.PALE_OAK_CHEST_BOAT.get(), context-> new BoatRenderer(context,true));

            BlockEntityRenderers.register(ModBlockEntities.PALE_OAK_SIGN.get(), SignRenderer::new);
            BlockEntityRenderers.register(ModBlockEntities.PALE_OAK_WALL_HANGING_SIGN.get(), HangingSignRenderer::new);

        }
        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.PALE_OAK_LEAVES.get(), PaleOakParticle.Provider::new);
            event.registerSpriteSet(ModParticles.TRAIL.get(), TrailParticle.Provider::new);
        }
    }
}