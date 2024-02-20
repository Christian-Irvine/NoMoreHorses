package me.craftymcfish.nomorehorses.block.custom;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.logging.Logger;

public class LivingOreBlock extends Block {
    public final float chance;

    public LivingOreBlock(Settings settings, float chance) {
        super(settings);
        this.chance = chance;
        //NoMoreHorses.LOGGER.info(String.valueOf(this.chance));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float randomNum = (float)random.nextBetween(0, 100) / 100f;

        if (randomNum > chance) {

        }


        super.randomTick(state, world, pos, random);
    }
}
