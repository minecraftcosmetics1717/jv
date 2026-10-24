package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeSpawnRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({NaturalSpawner.class})
public abstract class NaturalSpawnerMixin {
   @Inject(
      method = {"mobsAt"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private static void advancedworldgen$spawns(ServerLevel level, StructureManager structures, ChunkGenerator generator, MobCategory category, BlockPos pos, Holder<Biome> biome, CallbackInfoReturnable<WeightedRandomList<MobSpawnSettings.SpawnerData>> cir) {
      Holder<Biome> actualBiome = biome;
      if (biome == null && level != null && pos != null) {
         actualBiome = level.m_204166_(pos);
      }

      if (actualBiome != null && cir.getReturnValue() != null) {
         cir.setReturnValue(AdvancedBiomeSpawnRegistry.modify(level, actualBiome, category, (WeightedRandomList)cir.getReturnValue()));
      }
   }
}
