package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.DaburaKarabaAfterShinjukuEntity;
import net.mcreator.jujutsucraftv.entity.DaburaKarabaEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AiDaburaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double rnd2 = (double)0.0F;
         if (entity.m_6084_()) {
            label278: {
               AiActiveVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label278;
                  }
               }

               if (entity instanceof DaburaKarabaAfterShinjukuEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 29, false, false));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 24, false, false));
                  }
               }
            }

            label273: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label273;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            if (entity instanceof DaburaKarabaEntity && entity.getPersistentData().m_128471_("used_sublight") && !GetSublightSpeedProcedure.execute(entity)) {
               if (entity instanceof DaburaKarabaEntity) {
                  DaburaKarabaEntity _datEntSetI = (DaburaKarabaEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(DaburaKarabaEntity.DATA_sub_light, 1);
               }

               entity.getPersistentData().m_128379_("entity_can_use_rct", true);
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
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (GetSublightSpeedProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)5.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-5.0F);
               }

               label262: {
                  ResetCounterVProcedure.execute(entity);
                  GetDistanceVProcedure.execute(world, entity);
                  if (!(entity instanceof DaburaKarabaAfterShinjukuEntity)) {
                     int var39;
                     if (entity instanceof DaburaKarabaEntity) {
                        DaburaKarabaEntity _datEntI = (DaburaKarabaEntity)entity;
                        var39 = (Integer)_datEntI.m_20088_().m_135370_(DaburaKarabaEntity.DATA_sub_light);
                     } else {
                        var39 = 0;
                     }

                     if (var39 != 1 || GetSublightSpeedProcedure.execute(entity)) {
                        break label262;
                     }
                  }

                  domain = LogicConfilmDomainVProcedure.execute(world, x, y, z, entity);
               }

               if (!GetCanUseTechnique2Procedure.execute(entity) && !GetCoolDownProcedure.execute(entity)) {
                  if (entity instanceof DaburaKarabaAfterShinjukuEntity) {
                     if (domain && !GetDomainExpansionProcedure.execute(entity)) {
                        rnd = (double)20.0F;
                        tick = (double)20.0F;
                     } else {
                        rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 8);
                        if (rnd == (double)6.0F) {
                           tick = (double)3.0F;
                        } else {
                           label300: {
                              label309: {
                                 if (rnd == (double)7.0F) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label309;
                                    }

                                    LivingEntity _livEnt24 = (LivingEntity)entity;
                                    if (!_livEnt24.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                                       break label309;
                                    }
                                 }

                                 if (rnd == (double)8.0F) {
                                    label298: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt26 = (LivingEntity)entity;
                                          if (_livEnt26.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                                             break label298;
                                          }
                                       }

                                       tick = (double)6.0F;
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                          }
                                       }
                                       break label300;
                                    }
                                 }

                                 rnd = (double)5.0F;
                                 tick = (double)2.0F;
                                 break label300;
                              }

                              tick = (double)6.0F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                 }
                              }
                           }
                        }
                     }
                  } else if (entity instanceof DaburaKarabaEntity) {
                     int var40;
                     if (entity instanceof DaburaKarabaEntity) {
                        DaburaKarabaEntity _datEntI = (DaburaKarabaEntity)entity;
                        var40 = (Integer)_datEntI.m_20088_().m_135370_(DaburaKarabaEntity.DATA_sub_light);
                     } else {
                        var40 = 0;
                     }

                     if (var40 == 1) {
                        if (domain && !GetDomainExpansionProcedure.execute(entity)) {
                           rnd = (double)20.0F;
                           tick = (double)20.0F;
                        } else {
                           rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 8);
                           if (rnd == (double)6.0F) {
                              tick = (double)3.0F;
                           } else {
                              label304: {
                                 label310: {
                                    if (rnd == (double)7.0F) {
                                       if (!(entity instanceof LivingEntity)) {
                                          break label310;
                                       }

                                       LivingEntity _livEnt31 = (LivingEntity)entity;
                                       if (!_livEnt31.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                                          break label310;
                                       }
                                    }

                                    if (rnd == (double)8.0F) {
                                       label302: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt33 = (LivingEntity)entity;
                                             if (_livEnt33.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                                                break label302;
                                             }
                                          }

                                          tick = (double)6.0F;
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.m_9236_().m_5776_()) {
                                                _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                             }
                                          }
                                          break label304;
                                       }
                                    }

                                    rnd = (double)5.0F;
                                    tick = (double)2.0F;
                                    break label304;
                                 }

                                 tick = (double)6.0F;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                    }
                                 }
                              }
                           }
                        }
                     } else if (GetSublightSpeedProcedure.execute(entity)) {
                        label235: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get())) {
                                 var40 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get()).m_19557_();
                                 break label235;
                              }
                           }

                           var40 = 0;
                        }

                        if (var40 <= 600 && Mth.m_216271_(RandomSource.m_216327_(), 1, 10) == 5) {
                           rnd = (double)10.0F;
                           tick = (double)10.0F;
                           entity.getPersistentData().m_128379_("used_sublight", true);
                        }
                     } else {
                        float var41;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var41 = _livEnt.m_21223_();
                        } else {
                           var41 = -1.0F;
                        }

                        double var42 = (double)var41;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var42 <= (double)var10001 * (double)0.5F && !GetSublightSpeedProcedure.execute(entity)) {
                           rnd = (double)9.0F;
                           tick = (double)10.0F;
                        } else {
                           rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 7);
                           if (rnd == (double)6.0F) {
                              tick = (double)3.0F;
                           } else {
                              label311: {
                                 if (rnd == (double)7.0F) {
                                    label307: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt41 = (LivingEntity)entity;
                                          if (_livEnt41.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                                             break label307;
                                          }
                                       }

                                       tick = (double)5.0F;
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                          }
                                       }
                                       break label311;
                                    }
                                 }

                                 rnd = (double)5.0F;
                                 tick = (double)2.0F;
                              }
                           }
                        }
                     }
                  }
               }

               if (rnd > (double)0.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)63000.0F + rnd);
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
         }

      }
   }
}
