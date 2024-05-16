package me.craftymcfish.nomorehorses.block.custom;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class HeavyCasingBlock extends Block {
    public HeavyCasingBlock(Settings settings) { super(settings); }

    public void damageCasingBlock(World world, BlockPos pos) {
        Block block = getDefaultState().getBlock();
        if (block.equals(ModBlocks.HEAVY_CASING)) {
            breakInto(world, pos, ModBlocks.CHIPPED_HEAVY_CASING);
        }
        else if (block.equals(ModBlocks.CHIPPED_HEAVY_CASING)) {
            breakInto(world, pos, ModBlocks.DAMAGED_HEAVY_CASING);
        }
        else if (block.equals(ModBlocks.DAMAGED_HEAVY_CASING)) {
            breakBlock(world, pos, Items.NETHERITE_INGOT.getDefaultStack());
        }
    }

    private void breakInto(World world, BlockPos pos, Block blockToReplace) {
        world.setBlockState(pos, blockToReplace.getDefaultState());
    }

    private void breakBlock(World world, BlockPos pos, ItemStack itemToDrop) {
        Block.dropStack(world, pos, itemToDrop);
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }
}
