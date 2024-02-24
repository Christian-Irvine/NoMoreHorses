package me.craftymcfish.nomorehorses.gamerule;


import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanRule> EXHAUST_LIVING_ORES =
            GameRuleRegistry.register("exhaustLivingOres", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));


//        public static final GameRules.Key<GameRules.BooleanRule> EXHAUST_LIVING_ORES =
//            GameRuleRegistry.register("exhaustLivingOres", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));
}
