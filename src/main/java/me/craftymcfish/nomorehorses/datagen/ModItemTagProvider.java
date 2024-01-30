package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.LUV_OR_SOMETHIN_MUSIC_DISC, ModItems.ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS_MUSIC_DISC, ModItems.EMPTY_HOUSE_WITH_AN_OPEN_DOOR_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.OLIVE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.OLIVE_LOG.asItem())
                .add(ModBlocks.OLIVE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_OLIVE_LOG.asItem())
                .add(ModBlocks.STRIPPED_OLIVE_WOOD.asItem());
    }
}
