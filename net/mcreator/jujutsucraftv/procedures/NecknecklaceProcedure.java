package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class NecknecklaceProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.cancel_cursed_technique").getString(), (double)0.0F, false, true);
            break;
         case 7:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.necknecklace.1").getString(), (double)300.0F, false, false);
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("effect.domain_expansion").getString(), (double)1000.0F, false, false);
            }
            break;
         default:
            found = switchDefault(player, selected);
      }

      return found;
   }
}
