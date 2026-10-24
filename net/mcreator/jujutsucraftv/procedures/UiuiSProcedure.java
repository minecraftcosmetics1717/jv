package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class UiuiSProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.uiui.1").getString(), (double)100.0F, false, false);
            break;
         case 6:
            if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.uiui.2_2").getString(), (double)0.0F, false, false);
            } else {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.uiui.2_1").getString(), (double)50.0F, false, false);
            }
            break;
         case 7:
            if (!GetDomainExpansionProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.uiui.3").getString(), (double)300.0F, false, false);
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
