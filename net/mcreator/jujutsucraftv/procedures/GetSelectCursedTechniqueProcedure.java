package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class GetSelectCursedTechniqueProcedure {
   public static double execute(Entity entity, double num) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double select = (double)0.0F;
         if (num == (double)1.0F) {
            select = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         } else if (num == (double)2.0F) {
            select = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         }

         return select;
      }
   }
}
