package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class CloneBreakEndProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double _setval = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneDefolt;
         entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.CloneMax = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
