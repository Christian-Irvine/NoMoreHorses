package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.items.MeshItem;
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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NoMoreHorses.MOD_ID, name), item);
    }

    public static void registerItems(){
        NoMoreHorses.LOGGER.info("Successfully Registered Items");
    }
}
