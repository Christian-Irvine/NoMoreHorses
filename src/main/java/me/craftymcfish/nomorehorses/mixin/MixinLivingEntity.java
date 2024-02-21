package me.craftymcfish.nomorehorses.mixin;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.util.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(method = "eatFood", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyFoodEffects(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;)V"), cancellable = false)
    public void eatFoodInject(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir){
        if(stack.isIn(ModTags.Items.GLUTEN_FOOD) && ((LivingEntity)(Object)this).hasStatusEffect(ModEffects.GLUTEN_FREE)){
            ((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(ModEffects.GLUTEN_DAMAGE, 80, 0));
        }
    }

    @Inject(method = "drop", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;dropXp()V"), cancellable = false)
    public void dropInject(DamageSource source, CallbackInfo cir){
        String montyUUID = "5e5c6f0b-1980-4f5a-a4e8-36c6585af21d";

        if (((LivingEntity)(Object)this).getUuid().equals(UUID.fromString(montyUUID))) {
            ((LivingEntity)(Object)this).sendMessage(Text.of("Popped champagne"));
            ((LivingEntity)(Object)this).dropItem(ModItems.POP_CHAMPAGNE_MUSIC_DISC);
        }
    }
}
