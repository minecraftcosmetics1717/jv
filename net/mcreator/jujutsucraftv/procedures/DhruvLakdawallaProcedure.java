package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DhruvLakdawallaProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.shikigami_heterocephalus_glaber").getString(), (double)500.0F, false, false);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.shikigami_pterosaur").getString(), (double)500.0F, false, false);
            break;
         case 10:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.cancel").getString(), (double)0.0F, true, true);
            break;
         case 20:
            if (GetJjcvConfigProcedure.execute(world, (double)1.0F) && SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("effect.domain_expansion").getString(), (double)1000.0F, false, false);
            }
            break;
         default:
            found = switchDefault(player, selected);
      }

      return found;
   }
}
