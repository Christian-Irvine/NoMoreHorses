package me.craftymcfish.nomorehorses.sound;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent GEORGE_UNHAPPY = registerSoundEvent("george_unhappy");
    public static final BlockSoundGroup GEORGE_SOUNDS = new BlockSoundGroup(1, 1f,
            SoundEvents.BLOCK_NETHERITE_BLOCK_BREAK,
            SoundEvents.ENTITY_VILLAGER_HURT,
            SoundEvents.ENTITY_VILLAGER_AMBIENT,
            SoundEvents.ENTITY_VILLAGER_NO,
            SoundEvents.BLOCK_NETHERITE_BLOCK_FALL
    );

    public static final SoundEvent LUV_OR_SOMETHIN = registerSoundEvent("luv_or_somethin");
    public static final SoundEvent ALL_I_WANT_FOR_FORTMAS_IS_VBUCKS = registerSoundEvent("all_i_want_for_fortmas_is_vbucks");
    public static final SoundEvent EMPTY_HOUSE_WITH_AN_OPEN_DOOR = registerSoundEvent("empty_house_with_an_open_door");

    public static final SoundEvent POP_CHAMPAGNE = registerSoundEvent("pop_champagne");

    public static final SoundEvent SNAIL_HURT = registerSoundEvent("snail_hurt");
    public static final SoundEvent SNAIL_DEATH = registerSoundEvent("snail_death");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(NoMoreHorses.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        NoMoreHorses.LOGGER.info("Registered custom sounds");
    }
}
