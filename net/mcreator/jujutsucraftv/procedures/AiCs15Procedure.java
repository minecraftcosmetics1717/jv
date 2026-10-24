package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AICursedSpiritSpecialProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade15Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AiCs15Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            float var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21223_();
            } else {
               var10000 = -1.0F;
            }

            double var32 = (double)var10000;
            float var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21233_();
            } else {
               var10001 = -1.0F;
            }

            if (var32 >= (double)var10001 * 0.2) {
               int var33;
               if (entity instanceof CursedSpiritGrade15Entity) {
                  CursedSpiritGrade15Entity _datEntI = (CursedSpiritGrade15Entity)entity;
                  var33 = (Integer)_datEntI.m_20088_().m_135370_(CursedSpiritGrade15Entity.DATA_entity_form);
               } else {
                  var33 = 0;
               }

               if (var33 == 0) {
                  label174: {
                     AiActiveVProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt4 = (LivingEntity)entity;
                        if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                           break label174;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                        }
                     }
                  }

                  label169: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
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

                  LivingEntity var34;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var34 = _mobEnt.m_5448_();
                  } else {
                     var34 = null;
                  }

                  if (var34 instanceof LivingEntity) {
                     EntityAnchorArgument.Anchor var38 = Anchor.EYES;
                     Vec3 var10002 = new Vec3;
                     LivingEntity var10004;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     double var40 = ((Entity)var10004).m_20185_();
                     LivingEntity var10005;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     double var41 = ((Entity)var10005).m_20186_();
                     LivingEntity var10006;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var40, var41, ((Entity)var10006).m_20189_());
                     entity.m_7618_(var38, var10002);
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        domain = LogicConfilmDomainVProcedure.execute(world, x, y, z, entity);
                        if (GetDomainExpansionProcedure.execute(entity)) {
                           entity.getPersistentData().m_128347_("cnt_x", (double)-5.0F);
                        } else {
                           entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                        }

                        ResetCounterVProcedure.execute(entity);
                        rnd = (double)0.0F;
                        if (!domain && !GetDomainExpansionProcedure.execute(entity) && !GetCanUseTechnique2Procedure.execute(entity)) {
                           float var35;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.m_21223_();
                           } else {
                              var35 = -1.0F;
                           }

                           double var36 = (double)var35;
                           float var39;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var39 = _livEnt.m_21233_();
                           } else {
                              var39 = -1.0F;
                           }

                           if (var36 <= (double)var39 * 0.8 && 10 < Mth.m_216271_(RandomSource.m_216327_(), 1, 15)) {
                              domain = true;
                           }
                        }

                        if (LogicStartVProcedure.execute(entity) && Math.random() > (double)0.5F || domain) {
                           if (domain) {
                              tick = (double)20.0F;
                              rnd = (double)20.0F;
                           } else {
                              for(int index0 = 0; index0 < 512; ++index0) {
                                 rnd = (double)(5 + Math.round((float)(Mth.m_216271_(RandomSource.m_216327_(), 0, 1) * 15)));
                                 if (rnd == (double)5.0F) {
                                    tick = (double)5.0F;
                                    entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                                    break;
                                 }

                                 if (rnd == (double)20.0F) {
                                    tick = (double)20.0F;
                                    if (!(Math.random() > 0.1) && !AiDomainLogicVProcedure.execute(world, x, y, z, entity)) {
                                       break;
                                    }
                                 }
                              }
                           }

                           entity.getPersistentData().m_128347_("skill", (double)61300.0F + rnd);
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(tick) + " 0 true");
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique infinite 0 true");
                           }

                           return;
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  }

                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("form_change") == (double)1.0F) {
               AICursedSpiritSpecialProcedure.execute(world, x, y, z, entity);
            } else {
               if (entity instanceof CursedSpiritGrade15Entity) {
                  CursedSpiritGrade15Entity _datEntSetI = (CursedSpiritGrade15Entity)entity;
                  _datEntSetI.m_20088_().m_135381_(CursedSpiritGrade15Entity.DATA_entity_form, 1);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  _entity.m_21153_((float)Math.ceil((double)var10001 * 0.6));
               }

               JujutsucraftvMod.queueServerWork(10, () -> entity.getPersistentData().m_128347_("form_change", (double)1.0F));
            }
         }

      }
   }
}
