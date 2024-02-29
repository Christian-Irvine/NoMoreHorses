package me.craftymcfish.nomorehorses.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AbilityStoneItem extends Item {
    private int coolDown;

    public AbilityStoneItem(Settings settings, int coolDown) {
        super(settings);
        this.coolDown = coolDown;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        super.use(world, user, hand);
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient() && isValid(world, user, hand)) {
            user.getItemCooldownManager().set(this, coolDown);
            activate(world, user, hand);
            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.pass(itemStack);
    }

    protected void activate(World world, PlayerEntity user, Hand hand) {
        return;
    }

    protected boolean isValid(World world, PlayerEntity user, Hand han) {
        return true;
    }
}
