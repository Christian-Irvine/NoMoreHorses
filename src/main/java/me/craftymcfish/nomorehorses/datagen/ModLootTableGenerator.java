package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.block.custom.StrawberryCropBlock;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Drop Themselves
        addDrop(ModBlocks.PORK_BLOCK);

        addDrop(ModBlocks.CHEESE_BLOCK);
        addDrop(ModBlocks.CHEESE_STAIRS);
        addDrop(ModBlocks.CHEESE_SLAB, slabDrops(ModBlocks.CHEESE_SLAB));

        addDrop(ModBlocks.GEORGE);
        addDrop(ModBlocks.HEAVY_CASING);
        addDrop(ModBlocks.CHIPPED_HEAVY_CASING);
        addDrop(ModBlocks.DAMAGED_HEAVY_CASING);

        addDrop(ModBlocks.MONEY_SACK);

        addDrop(ModBlocks.MARBLE);
        addDrop(ModBlocks.MARBLE_STAIRS);
        addDrop(ModBlocks.MARBLE_SLAB, slabDrops(ModBlocks.MARBLE_SLAB));
        addDrop(ModBlocks.MARBLE_WALL);

        addDrop(ModBlocks.POLISHED_MARBLE);
        addDrop(ModBlocks.POLISHED_MARBLE_STAIRS);
        addDrop(ModBlocks.POLISHED_MARBLE_SLAB, slabDrops(ModBlocks.POLISHED_MARBLE_SLAB));
        addDrop(ModBlocks.POLISHED_MARBLE_WALL);

        addDrop(ModBlocks.MARBLE_BRICKS);
        addDrop(ModBlocks.MARBLE_BRICK_STAIRS);
        addDrop(ModBlocks.MARBLE_BRICK_SLAB, slabDrops(ModBlocks.MARBLE_BRICK_SLAB));
        addDrop(ModBlocks.MARBLE_BRICK_WALL);

        addDrop(ModBlocks.MARBLE_PILLAR);
        addDrop(ModBlocks.INFUSED_MARBLE_PILLAR);

        addDrop(ModBlocks.OLIVE_LOG);
        addDrop(ModBlocks.OLIVE_WOOD);
        addDrop(ModBlocks.STRIPPED_OLIVE_LOG);
        addDrop(ModBlocks.STRIPPED_OLIVE_WOOD);
        addDrop(ModBlocks.OLIVE_PLANKS);
        addDrop(ModBlocks.OLIVE_STAIRS);
        addDrop(ModBlocks.OLIVE_SLAB, slabDrops(ModBlocks.OLIVE_SLAB));
        addDrop(ModBlocks.OLIVE_DOOR, doorDrops(ModBlocks.OLIVE_DOOR));
        addDrop(ModBlocks.OLIVE_TRAP_DOOR);
        addDrop(ModBlocks.OLIVE_FENCE);
        addDrop(ModBlocks.OLIVE_FENCE_GATE);
        addDrop(ModBlocks.OLIVE_BUTTON);
        addDrop(ModBlocks.OLIVE_PRESSURE_PLATE);
        addDrop(ModBlocks.OLIVE_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_OLIVE_SAPLING);

        addDrop(ModBlocks.OLIVE_LEAVES, leavesDrops(ModBlocks.OLIVE_LEAVES, ModBlocks.OLIVE_SAPLING, 0.05f));

        addDrop(ModBlocks.CHORUS_LOG);
        addDrop(ModBlocks.STRIPPED_CHORUS_LOG);
        addDrop(ModBlocks.CHORUS_PLANKS);
        addDrop(ModBlocks.CHORUS_STAIRS);
        addDrop(ModBlocks.CHORUS_SLAB, slabDrops(ModBlocks.CHORUS_SLAB));
        addDrop(ModBlocks.CHORUS_DOOR, doorDrops(ModBlocks.CHORUS_DOOR));
        addDrop(ModBlocks.CHORUS_TRAP_DOOR);
        addDrop(ModBlocks.CHORUS_FENCE);
        addDrop(ModBlocks.CHORUS_FENCE_GATE);
        addDrop(ModBlocks.CHORUS_BUTTON);
        addDrop(ModBlocks.CHORUS_PRESSURE_PLATE);

        addDrop(ModBlocks.DAFFODIL);
        addPottedPlantDrops(ModBlocks.POTTED_DAFFODIL);

        addDrop(ModBlocks.DENSE_SPONGE);
        addDrop(ModBlocks.DENSE_WET_SPONGE);

        addDrop(ModBlocks.WHITE_CONCRETE_SLAB, slabDrops(ModBlocks.WHITE_CONCRETE_SLAB));
        addDrop(ModBlocks.WHITE_CONCRETE_STAIRS);

        addDrop(ModBlocks.GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.GRAY_CONCRETE_STAIRS);

        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);

        addDrop(ModBlocks.BLACK_CONCRETE_SLAB, slabDrops(ModBlocks.BLACK_CONCRETE_SLAB));
        addDrop(ModBlocks.BLACK_CONCRETE_STAIRS);

        addDrop(ModBlocks.RED_CONCRETE_SLAB, slabDrops(ModBlocks.RED_CONCRETE_SLAB));
        addDrop(ModBlocks.RED_CONCRETE_STAIRS);

        addDrop(ModBlocks.ORANGE_CONCRETE_SLAB, slabDrops(ModBlocks.ORANGE_CONCRETE_SLAB));
        addDrop(ModBlocks.ORANGE_CONCRETE_STAIRS);

        addDrop(ModBlocks.YELLOW_CONCRETE_SLAB, slabDrops(ModBlocks.YELLOW_CONCRETE_SLAB));
        addDrop(ModBlocks.YELLOW_CONCRETE_STAIRS);

        addDrop(ModBlocks.LIME_CONCRETE_SLAB, slabDrops(ModBlocks.LIME_CONCRETE_SLAB));
        addDrop(ModBlocks.LIME_CONCRETE_STAIRS);

        addDrop(ModBlocks.GREEN_CONCRETE_SLAB, slabDrops(ModBlocks.GREEN_CONCRETE_SLAB));
        addDrop(ModBlocks.GREEN_CONCRETE_STAIRS);

        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);

        addDrop(ModBlocks.CYAN_CONCRETE_SLAB, slabDrops(ModBlocks.CYAN_CONCRETE_SLAB));
        addDrop(ModBlocks.CYAN_CONCRETE_STAIRS);

        addDrop(ModBlocks.BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.BLUE_CONCRETE_STAIRS);

        addDrop(ModBlocks.PURPLE_CONCRETE_SLAB, slabDrops(ModBlocks.PURPLE_CONCRETE_SLAB));
        addDrop(ModBlocks.PURPLE_CONCRETE_STAIRS);

        addDrop(ModBlocks.MAGENTA_CONCRETE_SLAB, slabDrops(ModBlocks.MAGENTA_CONCRETE_SLAB));
        addDrop(ModBlocks.MAGENTA_CONCRETE_STAIRS);

        addDrop(ModBlocks.PINK_CONCRETE_SLAB, slabDrops(ModBlocks.PINK_CONCRETE_SLAB));
        addDrop(ModBlocks.PINK_CONCRETE_STAIRS);

        addDrop(ModBlocks.BROWN_CONCRETE_SLAB, slabDrops(ModBlocks.BROWN_CONCRETE_SLAB));
        addDrop(ModBlocks.BROWN_CONCRETE_STAIRS);

        addDrop(ModBlocks.WHITE_GLOWSTONE_LAMP);
        addDrop(ModBlocks.GRAY_GLOWSTONE_LAMP);
        addDrop(ModBlocks.LIGHT_GRAY_GLOWSTONE_LAMP);
        addDrop(ModBlocks.BLACK_GLOWSTONE_LAMP);
        addDrop(ModBlocks.RED_GLOWSTONE_LAMP);
        addDrop(ModBlocks.ORANGE_GLOWSTONE_LAMP);
        addDrop(ModBlocks.YELLOW_GLOWSTONE_LAMP);
        addDrop(ModBlocks.LIME_GLOWSTONE_LAMP);
        addDrop(ModBlocks.GREEN_GLOWSTONE_LAMP);
        addDrop(ModBlocks.LIGHT_BLUE_GLOWSTONE_LAMP);
        addDrop(ModBlocks.CYAN_GLOWSTONE_LAMP);
        addDrop(ModBlocks.BLUE_GLOWSTONE_LAMP);
        addDrop(ModBlocks.PURPLE_GLOWSTONE_LAMP);
        addDrop(ModBlocks.MAGENTA_GLOWSTONE_LAMP);
        addDrop(ModBlocks.PINK_GLOWSTONE_LAMP);
        addDrop(ModBlocks.BROWN_GLOWSTONE_LAMP);

        addDrop(ModBlocks.SHULKER_SHINGLES);
        addDrop(ModBlocks.SHULKER_SHINGLE_SLAB, slabDrops(ModBlocks.SHULKER_SHINGLE_SLAB));
        addDrop(ModBlocks.SHULKER_SHINGLE_STAIRS);

        addDrop(ModBlocks.SHULKER_BRICKS);
        addDrop(ModBlocks.SHULKER_BRICK_SLAB, slabDrops(ModBlocks.SHULKER_BRICK_SLAB));
        addDrop(ModBlocks.SHULKER_BRICK_STAIRS);

        addDrop(ModBlocks.SHINGLES);
        addDrop(ModBlocks.SHINGLE_SLAB, slabDrops(ModBlocks.SHINGLE_SLAB));
        addDrop(ModBlocks.SHINGLE_STAIRS);

        addDrop(ModBlocks.IRON_SHINGLES);
        addDrop(ModBlocks.IRON_SHINGLE_SLAB, slabDrops(ModBlocks.IRON_SHINGLE_SLAB));
        addDrop(ModBlocks.IRON_SHINGLE_STAIRS);

        addDrop(ModBlocks.CRACKED_END_STONE);
        addDrop(ModBlocks.ISLAND_HEART);
        addDrop(ModBlocks.VOIDFIRE_BLOCK);
        addDrop(ModBlocks.VOIDFIRE_LAMP);
        addDrop(ModBlocks.RIFTSTEEL_BLOCK);

        addDrop(ModBlocks.LIVING_SPORE);

        addDrop(ModBlocks.FISHER);
        addDrop(ModBlocks.MACERATOR);

        addDrop(ModBlocks.SALT_BLOCK);
        addDrop(ModBlocks.PACKED_SALT_BLOCK);

        //Custom Drops
        addDrop(ModBlocks.PORK_ORE, fortuneBlockDrops(ModBlocks.PORK_ORE, Items.PORKCHOP, 2, 5));
        addDrop(ModBlocks.DEEPSLATE_PORK_ORE, fortuneBlockDrops(ModBlocks.DEEPSLATE_PORK_ORE, Items.PORKCHOP, 2, 5));

        addDrop(ModBlocks.VOIDFIRE_ORE, fortuneBlockDrops(ModBlocks.VOIDFIRE_ORE, ModItems.VOIDFIRE_ESSENCE, 1, 6));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(StrawberryCropBlock.AGE, StrawberryCropBlock.MAX_AGE));
        addDrop(ModBlocks.STRAWBERRY_CROP, cropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder));

        addDrop(ModBlocks.LIVING_DIAMOND_ORE, livingBlockDrops(Blocks.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND, 1, 1));
        addDrop(ModBlocks.LIVING_GOLD_ORE, livingBlockDrops(Blocks.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 1, 1));
        addDrop(ModBlocks.LIVING_IRON_ORE, livingBlockDrops(Blocks.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 1, 1));
        addDrop(ModBlocks.LIVING_COPPER_ORE, livingBlockDrops(Blocks.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 2, 5));
        addDrop(ModBlocks.LIVING_LAPIS_ORE, livingBlockDrops(Blocks.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 4, 9));
        addDrop(ModBlocks.LIVING_REDSTONE_ORE, livingBlockDrops(Blocks.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 4, 5));
        addDrop(ModBlocks.LIVING_COAL_ORE, livingBlockDrops(Blocks.DEEPSLATE_COAL_ORE, Items.COAL, 1, 1));
        addDrop(ModBlocks.LIVING_EMERALD_ORE, livingBlockDrops(Blocks.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 1, 1));
        addDrop(ModBlocks.LIVING_QUARTZ_ORE, livingBlockDrops(Blocks.NETHER_QUARTZ_ORE, Items.QUARTZ, 1, 1));
        addDrop(ModBlocks.LIVING_VOIDFIRE_ORE, livingBlockDrops(ModBlocks.VOIDFIRE_ORE, ModItems.VOIDFIRE_ESSENCE, 1, 6));
    }

    public LootTable.Builder fortuneBlockDrops (Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder livingBlockDrops (Block baseBlock, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(baseBlock, (LootPoolEntry.Builder)this.applyExplosionDecay(baseBlock, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    } //UniformLootNumberProvider.create(0.0f, 1.0f)
}
