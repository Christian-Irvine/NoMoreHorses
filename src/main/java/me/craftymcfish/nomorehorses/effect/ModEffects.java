package me.craftymcfish.nomorehorses.effect;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect GLUTEN_FREE;
    public static StatusEffect GLUTEN_DAMAGE;

    public static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(NoMoreHorses.MOD_ID, name), statusEffect);
    }

    public static void registerStatusEffects() {
        GLUTEN_FREE = registerStatusEffect("gluten_free", new GlutenFreeEffect(StatusEffectCategory.HARMFUL, 9326859));
        GLUTEN_DAMAGE = registerStatusEffect("gluten_damage", new GlutenDamageEffect(StatusEffectCategory.HARMFUL, 4345362));
    }
}
