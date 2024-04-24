package me.craftymcfish.nomorehorses.entity.client;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.entity.custom.WanderingCollectorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.VillagerHeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class WanderingCollectorRenderer
        extends MobEntityRenderer<WanderingCollectorEntity, VillagerResemblingModel<WanderingCollectorEntity>> {
    private static final Identifier TEXTURE = new Identifier(NoMoreHorses.MOD_ID,"textures/entity/wandering_collector.png");

    public WanderingCollectorRenderer(EntityRendererFactory.Context context) {
        super(context, new VillagerResemblingModel(context.getPart(EntityModelLayers.WANDERING_TRADER)), 0.5f);
        this.addFeature(new HeadFeatureRenderer<WanderingCollectorEntity, VillagerResemblingModel<WanderingCollectorEntity>>(this, context.getModelLoader(), context.getHeldItemRenderer()));
        this.addFeature(new VillagerHeldItemFeatureRenderer<WanderingCollectorEntity, VillagerResemblingModel<WanderingCollectorEntity>>(this, context.getHeldItemRenderer()));
    }

    @Override
    public Identifier getTexture(WanderingCollectorEntity wanderingTraderEntity) {
        return TEXTURE;
    }

    @Override
    protected void scale(WanderingCollectorEntity wanderingTraderEntity, MatrixStack matrixStack, float f) {
        float g = 0.9375f;
        matrixStack.scale(0.9375f, 0.9375f, 0.9375f);
    }
}
