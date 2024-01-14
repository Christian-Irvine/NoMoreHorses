package me.craftymcfish.nomorehorses;

import net.fabricmc.api.ClientModInitializer;

public class ExampleModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());
	}
}