package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedFixedBiomeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({MultiNoiseBiomeSource.class})
public abstract class MultiNoiseBiomeSourceMixin {
   @Inject(
      method = {"getNoiseBiome(IIILnet/minecraft/world/level/biome/Climate$Sampler;)Lnet/minecraft/core/Holder;", "m_203407_(IIILnet/minecraft/world/level/biome/Climate$Sampler;)Lnet/minecraft/core/Holder;"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false,
      require = 1
   )
   private void advancedworldgen$fixedShape(int quartX, int quartY, int quartZ, Climate.Sampler sampler, CallbackInfoReturnable<Holder<Biome>> cir) {
      Holder<Biome> fixed = AdvancedFixedBiomeRegistry.resolve((BiomeSource)this, quartX, quartY, quartZ, sampler);
      if (fixed != null) {
         cir.setReturnValue(fixed);
      }

   }

   @Inject(
      method = {"getNoiseBiome(IIILnet/minecraft/world/level/biome/Climate$Sampler;)Lnet/minecraft/core/Holder;", "m_203407_(IIILnet/minecraft/world/level/biome/Climate$Sampler;)Lnet/minecraft/core/Holder;"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false,
      require = 1
   )
   private void advancedworldgen$keepFixedBiomeInsideItsConfiguredSize(int quartX, int quartY, int quartZ, Climate.Sampler sampler, CallbackInfoReturnable<Holder<Biome>> cir) {
      cir.setReturnValue(AdvancedFixedBiomeRegistry.replaceFixedOnlyOutside((BiomeSource)this, quartX, quartY, quartZ, sampler, (Holder)cir.getReturnValue()));
   }
}
