package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.entity.custom.EyeOfTheVoidEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

public class EyeOfTheVoidItem extends Item {
    public EyeOfTheVoidItem(Settings settings) {
        super(new Item.Settings().maxCount(16));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ServerWorld serverWorld;
        BlockPos blockPos;
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if (world instanceof ServerWorld && (blockPos = (serverWorld = (ServerWorld)world).locateStructure(StructureTags.EYE_OF_ENDER_LOCATED, user.getBlockPos(), 100, false)) != null) {
            EyeOfTheVoidEntity eyeOfTheVoidEntity = new EyeOfTheVoidEntity(world, user.getX(), user.getBodyY(0.5), user.getZ());
            eyeOfTheVoidEntity.setItem(itemStack);
            eyeOfTheVoidEntity.initTargetPos(blockPos);
            world.emitGameEvent(GameEvent.PROJECTILE_SHOOT, eyeOfTheVoidEntity.getPos(), GameEvent.Emitter.of(user));
            world.spawnEntity(eyeOfTheVoidEntity);
            if (user instanceof ServerPlayerEntity) {
                Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity)user, blockPos);
            }
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            world.syncWorldEvent(null, WorldEvents.EYE_OF_ENDER_LAUNCHES, user.getBlockPos(), 0);
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            user.swingHand(hand, true);
            return TypedActionResult.success(itemStack);
        }
        return TypedActionResult.consume(itemStack);
    }
}
