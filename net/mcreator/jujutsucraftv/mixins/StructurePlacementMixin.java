package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeStructureRegistry;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({StructurePlacement.class})
public abstract class StructurePlacementMixin {
   @Shadow
   protected abstract int m_227075_();

   @Inject(
      method = {"isStructureChunk"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void advancedworldgen$fixedCenter(ChunkGeneratorStructureState state, int chunkX, int chunkZ, CallbackInfoReturnable<Boolean> cir) {
      Boolean fixed = AdvancedBiomeStructureRegistry.fixedCenterResult(this.m_227075_(), state.m_254887_(), chunkX, chunkZ);
      if (fixed != null) {
         cir.setReturnValue(fixed && !AdvancedBiomeStructureRegistry.tooCloseToOtherStructure(this.m_227075_(), state.m_254887_(), chunkX, chunkZ));
      }

   }

   @Inject(
      method = {"isStructureChunk"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void advancedworldgen$minimumDistanceBetweenStructures(ChunkGeneratorStructureState state, int chunkX, int chunkZ, CallbackInfoReturnable<Boolean> cir) {
      if ((Boolean)cir.getReturnValue()) {
         if (AdvancedBiomeStructureRegistry.tooCloseToOtherStructure(this.m_227075_(), state.m_254887_(), chunkX, chunkZ)) {
            cir.setReturnValue(false);
         }

      }
   }
}
