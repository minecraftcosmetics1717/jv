package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CheckSublightSpeedProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get())) {
               var10000 = true;
               return !var10000;
            }
         }

         var10000 = false;
         return !var10000;
      }
   }
}
