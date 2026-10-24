package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class NanamiProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami1").getString(), (double)25.0F, true, false);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack4").getString(), (double)50.0F, false, true);
            break;
         case 7:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack9").getString(), (double)100.0F, false, true);
            break;
         case 8:
         case 9:
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
         case 10:
            if (GetAdvancementProcedure.execute(player, "jujutsucraft:skill_collapse") || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami2").getString(), (double)300.0F, false, false);
            }
            break;
         case 11:
            if (CheckOvertimeProcedure.execute(world, player) && GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_overtime") || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.nanami1").getString(), (double)100.0F, true, false);
            }
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.nanami_domain").getString(), (double)1250.0F, false, false);
            }
      }

      return found;
   }
}
