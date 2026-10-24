package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.SpawnLevel5Procedure;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel05Procedure {
   public static boolean execute(LevelAccessor world) {
      boolean spawn = false;
      double num = (double)0.0F;
      if (SpawnLevel5Procedure.execute(world)) {
         spawn = true;
      } else {
         spawn = false;
      }

      return spawn;
   }
}
