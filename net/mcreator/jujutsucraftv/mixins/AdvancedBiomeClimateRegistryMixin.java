package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeClimateRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(
   value = {AdvancedBiomeClimateRegistry.class},
   remap = false
)
public abstract class AdvancedBiomeClimateRegistryMixin {
   @ModifyArg(
      method = {"addSinglePoint"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/level/biome/Climate$ParameterPoint;<init>(Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;J)V",
   remap = true
),
      index = 6,
      remap = false,
      require = 0
   )
   private static long jjcv$clampClimateOffset(long offset) {
      return Math.max(0L, Math.min(10000L, offset));
   }
}
