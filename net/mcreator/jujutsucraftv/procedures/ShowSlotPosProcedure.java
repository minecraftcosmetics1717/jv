package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ShowSlotPosProcedure {
   public static void execute(Entity entity, double slot_num) {
      if (entity != null) {
         String pos = "";
         double slot = (double)0.0F;
         if (slot_num == (double)0.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot0);
         }

         if (slot_num == (double)1.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot1);
         }

         if (slot_num == (double)2.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot2);
         }

         if (slot_num == (double)3.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot3);
         }

         if (slot_num == (double)4.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot4);
         }

         if (slot_num == (double)5.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot5);
         }

         if (slot_num == (double)6.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot6);
         }

         if (slot_num == (double)7.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot7);
         }

         if (slot_num == (double)8.0F) {
            entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot8);
         }

         if (!entity.getPersistentData().m_128461_("pos").isEmpty()) {
            String[] parts = entity.getPersistentData().m_128461_("pos").trim().split(" ");
            if (parts.length != 3) {
               return;
            }

            try {
               entity.getPersistentData().m_128347_("x_pos", Double.parseDouble(parts[0].trim()));
               entity.getPersistentData().m_128347_("y_pos", Double.parseDouble(parts[1].trim()));
               entity.getPersistentData().m_128347_("z_pos", Double.parseDouble(parts[2].trim()));
            } catch (NumberFormatException var8) {
            }

            if (!Minecraft.m_91087_().f_91066_.f_92075_.equals("ja_jp")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("The coordinates set for slot" + slot_num + " are §4X" + entity.getPersistentData().m_128459_("x_pos") + "§2Y" + entity.getPersistentData().m_128459_("y_pos") + "§1Z" + entity.getPersistentData().m_128459_("z_pos")), true);
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("スロット" + slot_num + "に設定された座標は§4X" + entity.getPersistentData().m_128459_("x_pos") + "§2Y" + entity.getPersistentData().m_128459_("y_pos") + "§1Z" + entity.getPersistentData().m_128459_("z_pos") + "§fです"), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.message.not_set_slot_pos").getString()), true);
            }
         }

      }
   }
}
