package me.craftymcfish.nomorehorses.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MilkChaliceItem extends DrinkableChaliceItem {
    public MilkChaliceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);

        user.clearStatusEffects();
        return stack;
    }
}
