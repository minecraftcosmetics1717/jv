package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class JjcvConfigCheck1Procedure {
   public static boolean execute(LevelAccessor world) {
      if (world instanceof Level _level) {
         return JujutsucraftvModVariables.MapVariables.get(_level).jjcv_config_add_all_domain;
      } else {
         return false;
      }
   }
}
