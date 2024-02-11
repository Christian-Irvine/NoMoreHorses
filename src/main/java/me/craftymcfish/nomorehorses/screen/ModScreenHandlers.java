package me.craftymcfish.nomorehorses.screen;

import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MaceratorScreenHandler> MACERATOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(NoMoreHorses.MOD_ID, "macerator"),
                    new ExtendedScreenHandlerType<>(MaceratorScreenHandler::new));

    public static final ScreenHandlerType<FisherScreenHandler> FISHER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(NoMoreHorses.MOD_ID, "fisher"),
                    new ExtendedScreenHandlerType<>(FisherScreenHandler::new));

    public static void registerScreenHandlers(){
        NoMoreHorses.LOGGER.info("Successfully Registered Screen Handlers");
    }
}
