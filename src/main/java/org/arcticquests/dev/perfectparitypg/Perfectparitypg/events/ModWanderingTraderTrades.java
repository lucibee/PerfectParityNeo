package org.arcticquests.dev.perfectparitypg.Perfectparitypg.events;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.block.ModBlocks;
import org.arcticquests.dev.perfectparitypg.Perfectparitypg.PerfectParityPG;

@EventBusSubscriber(modid = PerfectParityPG.MODID)
public class ModWanderingTraderTrades {
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        addTrade(event, ModBlocks.PALE_HANGING_MOSS.get().asItem(), 1, 1, 8);
        addTrade(event, ModBlocks.PALE_MOSS_BLOCK.get().asItem(), 1, 2, 5);
        addTrade(event, ModBlocks.OPEN_EYEBLOSSOM.get().asItem(), 2, 1, 8);
        addTrade(event, ModBlocks.PALE_OAK_SAPLING.get().asItem(), 5, 1, 8);
    }

    private static void addTrade(WandererTradesEvent event, ItemLike item, int emeralds, int count, int maxUses) {
        event.getGenericTrades().add((trader, random) -> new MerchantOffer(
            new ItemCost(Items.EMERALD, emeralds),
            new ItemStack(item, count),
            maxUses,
            1,
            0.05F
        ));
    }
}
