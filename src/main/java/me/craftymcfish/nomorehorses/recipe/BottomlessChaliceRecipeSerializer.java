package me.craftymcfish.nomorehorses.recipe;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BottomlessChaliceRecipeSerializer implements RecipeSerializer<BottomlessChaliceRecipe> {

    public static final BottomlessChaliceRecipeSerializer BOTTOMLESS_CHALICE_RECIPE = new BottomlessChaliceRecipeSerializer();
    public static final Identifier ID = new Identifier("bottomless_chalice:bottomless_chalice_recipe");

    @Override
    public Codec<BottomlessChaliceRecipe> codec() {
        return null;
    }

    @Override
    public BottomlessChaliceRecipe read(PacketByteBuf buf) {
        return null;
    }

    @Override
    public void write(PacketByteBuf buf, BottomlessChaliceRecipe recipe) {

    }

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return (S) Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }
}
