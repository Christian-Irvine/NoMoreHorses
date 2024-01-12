package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //CustomTag
//        getOrCreateTagBuilder(ModTags.Blocks.EXAMPLE_TAG_HERE)
//                .add(ModBlocks.EXAMPLE_BLOCK);
//                .forceAddTag(BlockTags.EXAMPLE_TAG) e.g EMERALD_ORES

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PORK_ORE)
                .add(ModBlocks.DEEPSLATE_PORK_ORE)
                .add(ModBlocks.GEORGE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.PORK_BLOCK);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);
                //.add(ModBlocks.EXAMPLE_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
                //.add(ModBlocks.EXAMPLE_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PORK_ORE)
                .add(ModBlocks.DEEPSLATE_PORK_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        .add(ModBlocks.GEORGE);

    }
}
