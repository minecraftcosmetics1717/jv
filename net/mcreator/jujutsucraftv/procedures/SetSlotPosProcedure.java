package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SetSlotPosProcedure {
   public static void execute(Entity entity, double slot_num) {
      if (entity != null) {
         String pos = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double slot = (double)0.0F;
         x_pos = (double)Math.round(entity.m_20185_());
         y_pos = (double)Math.round(entity.m_20186_());
         z_pos = (double)Math.round(entity.m_20189_());
         pos = x_pos + " " + y_pos + " " + z_pos;
         if (slot_num == (double)0.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot0 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)1.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot1 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)2.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot2 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)3.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot3 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)4.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot4 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)5.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot5 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)6.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot6 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)7.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot7 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (slot_num == (double)8.0F) {
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.uiui_slot8 = pos;
               capability.syncPlayerVariables(entity);
            });
         }

         if (!Minecraft.m_91087_().f_91066_.f_92075_.equals("ja_jp")) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("Set coordinates §4X" + x_pos + "§2Y" + y_pos + "§1Z" + z_pos + "§f registered in slot" + slot_num), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("スロット" + slot_num + "に§4X" + x_pos + "§2Y" + y_pos + "§1Z" + z_pos + "§fの座標を登録しました"), true);
            }
         }

      }
   }
}
