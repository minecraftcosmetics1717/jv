package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SukunaProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.dismantle").getString(), (double)100.0F, false, false);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.cleave").getString(), (double)200.0F, false, false);
            break;
         case 7:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || GetAdvancementProcedure.execute(player, "jujutsucraft:skill_open") || LogicCreativeProcedure.execute(player)) {
               if (!player.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.open").getString(), (double)500.0F, false, false);
               } else {
                  found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.open").getString(), (double)1000.0F, false, false);
               }
            }
            break;
         case 8:
         case 9:
         case 10:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         default:
            found = switchDefault(player, selected);
            break;
         case 11:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || GetJjcvConfigProcedure.execute(world, (double)7.0F) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.dismantle1").getString(), (double)100.0F, false, true);
            }
            break;
         case 12:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || GetJjcvConfigProcedure.execute(world, (double)7.0F) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.dismantle2").getString(), (double)100.0F, false, true);
            }
            break;
         case 13:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || GetJjcvConfigProcedure.execute(world, (double)7.0F) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.dismantle3").getString(), (double)100.0F, false, true);
            }
            break;
         case 20:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.malevolent_shrine").getString(), (double)1250.0F, false, false);
            }
      }

      return found;
   }
}
