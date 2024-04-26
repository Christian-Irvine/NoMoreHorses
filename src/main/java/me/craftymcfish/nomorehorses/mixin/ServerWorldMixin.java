package me.craftymcfish.nomorehorses.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import me.craftymcfish.nomorehorses.NoMoreHorses;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.RandomSequencesState;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.storage.LevelStorage;
import net.minecraft.world.spawner.Spawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
abstract class ServerWorldMixin {


    @Shadow public abstract ServerWorld toServerWorld();

//    @Inject(method = "tickSpawners", at = @At(value = "HEAD"))
//    private void tickEachSpawner(boolean spawnMonsters, boolean spawnAnimals, CallbackInfo ci){
//        NoMoreHorses.LOGGER.info("SpawnerTick");
//        for (Object element : ((ServerWorldAccessor)this).getSpawners()) {
//            NoMoreHorses.LOGGER.info(element.toString());
//        }
//        NoMoreHorses.LOGGER.info("---------------------");
//    }
//
//    @Inject(at = @At("TAIL"), method = "<init>")
//    private void logSpawnerCount(MinecraftServer server, Executor workerExecutor, LevelStorage.Session session, ServerWorldProperties properties, RegistryKey worldKey, DimensionOptions dimensionOptions, WorldGenerationProgressListener worldGenerationProgressListener, boolean debugWorld, long seed, List spawners, boolean shouldTickTime, RandomSequencesState randomSequencesState, CallbackInfo ci){
//        NoMoreHorses.LOGGER.info("ServerWorld Constructor");
//        for (Object element : spawners) {
//            NoMoreHorses.LOGGER.info(element.toString());
//        }
//        NoMoreHorses.LOGGER.info("---------------------");
//    }
}