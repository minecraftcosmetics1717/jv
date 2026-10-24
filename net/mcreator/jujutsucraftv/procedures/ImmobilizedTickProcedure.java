package net.mcreator.jujutsucraftv.procedures;

import java.util.Map;
import java.util.WeakHashMap;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ImmobilizedTickProcedure {
   private static final Map<Entity, RotationLock> ROTATION_LOCKS = new WeakHashMap();

   public static void execute(Entity entity) {
      if (entity instanceof LivingEntity livingEntity) {
         MobEffectInstance effect = livingEntity.m_21124_((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get());
         if (effect != null) {
            if (effect.m_19564_() < 2) {
               ROTATION_LOCKS.remove(entity);
            } else {
               long gameTime = entity.m_9236_().m_46467_();
               RotationLock lock = (RotationLock)ROTATION_LOCKS.get(entity);
               if (lock == null) {
                  lock = new RotationLock(livingEntity);
                  ROTATION_LOCKS.put(entity, lock);
               } else if (gameTime - lock.lastTick > 1L) {
                  lock.set(livingEntity);
               }

               lock.lastTick = gameTime;
               entity.m_146922_(lock.yaw);
               entity.m_146926_(lock.pitch);
               entity.f_19859_ = lock.yaw;
               entity.f_19860_ = lock.pitch;
               livingEntity.m_5616_(lock.headYaw);
               livingEntity.m_5618_(lock.bodyYaw);
               livingEntity.f_20886_ = lock.headYaw;
               livingEntity.f_20884_ = lock.bodyYaw;
            }
         }
      }
   }

   private static class RotationLock {
      float yaw;
      float pitch;
      float headYaw;
      float bodyYaw;
      long lastTick;

      RotationLock(LivingEntity entity) {
         this.set(entity);
      }

      void set(LivingEntity entity) {
         this.yaw = entity.m_146908_();
         this.pitch = entity.m_146909_();
         this.headYaw = entity.m_6080_();
         this.bodyYaw = entity.f_20883_;
         this.lastTick = entity.m_9236_().m_46467_();
      }
   }
}
