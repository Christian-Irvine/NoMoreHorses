package me.craftymcfish.nomorehorses.items;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class MeshItem extends Item {
    public MeshItem() {
        super(new Item.Settings().maxCount(1).maxDamage(16));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();


        if (block == Blocks.WATER_CAULDRON){
            if (world.isClient()){
                context.getPlayer().playSound(SoundEvents.BLOCK_SAND_BREAK, 1.0f, 1.5f);
            }
            else {
                context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                context.getPlayer().giveItemStack(new ItemStack(ModItems.SALT));
                
            }

            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }
}
