package me.craftymcfish.nomorehorses.potion;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import me.craftymcfish.nomorehorses.mixin.BrewingRecipeRegistryMixin;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion GLUTEN_FREE_POTION;
    public static Potion GLUTEN_FREE_POTION_LONG;
    private static Potion GLUTEN_FREE_POTION_STRONG;

    public static Potion registerPotion(String name, StatusEffect effect, int duration, int amplifier) {
        return Registry.register(Registries.POTION, new Identifier(NoMoreHorses.MOD_ID, name),
                new Potion(new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static void registerPotions() {
        GLUTEN_FREE_POTION = registerPotion("gluten_free_potion", ModEffects.GLUTEN_FREE, 3600, 0);
        GLUTEN_FREE_POTION_LONG = registerPotion("gluten_free_potion_long", ModEffects.GLUTEN_FREE, 9600, 0);
        GLUTEN_FREE_POTION_STRONG = registerPotion("gluten_free_potion_strong", ModEffects.GLUTEN_FREE, 1800, 1);

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.BAGUETTE, ModPotions.GLUTEN_FREE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.GLUTEN_FREE_POTION, Items.REDSTONE, ModPotions.GLUTEN_FREE_POTION_LONG);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.GLUTEN_FREE_POTION, Items.GLOWSTONE_DUST, ModPotions.GLUTEN_FREE_POTION_STRONG);
    }
}
