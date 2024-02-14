package me.craftymcfish.nomorehorses.util;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    public static final Identifier FISHING_FISHER_LOOT = new Identifier(NoMoreHorses.MOD_ID, "gameplay/fishing");
    private static final Identifier END_CITY_TREASURE_CHEST = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier SHULKER_ENTITY = new Identifier("minecraft", "entities/shulker");


    public static void modifyLootTables() {
        //This is the way to do it for things like mobs drops with multiple possible drops
//        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
//            if (FISHING_JUNK_ID.equals(id)){
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1.0f))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f))
//                        .with(ItemEntry.builder(ModItems.SALT))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
//                tableBuilder.pool(poolBuilder.build());
//            }
//        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (END_CITY_TREASURE_CHEST.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (SHULKER_ENTITY.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2.0f)) //how many times it will run this
                        .conditionally(RandomChanceLootCondition.builder(1f)) // the chance of this roll succeeding
                        .with(ItemEntry.builder(ModItems.SHULKER_PELLET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build()); //Randomly pick how many it will drop per roll
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //The below is broken in current version of fabric, when updating to 1.20.4 check if it works again. This is because the pools field is private in this version

        //This is the way to do it for things like sus sand or fishing with singular drops system (sus sand has no weight)
        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
//            if (FISHING_JUNK_ID.equals(id)){
//                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                entries.add(ItemEntry.builder(ModItems.SALT).weight(20).build());
//
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }

            return null;
        }));
    }

}
