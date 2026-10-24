package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ParticleGeneratorCircleProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackVerdictVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         boolean logic_a = false;
         int amp = 0;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
               amp = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
            }
         }

         double strength = (double)Math.min(amp, 50);
         double range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + strength * 0.025);
         double CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double x_pos = entity.m_20185_();
         double y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         double z_pos = entity.m_20189_();
         if (entity instanceof Mob) {
            Mob _mob = (Mob)entity;
            _mob.m_21573_().m_26573_();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         LivingEntity target = var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            if (target instanceof LivingEntity) {
               net.mcreator.jujutsucraft.procedures.RotateEntityProcedure.execute(target.m_20185_(), target.m_20186_() + (double)target.m_20206_() * (double)0.5F, target.m_20189_(), entity);
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
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

            if (entity.getPersistentData().m_128459_("cnt3") >= (double)10.0F) {
               if (target instanceof LivingEntity) {
                  x_pos = target.m_20185_();
                  y_pos = target.m_20186_();
                  z_pos = target.m_20189_();
               } else {
                  double dis = (double)6.0F;

                  for(int index0 = 0; index0 < 6; ++index0) {
                     Vec3 _eyePos = entity.m_20299_(1.0F);
                     Vec3 _lookVec = entity.m_20252_(1.0F);
                     Vec3 _traceVec = _eyePos.m_82520_(_lookVec.f_82479_ * dis, _lookVec.f_82480_ * dis, _lookVec.f_82481_ * dis);
                     ClipContext _clipContext = new ClipContext(_eyePos, _traceVec, Block.VISUAL, Fluid.NONE, entity);
                     Vec3 _hitVec = entity.m_9236_().m_45547_(_clipContext).m_82450_();
                     x_pos = _hitVec.f_82479_;
                     y_pos = _hitVec.f_82480_;
                     z_pos = _hitVec.f_82481_;
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

               double dx = x_pos - entity.m_20185_();
               double dy = y_pos - entity.m_20186_();
               double dz = z_pos - entity.m_20189_();
               double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
               if (dist > (double)1.0F) {
                  dx /= dist;
                  dz /= dist;
               }

               entity.getPersistentData().m_128347_("x_power", dx);
               entity.getPersistentData().m_128347_("z_power", dz);
               entity.getPersistentData().m_128347_("cnt7", dist / (double)2.0F);
               entity.getPersistentData().m_128347_("cnt9", y_pos - entity.m_20186_());
               entity.getPersistentData().m_128347_("cnt10", Math.max(Math.sqrt(dist) * (double)3.0F, (double)3.0F));
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != (double)0.0F) {
            if (target instanceof LivingEntity) {
               entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
               entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
               entity.m_5616_(entity.m_146908_());
               entity.m_5618_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
            }

            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
            double c9 = entity.getPersistentData().m_128459_("cnt9");
            double c7 = entity.getPersistentData().m_128459_("cnt7");
            double c10 = entity.getPersistentData().m_128459_("cnt10");
            double c5 = entity.getPersistentData().m_128459_("cnt5");
            entity.getPersistentData().m_128347_("y_power", (c9 / c7 + c10 * (double)4.0F / c7 - c10 * (double)8.0F / (c7 * c7) * (c5 - (double)0.0F)) * (double)0.5F);
            if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-8.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)2.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               double xp = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               double yp = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               double zp = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               entity.m_20256_(new Vec3(xp, yp, zp));
               double spd = Math.sqrt(xp * xp + yp * yp + zp * zp);
               if (spd != (double)0.0F) {
                  xp /= spd;
                  yp /= spd;
                  zp /= spd;
               }

               double cx = entity.m_20185_();
               double cy = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               double cz = entity.m_20189_();
               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().f_82479_ * 1.1);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().f_82480_ * 1.1);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().f_82481_ * 1.1);

               for(int i = 0; i < (int)Math.max(spd, (double)1.0F); ++i) {
                  entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * range);
                  entity.getPersistentData().m_128347_("knockback", 0.6);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, cx, cy, cz, entity);
                  Vec3 _center = new Vec3(cx, cy, cz);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        logic_a = true;
                        break;
                     }
                  }

                  if (logic_a) {
                     entity.m_20256_(new Vec3((double)0.0F, entity.m_20184_().f_82480_, (double)0.0F));
                     break;
                  }

                  cx += xp;
                  cy += yp;
                  cz += zp;
               }

               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               entity.getPersistentData().m_128379_("attack", true);
               DamageFixProcedure.execute(entity);
               entity.getPersistentData().m_128347_("x_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("z_knockback", (double)0.0F);
               if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
                  double yr = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double off = (double)1.0F * (double)entity.m_20205_();
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yr) * off);
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yr) * off);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     _livingEntity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().m_128459_("cnt1") > (double)80.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt4") > (double)0.0F) {
               if (!(entity instanceof Player) || entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               double fx = entity.getPersistentData().m_128459_("x_pos");
               double fy = entity.getPersistentData().m_128459_("y_pos");
               double fz = entity.getPersistentData().m_128459_("z_pos");
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
                  if (entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(fx, fy, fz), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)range, 0.75F);
                        _level.m_5594_((Player)null, BlockPos.m_274561_(fx, fy, fz), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)range, 0.75F);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("y_knockback", (double)0.5F);
                     double old_c6 = entity.getPersistentData().m_128459_("cnt6");
                     entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
                     entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                     entity.getPersistentData().m_128347_("Range", (double)8.0F * range);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, fx, fy, fz, entity);
                     entity.getPersistentData().m_128347_("cnt6", old_c6);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F + strength / (double)16.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * range);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, fx, fy, fz, entity);
                  }

                  for(int i = 0; i < (int)((double)24.0F * range); ++i) {
                     double rr = Mth.m_14139_((double)world.m_213780_().m_188501_(), (double)0.0F, (double)4.0F * range);
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, rr, rr, Mth.m_14139_((double)world.m_213780_().m_188501_(), (double)1.0F, (double)8.0F), fx, fx, fy, fy + (double)1.0F, (double)0.0F, fz, fz, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128347_("BlockRange", strength);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, fx, fy, fz, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > (double)25.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
      }
   }
}
