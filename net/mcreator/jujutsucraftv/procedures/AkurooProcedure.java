package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class AkurooProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.2").getString(), (double)50.0F, false, true);
            break;
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack8").getString(), (double)200.0F, false, true);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.akuroo.1").getString(), (double)150.0F, false, false);
            break;
         case 7:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.akuroo.2").getString(), (double)150.0F, false, false);
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
