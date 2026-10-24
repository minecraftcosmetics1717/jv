package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.entity.PlojectileNostalgiaHandLargeEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileNostalgiaHandSmallEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AiPlojectileNostalgiaHandProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double count = (double)0.0F;
         double range = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (entity.getPersistentData().m_128459_("waza_nosta") == (double)4.0F) {
            entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_1") == (double)1.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)2.0F, (double)0.0F));
               if (entity.getPersistentData().m_128459_("color") == (double)1.0F) {
                  if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                     ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall1");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)2.0F) {
                  if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                     ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall2");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)3.0F) {
                  if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                     ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall3");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)4.0F) {
                  if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                     ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall4");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)5.0F) {
                  if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                     ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall5");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)6.0F && entity instanceof PlojectileNostalgiaHandSmallEntity) {
                  ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("fall6");
               }
            }

            entity.m_20256_(new Vec3((double)0.0F, (double)-1.0F, (double)0.0F));
            if (entity.getPersistentData().m_128459_("cnt_1") == (double)2.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)18.0F * entity.getPersistentData().m_128459_("cnt6"));
               entity.getPersistentData().m_128347_("Range", (double)5.0F);
               RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)60.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity.getPersistentData().m_128459_("waza_nosta") == (double)1.0F) {
            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(entity.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_1") == (double)1.0F) {
               entity.m_20242_(true);
            }

            if (entity.getPersistentData().m_128459_("cnt_1") == (double)8.0F) {
               range = SetEntitySizeProcedure.execute(entity);
               entity.getPersistentData().m_128347_("ramdom_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 3));
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 5, range, (double)0.0F, range, 0.05);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123746_, x, y, z, 1, range, (double)0.0F, range, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                  PlojectileNostalgiaHandSmallEntity var10000 = (PlojectileNostalgiaHandSmallEntity)entity;
                  CompoundTag var10001 = entity.getPersistentData();
                  var10000.setAnimation("attack" + Math.round(var10001.m_128459_("ramdom_count")));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") == (double)12.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)14.0F);
               entity.getPersistentData().m_128347_("Range", (double)6.0F);
               RangeAttackVProcedure.execute(world, Math.round(entity.getPersistentData().m_128459_("ramdom_count")) == 3L ? x : (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), Math.round(entity.getPersistentData().m_128459_("ramdom_count")) == 3L ? y + (double)entity.m_20206_() * (double)0.5F : (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), Math.round(entity.getPersistentData().m_128459_("ramdom_count")) == 3L ? z : (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)2.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)24.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity.getPersistentData().m_128459_("waza_nosta") == (double)3.0F) {
            entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
            count = entity.getPersistentData().m_128459_("cnt_1");
            entity.m_146922_(entity.m_146908_());
            entity.m_146926_(entity.m_146909_());
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (entity.getPersistentData().m_128459_("cnt_1") == (double)1.0F) {
               entity.m_146922_((float)((double)entity.m_146908_() + Math.toRadians((double)Mth.m_216271_(RandomSource.m_216327_(), -900, 900))));
               entity.m_146926_((float)((double)entity.m_146909_() + Math.toRadians((double)Mth.m_216271_(RandomSource.m_216327_(), -900, 900))));
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 90.0F)));
               entity.getPersistentData().m_128347_("start_p", Math.toRadians((double)entity.m_146909_()));
               entity.m_20242_(true);
               if (entity instanceof PlojectileNostalgiaHandSmallEntity) {
                  ((PlojectileNostalgiaHandSmallEntity)entity).setAnimation("attack4");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)2.0F) {
               entity.m_146922_(entity.m_146908_());
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.m_20256_(new Vec3(2.4 * Math.cos(entity.getPersistentData().m_128459_("start_r")), -2.4 * Math.sin(entity.getPersistentData().m_128459_("start_p")), 2.4 * Math.sin(entity.getPersistentData().m_128459_("start_r"))));
               entity.getPersistentData().m_128347_("Damage", (double)12.0F);
               entity.getPersistentData().m_128347_("Range", (double)4.0F);
               RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)8.0F) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entity instanceof LivingEntity && (new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) != entityiterator && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_1") == (double)8.0F) {
                  entity.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("x_pos_after"), entity.getPersistentData().m_128459_("y_pos_after"), entity.getPersistentData().m_128459_("z_pos_after")));
                  entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 90.0F)));
                  entity.getPersistentData().m_128347_("start_p", Math.toRadians((double)entity.m_146909_()));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)26.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity.getPersistentData().m_128459_("waza_nosta") == (double)5.0F) {
            entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
            entity.f_19789_ = 0.0F;
            if (entity.getPersistentData().m_128459_("cnt_1") == (double)1.0F) {
               if (entity.getPersistentData().m_128459_("color") == (double)1.0F) {
                  if (entity instanceof PlojectileNostalgiaHandLargeEntity) {
                     ((PlojectileNostalgiaHandLargeEntity)entity).setAnimation("ground_right");
                  }
               } else if (entity instanceof PlojectileNostalgiaHandLargeEntity) {
                  ((PlojectileNostalgiaHandLargeEntity)entity).setAnimation("ground_left");
               }

               entity.m_6021_(x, y - (double)8.0F, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, y - (double)8.0F, z, entity.m_146908_(), entity.m_146909_());
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") < (double)20.0F) {
               entity.m_6021_(x, y + (double)1.0F, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, y + (double)1.0F, z, entity.m_146908_(), entity.m_146909_());
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)20.0F) {
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
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
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
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
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
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20252_(1.0F).m_82490_((double)64.0F + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F))), Block.VISUAL, Fluid.NONE, (new BiFunction<LevelAccessor, String, Entity>() {
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
                     entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)1.5F, entity.m_20154_().f_82480_ * (double)1.5F, entity.m_20154_().f_82481_ * (double)1.5F));
                  } else {
                     Entity _mobEnt = (new BiFunction<LevelAccessor, String, Entity>() {
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
                     LivingEntity var36;
                     if (_mobEnt instanceof Mob) {
                        Mob _mobEnt = (Mob)_mobEnt;
                        var36 = _mobEnt.m_5448_();
                     } else {
                        var36 = null;
                     }

                     if (var36 instanceof LivingEntity) {
                        EntityAnchorArgument.Anchor var37 = Anchor.EYES;
                        Vec3 var10002 = new Vec3;
                        Entity var33 = (new BiFunction<LevelAccessor, String, Entity>() {
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
                        if (var33 instanceof Mob) {
                           Mob _mobEnt = (Mob)var33;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        double var38 = ((Entity)var10004).m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F);
                        var33 = (new BiFunction<LevelAccessor, String, Entity>() {
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
                        if (var33 instanceof Mob) {
                           Mob _mobEnt = (Mob)var33;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        double var39 = ((Entity)var10005).m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F);
                        var33 = (new BiFunction<LevelAccessor, String, Entity>() {
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
                        if (var33 instanceof Mob) {
                           Mob _mobEnt = (Mob)var33;
                           var10006 = _mobEnt.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        var10002.<init>(var38, var39, ((Entity)var10006).m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F));
                        entity.m_7618_(var37, var10002);
                        entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * (double)1.5F, entity.m_20154_().f_82480_ * (double)1.5F, entity.m_20154_().f_82481_ * (double)1.5F));
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("color") == (double)1.0F) {
                  if (entity instanceof PlojectileNostalgiaHandLargeEntity) {
                     ((PlojectileNostalgiaHandLargeEntity)entity).setAnimation("right");
                  }
               } else if (entity instanceof PlojectileNostalgiaHandLargeEntity) {
                  ((PlojectileNostalgiaHandLargeEntity)entity).setAnimation("left");
               }

               entity.getPersistentData().m_128347_("Damage", (double)12.0F);
               entity.getPersistentData().m_128347_("Range", (double)8.0F);
               entity.getPersistentData().m_128347_("knockback", 0.3);
               RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
               if (entity.getPersistentData().m_128459_("cnt_1") >= (double)160.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
