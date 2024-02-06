package me.craftymcfish.nomorehorses.mixin;

import me.craftymcfish.nomorehorses.effect.ModEffects;
import me.craftymcfish.nomorehorses.util.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(method = "eatFood", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyFoodEffects(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;)V"), cancellable = false)
    public void eatFoodInject(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir){
        if(stack.isIn(ModTags.Items.GLUTEN_FOOD)){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(ModEffects.GLUTEN_DAMAGE, 80, 0));
        }
    }
}
