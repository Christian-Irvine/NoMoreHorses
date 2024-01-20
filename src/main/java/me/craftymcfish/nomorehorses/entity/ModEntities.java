package me.craftymcfish.nomorehorses.entity;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.entity.custom.EyeOfTheVoidEntity;
import me.craftymcfish.nomorehorses.entity.custom.SnailEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SnailEntity> SNAIL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NoMoreHorses.MOD_ID, "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnailEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static EntityType<EyeOfTheVoidEntity> EYE_OF_THE_VOID = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NoMoreHorses.MOD_ID, "eye_of_the_void_entity"),
            FabricEntityTypeBuilder.<EyeOfTheVoidEntity>create(SpawnGroup.MISC, EyeOfTheVoidEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
