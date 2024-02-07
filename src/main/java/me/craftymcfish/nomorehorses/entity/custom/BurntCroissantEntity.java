package me.craftymcfish.nomorehorses.entity.custom;

import me.craftymcfish.nomorehorses.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BurntCroissantEntity extends PersistentProjectileEntity {
    public int returnTimer;
    public boolean hitSomething;

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        hitSomething = true;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        hitSomething = true;
    }

    public BurntCroissantEntity(EntityType<? extends BurntCroissantEntity> entityType, World world) {
        super(entityType, world);
    }

    public BurntCroissantEntity(World world, LivingEntity owner) {
        super(ModEntities.BURNT_CROISSANT, owner, world);
    }

    public BurntCroissantEntity(World world, double x, double y, double z) {
        super(ModEntities.BURNT_CROISSANT, x, y, z, world);
    }

    @Override
    public void tick() {

        Entity entity = this.getOwner();

//        if (!this.isOwnerAlive()) {
//            if (!this.getWorld().isClient && this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
//                this.dropStack(this.asItemStack(), 0.1f);
//            }
//            this.discard();
         if (true) {
            this.setNoClip(true);
            Vec3d vec3d = entity.getEyePos().subtract(this.getPos());
            this.setPos(this.getX(), this.getY() + vec3d.y * 0.015 * (double)3, this.getZ());
            if (this.getWorld().isClient) {
                this.lastRenderY = this.getY();
            }
            double d = 0.05 * (double)3;
            this.setVelocity(this.getVelocity().multiply(0.95).add(vec3d.normalize().multiply(d)));
            if (this.returnTimer == 0) {
                //this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0f, 1.0f);
            }
            ++this.returnTimer;
        }

        super.tick();
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }
}
