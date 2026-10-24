package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ShigemoProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            if (LogicMiracleSavingsProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.shigemo.1").getString(), (double)0.0F, true, false);
            } else if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.shigemo.1_1").getString(), (double)100.0F, false, false);
            } else {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.shigemo.1").getString(), (double)100.0F, false, false);
            }
            break;
         case 6:
            if (LogicMiracleSavesCountProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.shigemo.2").getString(), (double)150.0F, false, false);
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
