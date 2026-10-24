package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.SpawnLevel1Procedure;

public class SpawnLevel01Procedure {
   public static boolean execute() {
      boolean spawn = false;
      if (SpawnLevel1Procedure.execute() && Math.round(Math.random() * (double)10.0F) > 6L) {
         spawn = true;
      } else {
         spawn = false;
      }

      return spawn;
   }
}
