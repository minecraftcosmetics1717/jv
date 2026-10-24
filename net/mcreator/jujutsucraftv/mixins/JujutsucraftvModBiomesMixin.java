package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBiomes;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {JujutsucraftvModBiomes.class},
   remap = false
)
public abstract class JujutsucraftvModBiomesMixin {
   @Redirect(
      method = {"onServerAboutToStart"},
      at = @At(
   value = "FIELD",
   target = "Lnet/minecraft/world/level/chunk/ChunkGenerator;biomeSource:Lnet/minecraft/world/level/biome/BiomeSource;",
   opcode = 181,
   remap = false
),
      remap = false,
      require = 0
   )
   private static void jjcv$keepSerializableBiomeSourceDev(ChunkGenerator chunkGenerator, BiomeSource replacement) {
   }

   @Redirect(
      method = {"onServerAboutToStart"},
      at = @At(
   value = "FIELD",
   target = "Lnet/minecraft/world/level/chunk/ChunkGenerator;f_62137_:Lnet/minecraft/world/level/biome/BiomeSource;",
   opcode = 181,
   remap = false
),
      remap = false,
      require = 0
   )
   private static void jjcv$keepSerializableBiomeSourceRuntime(ChunkGenerator chunkGenerator, BiomeSource replacement) {
   }
}
