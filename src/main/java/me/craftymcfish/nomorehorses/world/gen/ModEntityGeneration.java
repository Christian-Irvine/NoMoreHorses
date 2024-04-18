package me.craftymcfish.nomorehorses.world.gen;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.CHERRY_GROVE),
                SpawnGroup.CREATURE, ModEntities.SNAIL, 40, 2, 4);

        SpawnRestriction.register(ModEntities.SNAIL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        NoMoreHorses.LOGGER.info("Loaded Mod Entity Spawning");
    }
}
