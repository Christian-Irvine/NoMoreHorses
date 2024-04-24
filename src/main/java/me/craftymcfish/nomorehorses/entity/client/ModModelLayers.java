package me.craftymcfish.nomorehorses.entity.client;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SNAIL = new EntityModelLayer(new Identifier(NoMoreHorses.MOD_ID, "snail"), "main");
    public static final EntityModelLayer WANDERING_COLLECTOR = new EntityModelLayer(new Identifier(NoMoreHorses.MOD_ID, "wandering_collector"), "main");
}
