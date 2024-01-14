package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class NoMoreHorsesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());
    }
}
