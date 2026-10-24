package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackJumpVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double dis = (double)0.0F;
         double d = (double)0.0F;
         double strength = (double)0.0F;
         double loop_num = (double)0.0F;
         double range = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double distance = (double)0.0F;
         Entity target_entity = null;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         entity.f_19864_ = true;
         LivingEntity _target = null;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            _target = _mobEnt.m_5448_();
         }

         if (_target instanceof LivingEntity) {
            net.mcreator.jujutsucraft.procedures.RotateEntityProcedure.execute(((Entity)_target).m_20185_(), ((Entity)_target).m_20186_() + (double)((Entity)_target).m_20206_() * (double)0.5F, ((Entity)_target).m_20189_(), entity);
         }

         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt5") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity = (LivingEntity)entity;
               if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity = (LivingEntity)entity;
               if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt5") >= (double)10.0F) {
            if (entity.getPersistentData().m_128459_("cnt5") == (double)10.0F) {
               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
               dis = (double)6.0F;
               if (_target instanceof LivingEntity) {
                  x_pos = ((Entity)_target).m_20185_();
                  y_pos = ((Entity)_target).m_20186_();
                  z_pos = ((Entity)_target).m_20189_();
               } else {
                  for(int index0 = 0; index0 < 6; ++index0) {
                     Vec3 _eyePos = entity.m_20299_(1.0F);
                     Vec3 _lookVec = entity.m_20252_(1.0F);
                     Vec3 _traceVec = _eyePos.m_82520_(_lookVec.f_82479_ * dis, _lookVec.f_82480_ * dis, _lookVec.f_82481_ * dis);
                     ClipContext _clipContext = new ClipContext(_eyePos, _traceVec, Block.VISUAL, Fluid.NONE, entity);
                     x_pos = (double)entity.m_9236_().m_45547_(_clipContext).m_82425_().m_123341_();
                     y_pos = (double)entity.m_9236_().m_45547_(_clipContext).m_82425_().m_123342_();
                     z_pos = (double)entity.m_9236_().m_45547_(_clipContext).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_();
                           z_pos = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += (double)6.0F;
                  }
               }

               x_power = x_pos - entity.m_20185_();
               y_power = y_pos - entity.m_20186_();
               z_power = z_pos - entity.m_20189_();
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance > (double)1.0F) {
                  x_power /= distance;
                  z_power /= distance;
               }

               entity.getPersistentData().m_128347_("x_power", x_power);
               entity.getPersistentData().m_128347_("z_power", z_power);
               entity.getPersistentData().m_128347_("cnt7", distance / (double)2.0F);
               entity.getPersistentData().m_128347_("cnt9", y_pos - entity.m_20186_());
               entity.getPersistentData().m_128347_("cnt10", Math.max(Math.sqrt(distance) * (double)1.5F, (double)2.0F));
            }

            double cnt9 = entity.getPersistentData().m_128459_("cnt9");
            double cnt7 = entity.getPersistentData().m_128459_("cnt7");
            double cnt10 = entity.getPersistentData().m_128459_("cnt10");
            double cnt5 = entity.getPersistentData().m_128459_("cnt5");
            entity.getPersistentData().m_128347_("y_power", (cnt9 / cnt7 + cnt10 * (double)4.0F / cnt7 - cnt10 * (double)8.0F / (cnt7 * cnt7) * (cnt5 - (double)9.0F)) * (double)0.5F);
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
