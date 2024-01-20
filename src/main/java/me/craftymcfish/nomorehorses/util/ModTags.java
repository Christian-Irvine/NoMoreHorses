package me.craftymcfish.nomorehorses.util;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.Structure;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(NoMoreHorses.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(NoMoreHorses.MOD_ID, name));
        }
    }

    public static class Structures {
        public static final TagKey<Structure> EYE_OF_THE_VOID_LOCATABLE = createTag("eye_of_the_void_locatable");


        private static TagKey<Structure> createTag(String name) {
            return TagKey.of(RegistryKeys.STRUCTURE, new Identifier(NoMoreHorses.MOD_ID, name));
        }
    }
}
