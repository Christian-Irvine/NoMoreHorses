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
    private static final ItemGroup NMHGROUP = FabricItemGroup.builder().icon(() -> new ItemStack(Items.GOLDEN_HORSE_ARMOR)).displayName(Text.translatable("itemGroup.no-more-horses.no_more_horses"))
            .entries((context, entries) -> {
                entries.add(ModItems.CHEESE);
                entries.add(ModBlocks.CHEESE_BLOCK);
                entries.add(ModItems.SALT);
                entries.add(ModItems.MESH);
                entries.add(ModBlocks.PORK_BLOCK);
                entries.add(ModBlocks.PORK_ORE);
                entries.add(ModBlocks.DEEPSLATE_PORK_ORE);
                entries.add(ModItems.RAW_MONEY);
                entries.add(ModItems.MONEY);
            }).build();

    //Vanilla Item Groups
    public static void registerItemGroups(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.BREAD, ModItems.CHEESE);
            entries.addAfter(Items.SPIDER_EYE, ModItems.SALT);
            entries.add(ModBlocks.PORK_BLOCK);
            entries.add(ModBlocks.CHEESE_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.SUGAR, ModItems.SALT);
        });

        Registry.register(Registries.ITEM_GROUP, new Identifier("no-more-horses", "no_more_horses"), NMHGROUP);

        NoMoreHorses.LOGGER.info("Successfully Registered Item Groups");
    }
}
