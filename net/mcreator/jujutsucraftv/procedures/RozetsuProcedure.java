package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class RozetsuProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 3:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack4").getString(), (double)50.0F, false, true);
            break;
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack7").getString(), (double)50.0F, false, true);
            break;
         case 5:
            if (CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami").getString(), (double)200.0F, false, false);
            }
            break;
         case 6:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_2") || LogicCreativeProcedure.execute(player)) && CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami_vessel").getString(), (double)250.0F, false, false);
            }
            break;
         case 7:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_3") || LogicCreativeProcedure.execute(player)) && CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.rozetsu_shikigami_vessel_2").getString(), (double)400.0F, false, false);
            }
            break;
         case 8:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_4") || LogicCreativeProcedure.execute(player)) && CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.8").getString(), (double)400.0F, false, false);
            }
            break;
         case 9:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_5") || LogicCreativeProcedure.execute(player)) && CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.9").getString(), (double)500.0F, false, false);
            }
            break;
         case 10:
         case 11:
         case 12:
         case 13:
         case 18:
         case 19:
         default:
            found = switchDefault(player, selected);
            break;
         case 14:
            if (GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_6") || LogicCreativeProcedure.execute(player)) {
               if (CheckFerociousUnitProcedure.execute(player)) {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.14").getString(), (double)300.0F, false, false);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.cancel_cursed_technique").getString(), (double)0.0F, false, true);
               }
            }
            break;
         case 15:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_5") || LogicCreativeProcedure.execute(player)) && !CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.15").getString(), (double)100.0F, false, false);
            }
            break;
         case 16:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_5") || LogicCreativeProcedure.execute(player)) && !CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.15").getString() + Component.m_237115_("jjcv.skill.add.4").getString(), (double)300.0F, false, false);
            }
            break;
         case 17:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_rozetsu_4") || LogicCreativeProcedure.execute(player)) && !CheckFerociousUnitProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.rozetsu.16").getString(), (double)100.0F, false, false);
            }
            break;
         case 20:
            if (SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.rozetsu_domain").getString(), (double)1250.0F, false, false);
            }
      }

      return found;
   }
}
