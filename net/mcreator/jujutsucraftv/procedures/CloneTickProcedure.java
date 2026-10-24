package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CloneTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (!(owner_uuid instanceof LivingEntity)) {
               JujutsucraftvMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 20, 0.8, (double)1.0F, 0.8, 0.1);
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            } else if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20193_() != null || ((JujutsucraftvModVariables.PlayerVariables)owner_uuid.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount <= (double)0.0F || GetCanUseTechnique2Procedure.execute(owner_uuid)) {
               if (world instanceof Level) {
                  ((Level)world).m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 20, 0.8, (double)1.0F, 0.8, 0.1);
               }

               double _setval = ((JujutsucraftvModVariables.PlayerVariables)(new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount - (double)1.0F;
               (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.CloneCount = _setval;
                  capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                     public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                           try {
                              return serverLevel.m_8791_(UUID.fromString(uuid));
                           } catch (Exception var5) {
                           }
                        }

                        return null;
                     }
                  }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")));
               });
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
            }

            label125: {
               if (entity instanceof Mob) {
                  Mob _mobEnt24 = (Mob)entity;
                  if (_mobEnt24.m_5912_()) {
                     break label125;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 10, 0, false, false));
                  }
               }
            }

            boolean var10000;
            label120: {
               AiMobVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof CloneEntity) {
                  CloneEntity _datEntL26 = (CloneEntity)entity;
                  if ((Boolean)_datEntL26.m_20088_().m_135370_(CloneEntity.DATA_follow)) {
                     var10000 = true;
                     break label120;
                  }
               }

               var10000 = false;
            }

            if (!var10000) {
               label151: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt27 = (LivingEntity)entity;
                     if (_livEnt27.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                        break label151;
                     }
                  }

                  JujutsucraftvMod.queueServerWork(10, () -> {
                     if (world instanceof Level) {
                        ((Level)world).m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }

                     if (world instanceof ServerLevel _level) {
                        _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 20, 0.8, (double)1.0F, 0.8, 0.1);
                     }

                     double _setval = ((JujutsucraftvModVariables.PlayerVariables)(new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount - (double)1.0F;
                     (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                           if (levelAccessor instanceof ServerLevel serverLevel) {
                              try {
                                 return serverLevel.m_8791_(UUID.fromString(uuid));
                              } catch (Exception var5) {
                              }
                           }

                           return null;
                        }
                     }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.CloneCount = _setval;
                        capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")));
                     });
                     if (world instanceof Level) {
                        ((Level)world).m_7785_((new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20185_(), (new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20186_(), (new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }

                     Entity patt10081$temp = (new BiFunction<LevelAccessor, String, Entity>() {
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
                     if (patt10081$temp instanceof Player _player) {
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.clone_auto_release").getString()), true);
                        }
                     }

                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                  });
               }
            }

            float var28;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var28 = _livEnt.m_21223_();
            } else {
               var28 = -1.0F;
            }

            float var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21233_();
            } else {
               var10001 = -1.0F;
            }

            if (var28 < var10001) {
               Entity var12 = (new BiFunction<LevelAccessor, String, Entity>() {
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
               if (var12 instanceof LivingEntity) {
                  LivingEntity _livEnt52 = (LivingEntity)var12;
                  if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                     if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr1 = (ServerPlayer)entity;
                           if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"))).m_8193_()) {
                              label155: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 5, -2, false, false));
                                       break label155;
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity2 = (LivingEntity)entity;
                                    if (!_entity2.m_9236_().m_5776_()) {
                                       _entity2.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 5, -1, false, false));
                                    }
                                 }
                              }
                           }
                        }
                     } else if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr2 = (ServerPlayer)entity;
                        if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"))).m_8193_()) {
                           label158: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 5, 2, false, false));
                                    break label158;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity2 = (LivingEntity)entity;
                                 if (!_entity2.m_9236_().m_5776_()) {
                                    _entity2.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 5, 1, false, false));
                                 }
                              }
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123815_, entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), 1, 0.1, 0.1, 0.1, 0.1);
                     }
                  }
               }
            }
         }

      }
   }
}
