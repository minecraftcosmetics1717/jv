package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class AmaiProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.amai.1").getString(), (double)10.0F, false, false);
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.amai.20").getString(), (double)1000.0F, false, false);
            }
            break;
         default:
            found = switchDefault(player, selected);
      }

      return found;
   }
}
