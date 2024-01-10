package me.craftymcfish.nomorehorses.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SaltItem extends Item {
    public SaltItem() {
        super(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(-1).saturationModifier(0.0f).alwaysEdible().build()));
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//
//        if (world.isClient()){
//            user.playSound(SoundEvents.BLOCK_SAND_STEP, 0.8f, 1.2f);
//        }
//
//        return TypedActionResult.success(user.getStackInHand(hand));
//    } //This stops salt from being eaten

}
