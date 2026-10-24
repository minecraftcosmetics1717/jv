package net.mcreator.jujutsucraftv.mixins;

import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ChunkGenerator.class})
public abstract class ChunkGeneratorStructureRadiusMixin {
   @ModifyConstant(
      method = {"createReferences(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/chunk/ChunkAccess;)V", "m_223076_(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/chunk/ChunkAccess;)V"},
      constant = {@Constant(
   intValue = 8
)},
      remap = false,
      require = 1
   )
   private int advancedworldgen$structureReferenceRadius(int original) {
      return 9;
   }
}
