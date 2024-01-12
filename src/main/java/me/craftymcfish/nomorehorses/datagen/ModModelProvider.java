package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cheesePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHEESE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_PORK_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PORK_ORE);

        cheesePool.stairs(ModBlocks.CHEESE_STAIRS);
        cheesePool.slab(ModBlocks.CHEESE_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHEESE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SALT, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAW_MONEY, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MONEY, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MESH, Models.HANDHELD);
    }
}
