package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ChangeSlotPosProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.m_9236_().m_5776_()) {
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

            entity.getPersistentData().m_128405_("slot_num", slot);
            if (pos != null && !pos.trim().isEmpty()) {
               entity.getPersistentData().m_128379_("null_pos", false);
               String[] parts = pos.trim().split("\\s+");
               if (parts.length == 3) {
                  try {
                     double px = Double.parseDouble(parts[0]);
                     double py = Double.parseDouble(parts[1]);
                     double pz = Double.parseDouble(parts[2]);
                     entity.getPersistentData().m_128347_("x_pos", px);
                     entity.getPersistentData().m_128347_("y_pos", py);
                     entity.getPersistentData().m_128347_("z_pos", pz);
                  } catch (NumberFormatException var10) {
                  }

               }
            } else {
               entity.getPersistentData().m_128379_("null_pos", true);
            }
         }
      }
   }
}
