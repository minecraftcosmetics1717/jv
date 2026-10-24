package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeStructureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Feature.class})
public abstract class FeatureStructureProtectionMixin {
   @Inject(
      method = {"place(Lnet/minecraft/world/level/levelgen/feature/configurations/FeatureConfiguration;Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z", "m_225028_(Lnet/minecraft/world/level/levelgen/feature/configurations/FeatureConfiguration;Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false,
      require = 1
   )
   private void advancedworldgen$preventVegetationInsideStructure(FeatureConfiguration configuration, WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
      Feature<?> feature = (Feature)this;
      if (advancedworldgen$isVegetation(feature) && AdvancedBiomeStructureRegistry.blocksVegetation(level, pos) || advancedworldgen$isTerrainReplacement(feature) && AdvancedBiomeStructureRegistry.blocksFeatureReplacement(level, pos)) {
         cir.setReturnValue(false);
      }

   }

   private static boolean advancedworldgen$isTerrainReplacement(Feature<?> feature) {
      return feature == Feature.f_65731_ || feature == Feature.f_159727_ || feature == Feature.f_65781_ || feature == Feature.f_65749_ || feature == Feature.f_159732_ || feature == Feature.f_159728_ || feature == Feature.f_65783_ || feature == Feature.f_65765_ || feature == Feature.f_159726_ || feature == Feature.f_65775_;
   }

   private static boolean advancedworldgen$isVegetation(Feature<?> feature) {
      return feature == Feature.f_65760_ || feature == Feature.f_65761_ || feature == Feature.f_65762_ || feature == Feature.f_65763_ || feature == Feature.f_65764_ || feature == Feature.f_65766_ || feature == Feature.f_65771_ || feature == Feature.f_65772_ || feature == Feature.f_65776_ || feature == Feature.f_190875_ || feature == Feature.f_159734_ || feature == Feature.f_159735_ || feature == Feature.f_159724_ || feature == Feature.f_225026_ || feature == Feature.f_65735_ || feature == Feature.f_65736_ || feature == Feature.f_65737_ || feature == Feature.f_65738_ || feature == Feature.f_65739_ || feature == Feature.f_65740_ || feature == Feature.f_65741_ || feature == Feature.f_65742_ || feature == Feature.f_65743_ || feature == Feature.f_65744_ || feature == Feature.f_65745_ || feature == Feature.f_65746_;
   }
}
