package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LogicMiracleSavesCountProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         int var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
               var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get()).m_19564_();
               return var10000 > 0;
            }
         }

         var10000 = 0;
         return var10000 > 0;
      }
   }
}
