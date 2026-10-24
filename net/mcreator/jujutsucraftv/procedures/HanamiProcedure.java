package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class HanamiProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami1").getString(), (double)25.0F, true, false);
            break;
         case 10:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami2").getString(), (double)300.0F, false, false);
            break;
         case 11:
            if (CheckOvertimeProcedure.execute(world, player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.nanami1").getString(), (double)100.0F, true, false);
            }
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami_domain").getString(), (double)1000.0F, false, false);
            }
            break;
         default:
            found = switchDefault(player, selected);
      }

      return found;
   }
}
