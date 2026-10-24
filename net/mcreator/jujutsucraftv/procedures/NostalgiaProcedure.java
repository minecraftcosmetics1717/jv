package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class NostalgiaProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 3:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.1").getString(), (double)50.0F, false, true);
            break;
         case 4:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         default:
            found = switchDefault(player, selected);
            break;
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.notostalgia.1").getString(), (double)100.0F, false, false);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.notostalgia.2").getString(), (double)150.0F, false, false);
            break;
         case 7:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.notostalgia.3").getString(), (double)500.0F, false, false);
            break;
         case 8:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.notostalgia.4").getString(), (double)400.0F, false, false);
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("effect.domain_expansion").getString(), (double)1000.0F, false, false);
            }
      }

      return found;
   }
}
