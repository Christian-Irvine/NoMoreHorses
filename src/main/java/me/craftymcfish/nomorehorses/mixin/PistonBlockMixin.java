package me.craftymcfish.nomorehorses.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.block.custom.HeavyCasingBlock;
import me.craftymcfish.nomorehorses.util.ModTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
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

@Mixin(PistonBlock.class)
public class PistonBlockMixin {
    @Unique
    public boolean triedToBreakBlock = false;
    @Unique
    private Random random;
    @Final
    @Shadow
    public static BooleanProperty EXTENDED;


    @Inject(method = "tryMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;", ordinal = 1, shift = At.Shift.AFTER))
    public void breakBlockIfPossible(World world, BlockPos posFrom, BlockState state, CallbackInfo ci, @Local Direction direction) {
        BlockPos posTo = posFrom.offset(direction);

        //NoMoreHorses.LOGGER.info("Tried To Break Block" + String.valueOf(triedToBreakBlock));
        //NoMoreHorses.LOGGER.info("Direction Is Down: " + String.valueOf(direction == Direction.DOWN));

        if (direction != Direction.DOWN || triedToBreakBlock) return;

        BlockPos blockToBreak = new BlockPos(posTo.getX(), posTo.getY() - 1, posTo.getZ());
        BlockPos supportBlock = new BlockPos(posTo.getX(), posTo.getY() - 2, posTo.getZ());

        if (world.getBlockState(posTo).isIn(ModTags.Blocks.HEAVY_CASING_BLOCKS) && (world.getBlockState(supportBlock).isIn(ModTags.Blocks.HEAVY_CASING_SUPPORT_BLOCKS) || world.getBlockState(supportBlock).hasBlockEntity())) {
            BlockState blockToBreakState = world.getBlockState(blockToBreak);

            if (blockToBreakState.isIn(BlockTags.NEEDS_DIAMOND_TOOL) || blockToBreakState.isIn(BlockTags.NEEDS_IRON_TOOL) || blockToBreakState.isIn(BlockTags.NEEDS_STONE_TOOL) || blockToBreakState.isIn(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))|| blockToBreakState.getBlock().getHardness() <= -1) {
                //Exceptions to block breaking rule go in here
                if (blockToBreakState.isIn(ModTags.Blocks.HEAVY_CASING_BREAKABLE_BLOCKS)) {
                    breakBlock(world, blockToBreak);
                    pistonMoves();
                }
                else {
                    tryDamageCasing(world, posTo);
                }
            }
            else if (blockToBreakState.isAir()){
                tryDamageCasing(world, posTo);
                pistonMoves();
            }
            else {
                breakBlock(world, blockToBreak);
                pistonMoves();
            }
        }
    }

    @Inject(method = "tryMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;", ordinal = 2, shift = At.Shift.AFTER))
    public void retractPiston(World world, BlockPos posFrom, BlockState state, CallbackInfo ci, @Local Direction direction) {
        triedToBreakBlock = false;
        //NoMoreHorses.LOGGER.info("triedToBreakBlock set to false");
    }

    @Unique void pistonMoves() {
        triedToBreakBlock = true;
        //NoMoreHorses.LOGGER.info("triedToBreakBlock set to true");
    }

    @Unique
    private void breakBlock(World world, BlockPos blockToBreak) {
        world.playSound(null, blockToBreak, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1, 1f);
        world.breakBlock(blockToBreak, true);
    }

    @Unique
    private void tryDamageCasing(World world, BlockPos casingPos) {
        if (random == null) {
            random = new Random();
        }

        //NoMoreHorses.LOGGER.info("TRYDAMAGE");

        if (random.nextInt(100) <= 25) {
            damageCasing(world, casingPos);
        }
        else {
            //Play creaky sound
            world.playSound(null, casingPos, SoundEvents.BLOCK_NETHERITE_BLOCK_BREAK, SoundCategory.BLOCKS, 1, 1f);
        }
    }

    @Unique
    private void damageCasing(World world, BlockPos casingPos) {
        BlockState casing = world.getBlockState(casingPos);

        //Play damaging sound
        world.playSound(null, casingPos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1, 1f);

        if (casing.isIn(ModTags.Blocks.HEAVY_CASING_BLOCKS)) {
            HeavyCasingBlock casingBlock = (HeavyCasingBlock) casing.getBlock();
            casingBlock.damageCasingBlock(world, casingPos);
        }
        else {
            NoMoreHorses.LOGGER.info("Wuh oh not working its not a casing here its a  " + casing.getBlock());
        }
    }
}
