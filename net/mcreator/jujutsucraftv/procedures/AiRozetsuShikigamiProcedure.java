package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiBoogieWoogieEntity;
import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiShrineEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AiRozetsuShikigamiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AiActiveVProcedure.execute(world, x, y, z, entity);
            if (entity instanceof RozetsuShikigamiShrineEntity) {
               label168: {
                  label145: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt2 = (LivingEntity)entity;
                        if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                           break label145;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 8, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                        break label168;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }
            } else if (entity instanceof RozetsuShikigamiBoogieWoogieEntity) {
               label169: {
                  label151: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt7 = (LivingEntity)entity;
                        if (_livEnt7.m_21023_(MobEffects.f_19600_)) {
                           break label151;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 6, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.m_21023_(MobEffects.f_19606_)) {
                        break label169;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }
            } else {
               label174: {
                  label158: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.m_21023_(MobEffects.f_19600_)) {
                           break label158;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 2, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt13 = (LivingEntity)entity;
                     if (_livEnt13.m_21023_(MobEffects.f_19606_)) {
                        break label174;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
                     }
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
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var31 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var32 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var31, var32, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-15.0F);
                  ResetCounterVProcedure.execute(entity);
                  distance = GetDistanceVProcedure.execute(world, entity);
                  if (!GetCoolDownProcedure.execute(entity)) {
                     if (entity instanceof RozetsuShikigamiShrineEntity) {
                        rnd = (double)15.0F;
                        tick = (double)6.0F;
                     }

                     if (entity instanceof RozetsuShikigamiBoogieWoogieEntity) {
                        if (distance <= (double)15.0F) {
                           if (Math.random() <= 0.7) {
                              rnd = (double)17.0F;
                              tick = (double)10.0F;
                           } else {
                              rnd = (double)7.0F;
                              tick = (double)6.0F;
                           }
                        } else {
                           rnd = (double)7.0F;
                           tick = (double)6.0F;
                        }
                     }
                  }

                  if (rnd > (double)0.0F) {
                     if (rnd == (double)7.0F && entity instanceof RozetsuShikigamiBoogieWoogieEntity) {
                        entity.getPersistentData().m_128347_("skill", (double)2007.0F);
                     } else {
                        entity.getPersistentData().m_128347_("skill", (double)4300.0F + rnd);
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(tick) + " 0 true");
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique infinite 0 true");
                     }
                  } else {
                     CalculateAttackVProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
