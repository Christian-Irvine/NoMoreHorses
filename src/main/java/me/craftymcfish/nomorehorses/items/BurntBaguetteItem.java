package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
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
                NoMoreHorses.LOGGER.info("has gluten effect");
                target.damage(target.getDamageSources().magic(), 8);
            }
            NoMoreHorses.LOGGER.info(String.valueOf(target.getHealth()));
        }

        return super.postHit(stack, target, attacker);
    }
}
