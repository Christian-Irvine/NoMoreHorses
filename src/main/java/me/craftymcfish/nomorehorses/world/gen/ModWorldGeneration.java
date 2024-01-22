package me.craftymcfish.nomorehorses.world.gen;

import me.craftymcfish.nomorehorses.NoMoreHorses;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        //Put these in a logical order (go into one of the classes and ctrl + click the generation step)

        NoMoreHorses.LOGGER.info("Successfully Loaded World Generation Features");
    }
}
