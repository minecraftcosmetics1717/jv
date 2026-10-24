package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class JjcvDebugData9Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         int var10000;
         label33: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label33;
               }
            }

            var10000 = 0;
         }

         ++var10000;
         int var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_(MobEffects.f_19606_)) {
               var10001 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
               return "STR:" + var10000 + " RES:" + (var10001 + 1);
            }
         }

         var10001 = 0;
         return "STR:" + var10000 + " RES:" + (var10001 + 1);
      }
   }
}
