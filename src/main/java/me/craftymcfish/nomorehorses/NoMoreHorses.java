package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.block.custom.entity.ModBlockEntities;
import me.craftymcfish.nomorehorses.color.ModColorProvider;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import me.craftymcfish.nomorehorses.entity.ModEntities;
import me.craftymcfish.nomorehorses.entity.custom.SnailEntity;
import me.craftymcfish.nomorehorses.entity.custom.WanderingCollectorEntity;
import me.craftymcfish.nomorehorses.potion.ModPotions;
import me.craftymcfish.nomorehorses.recipe.ModRecipes;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItemGroups;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.screen.ModScreenHandlers;
import me.craftymcfish.nomorehorses.sound.ModSounds;
import me.craftymcfish.nomorehorses.util.ModCustomTrades;
import me.craftymcfish.nomorehorses.util.ModLootTableModifiers;
import me.craftymcfish.nomorehorses.villager.ModVillagers;
import me.craftymcfish.nomorehorses.world.gen.ModEntityGeneration;
import me.craftymcfish.nomorehorses.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoMoreHorses implements ModInitializer {
	public static final String MOD_ID = "nomorehorses";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> EXHAUST_LIVING_ORES = registerBooleanGameRule("exhaustLivingOres", GameRules.Category.UPDATES, true);
	public static final GameRules.Key<GameRules.BooleanRule> DO_COLLECTOR_SPAWNING = registerBooleanGameRule("doCollectorSpawning", GameRules.Category.UPDATES, true);

	//final is a const

	@Override
	public void onInitialize() {
		//Register Items
		ModItems.registerItems();
		//Register Blocks
		ModBlocks.registerBlocks();

		StrippableBlockRegistry.register(ModBlocks.OLIVE_LOG, ModBlocks.STRIPPED_OLIVE_LOG);
		StrippableBlockRegistry.register(ModBlocks.OLIVE_WOOD, ModBlocks.STRIPPED_OLIVE_WOOD);

		StrippableBlockRegistry.register(ModBlocks.CHORUS_LOG, ModBlocks.STRIPPED_CHORUS_LOG);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_OLIVE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_OLIVE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_DOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_TRAP_DOOR, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OLIVE_LEAVES, 30, 60);

		//Register Item Groups
		ModItemGroups.registerItemGroups();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.MONEY, 100);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_2, 200);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_4, 400);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_8, 800);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_16, 1600);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_32, 3200);
		FuelRegistry.INSTANCE.add(ModItems.MONEY_64, 6400);
		LOGGER.info("Successfully Registered Fuel Items");

		FabricDefaultAttributeRegistry.register(ModEntities.SNAIL, SnailEntity.createSnailAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.WANDERING_COLLECTOR, WanderingCollectorEntity.createMobAttributes());

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		ModVillagers.registerVillagers();

		ModWorldGeneration.generateModWorldGen();

		ModEffects.registerStatusEffects();
		ModPotions.registerPotions();

		ModEntityGeneration.addSpawns();

		LOGGER.info("Successfully Removed All Horses!, No More Horses is complete");
	}

	public static GameRules.Key<GameRules.BooleanRule> registerBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
		NoMoreHorses.LOGGER.info("Registered " + name + " Gamerule");
		return GameRuleRegistry.register(name, category, GameRuleFactory.createBooleanRule(defaultValue));
	}
}