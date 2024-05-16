package me.craftymcfish.nomorehorses.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.block.custom.HeavyCasingBlock;
import me.craftymcfish.nomorehorses.effect.ModEffects;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.State;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {

    @Unique
    public boolean triedToBreakBlock = false;
    @Unique
    private Random random;
    @Shadow @Final private World world;

//    @Inject(method = "<init>", at = @At(value = "TAIL"))
//    private void init(World world, BlockPos pos, Direction dir, boolean retracted, CallbackInfo ci){
//        NoMoreHorses.LOGGER.info(String.valueOf(world.getBlockState(pos).getBlock()) + " Welp its being constructed I guess"); //Even the constructor is being called multiple times
//    }

    @Inject(method = "tryMove", at = @At(value = "HEAD"))
    public void checkForHeavyCasing(BlockPos pos, Direction dir, CallbackInfoReturnable<Boolean> cir){
//        BlockPos blockToBreak = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
//        BlockPos supportBlock = new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ());
//
//        if (triedToBreakBlock) {
//            NoMoreHorses.LOGGER.info("YUHH WE BROKEN BOIS, We going home now");
//            return;
//        }
//        else {
//            NoMoreHorses.LOGGER.info("Welp.. guess we aint borken... BONK TIME");
//            triedToBreakBlock = true;
//        }
//
//        if (world.getBlockState(pos).isIn(ModTags.Blocks.HEAVY_CASING_BLOCKS) && dir == Direction.DOWN && (world.getBlockState(supportBlock).isIn(ModTags.Blocks.HEAVY_CASING_SUPPORT_BLOCKS) || world.getBlockState(supportBlock).hasBlockEntity())) {
//            BlockState blockToBreakState = world.getBlockState(blockToBreak);
//
//            if (blockToBreakState.isIn(BlockTags.NEEDS_DIAMOND_TOOL) || blockToBreakState.isIn(BlockTags.NEEDS_IRON_TOOL) || blockToBreakState.isIn(BlockTags.NEEDS_STONE_TOOL) || blockToBreakState.isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))|| blockToBreakState.getBlock().getHardness() <= -1) {
//                //Exceptions to block breaking rule go in here
//                if (blockToBreakState.isIn(ModTags.Blocks.HEAVY_CASING_BREAKABLE_BLOCKS)) {
//                    breakBlock(blockToBreak);
//                }
//                else {
//                    tryDamageCasing(pos);
//                }
//            }
//            else if (blockToBreakState.isAir()){
//                tryDamageCasing(pos);
//            }
//            else {
//                breakBlock(blockToBreak);
//            }
//        }
    }

    @Unique
    private void breakBlock(BlockPos blockToBreak) {
        world.playSound(null, blockToBreak, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1, 1f);
        world.breakBlock(blockToBreak, true);
    }

    @Unique
    private void tryDamageCasing(BlockPos casingPos) {
        if (random == null) {
            random = new Random();
        }

        //NoMoreHorses.LOGGER.info("TRYDAMAGE");

        if (random.nextInt(100) <= 25) {
            damageCasing(casingPos);
        }
        else {
            //Play creaky sound
            world.playSound(null, casingPos, SoundEvents.BLOCK_NETHERITE_BLOCK_BREAK, SoundCategory.BLOCKS, 1, 1f);
        }
    }

    @Unique
    private void damageCasing(BlockPos casingPos) {
        BlockState casing = world.getBlockState(casingPos);

        //Play damaging sound
        world.playSound(null, casingPos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1, 1f);

        if (casing.isIn(ModTags.Blocks.HEAVY_CASING_BLOCKS)) {
            HeavyCasingBlock casingBlock = (HeavyCasingBlock) casing.getBlock();
            casingBlock.damageCasingBlock(world, casingPos);
        }
        else {
            NoMoreHorses.LOGGER.info("Wuh oh not working its not a casing here its a ... " + casing.getBlock());
        }
    }

//    @Inject(method = "calculatePush", at = @At(value = "HEAD"), cancellable = false)
//    public void blablabla(CallbackInfoReturnable<Boolean> cir){
//        NoMoreHorses.LOGGER.info(String.valueOf(posTo) + " posTo");
//        NoMoreHorses.LOGGER.info(String.valueOf(posFrom) + " posFrom");
//        NoMoreHorses.LOGGER.info("------");
//    }
}
