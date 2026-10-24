package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AIMahitoProcedure;
import net.mcreator.jujutsucraftv.entity.HsMahitoEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AiCursedSpirit0MainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         if (entity instanceof HsMahitoEntity) {
            AIMahitoProcedure.execute(world, x, y, z, entity);
         } else if (entity.m_6084_()) {
            label46: {
               AiActiveVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label46;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                  }
               }
            }

            label41: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label41;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  ResetCounterVProcedure.execute(entity);
                  GetDistanceVProcedure.execute(world, entity);
                  CalculateAttackVProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
