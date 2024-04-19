package me.craftymcfish.nomorehorses.registry;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.entity.ModEntities;
import me.craftymcfish.nomorehorses.items.*;
import me.craftymcfish.nomorehorses.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item CHEESE = registerItem("cheese",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build()))); //new FabricItemSettings()
    public static final Item SALT = registerItem("salt", new SaltItem());
    public static final Item BAGUETTE = registerItem("baguette",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(15).saturationModifier(1.8f).build())));
    public static final Item BURNT_BAGUETTE = registerItem("burnt_baguette", new BurntBaguetteItem(ModToolMaterial.BAGUETTE, 4, -2.4f, new FabricItemSettings()));
    //public static final Item BURNT_CROISSANT = registerItem("burnt_croissant", new BurntCroissantItem(new FabricItemSettings()));

    public static final Item CHICKEN_NUGGET = registerItem("chicken_nugget",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().snack().hunger(1).saturationModifier(0.1f).build())));
    public static final Item DINO_NUGGET = registerItem("dino_nugget",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.2f).build())));

    public static final Item GRILLED_CHEESE = registerItem("grilled_cheese",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).build())));

    public static final Item SEA_SPONGE = registerItem("sea_sponge", new Item(new FabricItemSettings()));

    public static final Item MESH = registerItem("mesh", new MeshItem());

    public static final Item MONEY = registerItem("money",
            new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(4).saturationModifier(0f).build())));
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

    public static final Item LUV_OR_SOMETHIN_MUSIC_DISC = registerItem("luv_or_somethin_music_disc", new MusicDiscItem(1, ModSounds.LUV_OR_SOMETHIN, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), 243));
    public static final Item ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS_MUSIC_DISC = registerItem("all_i_want_for_fortmas_is_vbucks_music_disc", new MusicDiscItem(2, ModSounds.ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), 241));
    public static final Item EMPTY_HOUSE_WITH_AN_OPEN_DOOR_MUSIC_DISC = registerItem("empty_house_with_an_open_door_music_disc", new MusicDiscItem(3, ModSounds.EMPTY_HOUSE_WITH_AN_OPEN_DOOR, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), 216));

    public static final Item POP_CHAMPAGNE_MUSIC_DISC = registerItem("pop_champagne_music_disc", new MusicDiscItem(14, ModSounds.POP_CHAMPAGNE, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), 215));

    public static final Item SNAIL_SPAWN_EGG = registerItem("snail_spawn_egg", new SpawnEggItem(ModEntities.SNAIL, 0xcec15f, 0xa6d05d, new FabricItemSettings()));

    public static final Item VOIDFIRE_ESSENCE = registerItem("voidfire_essence", new Item(new FabricItemSettings()));
    public static final Item VOIDFIRE_SHARD = registerItem("voidfire_shard", new Item(new FabricItemSettings()));
    public static final Item EYE_OF_THE_VOID = registerItem("eye_of_the_void", new EyeOfTheVoidItem(new FabricItemSettings()));

    public static final Item ENDSTONE_CORE = registerItem("endstone_core", new Item(new FabricItemSettings()));
    public static final Item RIFTSTEEL_CLUMP = registerItem("riftsteel_clump", new Item(new FabricItemSettings()));
    public static final Item RIFTSTEEL_UPGRADE_TEMPLATE = registerItem("riftsteel_upgrade_template", new Item(new FabricItemSettings()));

    public static final Item RIFTSTEEL_SWORD = registerItem("riftsteel_sword", new SwordItem(ModToolMaterial.RIFTSTEEL, 7, -2.1f, new FabricItemSettings()));
    public static final Item RIFTSTEEL_PICKAXE = registerItem("riftsteel_pickaxe", new PickaxeItem(ModToolMaterial.RIFTSTEEL, 5, -2.5f, new FabricItemSettings()));
    public static final Item RIFTSTEEL_AXE = registerItem("riftsteel_axe", new AxeItem(ModToolMaterial.RIFTSTEEL, 9, -2.6f, new FabricItemSettings()));
    public static final Item RIFTSTEEL_SHOVEL = registerItem("riftsteel_shovel", new ShovelItem(ModToolMaterial.RIFTSTEEL, 6f, -2.6f, new FabricItemSettings()));
    public static final Item RIFTSTEEL_HOE = registerItem("riftsteel_hoe", new HoeItem(ModToolMaterial.RIFTSTEEL, 1, 1f, new FabricItemSettings()));
    public static final Item RIFTSTEEL_TRIDENT = registerItem("riftsteel_trident", new TridentItem(new FabricItemSettings().maxCount(1)));

    public static final Item RIFTSTEEL_HELMET = registerItem("riftsteel_helmet", new ModArmorItem(ModArmorMaterials.RIFTSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RIFTSTEEL_CHESTPLATE = registerItem("riftsteel_chestplate", new ArmorItem(ModArmorMaterials.RIFTSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RIFTSTEEL_LEGGINGS = registerItem("riftsteel_leggings", new ArmorItem(ModArmorMaterials.RIFTSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RIFTSTEEL_BOOTS = registerItem("riftsteel_boots", new ArmorItem(ModArmorMaterials.RIFTSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item ROTTEN_LEATHER = registerItem("rotten_leather", new Item(new FabricItemSettings()));

    public static final Item SHULKER_PELLET = registerItem("shulker_pellet", new Item(new FabricItemSettings()));

    public static final Item EMPTY_BOTTOMLESS_CHALICE = registerItem("empty_bottomless_chalice", new EmptyChaliceItem(new FabricItemSettings().maxCount(1)));
    public static final Item MILK_BOTTOMLESS_CHALICE = registerItem("milk_bottomless_chalice", new MilkChaliceItem(new FabricItemSettings().maxCount(1)));
    public static final Item MUSHROOM_STEW_BOTTOMLESS_CHALICE = registerItem("mushroom_stew_bottomless_chalice", new DrinkableChaliceItem(new FabricItemSettings().maxCount(1).food(FoodComponents.MUSHROOM_STEW)));
    public static final Item RABBIT_STEW_BOTTOMLESS_CHALICE = registerItem("rabbit_stew_bottomless_chalice", new DrinkableChaliceItem(new FabricItemSettings().maxCount(1).food(FoodComponents.RABBIT_STEW)));
    public static final Item BEETROOT_SOUP_BOTTOMLESS_CHALICE = registerItem("beetroot_soup_bottomless_chalice", new DrinkableChaliceItem(new FabricItemSettings().maxCount(1).food(FoodComponents.BEETROOT_SOUP)));
    public static final Item POTION_BOTTOMLESS_CHALICE = registerItem("potion_bottomless_chalice", new PotionChaliceItem(new FabricItemSettings().maxCount(1)));

    public static final Item BOOST_STONE = registerItem("boost_stone", new BoostAbilityStoneItem(new FabricItemSettings().maxCount(1), 40));
    public static final Item JUMP_STONE = registerItem("jump_stone", new JumpAbilityStoneItem(new FabricItemSettings().maxCount(1), 20));
    public static final Item DEHYDRATION_GUN = registerItem("dehydration_gun", new DehydtationGunItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(NoMoreHorses.MOD_ID, name), item);
    }

    public static void registerItems(){
        NoMoreHorses.LOGGER.info("Successfully Registered Items");
    }
}
