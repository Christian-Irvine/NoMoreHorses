package me.craftymcfish.nomorehorses.datagen;

import me.craftymcfish.nomorehorses.block.custom.StrawberryCropBlock;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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


        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_PORK_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PORK_ORE);

        BlockStateModelGenerator.BlockTexturePool marblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE);
        marblePool.stairs(ModBlocks.MARBLE_STAIRS);
        marblePool.slab(ModBlocks.MARBLE_SLAB);

        BlockStateModelGenerator.BlockTexturePool polishedMarblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_MARBLE);
        polishedMarblePool.stairs(ModBlocks.POLISHED_MARBLE_STAIRS);
        polishedMarblePool.slab(ModBlocks.POLISHED_MARBLE_SLAB);

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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ISLAND_HEART);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MONEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MESH, Models.HANDHELD);

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

        itemModelGenerator.register(ModItems.SNAIL_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
