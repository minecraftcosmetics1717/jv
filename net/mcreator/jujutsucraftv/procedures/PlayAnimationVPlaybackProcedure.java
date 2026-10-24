package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class PlayAnimationVPlaybackProcedure {
   public static void execute(LevelAccessor world, Entity entity, int animationCode, String animationName) {
      if (entity != null && animationName != null && animationCode != 0) {
         SetupAnimationsProcedure.playResolved(world, entity, animationCode, animationName);
      }
   }
}
