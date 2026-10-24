package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GetNeutralizationLevelProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
               var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
               return var10000;
            }
         }

         var10000 = (double)0.0F;
         return var10000;
      }
   }
}
