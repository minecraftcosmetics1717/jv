package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class YukiProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      double hold_type = (double)0.0F;
      hold_type = HoldFoundationStoneProcedure.execute(player);
      switch (selected) {
         case 5:
            if (hold_type == (double)0.0F) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.1").getString(), (double)100.0F, true, false);
            }
            break;
         case 6:
            if (hold_type == (double)1.0F) {
               if (GetFlagShiftProcedure.execute(player)) {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.5_1").getString(), (double)300.0F, false, false);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.5").getString(), (double)150.0F, false, false);
               }
            }
            break;
         case 7:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_yuki_1") || LogicCreativeProcedure.execute(player)) && (hold_type == (double)1.0F || hold_type == (double)2.0F)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.2").getString(), (double)50.0F, false, false);
            }
            break;
         case 8:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_yuki_2") || LogicCreativeProcedure.execute(player)) && hold_type == (double)1.0F) {
               if (GetFlagShiftProcedure.execute(player)) {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.3_1").getString(), (double)300.0F, false, false);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.3").getString(), (double)150.0F, false, false);
               }
            }
            break;
         case 9:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_yuki_4") || LogicCreativeProcedure.execute(player)) && hold_type == (double)1.0F) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.4").getString(), (double)200.0F, false, false);
            }
            break;
         case 10:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_yuki_3") || LogicCreativeProcedure.execute(player)) && hold_type == (double)1.0F) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.6").getString(), (double)200.0F, false, false);
            }
            break;
         case 11:
            if ((GetAdvancementProcedure.execute(player, "jujutsucraftv:skill_yuki_5") || LogicCreativeProcedure.execute(player)) && (hold_type == (double)1.0F || hold_type == (double)2.0F)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.yuki.7").getString(), (double)300.0F, false, false);
            }
            break;
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
               found = setInfo(player, selected, Component.m_237115_("effect.domain_expansion").getString(), (double)1000.0F, false, false);
            }
      }

      return found;
   }
}
