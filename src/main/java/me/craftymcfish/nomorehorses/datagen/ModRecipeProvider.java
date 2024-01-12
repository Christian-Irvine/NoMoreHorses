package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PORK_SMELTABLES = List.of(ModBlocks.PORK_ORE, ModBlocks.DEEPSLATE_PORK_ORE);
    private static final List<ItemConvertible> MONEY_SMELTABLES = List.of(ModItems.RAW_MONEY);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 200, "pork");
        offerBlasting(exporter, PORK_SMELTABLES, RecipeCategory.MISC, Items.COOKED_PORKCHOP, 0.7f, 100, "pork");

        offerSmelting(exporter, MONEY_SMELTABLES, RecipeCategory.TOOLS, ModItems.MONEY, 0.4f, 100, "money");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.PORKCHOP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PORK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.CHEESE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHEESE_BLOCK);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RAW_MONEY, 1)
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
    }
}
