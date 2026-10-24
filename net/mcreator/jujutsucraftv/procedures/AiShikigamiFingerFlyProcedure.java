package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.ShikigamiFingerFlyEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AiShikigamiFingerFlyProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double count = (double)0.0F;
         double range = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (!((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt_1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 100, 1, false, false));
               }
            }

            if ((new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
               entity.m_7618_(Anchor.EYES, new Vec3(entity.m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)5.0F), entity.m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F)));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt_1") < (double)10.0F) {
            if (entity instanceof ShikigamiFingerFlyEntity) {
               ((ShikigamiFingerFlyEntity)entity).setAnimation("walk");
            }

            entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)2.0F, entity.m_20154_().f_82480_ * (double)2.0F, entity.m_20154_().f_82481_ * (double)2.0F));
         }

         if (entity.getPersistentData().m_128459_("cnt_1") >= (double)10.0F) {
            if ((new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
               if ((new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof Player) {
                  entity.m_7618_(Anchor.EYES, new Vec3((double)(new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_9236_().m_45547_(new ClipContext((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F), (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F).m_82549_((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)-10.0F, (double)10.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")))).m_82425_().m_123341_(), (double)(new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_9236_().m_45547_(new ClipContext((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F), (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F).m_82549_((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)3.0F, (double)12.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")))).m_82425_().m_123342_(), (double)(new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_9236_().m_45547_(new ClipContext((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F), (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20299_(1.0F).m_82549_((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)-10.0F, (double)10.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")))).m_82425_().m_123343_()));
                  if (entity.getPersistentData().m_128459_("cnt_1") >= (double)60.0F) {
                     if (entity instanceof ShikigamiFingerFlyEntity) {
                        ((ShikigamiFingerFlyEntity)entity).setAnimation("attack");
                     }

                     entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)3.0F, entity.m_20154_().f_82480_ * (double)3.0F, entity.m_20154_().f_82481_ * (double)3.0F));
                  } else {
                     if (entity instanceof ShikigamiFingerFlyEntity) {
                        ((ShikigamiFingerFlyEntity)entity).setAnimation("sprint");
                     }

                     entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)1.0F, entity.m_20154_().f_82480_ * (double)1.0F, entity.m_20154_().f_82481_ * (double)1.0F));
                  }
               } else {
                  Entity var13 = (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  LivingEntity var10000;
                  if (var13 instanceof Mob) {
                     Mob _mobEnt = (Mob)var13;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
                     Vec3 var10002 = new Vec3;
                     Entity var14 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     LivingEntity var10004;
                     if (var14 instanceof Mob) {
                        Mob _mobEnt = (Mob)var14;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     double var27 = ((Entity)var10004).m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-10.0F, (double)10.0F);
                     var14 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     LivingEntity var10005;
                     if (var14 instanceof Mob) {
                        Mob _mobEnt = (Mob)var14;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     double var28 = ((Entity)var10005).m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-10.0F, (double)10.0F);
                     var14 = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     LivingEntity var10006;
                     if (var14 instanceof Mob) {
                        Mob _mobEnt = (Mob)var14;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var27, var28, ((Entity)var10006).m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-10.0F, (double)10.0F));
                     entity.m_7618_(var10001, var10002);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_1") >= (double)60.0F) {
                     if (entity instanceof ShikigamiFingerFlyEntity) {
                        ((ShikigamiFingerFlyEntity)entity).setAnimation("attack");
                     }

                     entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)3.0F, entity.m_20154_().f_82480_ * (double)3.0F, entity.m_20154_().f_82481_ * (double)3.0F));
                  } else {
                     if (entity instanceof ShikigamiFingerFlyEntity) {
                        ((ShikigamiFingerFlyEntity)entity).setAnimation("sprint");
                     }

                     entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)1.0F, entity.m_20154_().f_82480_ * (double)1.0F, entity.m_20154_().f_82481_ * (double)1.0F));
                  }
               }
            }

            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)1.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (!LogicAttackProcedure.execute(world, entity, entityiterator) && !LogicBetrayalProcedure.execute(world, entity, entityiterator)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt99 = (LivingEntity)entity;
                     if (_livEnt99.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get()) && !GetEntityStoppedProcedure.execute(entity)) {
                        continue;
                     }
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128379_("hitted", true);
               } else {
                  if (entity instanceof ShikigamiFingerFlyEntity) {
                     ((ShikigamiFingerFlyEntity)entity).setAnimation("attack");
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("Range", (double)3.0F);
                  RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                  entity.getPersistentData().m_128379_("hitted", true);
               }
            }

            if (entity.getPersistentData().m_128471_("hitted")) {
               if (entity instanceof ShikigamiFingerFlyEntity) {
                  ((ShikigamiFingerFlyEntity)entity).setAnimation("on_ground");
               }

               JujutsucraftvMod.queueServerWork(30, () -> {
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)300.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
