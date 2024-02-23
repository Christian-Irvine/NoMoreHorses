package me.craftymcfish.nomorehorses.block.custom;

import me.craftymcfish.nomorehorses.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class LivingOreBlock extends Block {
    public final float spreadChance;
    public final float spreadAliveChance;
    public final float exhaustOnSpreadChance;
    public Item igniter;
    public static final IntProperty LIVING_STATE = IntProperty.of("living_state",0, 1);

    public LivingOreBlock(Settings settings, Item igniter, float spreadChance, float spreadAliveChance, float exhaustOnSpreadChance) {
        super(settings);
        this.spreadChance = spreadChance;
        this.igniter = igniter;
        this.exhaustOnSpreadChance = exhaustOnSpreadChance;
        this.spreadAliveChance = spreadAliveChance;
        setDefaultState(getDefaultState().with(LIVING_STATE, 0));
        //NoMoreHorses.LOGGER.info(String.valueOf(this.chance));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIVING_STATE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.PASS;
        if (!player.isHolding(igniter) || state == getDefaultState().with(LIVING_STATE, 1)) return ActionResult.PASS;

        world.setBlockState(pos, state.with(LIVING_STATE, 1));

        if (!player.getAbilities().creativeMode) {
            player.getStackInHand(hand).decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isClient) return;
        if (state == getDefaultState().with(LIVING_STATE, 0)) return;

        float randomNum = (float)random.nextBetween(0, 100) / 100f;

        if (randomNum <= spreadChance) {
            if (shouldexhaust(random)) {
                world.setBlockState(pos, this.getDefaultState());
            }
            trySpreadBlock(state, world, pos, random);
        }

        super.randomTick(state, world, pos, random);
    }

    private void trySpreadBlock(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos replacePos = getReplacePosition(pos, random);

        if (world.getBlockState(replacePos).isIn(ModTags.Blocks.LIVING_ORE_REPLACEABLES)) {
            BlockState replaceState;

            if ((float)random.nextBetween(0, 100) / 100f <= spreadAliveChance) {
                replaceState = getDefaultState().with(LIVING_STATE, 1);
            }
            else {
                replaceState = this.getDefaultState();
            }

            world.setBlockState(replacePos, replaceState);
        }
    }

    private boolean shouldexhaust(Random random) {
        return (float)random.nextBetween(0, 100) / 100f <= exhaustOnSpreadChance;
    }

    private BlockPos getReplacePosition(BlockPos pos, Random random) {
        switch (random.nextBetween(0, 5)) {
            case 0:
                return pos.up();
            case 1:
                return pos.down();
            case 2:
                return pos.north();
            case 3:
                return pos.east();
            case 4:
                return pos.south();
            case 5:
                return pos.west();
            default:
                return pos;
        }
    }
}
