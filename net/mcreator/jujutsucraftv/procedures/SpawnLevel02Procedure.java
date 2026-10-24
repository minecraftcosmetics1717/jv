package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.SpawnLevel2Procedure;
import net.minecraft.world.level.LevelAccessor;

public class SpawnLevel02Procedure {
   public static boolean execute(LevelAccessor world) {
      boolean spawn = false;
      if (SpawnLevel2Procedure.execute(world) && Math.round(Math.random() * (double)10.0F) > 6L) {
         spawn = true;
      } else {
         spawn = false;
      }

      return spawn;
   }
}
