package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.block.custom.*;
import me.craftymcfish.nomorehorses.sound.ModSounds;
import me.craftymcfish.nomorehorses.world.tree.OliveSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {
    public static final Block PORK_BLOCK = registerBlock("pork_block",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.FROGLIGHT)));
    public static final Block DEEPSLATE_PORK_ORE = registerBlock("deepslate_pork_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE), UniformIntProvider.create(5, 10)));
    public static final Block PORK_ORE = registerBlock("pork_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE), UniformIntProvider.create(5, 10)));

    public static final Block GEORGE = registerBlock("george", new GeorgeBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).sounds(ModSounds.GEORGE_SOUNDS)));

    public static final Block CHEESE_BLOCK = registerBlock("cheese_block", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.FROGLIGHT)));
    public static final Block CHEESE_STAIRS = registerBlock("cheese_stairs",
            new StairsBlock(ModBlocks.CHEESE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CHEESE_BLOCK)));
    public static final Block CHEESE_SLAB = registerBlock("cheese_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CHEESE_BLOCK)));

    public static final Block STRAWBERRY_CROP = Registry.register(Registries.BLOCK, new Identifier(NoMoreHorses.MOD_ID, "strawberry_crop"),
            new StrawberryCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block DAFFODIL = registerBlock("daffodil",
            new FlowerBlock(StatusEffects.LUCK, 10, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block POTTED_DAFFODIL = Registry.register(Registries.BLOCK, new Identifier(NoMoreHorses.MOD_ID, "potted_daffodil"),
            new FlowerPotBlock(DAFFODIL, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block MARBLE = registerBlock("marble", new Block(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK)));
    public static final Block POLISHED_MARBLE = registerBlock("polished_marble", new Block(FabricBlockSettings.copyOf(MARBLE)));
    public static final Block MARBLE_BRICKS = registerBlock("marble_bricks", new Block(FabricBlockSettings.copyOf(MARBLE)));
    public static final Block MARBLE_PILLAR = registerBlock("marble_pillar",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_PILLAR)));
    public static final Block INFUSED_MARBLE_PILLAR = registerBlock("infused_marble_pillar",
            new PillarBlock(FabricBlockSettings.copyOf(ModBlocks.MARBLE_PILLAR)));

    public static final Block MARBLE_STAIRS = registerBlock("marble_stairs",
            new StairsBlock(ModBlocks.MARBLE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.MARBLE)));
    public static final Block MARBLE_SLAB = registerBlock("marble_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.MARBLE)));

    public static final Block POLISHED_MARBLE_STAIRS = registerBlock("polished_marble_stairs",
            new StairsBlock(ModBlocks.POLISHED_MARBLE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE)));
    public static final Block POLISHED_MARBLE_SLAB = registerBlock("polished_marble_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE)));

    public static final Block MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
            new StairsBlock(ModBlocks.MARBLE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.MARBLE)));
    public static final Block MARBLE_BRICK_SLAB = registerBlock("marble_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.MARBLE_BRICKS)));

    public static final Block MACERATOR = registerBlock("macerator",
            new MaceratorBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).nonOpaque()));

    public static final Block OLIVE_LOG = registerBlock("olive_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3f)));
    public static final Block OLIVE_WOOD = registerBlock("olive_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(3f)));
    public static final Block OLIVE_LEAVES = registerBlock("olive_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(3f).nonOpaque()));
    public static final Block OLIVE_PLANKS = registerBlock("olive_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3f)));

    public static final Block OLIVE_STAIRS = registerBlock("olive_stairs",
            new StairsBlock(ModBlocks.OLIVE_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS)));
    public static final Block OLIVE_SLAB = registerBlock("olive_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS)));
    public static final Block OLIVE_BUTTON = registerBlock("olive_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS).noCollision(), BlockSetType.OAK, 15, true));
    //Blocks.createWoodenButtonBlock(BlockSetType.OAK, new FeatureFlag[0]));
    public static final Block OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS).noCollision(), BlockSetType.OAK));
    public static final Block OLIVE_FENCE = registerBlock("olive_fence",
            new FenceBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS)));
    public static final Block OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS), WoodType.OAK));
    public static final Block OLIVE_DOOR = registerBlock("olive_door",
            new DoorBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block OLIVE_TRAP_DOOR = registerBlock("olive_trap_door",
            new TrapdoorBlock(FabricBlockSettings.copyOf(ModBlocks.OLIVE_PLANKS).nonOpaque(), BlockSetType.OAK));

    public static final Block OLIVE_SAPLING = registerBlock("olive_sapling",
            new SaplingBlock(new OliveSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block POTTED_OLIVE_SAPLING = Registry.register(Registries.BLOCK, new Identifier(NoMoreHorses.MOD_ID, "potted_olive_sapling"),
            new FlowerPotBlock(OLIVE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block VOIDFIRE_ORE = registerBlock("voidfire_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE).strength(8), UniformIntProvider.create(5, 10)));
    public static final Block VOIDFIRE_BLOCK = registerBlock("voidfire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

    public static final Block ISLAND_HEART = registerBlock("island_heart",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block RIFTSTEEL_BLOCK = registerBlock("riftsteel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));

    public static final Block DENSE_SPONGE = registerBlock("dense_sponge",
            new DenseSpongeBlock(FabricBlockSettings.copyOf(Blocks.SPONGE)));

    public static final Block DENSE_WET_SPONGE = registerBlock("dense_wet_sponge",
            new Block(FabricBlockSettings.copyOf(Blocks.WET_SPONGE)));

    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE)));

    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));

    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_CONCRETE)));
    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.RED_CONCRETE)));

    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE)));

    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE)));

    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE)));

    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE)));

    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE)));

    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE)));

    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE)));

    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE)));

    public static final Block SHULKER_SHINGLES = registerBlock("shulker_shingles",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS).sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block SHULKER_SHINGLE_SLAB = registerBlock("shulker_shingle_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.SHULKER_SHINGLES)));
    public static final Block SHULKER_SHINGLE_STAIRS = registerBlock("shulker_shingle_stairs",
            new StairsBlock(ModBlocks.SHULKER_SHINGLES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.SHULKER_SHINGLES)));

    public static final Block SHULKER_BRICKS = registerBlock("shulker_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).sounds(BlockSoundGroup.DECORATED_POT)));

    public static final Block SHULKER_BRICK_SLAB = registerBlock("shulker_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.SHULKER_SHINGLES)));
    public static final Block SHULKER_BRICK_STAIRS = registerBlock("shulker_brick_stairs",
            new StairsBlock(ModBlocks.SHULKER_SHINGLES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.SHULKER_SHINGLES)));

    public static final Block SHINGLES = registerBlock("shingles",
            new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA).sounds(BlockSoundGroup.DECORATED_POT)));

    public static final Block SHINGLE_SLAB = registerBlock("shingle_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.SHINGLES)));
    public static final Block SHINGLE_STAIRS = registerBlock("shingle_stairs",
            new StairsBlock(ModBlocks.SHINGLES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.SHINGLES)));

    public static final Block FISHER = registerBlock("fisher",
            new FisherBlock(FabricBlockSettings.copyOf(Blocks.BARREL).nonOpaque().sounds(BlockSoundGroup.BAMBOO_WOOD)));

    public static final Block WHITE_GLOWSTONE_LAMP = registerBlock("white_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block GRAY_GLOWSTONE_LAMP = registerBlock("gray_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block LIGHT_GRAY_GLOWSTONE_LAMP = registerBlock("light_gray_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block BLACK_GLOWSTONE_LAMP = registerBlock("black_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block RED_GLOWSTONE_LAMP = registerBlock("red_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block ORANGE_GLOWSTONE_LAMP = registerBlock("orange_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block YELLOW_GLOWSTONE_LAMP = registerBlock("yellow_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block LIME_GLOWSTONE_LAMP = registerBlock("lime_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block GREEN_GLOWSTONE_LAMP = registerBlock("green_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block LIGHT_BLUE_GLOWSTONE_LAMP = registerBlock("light_blue_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block CYAN_GLOWSTONE_LAMP = registerBlock("cyan_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block BLUE_GLOWSTONE_LAMP = registerBlock("blue_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block PURPLE_GLOWSTONE_LAMP = registerBlock("purple_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block MAGENTA_GLOWSTONE_LAMP = registerBlock("magenta_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block PINK_GLOWSTONE_LAMP = registerBlock("pink_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));

    public static final Block BROWN_GLOWSTONE_LAMP = registerBlock("brown_glowstone_lamp",
            new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).luminance(15).sounds(BlockSoundGroup.GLASS)));


    public static final Block LIVING_DIAMOND_ORE = registerBlock("living_diamond_ore",
            new LivingOreBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).ticksRandomly().sounds(BlockSoundGroup.MOSS_BLOCK), 0.5f));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(NoMoreHorses.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NoMoreHorses.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        NoMoreHorses.LOGGER.info("Successfully Registered Blocks");
    }
}
