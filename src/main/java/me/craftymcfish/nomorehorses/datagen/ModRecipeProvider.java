package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PORK_SMELTABLES = List.of(ModBlocks.PORK_ORE, ModBlocks.DEEPSLATE_PORK_ORE);
    private static final List<ItemConvertible> VOIDFIRE_SMELTABLES = List.of(ModBlocks.VOIDFIRE_ORE);
    private static final List<ItemConvertible> MONEY_SMELTABLES = List.of(ModItems.RAW_MONEY);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 200, "pork");
        offerBlasting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 100, "pork");

        offerSmelting(exporter, MONEY_SMELTABLES, RecipeCategory.TOOLS, ModItems.MONEY, 0.4f, 100, "money");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.PORKCHOP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PORK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.CHEESE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_BLOCK);

        offerBlasting(exporter, List.of(ModItems.VOIDFIRE_ESSENCE), RecipeCategory.MISC, ModItems.VOIDFIRE_SHARD, 0.7f, 100, "voidfire");
        offerSmelting(exporter, VOIDFIRE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDFIRE_ESSENCE, 0.2f, 200, "voidfire_ore");
        offerBlasting(exporter, VOIDFIRE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDFIRE_ESSENCE, 0.2f, 100, "voidfire_ore");

        offerSmelting(exporter, List.of(ModBlocks.ISLAND_HEART), RecipeCategory.TOOLS, ModItems.ENDSTONE_CORE, 1f, 400, "island_heart");
        offerBlasting(exporter, List.of(ModBlocks.ISLAND_HEART), RecipeCategory.TOOLS, ModItems.ENDSTONE_CORE, 1f, 200, "island_heart");

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MESH, 1)
                .pattern("SRS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STICK)
                .input('R', Items.STRING)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier("mesh_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RAW_MONEY, 8)
                .pattern("PPP")
                .pattern("PLP")
                .pattern("PPP")
                .input('P', Items.PAPER)
                .input('L', Items.LIME_DYE)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.LIME_DYE), conditionsFromItem(Items.LIME_DYE))
                .offerTo(exporter, new Identifier("raw_money_crafting"));

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
                .offerTo(exporter, new Identifier("george_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHEESE, 1)
                .input(ModItems.SALT)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
                .offerTo(exporter, new Identifier("cheese_crafting"));

        createStairsRecipe(ModBlocks.CHEESE_STAIRS, Ingredient.ofItems(ModBlocks.CHEESE_BLOCK))
                .criterion(hasItem(ModBlocks.CHEESE_BLOCK), conditionsFromItem(ModBlocks.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier("cheese_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_SLAB, Ingredient.ofItems(ModBlocks.CHEESE_BLOCK))
                .criterion(hasItem(ModBlocks.CHEESE_BLOCK), conditionsFromItem(ModBlocks.CHEESE_BLOCK))
                .offerTo(exporter, new Identifier("cheese_slab_crafting"));

        createStairsRecipe(ModBlocks.MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier("marble_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier("marble_slab_crafting"));

        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS ,ModBlocks.POLISHED_MARBLE, Ingredient.ofItems(ModBlocks.MARBLE))
                .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                .offerTo(exporter, new Identifier("polished_marble_crafting"));

        createStairsRecipe(ModBlocks.POLISHED_MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(exporter, new Identifier("polished_marble_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE), conditionsFromItem(ModBlocks.POLISHED_MARBLE))
                .offerTo(exporter, new Identifier("polished_marble_slab_crafting"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, ModBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_STAIRS, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.MARBLE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.POLISHED_MARBLE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.OLIVE_LOG)
                .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                .offerTo(exporter, new Identifier("olive_planks_crafting_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.OLIVE_WOOD)
                .criterion(hasItem(ModBlocks.OLIVE_WOOD), conditionsFromItem(ModBlocks.OLIVE_WOOD))
                .offerTo(exporter, new Identifier("olive_planks_crafting_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_OLIVE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                .offerTo(exporter, new Identifier("olive_planks_crafting_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_OLIVE_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_WOOD), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_WOOD))
                .offerTo(exporter, new Identifier("olive_planks_crafting_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_WOOD, 3)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("   ")
                .input('L', ModBlocks.OLIVE_LOG)
                .criterion(hasItem(ModBlocks.OLIVE_LOG), conditionsFromItem(ModBlocks.OLIVE_LOG))
                .offerTo(exporter, new Identifier("olive_wood_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_OLIVE_WOOD, 3)
                .pattern("LL ")
                .pattern("LL ")
                .pattern("   ")
                .input('L', ModBlocks.STRIPPED_OLIVE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_OLIVE_LOG), conditionsFromItem(ModBlocks.STRIPPED_OLIVE_LOG))
                .offerTo(exporter, new Identifier("stripped_olive_wood_crafting"));

        createStairsRecipe(ModBlocks.OLIVE_STAIRS, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_stairs_crafting"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_SLAB, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_slab_crafting"));

        createDoorRecipe(ModBlocks.OLIVE_DOOR, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_door_crafting"));

        createTrapdoorRecipe(ModBlocks.OLIVE_TRAP_DOOR, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_trap_door_crafting"));

        createFenceRecipe(ModBlocks.OLIVE_FENCE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("olive_fence_crafting"));

        createFenceGateRecipe(ModBlocks.OLIVE_FENCE_GATE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("olive_fence_gate_crafting"));

        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.OLIVE_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.OLIVE_PLANKS))
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_pressure_plate_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OLIVE_BUTTON, 1)
                .input(ModBlocks.OLIVE_PLANKS)
                .criterion(hasItem(ModBlocks.OLIVE_PLANKS), conditionsFromItem(ModBlocks.OLIVE_PLANKS))
                .offerTo(exporter, new Identifier("olive_button_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HELMET, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_helmet_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_CHESTPLATE, 1)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_chestplate_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_LEGGINGS, 1)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_leggings_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_BOOTS, 1)
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_boots_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SWORD, 1)
                .pattern(" C ")
                .pattern(" C ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_sword_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE, 1)
                .pattern("CCC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_pickaxe_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE, 1)
                .pattern("CC ")
                .pattern("CS ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_axe_crafting_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE, 1)
                .pattern(" CC")
                .pattern(" SC")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_axe_crafting_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL, 1)
                .pattern(" C ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_shovel_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE, 1)
                .pattern("CC ")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_hoe_crafting_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE, 1)
                .pattern(" CC")
                .pattern(" S ")
                .pattern(" S ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("copper_hoe_crafting_right"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .input(ModBlocks.DAFFODIL)
                .criterion(hasItem(ModBlocks.DAFFODIL), conditionsFromItem(ModBlocks.DAFFODIL))
                .offerTo(exporter, new Identifier("daffodil_dye_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EYE_OF_THE_VOID, 1)
                .pattern(" V ")
                .pattern("VEV")
                .pattern(" V ")
                .input('V', ModItems.VOIDFIRE_ESSENCE)
                .input('E', Items.ENDER_PEARL)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(ModItems.VOIDFIRE_ESSENCE), conditionsFromItem(ModItems.VOIDFIRE_ESSENCE))
                .offerTo(exporter, new Identifier("eye_of_the_void_crafting"));

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
                .offerTo(exporter, new Identifier("riftsteel_crafting"));

        offerSmithingTemplateCopyingRecipe(exporter, ModItems.RIFTSTEEL_UPGRADE_TEMPLATE, Blocks.END_STONE);

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_SWORD), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_SWORD)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier("riftsteel_sword_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_PICKAXE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_PICKAXE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier("riftsteel_pickaxe_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_AXE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_AXE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier("riftsteel_axe_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_SHOVEL), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_SHOVEL)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier("riftsteel_shovel_upgrading"));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE), Ingredient.ofItems(Items.DIAMOND_HOE), Ingredient.ofItems(ModItems.RIFTSTEEL_CLUMP), RecipeCategory.TOOLS, ModItems.RIFTSTEEL_HOE)
                .criterion(hasItem(ModItems.RIFTSTEEL_CLUMP), conditionsFromItem(ModItems.RIFTSTEEL_CLUMP))
                .offerTo(exporter, new Identifier("riftsteel_hoe_upgrading"));
    }
}
