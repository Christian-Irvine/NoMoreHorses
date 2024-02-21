package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.logging.Logger;

public class EmptyChaliceItem extends Item {

    public EmptyChaliceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getWorld().isClient()) return ActionResult.PASS;
        if (entity.isBaby()) return ActionResult.PASS;

        if (entity.getType().equals(EntityType.COW)) {
            user.setStackInHand(hand, ModItems.MILK_BOTTOMLESS_CHALICE.getDefaultStack());
        }
        if (entity.getType().equals(EntityType.MOOSHROOM)) {
            user.setStackInHand(hand, ModItems.MUSHROOM_STEW_BOTTOMLESS_CHALICE.getDefaultStack());
        }

        return ActionResult.SUCCESS;
    }
}
