package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class KashimoProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 3:
            found = setInfo(player, selected, Component.m_237115_("entity.jujutsucraft.entity_attack_strike").getString(), (double)50.0F, false, true);
            break;
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack4").getString(), (double)50.0F, false, true);
            break;
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo1").getString(), (double)200.0F, true, true);
            break;
         case 6:
         case 7:
         case 8:
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 18:
         default:
            found = switchDefault(player, selected);
            break;
         case 10:
            if (!player.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get()) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo2").getString(), (double)150.0F, true, true);
            }
            break;
         case 15:
            if (!player.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("effect.mythical_beast_amber_effect").getString(), (double)150.0F, true, false);
            }
            break;
         case 16:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo_ah").getString(), (double)100.0F, false, false);
            }
            break;
         case 17:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo_energy_wave").getString(), (double)250.0F, false, false);
            }
            break;
         case 19:
            if (player.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()) || LogicCreativeProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.flying_kick").getString(), (double)400.0F, false, true);
            }
            break;
         case 20:
            if (GetJjcvConfigProcedure.execute(world, (double)1.0F) && SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo_domain").getString(), (double)1250.0F, false, false);
            }
      }

      return found;
   }
}
