package me.craftymcfish.nomorehorses.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MaceratorScreen extends HandledScreen<MaceratorScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(NoMoreHorses.MOD_ID, "textures/gui/macerator_gui.png");
    public MaceratorScreen(MaceratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        //titleX = 19;
        //titleY = 19;
        //playerInventoryTitleX = 0;
        //playerInventoryTitleY = 0;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderFuelBar(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 80, y + 35, 182, 0, handler.getScaledProgress(), 16);
        }
    }

    private void renderFuelBar(DrawContext context, int x, int y) {
        int scaledProgress = handler.getScaledFuelProgress();
        context.drawTexture(TEXTURE, x + 61, y + 37 + (13 - scaledProgress), 176, 13 - scaledProgress, 6, scaledProgress);
        //context.drawTexture(TEXTURE, x + 61, y + 37, 176, 0, 6, handler.getScaledFuelProgress()); //Works just backwards
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
