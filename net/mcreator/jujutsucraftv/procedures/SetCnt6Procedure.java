package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SetCnt6Procedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         String message_press = "";
         String r_m = "";
         if (entity.getPersistentData().m_128471_("PRESS_Z")) {
            if (entity.getPersistentData().m_128459_("cnt6") <= (double)0.0F) {
               r_m = "■■■■■";
            } else if (entity.getPersistentData().m_128459_("cnt6") == (double)1.0F) {
               r_m = "■■■■";
            } else if (entity.getPersistentData().m_128459_("cnt6") == (double)2.0F) {
               r_m = "■■■";
            } else if (entity.getPersistentData().m_128459_("cnt6") == (double)3.0F) {
               r_m = "■■";
            } else if (entity.getPersistentData().m_128459_("cnt6") == (double)4.0F) {
               r_m = "■";
            } else if (entity.getPersistentData().m_128459_("cnt6") <= (double)5.0F) {
               r_m = "";
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(r_m + Component.m_237115_("jjcv.long_press").getString() + r_m), true);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (!_livEnt.m_21220_().isEmpty()) {
                  int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                  if (cooldownTicks > 0) {
                     _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
            }
         }

      }
   }
}
