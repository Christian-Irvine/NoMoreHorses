package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //Custom Item Group For NMH
    private static final ItemGroup NMHGROUP = FabricItemGroup.builder().icon(() -> new ItemStack(Items.GOLDEN_HORSE_ARMOR)).displayName(Text.translatable("itemGroup.nomorehorses.no_more_horses"))
            .entries((context, entries) -> {
                entries.add(ModItems.STRAWBERRY);
                entries.add(ModItems.STRAWBERRY_SEEDS);
                entries.add(ModItems.CHEESE);
                entries.add(ModBlocks.CHEESE_BLOCK);
                entries.add(ModBlocks.CHEESE_STAIRS);
                entries.add(ModBlocks.CHEESE_SLAB);
                entries.add(ModItems.SALT);
                entries.add(ModItems.MESH);
                entries.add(ModBlocks.PORK_BLOCK);
                entries.add(ModBlocks.PORK_ORE);
                entries.add(ModBlocks.DEEPSLATE_PORK_ORE);
                entries.add(ModItems.RAW_MONEY);
                entries.add(ModItems.MONEY);
                entries.add(ModBlocks.GEORGE);
                entries.add(ModItems.COPPER_SWORD);
                entries.add(ModItems.COPPER_PICKAXE);
                entries.add(ModItems.COPPER_AXE);
                entries.add(ModItems.COPPER_SHOVEL);
                entries.add(ModItems.COPPER_HOE);
                entries.add(ModItems.COPPER_HELMET);
                entries.add(ModItems.COPPER_CHESTPLATE);
                entries.add(ModItems.COPPER_LEGGINGS);
                entries.add(ModItems.COPPER_BOOTS);
                entries.add(ModBlocks.DAFFODIL);
                entries.add(ModItems.LUV_OR_SOMETHIN_MUSIC_DISC);
                entries.add(ModItems.ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS_MUSIC_DISC);
                entries.add(ModItems.EMPTY_HOUSE_WITH_AN_OPEN_DOOR_MUSIC_DISC);
                entries.add(ModBlocks.MARBLE);
                entries.add(ModBlocks.MARBLE_STAIRS);
                entries.add(ModBlocks.MARBLE_SLAB);
                entries.add(ModBlocks.POLISHED_MARBLE);
                entries.add(ModBlocks.POLISHED_MARBLE_STAIRS);
                entries.add(ModBlocks.POLISHED_MARBLE_SLAB);
                entries.add(ModItems.SNAIL_SPAWN_EGG);
                entries.add(ModBlocks.MACERATOR);
            }).build();

    //Vanilla Item Groups
    public static void registerItemGroups(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.BREAD, ModItems.CHEESE);
            entries.addAfter(Items.SPIDER_EYE, ModItems.SALT);
            entries.addAfter(Items.CARROT, ModItems.STRAWBERRY);
            //entries.addAfter(Items.WHEAT_SEEDS, ModItems.STRAWBERRY_SEEDS);
            entries.add(ModBlocks.PORK_BLOCK);
            entries.add(ModBlocks.CHEESE_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.STONE_HOE, ModItems.COPPER_SHOVEL);
            entries.addAfter(ModItems.COPPER_SHOVEL, ModItems.COPPER_PICKAXE);
            entries.addAfter(ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE);
            entries.addAfter(ModItems.COPPER_AXE, ModItems.COPPER_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.STONE_SWORD, ModItems.COPPER_SWORD);
            entries.addAfter(Items.STONE_AXE, ModItems.COPPER_AXE);

            entries.addAfter(Items.CHAINMAIL_BOOTS, ModItems.COPPER_HELMET);
            entries.addAfter(ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE);
            entries.addAfter(ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS);
            entries.addAfter(ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.SUGAR, ModItems.SALT);
        });

        Registry.register(Registries.ITEM_GROUP, new Identifier("nomorehorses", "no_more_horses"), NMHGROUP);

        NoMoreHorses.LOGGER.info("Successfully Registered Item Groups");
    }
}
