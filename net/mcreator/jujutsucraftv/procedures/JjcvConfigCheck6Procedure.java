package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class JjcvConfigCheck6Procedure {
   public static boolean execute(LevelAccessor world) {
      if (world instanceof Level _level) {
         return JujutsucraftvModVariables.MapVariables.get(_level).jjcv_config_mahoraga_19;
      } else {
         return false;
      }
   }
}
