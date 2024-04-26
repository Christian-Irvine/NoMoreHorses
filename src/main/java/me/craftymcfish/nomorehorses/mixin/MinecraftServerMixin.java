package me.craftymcfish.nomorehorses.mixin;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import me.craftymcfish.nomorehorses.spawning.WanderingCollectorManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.RandomSequencesState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.UnmodifiableLevelProperties;
import net.minecraft.world.spawner.Spawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.*;

@Mixin(MinecraftServer.class)
abstract class MinecraftServerMixin {
    @Inject(method = "createWorlds", at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/Registry;get(Lnet/minecraft/registry/RegistryKey;)Ljava/lang/Object;", shift = At.Shift.AFTER)) //Lcom/google/common/collect/ImmutableList;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;
    private void addToSpawnerListInject(WorldGenerationProgressListener worldGenerationProgressListener, CallbackInfo ci, @Local LocalRef<List<Spawner>> listLocalRef, @Local ServerWorldProperties serverWorldProperties){
        ArrayList<Spawner> list = new ArrayList<Spawner>(listLocalRef.get());
        list.add(new WanderingCollectorManager(serverWorldProperties));
        listLocalRef.set(list);
    }


//    @Inject(method = "createWorlds", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;<init>(Lnet/minecraft/server/MinecraftServer;Ljava/util/concurrent/Executor;Lnet/minecraft/world/level/storage/LevelStorage$Session;Lnet/minecraft/world/level/ServerWorldProperties;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/world/dimension/DimensionOptions;Lnet/minecraft/server/WorldGenerationProgressListener;ZJLjava/util/List;ZLnet/minecraft/util/math/random/RandomSequencesState;)V")) //"Lcom/google/common/collect/ImmutableList;of()Lcom/google/common/collect/ImmutableList;"
//    private void spawnerLogger(WorldGenerationProgressListener worldGenerationProgressListener, CallbackInfo ci, @Local LocalRef<List<Spawner>> listLocalRef, @Local ServerWorldProperties serverWorldProperties){
//        ArrayList<Spawner> list = new ArrayList<Spawner>(listLocalRef.get());
//
//        NoMoreHorses.LOGGER.info("Post Adding To List");
//        for (Spawner element : list) {
//            NoMoreHorses.LOGGER.info(element.toString());
//        }
//        NoMoreHorses.LOGGER.info("---------------------");
//    }
}