package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class JjcvDebugDisplayProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).Debug) {
            boolean _setval = false;
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.Debug = _setval;
               capability.syncPlayerVariables(entity);
            });
         } else {
            boolean _setval = true;
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.Debug = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

      }
   }
}
