package me.craftymcfish.nomorehorses.world;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> VOIDFIRE_ORE_KEY = registerKey("voidfire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PORK_ORE_KEY = registerKey("pork_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MARBLE_ORE_KEY = registerKey("marble_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> OLIVE_TREE_KEY = registerKey("olive_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldPorkOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PORK_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PORK_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endVoidfireOres = List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.VOIDFIRE_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> overworldMarbleOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.MARBLE.getDefaultState()));

        //Ores
        register(context, PORK_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPorkOres, 8));
        register(context, VOIDFIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endVoidfireOres, 14));

        //Underground Blocks
        register(context, MARBLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMarbleOres, 64));

        //Trees
        register(context, OLIVE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.OLIVE_LOG),
                new BendingTrunkPlacer(4, 2, 2, 4,ConstantIntProvider.create(2)),
                BlockStateProvider.of(ModBlocks.OLIVE_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1)),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(NoMoreHorses.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
