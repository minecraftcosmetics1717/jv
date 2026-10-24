package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedFixedBiomeRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RandomState.class})
public abstract class RandomStateMixin {
   @Inject(
      method = {"<init>(Lnet/minecraft/world/level/levelgen/NoiseGeneratorSettings;Lnet/minecraft/core/HolderGetter;J)V"},
      at = {@At("RETURN")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$bindSeed(NoiseGeneratorSettings settings, HolderGetter<NormalNoise.NoiseParameters> noises, long seed, CallbackInfo ci) {
      AdvancedFixedBiomeRegistry.bindSeed(((RandomState)this).m_224579_(), seed);
   }
}
