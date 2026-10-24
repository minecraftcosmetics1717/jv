package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeTerrainRegistry;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({NoiseBasedChunkGenerator.class})
public abstract class NoiseBasedChunkGeneratorSurfaceMixin {
   @Inject(
      method = {"buildSurface(Lnet/minecraft/server/level/WorldGenRegion;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/chunk/ChunkAccess;)V", "m_214194_(Lnet/minecraft/server/level/WorldGenRegion;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/chunk/ChunkAccess;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$applyBiomeTerrain(WorldGenRegion level, StructureManager structures, RandomState randomState, ChunkAccess chunk, CallbackInfo ci) {
      AdvancedBiomeTerrainRegistry.apply(level, chunk);
   }
}
