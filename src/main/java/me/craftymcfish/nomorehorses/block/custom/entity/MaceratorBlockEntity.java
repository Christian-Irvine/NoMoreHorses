package me.craftymcfish.nomorehorses.block.custom.entity;

import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.screen.MaceratorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MaceratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int FUEL_SLOT = 2;

    private int progress = 0;
    private int maxProgress = 120;
    private int fuel = 0;
    private int maxFuel = 200;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> MaceratorBlockEntity.this.progress;
                case 1 -> MaceratorBlockEntity.this.maxProgress;
                case 2 -> MaceratorBlockEntity.this.fuel;
                case 3 -> MaceratorBlockEntity.this.maxFuel;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> MaceratorBlockEntity.this.progress = value;
                case 1 -> MaceratorBlockEntity.this.maxProgress = value;
                case 2 -> MaceratorBlockEntity.this.fuel = value;
                case 3 -> MaceratorBlockEntity.this.maxFuel = value;
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };


    public MaceratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MACERATOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("macerator_progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("macerator_progress");
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.nomorehorses.macerator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MaceratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()){
            return;
        }

        if (this.hasFuelLevel()) {
            this.checkStepInCraft(world, pos, state);
        }
        else  {
            if (this.hasFuelItem()){
                this.useFuelItem();
                this.checkStepInCraft(world, pos, state);
            }
        }


//        if (isOutputSlotEmptyOrRecievable()) {
//            if(this.hasRecipe()) {
//                if(this.hasFuelLevel()){
//                    makeStepInCraft(world, pos, state);
//                }
//                else {
//                    if (this.hasFuelItem()){
//                        this.useFuelItem();
//                        this.makeStepInCraft(world, pos, state);
//                    }
//                }
//            }
//            else {
//                this.resetProgress();
//            }
//        }
//        else {
//            this.resetProgress();
//            markDirty(world, pos, state);
//        }
    }

    private void checkStepInCraft(World world, BlockPos pos, BlockState state) {
        if (isOutputSlotEmptyOrRecievable()) {
            if(this.hasRecipe()) {
                makeStepInCraft(world, pos, state);
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void useFuelItem() {
        fuel = maxFuel;
        this.setStack(FUEL_SLOT, new ItemStack(getStack(FUEL_SLOT).getItem(), getStack(FUEL_SLOT).getCount() - 1));
    }

    private void useFuelLevel() {
        fuel--;
    }

    private boolean hasFuelItem() {
        return getStack(FUEL_SLOT).getItem() == Items.AMETHYST_SHARD;
    }

    private boolean hasFuelLevel() {
        return fuel > 0;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.SALT);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.CHEESE;

        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrRecievable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    private void makeStepInCraft(World world, BlockPos pos, BlockState state) {
        this.increaseCraftProgress();
        this.useFuelLevel();
        markDirty(world, pos, state);

        if (hasCraftingFinished()){
            this.craftItem();
            this.resetProgress();
        }
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT, 1);
        ItemStack result = new ItemStack(ModItems.SALT);

        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }
}
