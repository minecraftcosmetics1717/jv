package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CountTimeTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double var10000;
         int var10001;
         label25: {
            double cost = (double)0.0F;
            var10000 = entity.getPersistentData().m_128459_("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.COUNT_TIME.get())) {
                  var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.COUNT_TIME.get()).m_19564_();
                  break label25;
               }
            }

            var10001 = 0;
         }

         if (var10000 >= (double)var10001) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            double var5 = entity.getPersistentData().m_128459_("cost") / (double)-20.0F;
            if (var5 > (double)0.0F) {
               SetCoolDownProcedure.execute(entity, (double)0.0F, (double)Math.round(entity.getPersistentData().m_128459_("cost") / (double)20.0F));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.COUNT_TIME.get());
            }
         }

      }
   }
}
