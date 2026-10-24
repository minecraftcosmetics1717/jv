package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GetCanUseTechniqueProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         label42: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                  break label42;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  break label42;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  break label42;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                  break label42;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }
}
