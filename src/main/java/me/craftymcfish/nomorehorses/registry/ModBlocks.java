package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.blocks.StrawberryCropBlock;
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

    public static final Block GEORGE = registerBlock("george", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN), UniformIntProvider.create(50, 100)));

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
