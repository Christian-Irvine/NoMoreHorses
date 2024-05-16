package me.craftymcfish.nomorehorses.items;

import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BoostAbilityStoneItem extends AbilityStoneItem{
    public BoostAbilityStoneItem(Settings settings, int cooldown) {
        super(settings, cooldown);
    }

    @Override
    protected void activate(World world, PlayerEntity playerEntity, Hand hand) {
        float boostLevel = 1.2f;

        float f = playerEntity.getYaw();
        float g = playerEntity.getPitch();
        float h = -MathHelper.sin(f * ((float)Math.PI / 180)) * MathHelper.cos(g * ((float)Math.PI / 180));
        float k = -MathHelper.sin(g * ((float)Math.PI / 180));
        float l = MathHelper.cos(f * ((float)Math.PI / 180)) * MathHelper.cos(g * ((float)Math.PI / 180));
        float m = MathHelper.sqrt(h * h + k * k + l * l);
        float n = 3.0f * ((1.0f + boostLevel) / 4.0f);

        //This line removes velocity
        playerEntity.setVelocity(0, playerEntity.getVelocity().y, 0);

        playerEntity.addVelocity(h *= n / m, k *= n / m, l *= n / m);
        playerEntity.useRiptide(20);
        if (playerEntity.isOnGround()) {
            playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
        }
    }

    @Override
    protected boolean isValid(World world, PlayerEntity playerEntity, Hand hand) {
        return !playerEntity.isFallFlying();
    }
}
