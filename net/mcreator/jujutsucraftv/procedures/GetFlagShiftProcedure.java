package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class GetFlagShiftProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic = false;
         return ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift;
      }
   }
}
