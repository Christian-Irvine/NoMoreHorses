package me.craftymcfish.nomorehorses.effect;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect GLUTEN_FREE;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(NoMoreHorses.MOD_ID, name),
                new GlutenFreeEffect(StatusEffectCategory.HARMFUL, 9326859));
    }

    public static void registerStatusEffects() {
        GLUTEN_FREE = registerStatusEffect("gluten_free");
    }
}
