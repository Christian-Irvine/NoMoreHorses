package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class DehydtationGunItem extends Item {
    public DehydtationGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        super.use(world, user, hand);
//        if (!world.isClient()) return TypedActionResult.pass(user.getStackInHand(hand));


        //Uncomment this when working on it
        return TypedActionResult.pass(user.getStackInHand(hand));
//        MinecraftClient client = MinecraftClient.getInstance();
//
//        double maxReach = 10;
//        float tickDelta = 1F;
//        boolean includeFluids = false;
//
//        HitResult hit = client.cameraEntity.raycast(maxReach, tickDelta, includeFluids);
//
//        switch(hit.getType()) {
//            case MISS:
//                NoMoreHorses.LOGGER.info("Miss");
//                break;
//            case BLOCK:
//                NoMoreHorses.LOGGER.info("Block");
//                break;
//            case ENTITY:
//                NoMoreHorses.LOGGER.info("Entity");
//                EntityHitResult entityHit = (EntityHitResult) hit;
//                Entity entity = entityHit.getEntity();
//                if (entity.isLiving()){
//                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING));
//                }
//                break;
//        }
//        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
}
