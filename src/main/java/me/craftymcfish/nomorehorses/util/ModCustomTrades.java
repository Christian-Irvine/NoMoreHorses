package me.craftymcfish.nomorehorses.util;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.STRAWBERRY, 12),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f));
                });

        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.STRAWBERRY_SEEDS, 1),
                            4, 2, 0.05f));
                });

        NoMoreHorses.LOGGER.info("Successfully loaded custom villager trades");
    }
}
