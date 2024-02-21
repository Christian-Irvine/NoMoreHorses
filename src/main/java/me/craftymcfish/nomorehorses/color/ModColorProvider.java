package me.craftymcfish.nomorehorses.color;


import me.craftymcfish.nomorehorses.registry.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.potion.PotionUtil;

public class ModColorProvider {

    public static void registerColorProviders() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : PotionUtil.getColor(stack), ModItems.POTION_BOTTOMLESS_CHALICE);
    }
}
