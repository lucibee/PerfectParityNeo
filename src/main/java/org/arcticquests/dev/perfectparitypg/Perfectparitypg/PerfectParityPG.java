package org.arcticquests.dev.perfectparitypg.Perfectparitypg;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
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
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.ModBlocks;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.custom.entity.ModBlockEntities;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.wood.ModBlockFamilies;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.ModEntities;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.client.CreakingRenderer;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.item.ModItems;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.particles.ModParticles;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.particles.PaleOakParticle;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.particles.TrailParticle;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.sounds.ModSounds;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.util.WoodTypeVariant;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.ModConfiguredFeatures;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.ModPlacedFeatures;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.ModTreeDecoratorTypes;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.worldgen.biome.ModOverworldRegion;
import org.slf4j.Logger;
import terrablender.api.Regions;


@Mod(PerfectParityPG.MODID)
public class PerfectParityPG {

    public static final String MODID = "perfectparitypg";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PerfectParityPG(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.COMMON, org.arcticquests.dev.perfectparitypg.Perfectparitypg.config.CreakingFleeConfig.CONFIG);
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

        modEventBus.addListener(this::addCreative);

        modEventBus.addListener(ModBlockEntities::registerTileExtensions);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
            registerFlammables();
            Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath("minecraft", "palegarden"), 2));
            ModBlockFamilies.createBlockFamilies();
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.OPEN_EYEBLOSSOM.getId(), ModBlocks.POTTED_OPEN_EYEBLOSSOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PALE_OAK_SAPLING.getId(), ModBlocks.POTTED_PALE_OAK_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CLOSED_EYEBLOSSOM.getId(), ModBlocks.POTTED_CLOSED_EYEBLOSSOM);
        });

    }
    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(ModBlocks.CLOSED_EYEBLOSSOM.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.OPEN_EYEBLOSSOM.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.PALE_MOSS_BLOCK.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.PALE_MOSS_BLOCK.get().asItem(), 0.3f); // (Note: This will overwrite the previous value for PALE_MOSS_BLOCK)
        ComposterBlock.COMPOSTABLES.put(ModBlocks.PALE_HANGING_MOSS.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.PALE_MOSS_CARPET.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.PALE_OAK_LEAVES.get().asItem(), 0.3f);
    }
    public static void registerFlammables() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(ModBlocks.PALE_OAK_LOG.get(), 5, 5);
        fire.setFlammable(ModBlocks.STRIPPED_PALE_OAK_LOG.get(), 5, 5);
        fire.setFlammable(ModBlocks.PALE_OAK_WOOD.get(), 5, 5);
        fire.setFlammable(ModBlocks.STRIPPED_PALE_OAK_WOOD.get(), 5, 5);
        fire.setFlammable(ModBlocks.PALE_OAK_PLANKS.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_OAK_LEAVES.get(), 30, 60);
        fire.setFlammable(ModBlocks.PALE_OAK_SLAB.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_OAK_STAIRS.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_OAK_FENCE.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_OAK_FENCE_GATE.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_HANGING_MOSS.get(), 5, 100);
        fire.setFlammable(ModBlocks.PALE_MOSS_BLOCK.get(), 5, 20);
        fire.setFlammable(ModBlocks.PALE_MOSS_CARPET.get(), 5, 100);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.CREAKING_SPAWN_EGG);
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

        if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            event.insertAfter(ModBlocks.RESIN_CLUMP.toStack(), ModItems.RESIN_BRICK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(WoodTypeVariant.PALE_OAK.getWoodType());
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_HANGING_MOSS.get(), net.minecraft.client.renderer.RenderType.cutout());
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.OPEN_EYEBLOSSOM.get(), net.minecraft.client.renderer.RenderType.cutout());
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOSED_EYEBLOSSOM.get(), net.minecraft.client.renderer.RenderType.cutout());
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.RESIN_CLUMP.get(), net.minecraft.client.renderer.RenderType.cutout());
                net.minecraft.client.renderer.ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_MOSS_CARPET.get(), net.minecraft.client.renderer.RenderType.cutout());

            });

            EntityRenderers.register(ModEntities.CREAKING.get(), CreakingRenderer::new);

            EntityRenderers.register(ModEntities.PALE_OAK_BOAT.get(), context ->
                    new org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.client.PaleOakBoatRenderer(context, false));

            EntityRenderers.register(ModEntities.PALE_OAK_CHEST_BOAT.get(), context ->
                    new org.arcticquests.dev.perfectparitypg.Perfectparitypg.entity.client.PaleOakBoatRenderer(context, true));

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