package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.recipe.BottomlessChaliceRecipe;
import me.craftymcfish.nomorehorses.recipe.BottomlessChaliceRecipeSerializer;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PORK_SMELTABLES = List.of(ModBlocks.PORK_ORE, ModBlocks.DEEPSLATE_PORK_ORE);
    private static final List<ItemConvertible> VOIDFIRE_SMELTABLES = List.of(ModBlocks.VOIDFIRE_ORE);
    private static final List<ItemConvertible> MONEY_SMELTABLES = List.of(ModItems.RAW_MONEY);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //ComplexRecipeJsonBuilder.create(BottomlessChaliceRecipeSerializer.BOTTOMLESS_CHALICE_RECIPE).offerTo(exporter, "potion_bottomless_chalice");

        offerSmelting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 200, "pork");
        offerBlasting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 100, "pork");

        offerSmelting(exporter, MONEY_SMELTABLES, RecipeCategory.TOOLS, ModItems.MONEY, 0.4f, 100, "money");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.PORKCHOP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PORK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.CHEESE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_BLOCK);

        offerSmelting(exporter, List.of(ModItems.VOIDFIRE_ESSENCE), RecipeCategory.MISC, ModItems.VOIDFIRE_SHARD, 0.7f, 200, "voidfire");
        offerBlasting(exporter, List.of(ModItems.VOIDFIRE_ESSENCE), RecipeCategory.MISC, ModItems.VOIDFIRE_SHARD, 0.7f, 100, "voidfire");
        offerSmelting(exporter, VOIDFIRE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDFIRE_ESSENCE, 0.2f, 200, "voidfire_ore");
        offerBlasting(exporter, VOIDFIRE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDFIRE_ESSENCE, 0.2f, 100, "voidfire_ore");

        offerSmelting(exporter, List.of(ModBlocks.ISLAND_HEART), RecipeCategory.TOOLS, ModItems.ENDSTONE_CORE, 1f, 400, "island_heart");
        offerBlasting(exporter, List.of(ModBlocks.ISLAND_HEART), RecipeCategory.TOOLS, ModItems.ENDSTONE_CORE, 1f, 200, "island_heart");

        offerSmelting(exporter, List.of(ModItems.BAGUETTE), RecipeCategory.FOOD, ModItems.BURNT_BAGUETTE, 1f, 200, "burnt_baguette");
        offerCooking(exporter, List.of(ModItems.BAGUETTE), ModItems.BURNT_BAGUETTE, 1f, 50, 600);

        offerSmelting(exporter, List.of(ModItems.ROTTEN_LEATHER), RecipeCategory.MISC, Items.LEATHER, 1f, 200, "leather");

        offerSmelting(exporter, List.of(ModBlocks.DENSE_WET_SPONGE), RecipeCategory.MISC, ModBlocks.DENSE_SPONGE, 1f, 50, "dense_sponge");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROTTEN_LEATHER, 1)
                .input(Items.ROTTEN_FLESH)
                .input(Items.ROTTEN_FLESH)
                .input(Items.ROTTEN_FLESH)
                .input(Items.ROTTEN_FLESH)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"rotten_leather_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MESH, 1)
                .pattern("SRS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STICK)
                .input('R', Items.STRING)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"mesh_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RAW_MONEY, 8)
                .pattern("PPP")
                .pattern("PLP")
                .pattern("PPP")
                .input('P', Items.PAPER)
                .input('L', Items.LIME_DYE)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.LIME_DYE), conditionsFromItem(Items.LIME_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"raw_money_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.GEORGE, 1)
                .pattern("MNM")
                .pattern("EME")
                .pattern("MNM")
                .input('M', ModItems.MONEY)
                .input('N', Items.NETHERITE_INGOT)
                .input('E', Items.EMERALD_BLOCK)
                .criterion(hasItem(ModItems.MONEY), conditionsFromItem(ModItems.MONEY))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.EMERALD_BLOCK), conditionsFromItem(Items.EMERALD_BLOCK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"george_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESE, 1)
                .input(ModItems.SALT)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"cheese_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GRILLED_CHEESE, 1)
                .input(ModItems.CHEESE)
                .input(Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"grilled_cheese_crafting"));

        createStairsRecipe(ModBlocks.CHEESE_STAIRS, Ingredient.ofItems(ModBlocks.CHEESE_BLOCK))
                .criterion(hasItem(ModBlocks.CHEESE_BLOCK), conditionsFromItem(ModBlocks.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"cheese_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_SLAB, Ingredient.ofItems(ModBlocks.CHEESE_BLOCK))
                .criterion(hasItem(ModBlocks.CHEESE_BLOCK), conditionsFromItem(ModBlocks.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"cheese_slab_crafting"));

        createStairsRecipe(ModBlocks.MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"marble_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID,"marble_slab_crafting"));

        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS ,ModBlocks.POLISHED_MARBLE, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "polished_marble_crafting"));

        createStairsRecipe(ModBlocks.POLISHED_MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "polished_marble_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "polished_marble_slab_crafting"));

        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS ,ModBlocks.MARBLE_BRICKS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_bricks_crafting"));

        createStairsRecipe(ModBlocks.MARBLE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.MARBLE_BRICKS))
                .criterion(hasItem(ModBlocks.MARBLE_BRICKS), conditionsFromItem(ModBlocks.MARBLE_BRICKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_brick_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_SLAB, Ingredient.ofItems(ModBlocks.MARBLE_BRICKS))
                .criterion(hasItem(ModBlocks.MARBLE_BRICKS), conditionsFromItem(ModBlocks.MARBLE_BRICKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_brick_slab_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern("   ")
                .input('S', ModBlocks.MARBLE_SLAB)
                .criterion(hasItem(ModBlocks.MARBLE_SLAB), conditionsFromItem(ModBlocks.MARBLE_SLAB))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_pillar_crafting_marble"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern("   ")
                .input('S', ModBlocks.POLISHED_MARBLE_SLAB)
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_SLAB), conditionsFromItem(ModBlocks.POLISHED_MARBLE_SLAB))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_pillar_crafting_polished_marble"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern("   ")
                .input('S', ModBlocks.MARBLE_BRICK_SLAB)
                .criterion(hasItem(ModBlocks.MARBLE_BRICK_SLAB), conditionsFromItem(ModBlocks.MARBLE_BRICK_SLAB))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "marble_pillar_crafting_marble_bricks"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFUSED_MARBLE_PILLAR, 1)
                .input(ModBlocks.MARBLE_PILLAR)
                .input(ModItems.VOIDFIRE_ESSENCE)
                .criterion(hasItem(ModBlocks.MARBLE_PILLAR), conditionsFromItem(ModBlocks.MARBLE_PILLAR))
                .criterion(hasItem(ModItems.VOIDFIRE_ESSENCE), conditionsFromItem(ModItems.VOIDFIRE_ESSENCE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "infused_marble_pillar"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, ModBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_STAIRS, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_SLAB, ModBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_STAIRS, ModBlocks.MARBLE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS, ModBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_SLAB, ModBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_STAIRS, ModBlocks.POLISHED_MARBLE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_SLAB, ModBlocks.MARBLE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICK_STAIRS, ModBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, ModBlocks.POLISHED_MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR, ModBlocks.MARBLE_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_SLAB, Blocks.WHITE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_STAIRS, Blocks.WHITE_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_SLAB, Blocks.GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_STAIRS, Blocks.GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, Blocks.LIGHT_GRAY_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS, Blocks.LIGHT_GRAY_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_SLAB, Blocks.BLACK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_STAIRS, Blocks.BLACK_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_SLAB, Blocks.RED_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_STAIRS, Blocks.RED_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_SLAB, Blocks.ORANGE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_STAIRS, Blocks.ORANGE_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_SLAB, Blocks.YELLOW_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_STAIRS, Blocks.YELLOW_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_SLAB, Blocks.LIME_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_STAIRS, Blocks.LIME_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_SLAB, Blocks.GREEN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_STAIRS, Blocks.GREEN_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, Blocks.LIGHT_BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS, Blocks.LIGHT_BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_SLAB, Blocks.CYAN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_STAIRS, Blocks.CYAN_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_SLAB, Blocks.BLUE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_STAIRS, Blocks.BLUE_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_SLAB, Blocks.PURPLE_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_STAIRS, Blocks.PURPLE_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_SLAB, Blocks.MAGENTA_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_STAIRS, Blocks.MAGENTA_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_SLAB, Blocks.PINK_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_STAIRS, Blocks.PINK_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_SLAB, Blocks.BROWN_CONCRETE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_STAIRS, Blocks.BROWN_CONCRETE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_SHINGLE_SLAB, ModBlocks.SHULKER_SHINGLES, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_SHINGLE_STAIRS, ModBlocks.SHULKER_SHINGLES);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_BRICK_SLAB, ModBlocks.SHULKER_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_BRICK_STAIRS, ModBlocks.SHULKER_BRICKS);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_SLAB, ModBlocks.SHINGLES, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_STAIRS, ModBlocks.SHINGLES);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.OLIVE_LOG)
                .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_planks_crafting_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.OLIVE_WOOD)
                .criterion(hasItem(ModBlocks.OLIVE_WOOD), conditionsFromItem(ModBlocks.OLIVE_WOOD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_planks_crafting_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_OLIVE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_planks_crafting_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_OLIVE_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_WOOD), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_WOOD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_planks_crafting_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_WOOD, 3)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("   ")
                .input('L', ModBlocks.OLIVE_LOG)
                .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_wood_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_OLIVE_WOOD, 3)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("   ")
                .input('L', ModBlocks.STRIPPED_OLIVE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "stripped_olive_wood_crafting"));

        createStairsRecipe(ModBlocks.OLIVE_STAIRS, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_SLAB, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_slab_crafting"));

        createDoorRecipe(ModBlocks.OLIVE_DOOR, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_door_crafting"));

        createTrapdoorRecipe(ModBlocks.OLIVE_TRAP_DOOR, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_trap_door_crafting"));

        createFenceRecipe(ModBlocks.OLIVE_FENCE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_fence_crafting"));

        createFenceGateRecipe(ModBlocks.OLIVE_FENCE_GATE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_fence_gate_crafting"));

        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.OLIVE_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_pressure_plate_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_BUTTON, 1)
                .input(ModBlocks.OLIVE_PLANKS)
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "olive_button_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HELMET, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_helmet_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_CHESTPLATE, 1)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_chestplate_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_LEGGINGS, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_leggings_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_BOOTS, 1)
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_boots_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SWORD, 1)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_sword_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE, 1)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_pickaxe_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE, 1)
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_axe_crafting_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE, 1)
                .pattern(" CC")
                .pattern(" SC")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_axe_crafting_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL, 1)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_shovel_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE, 1)
                .pattern("CC ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_hoe_crafting_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE, 1)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "copper_hoe_crafting_right"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .input(ModBlocks.DAFFODIL)
                .criterion(hasItem(ModBlocks.DAFFODIL), conditionsFromItem(ModBlocks.DAFFODIL))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "daffodil_dye_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EYE_OF_THE_VOID, 1)
                .pattern(" V ")
                .pattern("VEV")
                .pattern(" V ")
                .input('V', ModItems.VOIDFIRE_ESSENCE)
                .input('E', Items.ENDER_PEARL)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(ModItems.VOIDFIRE_ESSENCE), conditionsFromItem(ModItems.VOIDFIRE_ESSENCE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "eye_of_the_void_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RIFTSTEEL_CLUMP, 1)
                .input(ModItems.ENDSTONE_CORE)
                .input(ModItems.ENDSTONE_CORE)
                .input(ModItems.ENDSTONE_CORE)
                .input(ModItems.ENDSTONE_CORE)
                .input(ModItems.VOIDFIRE_SHARD)
                .input(ModItems.VOIDFIRE_SHARD)
                .input(ModItems.VOIDFIRE_SHARD)
                .input(ModItems.VOIDFIRE_SHARD)
                .criterion(hasItem(ModItems.VOIDFIRE_SHARD), conditionsFromItem(ModItems.VOIDFIRE_SHARD))
                .criterion(hasItem(ModItems.ENDSTONE_CORE), conditionsFromItem(ModItems.ENDSTONE_CORE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_crafting"));

        offerSmithingTemplateCopyingRecipe(exporter, ModItems.RIFTSTEEL_UPGRADE_TEMPLATE, Blocks.END_STONE);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_SWORD), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_SWORD)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_sword_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_PICKAXE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_PICKAXE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_pickaxe_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_AXE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_AXE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_axe_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_SHOVEL), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_SHOVEL)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_shovel_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_HOE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_HOE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_hoe_upgrading"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" B ")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "baguette_crafting_vertical"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .pattern("   ")
                .pattern("BBB")
                .pattern("   ")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "baguette_crafting_horizontal"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .pattern("B  ")
                .pattern(" B ")
                .pattern("  B")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "baguette_crafting_diagonal_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .pattern("  B")
                .pattern(" B ")
                .pattern("B  ")
                .input('B', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "baguette_crafting_diagonal_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DENSE_SPONGE, 1)
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .input('S', Blocks.SPONGE)
                .criterion(hasItem(Blocks.SPONGE), conditionsFromItem(Blocks.SPONGE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "dense_sponge_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_SLAB, Ingredient.ofItems(Blocks.WHITE_CONCRETE))
                .criterion(hasItem(Blocks.WHITE_CONCRETE), conditionsFromItem(Blocks.WHITE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "white_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.WHITE_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.WHITE_CONCRETE))
                .criterion(hasItem(Blocks.WHITE_CONCRETE), conditionsFromItem(Blocks.WHITE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "white_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_SLAB, Ingredient.ofItems(Blocks.GRAY_CONCRETE))
                .criterion(hasItem(Blocks.GRAY_CONCRETE), conditionsFromItem(Blocks.GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "gray_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.GRAY_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.GRAY_CONCRETE))
                .criterion(hasItem(Blocks.GRAY_CONCRETE), conditionsFromItem(Blocks.GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "gray_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, Ingredient.ofItems(Blocks.LIGHT_GRAY_CONCRETE))
                .criterion(hasItem(Blocks.LIGHT_GRAY_CONCRETE), conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_gray_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.LIGHT_GRAY_CONCRETE))
                .criterion(hasItem(Blocks.LIGHT_GRAY_CONCRETE), conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_gray_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_SLAB, Ingredient.ofItems(Blocks.BLACK_CONCRETE))
                .criterion(hasItem(Blocks.BLACK_CONCRETE), conditionsFromItem(Blocks.BLACK_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "black_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.BLACK_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.BLACK_CONCRETE))
                .criterion(hasItem(Blocks.BLACK_CONCRETE), conditionsFromItem(Blocks.BLACK_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "black_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_SLAB, Ingredient.ofItems(Blocks.RED_CONCRETE))
                .criterion(hasItem(Blocks.RED_CONCRETE), conditionsFromItem(Blocks.RED_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "red_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.RED_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.RED_CONCRETE))
                .criterion(hasItem(Blocks.RED_CONCRETE), conditionsFromItem(Blocks.RED_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "red_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_SLAB, Ingredient.ofItems(Blocks.ORANGE_CONCRETE))
                .criterion(hasItem(Blocks.ORANGE_CONCRETE), conditionsFromItem(Blocks.ORANGE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "orange_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.ORANGE_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.ORANGE_CONCRETE))
                .criterion(hasItem(Blocks.ORANGE_CONCRETE), conditionsFromItem(Blocks.ORANGE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "orange_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_SLAB, Ingredient.ofItems(Blocks.YELLOW_CONCRETE))
                .criterion(hasItem(Blocks.YELLOW_CONCRETE), conditionsFromItem(Blocks.YELLOW_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "yellow_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.YELLOW_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.YELLOW_CONCRETE))
                .criterion(hasItem(Blocks.YELLOW_CONCRETE), conditionsFromItem(Blocks.YELLOW_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "yellow_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_SLAB, Ingredient.ofItems(Blocks.LIME_CONCRETE))
                .criterion(hasItem(Blocks.LIME_CONCRETE), conditionsFromItem(Blocks.LIME_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "lime_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.LIME_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.LIME_CONCRETE))
                .criterion(hasItem(Blocks.LIME_CONCRETE), conditionsFromItem(Blocks.LIME_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "lime_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_SLAB, Ingredient.ofItems(Blocks.GREEN_CONCRETE))
                .criterion(hasItem(Blocks.GREEN_CONCRETE), conditionsFromItem(Blocks.GREEN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "green_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.GREEN_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.GREEN_CONCRETE))
                .criterion(hasItem(Blocks.GREEN_CONCRETE), conditionsFromItem(Blocks.GREEN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "green_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, Ingredient.ofItems(Blocks.LIGHT_BLUE_CONCRETE))
                .criterion(hasItem(Blocks.LIGHT_BLUE_CONCRETE), conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_blue_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.LIGHT_BLUE_CONCRETE))
                .criterion(hasItem(Blocks.LIGHT_BLUE_CONCRETE), conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_blue_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_SLAB, Ingredient.ofItems(Blocks.CYAN_CONCRETE))
                .criterion(hasItem(Blocks.CYAN_CONCRETE), conditionsFromItem(Blocks.CYAN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "cyan_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.CYAN_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.CYAN_CONCRETE))
                .criterion(hasItem(Blocks.CYAN_CONCRETE), conditionsFromItem(Blocks.CYAN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "cyan_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_SLAB, Ingredient.ofItems(Blocks.BLUE_CONCRETE))
                .criterion(hasItem(Blocks.BLUE_CONCRETE), conditionsFromItem(Blocks.BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "blue_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.BLUE_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.BLUE_CONCRETE))
                .criterion(hasItem(Blocks.BLUE_CONCRETE), conditionsFromItem(Blocks.BLUE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "blue_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_SLAB, Ingredient.ofItems(Blocks.PURPLE_CONCRETE))
                .criterion(hasItem(Blocks.PURPLE_CONCRETE), conditionsFromItem(Blocks.PURPLE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "purple_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.PURPLE_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.PURPLE_CONCRETE))
                .criterion(hasItem(Blocks.PURPLE_CONCRETE), conditionsFromItem(Blocks.PURPLE_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "purple_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_SLAB, Ingredient.ofItems(Blocks.MAGENTA_CONCRETE))
                .criterion(hasItem(Blocks.MAGENTA_CONCRETE), conditionsFromItem(Blocks.MAGENTA_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "magenta_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.MAGENTA_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.MAGENTA_CONCRETE))
                .criterion(hasItem(Blocks.MAGENTA_CONCRETE), conditionsFromItem(Blocks.MAGENTA_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "magenta_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_SLAB, Ingredient.ofItems(Blocks.PINK_CONCRETE))
                .criterion(hasItem(Blocks.PINK_CONCRETE), conditionsFromItem(Blocks.PINK_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "pink_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.PINK_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.PINK_CONCRETE))
                .criterion(hasItem(Blocks.PINK_CONCRETE), conditionsFromItem(Blocks.PINK_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "pink_concrete_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_SLAB, Ingredient.ofItems(Blocks.BROWN_CONCRETE))
                .criterion(hasItem(Blocks.BROWN_CONCRETE), conditionsFromItem(Blocks.BROWN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "brown_concrete_slab_crafting"));

        createStairsRecipe(ModBlocks.BROWN_CONCRETE_STAIRS, Ingredient.ofItems(Blocks.BROWN_CONCRETE))
                .criterion(hasItem(Blocks.BROWN_CONCRETE), conditionsFromItem(Blocks.BROWN_CONCRETE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "brown_concrete_stairs_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.SHULKER_BRICKS, 4)
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .input('S', ModItems.SHULKER_PELLET)
                .criterion(hasItem(ModItems.SHULKER_PELLET), conditionsFromItem(ModItems.SHULKER_PELLET))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_bricks_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_BRICK_SLAB, Ingredient.ofItems(ModBlocks.SHULKER_BRICKS))
                .criterion(hasItem(ModBlocks.SHULKER_BRICKS), conditionsFromItem(ModBlocks.SHULKER_BRICKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_brick_slab_crafting"));

        createStairsRecipe(ModBlocks.SHULKER_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.SHULKER_BRICKS))
                .criterion(hasItem(ModBlocks.SHULKER_BRICKS), conditionsFromItem(ModBlocks.SHULKER_BRICKS))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_brick_stairs_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_SHINGLES, 8)
                .pattern("SSS")
                .pattern("   ")
                .pattern("   ")
                .input('S', ModItems.SHULKER_PELLET)
                .criterion(hasItem(ModItems.SHULKER_PELLET), conditionsFromItem(ModItems.SHULKER_PELLET))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_shingle_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHULKER_SHINGLE_SLAB, Ingredient.ofItems(ModBlocks.SHULKER_SHINGLES))
                .criterion(hasItem(ModBlocks.SHULKER_SHINGLES), conditionsFromItem(ModBlocks.SHULKER_SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_shingle_slab_crafting"));

        createStairsRecipe(ModBlocks.SHULKER_SHINGLE_STAIRS, Ingredient.ofItems(ModBlocks.SHULKER_SHINGLES))
                .criterion(hasItem(ModBlocks.SHULKER_SHINGLES), conditionsFromItem(ModBlocks.SHULKER_SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shulker_shingle_stairs_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLES, 8)
                .pattern("BBB")
                .pattern("   ")
                .pattern("   ")
                .input('B', Items.BRICK)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shingle_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_SLAB, Ingredient.ofItems(ModBlocks.SHINGLES))
                .criterion(hasItem(ModBlocks.SHINGLES), conditionsFromItem(ModBlocks.SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shingle_slab_crafting"));

        createStairsRecipe(ModBlocks.SHINGLE_STAIRS, Ingredient.ofItems(ModBlocks.SHINGLES))
                .criterion(hasItem(ModBlocks.SHINGLES), conditionsFromItem(ModBlocks.SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "shingle_stairs_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RIFTSTEEL_BLOCK, 1)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RIFTSTEEL_CLUMP)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_block_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RIFTSTEEL_CLUMP, 9)
                .input(ModBlocks.RIFTSTEEL_BLOCK)
                .criterion(hasItem(ModBlocks.RIFTSTEEL_BLOCK), conditionsFromItem(ModBlocks.RIFTSTEEL_BLOCK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "riftsteel_from_block_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.VOIDFIRE_BLOCK, 1)
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .input('V', ModItems.VOIDFIRE_SHARD)
                .criterion(hasItem(ModItems.VOIDFIRE_SHARD), conditionsFromItem(ModItems.VOIDFIRE_SHARD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "voidfire_block_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOIDFIRE_SHARD, 9)
                .input(ModBlocks.VOIDFIRE_BLOCK)
                .criterion(hasItem(ModBlocks.VOIDFIRE_BLOCK), conditionsFromItem(ModBlocks.VOIDFIRE_BLOCK))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "voidfire_shard_from_block_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SPONGE, 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SEA_SPONGE)
                .criterion(hasItem(ModItems.SEA_SPONGE), conditionsFromItem(ModItems.SEA_SPONGE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "sponge_block_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.WHITE_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "white_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.GRAY_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.GRAY_DYE), conditionsFromItem(Items.GRAY_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "gray_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.LIGHT_GRAY_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.LIGHT_GRAY_DYE), conditionsFromItem(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_gray_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.BLACK_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "black_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.RED_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "red_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.ORANGE_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.ORANGE_DYE), conditionsFromItem(Items.ORANGE_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "orange_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.YELLOW_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "yellow_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.LIME_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.LIME_DYE), conditionsFromItem(Items.LIME_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "lime_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.GREEN_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "green_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.LIGHT_BLUE_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.LIGHT_BLUE_DYE), conditionsFromItem(Items.LIGHT_BLUE_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "light_blue_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.CYAN_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.CYAN_DYE), conditionsFromItem(Items.CYAN_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "cyan_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.BLUE_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "blue_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.PURPLE_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "purple_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.MAGENTA_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "magenta_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.PINK_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.PINK_DYE), conditionsFromItem(Items.PINK_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "pink_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_GLOWSTONE_LAMP, 2)
                .pattern("RGR")
                .pattern("GDG")
                .pattern("RGR")
                .input('R', Items.REDSTONE)
                .input('G', Items.GLOWSTONE_DUST)
                .input('D', Items.BROWN_DYE)
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.BROWN_DYE), conditionsFromItem(Items.BROWN_DYE))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "brown_glowstone_lamp_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.COOKED_CHICKEN, 1)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.CHICKEN_NUGGET)
                .criterion(hasItem(ModItems.CHICKEN_NUGGET), conditionsFromItem(ModItems.CHICKEN_NUGGET))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "chicken_from_nugget_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHICKEN_NUGGET, 9)
                .input(Items.COOKED_CHICKEN)
                .criterion(hasItem(Items.COOKED_CHICKEN), conditionsFromItem(Items.COOKED_CHICKEN))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "chicken_nugget_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DINO_NUGGET, 5)
                .pattern("C  ")
                .pattern("CBC")
                .pattern("C C")
                .input('C', ModItems.CHICKEN_NUGGET)
                .input('B', Items.BREAD)
                .criterion(hasItem(ModItems.CHICKEN_NUGGET), conditionsFromItem(ModItems.CHICKEN_NUGGET))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "dino_nugget_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SHINGLES, 8)
                .pattern("III")
                .pattern("   ")
                .pattern("   ")
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "iron_shingle_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SHINGLE_SLAB, Ingredient.ofItems(ModBlocks.IRON_SHINGLES))
                .criterion(hasItem(ModBlocks.IRON_SHINGLES), conditionsFromItem(ModBlocks.IRON_SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "iron_shingle_slab_crafting"));

        createStairsRecipe(ModBlocks.IRON_SHINGLE_STAIRS, Ingredient.ofItems(ModBlocks.IRON_SHINGLES))
                .criterion(hasItem(ModBlocks.IRON_SHINGLES), conditionsFromItem(ModBlocks.IRON_SHINGLES))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "iron_shingle_stairs_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MACERATOR, 1)
                .pattern("CCC")
                .pattern("CPC")
                .pattern("CCC")
                .input('C', ItemTags.STONE_CRAFTING_MATERIALS)
                .input('P', Blocks.PISTON)
                //.input('S', Blocks.SMOOTH_STONE)
                //.criterion(hasItem(Blocks.SMOOTH_STONE), conditionsFromItem(Blocks.SMOOTH_STONE))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .criterion(hasItem(Blocks.COBBLED_DEEPSLATE), conditionsFromItem(Blocks.COBBLED_DEEPSLATE))
                .criterion(hasItem(Blocks.PISTON), conditionsFromItem(Blocks.PISTON))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "macerator_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FISHER, 1)
                .pattern("PPP")
                .pattern("PMP")
                .pattern("SSS")
                .input('P', ItemTags.PLANKS)
                .input('M', ModItems.MESH)
                .input('S', Blocks.SMOOTH_STONE)
                .criterion(hasItem(Blocks.SMOOTH_STONE), conditionsFromItem(Blocks.SMOOTH_STONE))
                .criterion(hasItem(ModItems.MESH), conditionsFromItem(ModItems.MESH))
                .offerTo(exporter, new Identifier(NoMoreHorses.MOD_ID, "fisher_crafting"));
    }

    public static void offerCooking(RecipeExporter exporter, List<ItemConvertible> inputs, ItemConvertible output, float experience, int cookingTime, int campfireCookingTime) {
        for (ItemConvertible input : inputs) {
            RecipeProvider.offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, cookingTime, input, output, experience);
            RecipeProvider.offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, campfireCookingTime, input, output, experience);
        }
    }
}
