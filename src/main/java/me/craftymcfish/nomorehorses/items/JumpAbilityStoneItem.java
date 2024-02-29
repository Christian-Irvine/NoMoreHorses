package me.craftymcfish.nomorehorses.items;

import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JumpAbilityStoneItem extends AbilityStoneItem{
    public JumpAbilityStoneItem(Settings settings, int cooldown) {
        super(settings, cooldown);
    }

    @Override
    protected void activate(World world, PlayerEntity playerEntity, Hand hand) {
        float jumpLevel = 0.75f;

        Vec3d velocity = playerEntity.getVelocity();
        playerEntity.setVelocity(velocity.x, 0, velocity.z);
        playerEntity.addVelocity(0, jumpLevel, 0);

        playerEntity.velocityDirty = true;
    }

    @Override
    protected boolean isValid(World world, PlayerEntity playerEntity, Hand hand) {
        return !playerEntity.isFallFlying();
    }
}
