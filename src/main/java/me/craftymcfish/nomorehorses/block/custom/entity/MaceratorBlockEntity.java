package me.craftymcfish.nomorehorses.block.custom.entity;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.recipe.MaceratorRecipe;
import me.craftymcfish.nomorehorses.registry.ModItems;
import me.craftymcfish.nomorehorses.screen.MaceratorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.crypto.Mac;
import javax.swing.text.html.Option;
import java.util.Optional;

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
        nbt.putInt("macerator_fuel", fuel);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("macerator_progress");
        fuel = nbt.getInt("macerator_fuel");
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
            else {
                resetProgress();
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
        return getStack(FUEL_SLOT).getItem() == ModItems.VOIDFIRE_SHARD;
    }

    private boolean hasFuelLevel() {
        return fuel > 0;
    }

    private boolean hasRecipe() {
//        ItemStack result = new ItemStack(ModItems.SALT); //Hard Coding (lame)
//        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.CHEESE;

        Optional<RecipeEntry<MaceratorRecipe>> recipe = getCurrentRecipe();

        //NoMoreHorses.LOGGER.info("Hello!");
        //NoMoreHorses.LOGGER.info(String.valueOf(recipe.get().value().getResult(null).getItem()));

        //recipe.get().value().getResult(null).getItem();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<MaceratorRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(MaceratorRecipe.Type.INSTANCE, inv, getWorld());
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
        Optional<RecipeEntry<MaceratorRecipe>> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);

        //ItemStack result = new ItemStack(ModItems.SALT);



        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(), getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }
}
