package me.craftymcfish.nomorehorses.recipe;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.recipe.TippedArrowRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(NoMoreHorses.MOD_ID, MaceratorRecipe.Serializer.ID),
                MaceratorRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(NoMoreHorses.MOD_ID, MaceratorRecipe.Type.ID),
                MaceratorRecipe.Type.INSTANCE);

//        Registry.register(Registries.RECIPE_SERIALIZER, BottomlessChaliceRecipeSerializer.ID,
//                BottomlessChaliceRecipeSerializer.BOTTOMLESS_CHALICE_RECIPE);
//        Registry.register(Registries.RECIPE_TYPE, new Identifier(NoMoreHorses.MOD_ID, BottomlessChaliceRecipe.Type.ID),
//                BottomlessChaliceRecipe.Type.INSTANCE);
    }
}
