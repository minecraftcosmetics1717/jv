package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class TojiProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.1").getString(), (double)0.0F, false, true);
            break;
         case 5:
            if (GetPerfectPhysicalGiftedEffectProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack7").getString(), (double)0.0F, false, true);
            }
            break;
         case 6:
            if (GetPerfectPhysicalGiftedEffectProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack4").getString(), (double)0.0F, false, true);
            }
            break;
         case 7:
            if (GetPerfectPhysicalGiftedEffectProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack5").getString(), (double)0.0F, false, true);
            }
            break;
         case 8:
         case 9:
         default:
            found = switchDefault(player, selected);
            break;
         case 10:
            if (GetPerfectPhysicalGiftedEffectProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.7").getString(), (double)0.0F, false, true);
            }
      }

      return found;
   }
}
