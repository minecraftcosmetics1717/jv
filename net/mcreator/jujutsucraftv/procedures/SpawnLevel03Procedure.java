package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.SpawnLevel3Procedure;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel03Procedure {
   public static boolean execute(LevelAccessor world) {
      boolean spawn = false;
      if (SpawnLevel3Procedure.execute(world) && Math.round(Math.random() * (double)10.0F) > 6L) {
         spawn = true;
      } else {
         spawn = false;
      }

      return spawn;
   }
}
