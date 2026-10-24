package net.mcreator.jujutsucraftv.mixins;

import java.util.function.Function;
import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeStructureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({OreFeature.class})
public abstract class OreFeatureStructureProtectionMixin {
   private static final ThreadLocal<WorldGenLevel> ADVANCED_WORLDGEN_LEVEL = new ThreadLocal();

   @Inject(
      method = {"doPlace(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;DDDDDDIIIII)Z", "m_225171_(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;DDDDDDIIIII)Z"},
      at = {@At("HEAD")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$beginOrePlacement(WorldGenLevel level, RandomSource random, OreConfiguration configuration, double x1, double x2, double z1, double z2, double y1, double y2, int minX, int minY, int minZ, int width, int height, CallbackInfoReturnable<Boolean> cir) {
      ADVANCED_WORLDGEN_LEVEL.set(level);
   }

   @Inject(
      method = {"doPlace(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;DDDDDDIIIII)Z", "m_225171_(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;DDDDDDIIIII)Z"},
      at = {@At("RETURN")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$endOrePlacement(WorldGenLevel level, RandomSource random, OreConfiguration configuration, double x1, double x2, double z1, double z2, double y1, double y2, int minX, int minY, int minZ, int width, int height, CallbackInfoReturnable<Boolean> cir) {
      ADVANCED_WORLDGEN_LEVEL.remove();
   }

   @Inject(
      method = {"canPlaceOre(Lnet/minecraft/world/level/block/state/BlockState;Ljava/util/function/Function;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration$TargetBlockState;Lnet/minecraft/core/BlockPos$MutableBlockPos;)Z", "m_225186_(Lnet/minecraft/world/level/block/state/BlockState;Ljava/util/function/Function;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration;Lnet/minecraft/world/level/levelgen/feature/configurations/OreConfiguration$TargetBlockState;Lnet/minecraft/core/BlockPos$MutableBlockPos;)Z"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false,
      require = 1
   )
   private static void advancedworldgen$protectStructureBlocks(BlockState state, Function<BlockPos, BlockState> adjacentState, RandomSource random, OreConfiguration configuration, OreConfiguration.TargetBlockState target, BlockPos.MutableBlockPos pos, CallbackInfoReturnable<Boolean> cir) {
      WorldGenLevel level = (WorldGenLevel)ADVANCED_WORLDGEN_LEVEL.get();
      if (level != null && AdvancedBiomeStructureRegistry.blocksFeatureReplacement(level, pos)) {
         cir.setReturnValue(false);
      }

   }
}
