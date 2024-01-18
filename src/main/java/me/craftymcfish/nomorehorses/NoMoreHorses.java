package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.block.custom.entity.ModBlockEntities;
import me.craftymcfish.nomorehorses.entity.ModEntities;
import me.craftymcfish.nomorehorses.entity.custom.SnailEntity;
import me.craftymcfish.nomorehorses.recipe.ModRecipes;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItemGroups;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.screen.ModScreenHandlers;
import me.craftymcfish.nomorehorses.sound.ModSounds;
import me.craftymcfish.nomorehorses.util.ModCustomTrades;
import me.craftymcfish.nomorehorses.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoMoreHorses implements ModInitializer {
	public static final String MOD_ID = "nomorehorses";
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

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.MONEY, 800);
		LOGGER.info("Successfully Registered Fuel Items");

		FabricDefaultAttributeRegistry.register(ModEntities.SNAIL, SnailEntity.createSnailAttributes());

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		LOGGER.info("Successfully Removed All Horses!, No More Horses is complete");
	}
}