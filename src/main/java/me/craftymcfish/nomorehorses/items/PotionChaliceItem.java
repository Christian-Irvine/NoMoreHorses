package me.craftymcfish.nomorehorses.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotionChaliceItem extends DrinkableChaliceItem{
    public PotionChaliceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        return PotionUtil.setPotion(super.getDefaultStack(), Potions.POISON);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);

        List<StatusEffectInstance> list = PotionUtil.getPotionEffects(stack);
        for (StatusEffectInstance statusEffectInstance : list) {
            if (statusEffectInstance.getEffectType().isInstant()) {
                statusEffectInstance.getEffectType().applyInstantEffect(user, user, user, statusEffectInstance.getAmplifier(), 1.0);
                continue;
            }
            user.addStatusEffect(new StatusEffectInstance(statusEffectInstance));
        }

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        PotionUtil.buildTooltip(stack, tooltip, 1f);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return PotionUtil.getPotion(stack).finishTranslationKey(this.getTranslationKey() + ".effect.");
    }
}
