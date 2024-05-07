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
                entries.add(ModBlocks.SALT_BLOCK);
                entries.add(ModBlocks.PACKED_SALT_BLOCK);
                entries.add(ModItems.GRILLED_CHEESE);
                entries.add(ModItems.CHICKEN_NUGGET);
                entries.add(ModItems.DINO_NUGGET);
                entries.add(ModItems.BAGUETTE);
                entries.add(ModItems.BURNT_BAGUETTE);
                entries.add(ModItems.MESH);
                entries.add(ModBlocks.PORK_BLOCK);
                entries.add(ModBlocks.PORK_ORE);
                entries.add(ModBlocks.DEEPSLATE_PORK_ORE);
                entries.add(ModItems.RAW_MONEY);
                entries.add(ModBlocks.MONEY_SACK);
                entries.add(ModItems.MONEY);
                entries.add(ModItems.MONEY_2);
                entries.add(ModItems.MONEY_4);
                entries.add(ModItems.MONEY_8);
                entries.add(ModItems.MONEY_16);
                entries.add(ModItems.MONEY_32);
                entries.add(ModItems.MONEY_64);
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
                entries.add(ModBlocks.MARBLE_WALL);
                entries.add(ModBlocks.POLISHED_MARBLE);
                entries.add(ModBlocks.POLISHED_MARBLE_STAIRS);
                entries.add(ModBlocks.POLISHED_MARBLE_SLAB);
                entries.add(ModBlocks.POLISHED_MARBLE_WALL);
                entries.add(ModBlocks.MARBLE_BRICKS);
                entries.add(ModBlocks.MARBLE_BRICK_STAIRS);
                entries.add(ModBlocks.MARBLE_BRICK_SLAB);
                entries.add(ModBlocks.MARBLE_BRICK_WALL);
                entries.add(ModBlocks.MARBLE_PILLAR);
                entries.add(ModBlocks.INFUSED_MARBLE_PILLAR);

                entries.add(ModItems.SNAIL_SPAWN_EGG);
                entries.add(ModItems.WANDERING_COLLECTOR_SPAWN_EGG);

                entries.add(ModBlocks.MACERATOR);
                entries.add(ModBlocks.FISHER);

                entries.add(ModBlocks.OLIVE_LOG);
                entries.add(ModBlocks.OLIVE_WOOD);
                entries.add(ModBlocks.STRIPPED_OLIVE_LOG);
                entries.add(ModBlocks.STRIPPED_OLIVE_WOOD);
                entries.add(ModBlocks.OLIVE_LEAVES);
                entries.add(ModBlocks.OLIVE_PLANKS);
                entries.add(ModBlocks.OLIVE_STAIRS);
                entries.add(ModBlocks.OLIVE_SLAB);
                entries.add(ModBlocks.OLIVE_TRAP_DOOR);
                entries.add(ModBlocks.OLIVE_DOOR);
                entries.add(ModBlocks.OLIVE_FENCE);
                entries.add(ModBlocks.OLIVE_FENCE_GATE);
                entries.add(ModBlocks.OLIVE_BUTTON);
                entries.add(ModBlocks.OLIVE_PRESSURE_PLATE);
                entries.add(ModBlocks.OLIVE_SAPLING);

                entries.add(ModBlocks.CHORUS_LOG);
                entries.add(ModBlocks.STRIPPED_CHORUS_LOG);
                entries.add(ModBlocks.CHORUS_PLANKS);
                entries.add(ModBlocks.CHORUS_STAIRS);
                entries.add(ModBlocks.CHORUS_SLAB);
                entries.add(ModBlocks.CHORUS_TRAP_DOOR);
                entries.add(ModBlocks.CHORUS_DOOR);
                entries.add(ModBlocks.CHORUS_FENCE);
                entries.add(ModBlocks.CHORUS_FENCE_GATE);
                entries.add(ModBlocks.CHORUS_BUTTON);
                entries.add(ModBlocks.CHORUS_PRESSURE_PLATE);

                entries.add(ModBlocks.VOIDFIRE_ORE);
                entries.add(ModItems.VOIDFIRE_ESSENCE);
                entries.add(ModItems.VOIDFIRE_SHARD);
                entries.add(ModBlocks.VOIDFIRE_BLOCK);
                entries.add(ModBlocks.VOIDFIRE_LAMP);
                entries.add(ModItems.EYE_OF_THE_VOID);

                entries.add(ModBlocks.CRACKED_END_STONE);

                entries.add(ModBlocks.ISLAND_HEART);
                entries.add(ModItems.ENDSTONE_CORE);
                entries.add(ModItems.RIFTSTEEL_CLUMP);
                entries.add(ModBlocks.RIFTSTEEL_BLOCK);
                entries.add(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE);
                entries.add(ModItems.RIFTSTEEL_SWORD);
                entries.add(ModItems.RIFTSTEEL_PICKAXE);
                entries.add(ModItems.RIFTSTEEL_AXE);
                entries.add(ModItems.RIFTSTEEL_SHOVEL);
                entries.add(ModItems.RIFTSTEEL_HOE);
                entries.add(ModItems.RIFTSTEEL_HELMET);
                entries.add(ModItems.RIFTSTEEL_CHESTPLATE);
                entries.add(ModItems.RIFTSTEEL_LEGGINGS);
                entries.add(ModItems.RIFTSTEEL_BOOTS);

                entries.add(ModItems.SEA_SPONGE);
                entries.add(ModBlocks.DENSE_SPONGE);
                entries.add(ModBlocks.DENSE_WET_SPONGE);

                entries.add(ModBlocks.WHITE_CONCRETE_SLAB);
                entries.add(ModBlocks.WHITE_CONCRETE_STAIRS);
                entries.add(ModBlocks.GRAY_CONCRETE_SLAB);
                entries.add(ModBlocks.GRAY_CONCRETE_STAIRS);
                entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
                entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
                entries.add(ModBlocks.BLACK_CONCRETE_SLAB);
                entries.add(ModBlocks.BLACK_CONCRETE_STAIRS);
                entries.add(ModBlocks.RED_CONCRETE_SLAB);
                entries.add(ModBlocks.RED_CONCRETE_STAIRS);
                entries.add(ModBlocks.ORANGE_CONCRETE_SLAB);
                entries.add(ModBlocks.ORANGE_CONCRETE_STAIRS);
                entries.add(ModBlocks.YELLOW_CONCRETE_SLAB);
                entries.add(ModBlocks.YELLOW_CONCRETE_STAIRS);
                entries.add(ModBlocks.LIME_CONCRETE_SLAB);
                entries.add(ModBlocks.LIME_CONCRETE_STAIRS);
                entries.add(ModBlocks.GREEN_CONCRETE_SLAB);
                entries.add(ModBlocks.GREEN_CONCRETE_STAIRS);
                entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
                entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
                entries.add(ModBlocks.CYAN_CONCRETE_SLAB);
                entries.add(ModBlocks.CYAN_CONCRETE_STAIRS);
                entries.add(ModBlocks.BLUE_CONCRETE_SLAB);
                entries.add(ModBlocks.BLUE_CONCRETE_STAIRS);
                entries.add(ModBlocks.PURPLE_CONCRETE_SLAB);
                entries.add(ModBlocks.PURPLE_CONCRETE_STAIRS);
                entries.add(ModBlocks.MAGENTA_CONCRETE_SLAB);
                entries.add(ModBlocks.MAGENTA_CONCRETE_STAIRS);
                entries.add(ModBlocks.PINK_CONCRETE_SLAB);
                entries.add(ModBlocks.PINK_CONCRETE_STAIRS);
                entries.add(ModBlocks.BROWN_CONCRETE_SLAB);
                entries.add(ModBlocks.BROWN_CONCRETE_STAIRS);

                entries.add(ModBlocks.WHITE_GLOWSTONE_LAMP);
                entries.add(ModBlocks.GRAY_GLOWSTONE_LAMP);
                entries.add(ModBlocks.LIGHT_GRAY_GLOWSTONE_LAMP);
                entries.add(ModBlocks.BLACK_GLOWSTONE_LAMP);
                entries.add(ModBlocks.RED_GLOWSTONE_LAMP);
                entries.add(ModBlocks.ORANGE_GLOWSTONE_LAMP);
                entries.add(ModBlocks.YELLOW_GLOWSTONE_LAMP);
                entries.add(ModBlocks.LIME_GLOWSTONE_LAMP);
                entries.add(ModBlocks.GREEN_GLOWSTONE_LAMP);
                entries.add(ModBlocks.LIGHT_BLUE_GLOWSTONE_LAMP);
                entries.add(ModBlocks.CYAN_GLOWSTONE_LAMP);
                entries.add(ModBlocks.BLUE_GLOWSTONE_LAMP);
                entries.add(ModBlocks.PURPLE_GLOWSTONE_LAMP);
                entries.add(ModBlocks.MAGENTA_GLOWSTONE_LAMP);
                entries.add(ModBlocks.PINK_GLOWSTONE_LAMP);
                entries.add(ModBlocks.BROWN_GLOWSTONE_LAMP);

                entries.add(ModItems.SHULKER_PELLET);

                entries.add(ModBlocks.SHULKER_SHINGLES);
                entries.add(ModBlocks.SHULKER_SHINGLE_SLAB);
                entries.add(ModBlocks.SHULKER_SHINGLE_STAIRS);

                entries.add(ModBlocks.SHULKER_BRICKS);
                entries.add(ModBlocks.SHULKER_BRICK_SLAB);
                entries.add(ModBlocks.SHULKER_BRICK_STAIRS);

                entries.add(ModBlocks.SHINGLES);
                entries.add(ModBlocks.SHINGLE_SLAB);
                entries.add(ModBlocks.SHINGLE_STAIRS);

                entries.add(ModBlocks.IRON_SHINGLES);
                entries.add(ModBlocks.IRON_SHINGLE_STAIRS);
                entries.add(ModBlocks.IRON_SHINGLE_SLAB);

                entries.add(ModBlocks.LIVING_DIAMOND_ORE);
                entries.add(ModBlocks.LIVING_COAL_ORE);
                entries.add(ModBlocks.LIVING_REDSTONE_ORE);
                entries.add(ModBlocks.LIVING_LAPIS_ORE);
                entries.add(ModBlocks.LIVING_EMERALD_ORE);
                entries.add(ModBlocks.LIVING_GOLD_ORE);
                entries.add(ModBlocks.LIVING_IRON_ORE);
                entries.add(ModBlocks.LIVING_COPPER_ORE);
                entries.add(ModBlocks.LIVING_QUARTZ_ORE);
                entries.add(ModBlocks.LIVING_VOIDFIRE_ORE);

                entries.add(ModBlocks.LIVING_SPORE);

                entries.add(ModItems.EMPTY_BOTTOMLESS_CHALICE);
                entries.add(ModItems.MILK_BOTTOMLESS_CHALICE);
                entries.add(ModItems.MUSHROOM_STEW_BOTTOMLESS_CHALICE);
                entries.add(ModItems.RABBIT_STEW_BOTTOMLESS_CHALICE);
                entries.add(ModItems.BEETROOT_SOUP_BOTTOMLESS_CHALICE);
                entries.add(ModItems.POTION_BOTTOMLESS_CHALICE);

                entries.add(ModItems.BOOST_STONE);
                entries.add(ModItems.JUMP_STONE);

                //entries.add(ModItems.DEHYDRATION_GUN);
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

            entries.addAfter(Items.NETHERITE_BOOTS, ModItems.RIFTSTEEL_HELMET);
            entries.addAfter(ModItems.RIFTSTEEL_HELMET, ModItems.RIFTSTEEL_CHESTPLATE);
            entries.addAfter(ModItems.RIFTSTEEL_CHESTPLATE, ModItems.RIFTSTEEL_LEGGINGS);
            entries.addAfter(ModItems.RIFTSTEEL_LEGGINGS, ModItems.RIFTSTEEL_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.SUGAR, ModItems.SALT);
        });

        Registry.register(Registries.ITEM_GROUP, new Identifier(NoMoreHorses.MOD_ID, "no_more_horses"), NMHGROUP);

        NoMoreHorses.LOGGER.info("Successfully Registered Item Groups");
    }
}
