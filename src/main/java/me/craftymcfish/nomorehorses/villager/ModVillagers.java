package me.craftymcfish.nomorehorses.villager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ModVillagers {


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent workSound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NoMoreHorses.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(NoMoreHorses.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(NoMoreHorses.MOD_ID, name));
    }

    public static void registerVillagers() {
        NoMoreHorses.LOGGER.info("Registering Villagers");
    }

}
