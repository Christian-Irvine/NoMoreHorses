package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.items.MeshItem;
import me.craftymcfish.nomorehorses.items.ModArmorMaterials;
import me.craftymcfish.nomorehorses.items.ModToolMaterial;
import me.craftymcfish.nomorehorses.items.SaltItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHEESE = registerItem("cheese",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build()))); //new FabricItemSettings()
    public static final Item SALT = registerItem("salt", new SaltItem());
    public static final Item MESH = registerItem("mesh", new MeshItem());

    public static final Item MONEY = registerItem("money", new Item(new Item.Settings().maxCount(64)));
    public static final Item RAW_MONEY = registerItem("raw_money", new Item(new Item.Settings().maxCount(64)));

    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())));
    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds",
            new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP, new FabricItemSettings()));

    public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(ModToolMaterial.COPPER, 6, -2.4f, new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ModToolMaterial.COPPER, 2, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ModToolMaterial.COPPER, 9, -3.1f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ModToolMaterial.COPPER, 4, -3f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new HoeItem(ModToolMaterial.COPPER, 1, -1.5f, new FabricItemSettings()));

    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NoMoreHorses.MOD_ID, name), item);
    }

    public static void registerItems(){
        NoMoreHorses.LOGGER.info("Successfully Registered Items");
    }
}
