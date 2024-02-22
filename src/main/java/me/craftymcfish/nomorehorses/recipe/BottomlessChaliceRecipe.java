package me.craftymcfish.nomorehorses.recipe;

import me.craftymcfish.nomorehorses.registry.ModItems;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.world.World;

public class BottomlessChaliceRecipe extends SpecialCraftingRecipe {
    public BottomlessChaliceRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(RecipeInputInventory recipeInputInventory, World world) {
        int potionCount = 0;
        int chaliceCount = 0;

        for (int i = 0; i < recipeInputInventory.getWidth(); ++i) {
            for (int j = 0; j < recipeInputInventory.getHeight(); ++j) {
                ItemStack itemStack = recipeInputInventory.getStack(i + j * recipeInputInventory.getWidth());

                if (itemStack.isOf(Items.POTION)) potionCount++;
                if (itemStack.isOf(ModItems.EMPTY_BOTTOMLESS_CHALICE)) chaliceCount++;

                if (potionCount > 1 || chaliceCount > 1) return false;
            }
        }

        return potionCount == 1 && chaliceCount == 1;
    }

    @Override
    public ItemStack craft(RecipeInputInventory recipeInputInventory, DynamicRegistryManager registryManager) {
        ItemStack itemStack = new ItemStack(ModItems.POTION_BOTTOMLESS_CHALICE);

        for (int i = 0; i < recipeInputInventory.getWidth(); ++i) {
            for (int j = 0; j < recipeInputInventory.getHeight(); ++j) {
                if (itemStack.isOf(Items.POTION)) {
                    itemStack = recipeInputInventory.getStack(i + j * recipeInputInventory.getWidth());
                    break;
                }
            }
        }

        ItemStack chaliceStack = new ItemStack(ModItems.POTION_BOTTOMLESS_CHALICE, 1);
        PotionUtil.setPotion(chaliceStack, PotionUtil.getPotion(itemStack));
        PotionUtil.setCustomPotionEffects(chaliceStack, PotionUtil.getCustomPotionEffects(itemStack));
        return chaliceStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    public static class Type implements RecipeType<BottomlessChaliceRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "bottomless_chalice_recipe";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BottomlessChaliceRecipeSerializer.BOTTOMLESS_CHALICE_RECIPE;
    }
    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
}
