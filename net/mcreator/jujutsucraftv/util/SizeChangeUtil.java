package net.mcreator.jujutsucraftv.util;

import net.mcreator.jujutsucraftv.potion.SizeChangeMobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SizeChangeUtil {
   public static float getScale(LivingEntity entity) {
      if (!(entity instanceof Player)) {
         return 1.0F;
      } else if (entity instanceof SizeChangeReady) {
         SizeChangeReady ready = (SizeChangeReady)entity;
         float forcedScale = ready.jjcv$getForcedSizeChangeScale();
         return !Float.isNaN(forcedScale) ? clampScale(forcedScale) : clampScale(ready.jjcv$getSyncedSizeChangeScale());
      } else {
         return getEffectScale(entity);
      }
   }

   public static float getEffectScale(LivingEntity entity) {
      if (!(entity instanceof Player)) {
         return 1.0F;
      } else {
         for(MobEffectInstance effectInstance : entity.m_21220_()) {
            if (effectInstance.m_19544_() instanceof SizeChangeMobEffect) {
               return SizeChangeMobEffect.getScale(effectInstance.m_19564_());
            }
         }

         return 1.0F;
      }
   }

   public static boolean isSizeChangeEffect(MobEffectInstance effectInstance) {
      return effectInstance != null && effectInstance.m_19544_() instanceof SizeChangeMobEffect;
   }

   public static float getResultingScale(MobEffectInstance oldEffect, MobEffectInstance newEffect) {
      if (newEffect != null && newEffect.m_19544_() instanceof SizeChangeMobEffect) {
         return SizeChangeMobEffect.getScale(newEffect.m_19564_());
      } else {
         return oldEffect != null && oldEffect.m_19544_() instanceof SizeChangeMobEffect ? SizeChangeMobEffect.getScale(oldEffect.m_19564_()) : 1.0F;
      }
   }

   private static float clampScale(float scale) {
      return Math.max(0.1F, Math.min(10.0F, scale));
   }
}
