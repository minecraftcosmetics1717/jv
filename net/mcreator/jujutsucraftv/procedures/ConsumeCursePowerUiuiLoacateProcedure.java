package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ConsumeCursePowerUiuiLoacateProcedure {
   public static int execute(Entity entity) {
      if (entity == null) {
         return 0;
      } else {
         int cost = 0;
         int slot = GetPlayerSelectSlotProcedure.execute(entity);
         String pos = "";
         if (slot == 0) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot0;
         } else if (slot == 1) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot1;
         } else if (slot == 2) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot2;
         } else if (slot == 3) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot3;
         } else if (slot == 4) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot4;
         } else if (slot == 5) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot5;
         } else if (slot == 6) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot6;
         } else if (slot == 7) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot7;
         } else if (slot == 8) {
            pos = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot8;
         }

         if (pos != null && !pos.trim().isEmpty()) {
            String[] parts = pos.trim().split("\\s+");
            if (parts.length != 3) {
               return 0;
            } else {
               try {
                  double px = Double.parseDouble(parts[0]);
                  double py = Double.parseDouble(parts[1]);
                  double pz = Double.parseDouble(parts[2]);
                  double ex = entity.m_20185_();
                  double ey = entity.m_20186_();
                  double ez = entity.m_20189_();
                  double dx = Math.abs(px - ex);
                  double dy = Math.abs(py - ey);
                  double dz = Math.abs(pz - ez);
                  double dist = dx + dy + dz;
                  if (dist <= (double)30.0F) {
                     cost = 100;
                  } else if (dist > (double)30.0F && dist <= (double)50.0F) {
                     cost = 300;
                  } else if (dist > (double)50.0F) {
                     cost = 500;
                  }

                  return cost;
               } catch (NumberFormatException var25) {
                  return 0;
               }
            }
         } else {
            return 0;
         }
      }
   }
}
