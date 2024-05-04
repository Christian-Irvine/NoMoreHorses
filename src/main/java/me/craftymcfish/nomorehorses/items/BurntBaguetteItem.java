package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.logging.Logger;

public class BurntBaguetteItem extends SwordItem {
    public BurntBaguetteItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient()) {
            if (target.hasStatusEffect(ModEffects.GLUTEN_FREE)) {
                //target.damage(target.getDamageSources().magic(), 8);
                int amplifier = target.getStatusEffect(ModEffects.GLUTEN_FREE).getAmplifier();
                target.addStatusEffect(new StatusEffectInstance(ModEffects.GLUTEN_DAMAGE, 80, amplifier));
            }
            NoMoreHorses.LOGGER.info(String.valueOf(target.getHealth()));
        }

        return super.postHit(stack, target, attacker);
    }
}
