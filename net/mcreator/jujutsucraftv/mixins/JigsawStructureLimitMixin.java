package net.mcreator.jujutsucraftv.mixins;

import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({JigsawStructure.class})
public abstract class JigsawStructureLimitMixin {
   @ModifyConstant(
      method = {"lambda$static$7", "m_227639_"},
      constant = {@Constant(
   intValue = 7
)},
      remap = false,
      require = 1
   )
   private static int advancedworldgen$depthMaximum(int original) {
      return 128;
   }

   @ModifyConstant(
      method = {"lambda$static$7", "m_227639_"},
      constant = {@Constant(
   intValue = 128
)},
      remap = false,
      require = 1
   )
   private static int advancedworldgen$codecMaximum(int original) {
      return 1080;
   }

   @ModifyConstant(
      method = {"verifyRange", "m_286028_"},
      constant = {@Constant(
   intValue = 128
)},
      remap = false,
      require = 1
   )
   private static int advancedworldgen$rangeMaximum(int original) {
      return 1092;
   }
}
