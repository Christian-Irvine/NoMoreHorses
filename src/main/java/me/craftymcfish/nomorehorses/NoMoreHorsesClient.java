package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.entity.ModEntities;
import me.craftymcfish.nomorehorses.entity.client.ModModelLayers;
import me.craftymcfish.nomorehorses.entity.client.SnailModel;
import me.craftymcfish.nomorehorses.entity.client.SnailRenderer;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class NoMoreHorsesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAFFODIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAFFODIL, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAIL, SnailModel::getTexturedModelData);
    }
}
