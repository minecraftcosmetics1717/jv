package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ShowDebugDisplayProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).Debug;
      }
   }
}
