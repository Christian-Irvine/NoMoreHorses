package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.block.custom.StrawberryCropBlock;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.MossBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerLog(ModBlocks.PORK_BLOCK).log(ModBlocks.PORK_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_PORK_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PORK_ORE);

        BlockStateModelGenerator.BlockTexturePool marblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE);
        marblePool.stairs(ModBlocks.MARBLE_STAIRS);
        marblePool.slab(ModBlocks.MARBLE_SLAB);

        BlockStateModelGenerator.BlockTexturePool polishedMarblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_MARBLE);
        polishedMarblePool.stairs(ModBlocks.POLISHED_MARBLE_STAIRS);
        polishedMarblePool.slab(ModBlocks.POLISHED_MARBLE_SLAB);

        BlockStateModelGenerator.BlockTexturePool marbleBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE_BRICKS);
        marbleBricksPool.stairs(ModBlocks.MARBLE_BRICK_STAIRS);
        marbleBricksPool.slab(ModBlocks.MARBLE_BRICK_SLAB);

        blockStateModelGenerator.registerLog(ModBlocks.MARBLE_PILLAR).log(ModBlocks.MARBLE_PILLAR);
        blockStateModelGenerator.registerLog(ModBlocks.INFUSED_MARBLE_PILLAR).log(ModBlocks.INFUSED_MARBLE_PILLAR);

        BlockStateModelGenerator.BlockTexturePool cheesePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHEESE_BLOCK);
        cheesePool.stairs(ModBlocks.CHEESE_STAIRS);
        cheesePool.slab(ModBlocks.CHEESE_SLAB);

        blockStateModelGenerator.registerLog(ModBlocks.OLIVE_LOG).log(ModBlocks.OLIVE_LOG).wood(ModBlocks.OLIVE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_OLIVE_LOG).log(ModBlocks.STRIPPED_OLIVE_LOG).wood(ModBlocks.STRIPPED_OLIVE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OLIVE_LEAVES);
        BlockStateModelGenerator.BlockTexturePool olivePlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OLIVE_PLANKS);
        olivePlankPool.slab(ModBlocks.OLIVE_SLAB);
        olivePlankPool.stairs(ModBlocks.OLIVE_STAIRS);
        olivePlankPool.fence(ModBlocks.OLIVE_FENCE);
        olivePlankPool.fenceGate(ModBlocks.OLIVE_FENCE_GATE);
        olivePlankPool.button(ModBlocks.OLIVE_BUTTON);
        olivePlankPool.pressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.OLIVE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.OLIVE_TRAP_DOOR);
        blockStateModelGenerator.registerTintableCross(ModBlocks.OLIVE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAFFODIL, ModBlocks.POTTED_DAFFODIL, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VOIDFIRE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VOIDFIRE_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ISLAND_HEART);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RIFTSTEEL_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DENSE_SPONGE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DENSE_WET_SPONGE);

        BlockStateModelGenerator.BlockTexturePool whiteConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.WHITE_CONCRETE);
        whiteConcretePool.slab(ModBlocks.WHITE_CONCRETE_SLAB);
        whiteConcretePool.stairs(ModBlocks.WHITE_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool grayConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GRAY_CONCRETE);
        grayConcretePool.slab(ModBlocks.GRAY_CONCRETE_SLAB);
        grayConcretePool.stairs(ModBlocks.GRAY_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool light_grayConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_GRAY_CONCRETE);
        light_grayConcretePool.slab(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        light_grayConcretePool.stairs(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool blackConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLACK_CONCRETE);
        blackConcretePool.slab(ModBlocks.BLACK_CONCRETE_SLAB);
        blackConcretePool.stairs(ModBlocks.BLACK_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool redConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.RED_CONCRETE);
        redConcretePool.slab(ModBlocks.RED_CONCRETE_SLAB);
        redConcretePool.stairs(ModBlocks.RED_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool orangeConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ORANGE_CONCRETE);
        orangeConcretePool.slab(ModBlocks.ORANGE_CONCRETE_SLAB);
        orangeConcretePool.stairs(ModBlocks.ORANGE_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool yellowConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.YELLOW_CONCRETE);
        yellowConcretePool.slab(ModBlocks.YELLOW_CONCRETE_SLAB);
        yellowConcretePool.stairs(ModBlocks.YELLOW_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool limeConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIME_CONCRETE);
        limeConcretePool.slab(ModBlocks.LIME_CONCRETE_SLAB);
        limeConcretePool.stairs(ModBlocks.LIME_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool greenConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GREEN_CONCRETE);
        greenConcretePool.slab(ModBlocks.GREEN_CONCRETE_SLAB);
        greenConcretePool.stairs(ModBlocks.GREEN_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool light_blueConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.LIGHT_BLUE_CONCRETE);
        light_blueConcretePool.slab(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        light_blueConcretePool.stairs(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool cyanConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CYAN_CONCRETE);
        cyanConcretePool.slab(ModBlocks.CYAN_CONCRETE_SLAB);
        cyanConcretePool.stairs(ModBlocks.CYAN_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool blueConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BLUE_CONCRETE);
        blueConcretePool.slab(ModBlocks.BLUE_CONCRETE_SLAB);
        blueConcretePool.stairs(ModBlocks.BLUE_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool purpleConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPLE_CONCRETE);
        purpleConcretePool.slab(ModBlocks.PURPLE_CONCRETE_SLAB);
        purpleConcretePool.stairs(ModBlocks.PURPLE_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool magentaConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MAGENTA_CONCRETE);
        magentaConcretePool.slab(ModBlocks.MAGENTA_CONCRETE_SLAB);
        magentaConcretePool.stairs(ModBlocks.MAGENTA_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool pinkConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PINK_CONCRETE);
        pinkConcretePool.slab(ModBlocks.PINK_CONCRETE_SLAB);
        pinkConcretePool.stairs(ModBlocks.PINK_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool brownConcretePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.BROWN_CONCRETE);
        brownConcretePool.slab(ModBlocks.BROWN_CONCRETE_SLAB);
        brownConcretePool.stairs(ModBlocks.BROWN_CONCRETE_STAIRS);

        BlockStateModelGenerator.BlockTexturePool shulker_bricks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHULKER_BRICKS);
        shulker_bricks_pool.stairs(ModBlocks.SHULKER_BRICK_STAIRS);
        shulker_bricks_pool.slab(ModBlocks.SHULKER_BRICK_SLAB);

        BlockStateModelGenerator.BlockTexturePool shulker_shingles_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHULKER_SHINGLES);
        shulker_shingles_pool.stairs(ModBlocks.SHULKER_SHINGLE_STAIRS);
        shulker_shingles_pool.slab(ModBlocks.SHULKER_SHINGLE_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MONEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MESH, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNT_BAGUETTE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.COPPER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.COPPER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.COPPER_BOOTS);

        itemModelGenerator.register(ModItems.LUV_OR_SOMETHIN_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_HOUSE_WITH_AN_OPEN_DOOR_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.VOIDFIRE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOIDFIRE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.EYE_OF_THE_VOID, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDSTONE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RIFTSTEEL_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.RIFTSTEEL_UPGRADE_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RIFTSTEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RIFTSTEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RIFTSTEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RIFTSTEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RIFTSTEEL_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem)ModItems.RIFTSTEEL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RIFTSTEEL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RIFTSTEEL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem)ModItems.RIFTSTEEL_BOOTS);

        itemModelGenerator.register(ModItems.ROTTEN_LEATHER, Models.GENERATED);

        itemModelGenerator.register(ModItems.SHULKER_PELLET, Models.GENERATED);

        itemModelGenerator.register(ModItems.SNAIL_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
