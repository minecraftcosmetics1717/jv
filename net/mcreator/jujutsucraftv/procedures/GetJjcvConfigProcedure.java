package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.world.level.LevelAccessor;

public class GetJjcvConfigProcedure {
   public static boolean execute(LevelAccessor world, double config_num) {
      JujutsucraftvModVariables.MapVariables vars = JujutsucraftvModVariables.MapVariables.get(world);
      int id = (int)Math.round(config_num);
      boolean var10000;
      switch (id) {
         case 1 -> var10000 = vars.jjcv_config_add_all_domain;
         case 2 -> var10000 = vars.jjcv_config_add_without_ct_domain;
         case 3 -> var10000 = vars.jjcv_config_gui_jjc_key;
         case 4 -> var10000 = vars.jjcv_config_cp_color_get;
         case 5 -> var10000 = vars.jjcv_config_job_selector_get;
         case 6 -> var10000 = vars.jjcv_config_mahoraga_19;
         case 7 -> var10000 = vars.jjcv_config_sukuna_dismantle_combo;
         default -> var10000 = false;
      }

      boolean result = var10000;
      return result;
   }
}
