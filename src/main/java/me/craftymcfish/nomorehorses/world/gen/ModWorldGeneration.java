package me.craftymcfish.nomorehorses.world.gen;

import me.craftymcfish.nomorehorses.NoMoreHorses;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        NoMoreHorses.LOGGER.info("Successfully Loaded World Generation Features");
    }
}
