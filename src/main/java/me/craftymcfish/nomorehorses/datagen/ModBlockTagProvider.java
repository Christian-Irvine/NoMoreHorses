package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
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
                .add(ModBlocks.GEORGE)
                .add(ModBlocks.MARBLE)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.POLISHED_MARBLE)
                .add(ModBlocks.POLISHED_MARBLE_STAIRS)
                .add(ModBlocks.POLISHED_MARBLE_SLAB)
                .add(ModBlocks.MARBLE_BRICKS)
                .add(ModBlocks.MARBLE_BRICK_STAIRS)
                .add(ModBlocks.MARBLE_BRICK_SLAB)
                .add(ModBlocks.MARBLE_PILLAR)
                .add(ModBlocks.INFUSED_MARBLE_PILLAR)
                .add(ModBlocks.MARBLE_WALL)
                .add(ModBlocks.POLISHED_MARBLE_WALL)
                .add(ModBlocks.MARBLE_BRICK_WALL)
                .add(ModBlocks.MACERATOR)
                .add(ModBlocks.VOIDFIRE_ORE)
                .add(ModBlocks.CRACKED_END_STONE)

                .add(ModBlocks.LIVING_DIAMOND_ORE)
                .add(ModBlocks.LIVING_GOLD_ORE)
                .add(ModBlocks.LIVING_IRON_ORE)
                .add(ModBlocks.LIVING_COPPER_ORE)
                .add(ModBlocks.LIVING_LAPIS_ORE)
                .add(ModBlocks.LIVING_REDSTONE_ORE)
                .add(ModBlocks.LIVING_COAL_ORE)
                .add(ModBlocks.LIVING_EMERALD_ORE)
                .add(ModBlocks.LIVING_QUARTZ_ORE)
                .add(ModBlocks.LIVING_VOIDFIRE_ORE)

                .add(ModBlocks.LIVING_SPORE)

                .add(ModBlocks.WHITE_CONCRETE_SLAB)
                .add(ModBlocks.WHITE_CONCRETE_STAIRS)
                .add(ModBlocks.GRAY_CONCRETE_SLAB)
                .add(ModBlocks.GRAY_CONCRETE_STAIRS)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS)
                .add(ModBlocks.BLACK_CONCRETE_SLAB)
                .add(ModBlocks.BLACK_CONCRETE_STAIRS)
                .add(ModBlocks.RED_CONCRETE_SLAB)
                .add(ModBlocks.RED_CONCRETE_STAIRS)
                .add(ModBlocks.ORANGE_CONCRETE_SLAB)
                .add(ModBlocks.ORANGE_CONCRETE_STAIRS)
                .add(ModBlocks.YELLOW_CONCRETE_SLAB)
                .add(ModBlocks.YELLOW_CONCRETE_STAIRS)
                .add(ModBlocks.LIME_CONCRETE_SLAB)
                .add(ModBlocks.LIME_CONCRETE_STAIRS)
                .add(ModBlocks.GREEN_CONCRETE_SLAB)
                .add(ModBlocks.GREEN_CONCRETE_STAIRS)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS)
                .add(ModBlocks.CYAN_CONCRETE_SLAB)
                .add(ModBlocks.CYAN_CONCRETE_STAIRS)
                .add(ModBlocks.BLUE_CONCRETE_SLAB)
                .add(ModBlocks.BLUE_CONCRETE_STAIRS)
                .add(ModBlocks.PURPLE_CONCRETE_SLAB)
                .add(ModBlocks.PURPLE_CONCRETE_STAIRS)
                .add(ModBlocks.MAGENTA_CONCRETE_SLAB)
                .add(ModBlocks.MAGENTA_CONCRETE_STAIRS)
                .add(ModBlocks.PINK_CONCRETE_SLAB)
                .add(ModBlocks.PINK_CONCRETE_STAIRS)
                .add(ModBlocks.BROWN_CONCRETE_SLAB)
                .add(ModBlocks.BROWN_CONCRETE_STAIRS)

                .add(ModBlocks.SHULKER_SHINGLES)
                .add(ModBlocks.SHULKER_SHINGLE_SLAB)
                .add(ModBlocks.SHULKER_SHINGLE_STAIRS)

                .add(ModBlocks.SHULKER_BRICKS)
                .add(ModBlocks.SHULKER_BRICK_SLAB)
                .add(ModBlocks.SHULKER_BRICK_STAIRS)

                .add(ModBlocks.SHINGLES)
                .add(ModBlocks.SHINGLE_SLAB)
                .add(ModBlocks.SHINGLE_STAIRS)

                .add(ModBlocks.IRON_SHINGLES)
                .add(ModBlocks.IRON_SHINGLE_SLAB)
                .add(ModBlocks.IRON_SHINGLE_STAIRS)

                .add(ModBlocks.VOIDFIRE_BLOCK)
                .add(ModBlocks.RIFTSTEEL_BLOCK)

                .add(ModBlocks.ISLAND_HEART);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CHEESE_BLOCK)
                .add(ModBlocks.CHEESE_STAIRS)
                .add(ModBlocks.CHEESE_SLAB)
                .add(ModBlocks.PORK_BLOCK)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD)
                .add(ModBlocks.OLIVE_PLANKS)
                .add(ModBlocks.OLIVE_STAIRS)
                .add(ModBlocks.OLIVE_SLAB)
                .add(ModBlocks.OLIVE_FENCE)
                .add(ModBlocks.OLIVE_FENCE_GATE)
                .add(ModBlocks.OLIVE_BUTTON)
                .add(ModBlocks.OLIVE_PRESSURE_PLATE)
                .add(ModBlocks.OLIVE_TRAP_DOOR)
                .add(ModBlocks.OLIVE_DOOR)
                .add(ModBlocks.FISHER);


        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.DENSE_SPONGE)
                .add(ModBlocks.DENSE_WET_SPONGE)
                .add(ModBlocks.OLIVE_LEAVES);


        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
                //.add(ModBlocks.EXAMPLE_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PORK_ORE)
                .add(ModBlocks.DEEPSLATE_PORK_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VOIDFIRE_ORE)
                .add(ModBlocks.RIFTSTEEL_BLOCK)
                .add(ModBlocks.ISLAND_HEART);


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.GEORGE)
                .add(ModBlocks.LIVING_SPORE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.OLIVE_LOG)
                .add(ModBlocks.OLIVE_WOOD)
                .add(ModBlocks.STRIPPED_OLIVE_LOG)
                .add(ModBlocks.STRIPPED_OLIVE_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.OLIVE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.OLIVE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MARBLE_WALL)
                .add(ModBlocks.POLISHED_MARBLE_WALL)
                .add(ModBlocks.MARBLE_BRICK_WALL);
    }
}
