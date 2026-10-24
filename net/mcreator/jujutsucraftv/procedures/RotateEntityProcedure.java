package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RotateEntityProcedure {
   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double distance = (double)0.0F;
         double dx = (double)0.0F;
         double dy = (double)0.0F;
         double dz = (double)0.0F;
         double atan2_result = (double)0.0F;
         dx = x - entity.m_20185_();
         dy = y - (entity.m_20186_() + (double)entity.m_20192_() * 0.9);
         dz = z - entity.m_20189_();
         if (dz == (double)0.0F) {
            if (dx > (double)0.0F) {
               atan2_result = (double)90.0F;
            } else if (dx < (double)0.0F) {
               atan2_result = (double)-90.0F;
            } else {
               atan2_result = (double)0.0F;
            }
         } else if (dx == (double)0.0F) {
            if (dz > (double)0.0F) {
               atan2_result = (double)0.0F;
            } else {
               atan2_result = (double)180.0F;
            }
         } else {
            atan2_result = Math.toDegrees(Math.atan(dx / dz));
            if (dz < (double)0.0F) {
               atan2_result += (double)(dx > (double)0.0F ? 180 : -180);
            }
         }

         distance = Math.sqrt(dx * dx + dz * dz + dy * dy);
         yaw = (double)-1.0F * atan2_result;
         pitch = Math.toDegrees(distance == (double)0.0F ? (double)0.0F : (double)-1.0F * Math.asin(dy / distance));
         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            livingEntity.m_146922_(livingEntity.m_146908_());
            livingEntity.m_146926_(livingEntity.m_146909_());
            livingEntity.f_20885_ = livingEntity.m_146908_();
         }

         entity.m_5616_(entity.m_146908_());
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            livingEntity.f_20884_ = livingEntity.m_146908_();
            livingEntity.f_20883_ = livingEntity.m_146908_();
         }
      }

   }
}
