package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class BagmaskProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.2").getString(), (double)50.0F, false, true);
            break;
         case 5:
            if (((JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax > (double)0.0F) {
               if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                  double cloneMaxValue = (((JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax - ((JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount) * (double)150.0F;
                  if (cloneMaxValue > (double)1500.0F) {
                     cloneMaxValue = (double)1500.0F;
                  }

                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.bagmask.1_1").getString(), cloneMaxValue, false, false);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.bagmask.1").getString(), (double)150.0F, false, false);
               }
            }
            break;
         case 6:
            if (((JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount > (double)0.0F) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.bagmask.2").getString(), (double)10.0F, false, true);
            }
            break;
         case 7:
            if (((JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount > (double)0.0F) {
               if (((JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.cancel_cursed_technique_1").getString(), (double)0.0F, false, true);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.cancel_cursed_technique").getString(), (double)0.0F, false, true);
               }
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
