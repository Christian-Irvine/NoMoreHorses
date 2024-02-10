package me.craftymcfish.nomorehorses.block.custom;

import me.craftymcfish.nomorehorses.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GeorgeBlock extends Block {
    public static final IntProperty GEORGE_STATE = IntProperty.of("george_state",0, 2);

    public GeorgeBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(GEORGE_STATE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GEORGE_STATE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int newState = ((world.getBlockState(pos).get(GEORGE_STATE) + 1) % 3);

        if (newState == 1) {
            world.playSound(null, pos, ModSounds.GEORGE_UNHAPPY, SoundCategory.BLOCKS, 1.3f, 0.3f);
        }
        else if (newState == 2) {
            world.playSound(null, pos, ModSounds.GEORGE_UNHAPPY, SoundCategory.BLOCKS, 1.5f, 0.6f);
            world.playSound(null, pos, ModSounds.GEORGE_UNHAPPY, SoundCategory.BLOCKS, 1.5f, 0.5f);
        }

        world.setBlockState(pos, state.with(GEORGE_STATE, newState));
        return ActionResult.SUCCESS;
    }
}
