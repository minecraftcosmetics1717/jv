package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class JjcvDebugData6Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         double var10000 = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax;
         return "ClMax:" + var10000 + " ClCou:" + ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount;
      }
   }
}
