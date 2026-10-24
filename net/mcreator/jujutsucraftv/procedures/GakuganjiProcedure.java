package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class GakuganjiProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            if (HoldGuitarProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.gakuganji.1").getString(), (double)100.0F, false, false);
            }
            break;
         case 6:
            if (HoldGuitarProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.gakuganji.2").getString(), (double)300.0F, false, false);
            }
            break;
         case 7:
            if (!HoldGuitarProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.gakuganji.3").getString(), (double)50.0F, false, false);
            }
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
