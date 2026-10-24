package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class OTsurugiProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 3 -> found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.1").getString(), (double)50.0F, false, true);
         case 5 -> found = setInfo(player, selected, Component.m_237115_("jjcv.skill.o_tsurugi.1").getString(), (double)120.0F, false, true);
         default -> found = switchDefault(player, selected);
      }

      return found;
   }
}
