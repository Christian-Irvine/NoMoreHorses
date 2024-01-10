package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItemGroups;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoMoreHorses implements ModInitializer {
	public static final String MOD_ID = "no-more-horses";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//final is a const

	@Override
	public void onInitialize() {

		//Register Items
		ModItems.registerItems();
		//Register Blocks
		ModBlocks.registerBlocks();
		//Register Item Groups
		ModItemGroups.registerItemGroups();

		LOGGER.info("Successfully Removed All Horses!, No More Horses is complete");
	}
}