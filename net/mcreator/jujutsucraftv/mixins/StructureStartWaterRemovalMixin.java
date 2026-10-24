package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeStructureRegistry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({StructureStart.class})
public abstract class StructureStartWaterRemovalMixin {
   @Inject(
      method = {"placeInChunk(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/world/level/ChunkPos;)V", "m_226850_(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/world/level/ChunkPos;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$removeWaterInside(WorldGenLevel level, StructureManager structures, ChunkGenerator generator, RandomSource random, BoundingBox generationBox, ChunkPos chunkPos, CallbackInfo ci) {
      AdvancedBiomeStructureRegistry.removeWaterInside(level, (StructureStart)this, generationBox, chunkPos);
   }
}
