package net.mcreator.jujutsucraftv.mixins;

import net.minecraft.world.level.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ChunkStatus.class})
public abstract class ChunkStatusStructureRadiusMixin {
   @ModifyConstant(
      method = {"<clinit>"},
      constant = {@Constant(
   intValue = 8
)},
      require = 1
   )
   private static int advancedworldgen$structureGenerationRadius(int original) {
      return 9;
   }
}
