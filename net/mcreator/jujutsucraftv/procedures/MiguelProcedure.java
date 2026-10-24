package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MiguelProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.4").getString(), (double)50.0F, false, true);
            break;
         case 5:
            if (!player.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
               found = setInfo(player, selected, Component.m_237115_("effect.jujutsucraft.prayer_song").getString(), (double)400.0F, true, false);
            }
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack9").getString(), (double)100.0F, false, true);
            break;
         case 20:
            if (GetJjcvConfigProcedure.execute(world, (double)1.0F) && SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jjcv.skill.miguel.domain").getString(), (double)1250.0F, false, false);
            }
            break;
         default:
            found = switchDefault(player, selected);
      }

      return found;
   }
}
