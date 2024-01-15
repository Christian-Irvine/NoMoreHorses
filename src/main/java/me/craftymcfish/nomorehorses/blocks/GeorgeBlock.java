package me.craftymcfish.nomorehorses.blocks;

import me.craftymcfish.nomorehorses.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GeorgeBlock extends Block {
    public GeorgeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        world.playSound(null, pos, ModSounds.GEORGE_UNHAPPY, SoundCategory.BLOCKS, 1.5f, 0.6f);
        return ActionResult.SUCCESS;
    }
}
