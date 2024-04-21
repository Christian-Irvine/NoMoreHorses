package me.craftymcfish.nomorehorses;

import me.craftymcfish.nomorehorses.color.ModColorProvider;
import me.craftymcfish.nomorehorses.entity.ModEntities;
import me.craftymcfish.nomorehorses.entity.client.ModModelLayers;
import me.craftymcfish.nomorehorses.entity.client.SnailModel;
import me.craftymcfish.nomorehorses.entity.client.SnailRenderer;
import me.craftymcfish.nomorehorses.registry.ModBlocks;
import me.craftymcfish.nomorehorses.screen.FisherScreen;
import me.craftymcfish.nomorehorses.screen.MaceratorScreen;
import me.craftymcfish.nomorehorses.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class NoMoreHorsesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAFFODIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAFFODIL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FISHER, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.SNAIL, SnailRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNAIL, SnailModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.EYE_OF_THE_VOID, FlyingItemEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.MACERATOR_SCREEN_HANDLER, MaceratorScreen::new);
        HandledScreens.register(ModScreenHandlers.FISHER_SCREEN_HANDLER, FisherScreen::new);

        ModColorProvider.registerColorProviders();
    }
}
