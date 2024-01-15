package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.blocks.StrawberryCropBlock;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
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

        addDrop(ModBlocks.MARBLE);
        addDrop(ModBlocks.MARBLE_STAIRS);
        addDrop(ModBlocks.MARBLE_SLAB, slabDrops(ModBlocks.MARBLE_SLAB));

        addDrop(ModBlocks.POLISHED_MARBLE);
        addDrop(ModBlocks.POLISHED_MARBLE_STAIRS);
        addDrop(ModBlocks.POLISHED_MARBLE_SLAB, slabDrops(ModBlocks.POLISHED_MARBLE_SLAB));

        addDrop(ModBlocks.DAFFODIL);
        addPottedPlantDrops(ModBlocks.POTTED_DAFFODIL);

        //Custom Drops
        addDrop(ModBlocks.PORK_ORE, fortuneBlockDrops(ModBlocks.PORK_ORE, Items.PORKCHOP, 2, 5));
        addDrop(ModBlocks.DEEPSLATE_PORK_ORE, fortuneBlockDrops(ModBlocks.DEEPSLATE_PORK_ORE, Items.PORKCHOP, 2, 5));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(StrawberryCropBlock.AGE, StrawberryCropBlock.MAX_AGE));
        addDrop(ModBlocks.STRAWBERRY_CROP, cropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder));
    }

    public LootTable.Builder fortuneBlockDrops (Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
