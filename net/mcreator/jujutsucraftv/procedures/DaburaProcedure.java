package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DaburaProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            if (CheckSublightSpeedProcedure.execute(player) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, "\ue210" + Component.m_237115_("jjcv.skill.dabura.1").getString(), (double)100.0F, false, false);
            }
            break;
         case 6:
            if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_dabura_1") && CheckSublightSpeedProcedure.execute(player) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, "\ue210" + Component.m_237115_("jjcv.skill.dabura.1").getString() + Component.m_237115_("jjcv.skill.add.1").getString(), (double)300.0F, false, false);
            }
            break;
         case 7:
            if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_dabura_2") && CheckSublightSpeedProcedure.execute(player) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, "\ue210" + Component.m_237115_("jjcv.skill.dabura.1").getString() + Component.m_237115_("jjcv.skill.add.2").getString(), (double)500.0F, false, false);
            }
            break;
         case 8:
            if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_dabura_4") && CheckSublightSpeedProcedure.execute(player) && GetCanUseReverseCursedTechniqueProcedure.execute(player) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.ct.reverse").getString() + "\ue210", (double)500.0F, false, false);
            }
            break;
         case 9:
            if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_dabura_3") && CheckSublightSpeedProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.dabura.3").getString(), (double)150.0F, false, false);
            } else if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_dabura_3")) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.cancel_cursed_technique").getString(), (double)0.0F, false, true);
            }
            break;
         case 10:
            if (!CheckSublightSpeedProcedure.execute(player) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.dabura.4").getString(), (double)700.0F, false, false);
            }
            break;
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
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.dabura.20").getString(), (double)1250.0F, false, false);
            }
      }

      return found;
   }
}
