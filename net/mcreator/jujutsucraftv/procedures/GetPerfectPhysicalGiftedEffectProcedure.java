package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GetPerfectPhysicalGiftedEffectProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
               return _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_() > 0;
            }
         }

         return false;
      }
   }
}
