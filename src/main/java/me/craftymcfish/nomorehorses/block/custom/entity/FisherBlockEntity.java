package me.craftymcfish.nomorehorses.block.custom.entity;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.NoMoreHorsesClient;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.screen.FisherScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class FisherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);

    private static final int MESH_SLOT = 0;
    //Loot slots are numbers 1-9 inclusive

    private int progress = 0;
    private int maxProgress = 100;

    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> FisherBlockEntity.this.progress;
                case 1 -> FisherBlockEntity.this.maxProgress;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> FisherBlockEntity.this.progress = value;
                case 1 -> FisherBlockEntity.this.maxProgress = value;
            }
        }

        @Override
        public int size() {
            return 2;
        }
    };

    public FisherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FISHER_BLOCK_ENTITY , pos, state);
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if (slot == 0 && (side == Direction.UP || side == Direction.NORTH || side == Direction.SOUTH || side == Direction.EAST || side == Direction.WEST)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        if (slot >= 1 && slot <= 9 && side == Direction.DOWN) {
            return true;
        }
        return false;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("fisher_progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("fisher_progress");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.nomorehorses.fisher");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FisherScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }

        if (!hasMesh()){
            resetProgress(world, pos, state);
            return;
        }

        if (progress < maxProgress) {
            this.increaseProgress(world, pos, state);
            return;
        }

        Item item = generateLoot();
        OutputItem outputItem = outputSlotsAreEmptyOrReceivable(item);

        if (outputItem.getReceivable()) {
            this.damageMesh(world, pos);
            ItemStack itemStack = new ItemStack(item, getStack(outputItem.getSlot()).getCount() + 1);
            this.placeLootInOutput(itemStack, outputItem.getSlot());
            this.resetProgress(world, pos, state);
            world.playSound(null, pos, SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, SoundCategory.BLOCKS,0.8f, 1);
            return;
        }

        this.resetProgress(world, pos, state);
    }

    private void damageMesh(World world, BlockPos pos) {
        this.getStack(0).setDamage(this.getStack(0).getDamage() + 1);
        NoMoreHorses.LOGGER.info(String.valueOf(this.getStack(0).getDamage()));
        if (this.getStack(0).getDamage() > this.getStack(0).getMaxDamage()) {
            this.setStack(0, ItemStack.EMPTY);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS,1f, 1);
        }
    }

    private boolean hasMesh() {
        return this.getStack(0).getItem() == ModItems.MESH;
    }

    private void resetProgress(World world, BlockPos pos, BlockState state) {
        this.progress = 0;
        markDirty(world, pos, state);
    }

    private void placeLootInOutput(ItemStack item, int slot) {
        this.setStack(slot, item);
    }

    private Item generateLoot() {
        return ModItems.CHEESE;
    }

    private void increaseProgress(World world, BlockPos pos, BlockState state) {
        this.progress++;
        markDirty(world, pos, state);
    }

    private OutputItem outputSlotsAreEmptyOrReceivable(Item item) {
        for (int i = 1; i <= 9; i++) {
            if (this.getStack(i).isEmpty() || (this.getStack(i).getItem() == item && this.getStack(i).getCount() < this.getStack(i).getItem().getMaxCount())) {
                return new OutputItem(i, true);
            }
        }
        return new OutputItem(-1, false);
    }
}

class OutputItem {
    private int slot;
    private boolean receivable;

    public OutputItem(int slot, boolean receivable) {
        this.slot = slot;
        this.receivable = receivable;
    }

    public int getSlot() {
        return this.slot;
    }

    public boolean getReceivable() {
        return this.receivable;
    }
}
