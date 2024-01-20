package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.block.custom.GeorgeBlock;
import me.craftymcfish.nomorehorses.block.custom.MaceratorBlock;
import me.craftymcfish.nomorehorses.block.custom.StrawberryCropBlock;
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
    public static final Block MARBLE_STAIRS = registerBlock("marble_stairs",
            new StairsBlock(ModBlocks.MARBLE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.MARBLE)));
    public static final Block MARBLE_SLAB = registerBlock("marble_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.MARBLE)));
    public static final Block POLISHED_MARBLE_STAIRS = registerBlock("polished_marble_stairs",
            new StairsBlock(ModBlocks.POLISHED_MARBLE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE)));
    public static final Block POLISHED_MARBLE_SLAB = registerBlock("polished_marble_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE)));

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
