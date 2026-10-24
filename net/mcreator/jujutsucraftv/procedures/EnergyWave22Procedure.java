package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.entity.BulletCursePowerProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EnergyWave22Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         boolean flame = false;
         boolean set_particle = false;
         boolean forest = false;
         if (entity.getPersistentData().m_128459_("skill") != (double)60506.0F) {
            forest = entity.getPersistentData().m_128459_("skill") == (double)60405.0F;
         }

         set_particle = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            x_pos = ((Entity)var10000).m_20185_();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            double var87 = ((Entity)var10000).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            y_pos = var87 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
            LivingEntity var88;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var88 = _mobEnt.m_5448_();
            } else {
               var88 = null;
            }

            z_pos = ((Entity)var88).m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") < (double)45.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity28 = (LivingEntity)entity;
               if (_livingEntity28.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity28.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-4.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity29 = (LivingEntity)entity;
               if (_livingEntity29.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity29.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)30.0F) {
            if (forest) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.05);
               }
            } else if (set_particle) {
               SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(particleType, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.05);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)13.0F) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceVProcedure.execute(world, entity) > (double)8.0F) {
                     label334: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label326: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label326;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label334;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)13.0F));
                  if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }

                     if (entity instanceof Player) {
                        damage -= (double)2.0F;
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)((double)1.0F + CNT6), 0.05, 0.05, 0.05, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)((double)1.0F * CNT6), 0.05, 0.05, 0.05, 0.05);
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               Level var96 = ((Entity)var10000).m_9236_();
               ClipContext var98 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var104 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var106 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var106 = var106.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var110 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var98.<init>(var104, var106, var110, var10006, var10007);
               double var97 = (double)var96.m_45547_(var98).m_82425_().m_123341_();
               LivingEntity var99;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var99 = _mobEnt.m_5448_();
               } else {
                  var99 = null;
               }

               Level var100 = ((Entity)var99).m_9236_();
               ClipContext var10002 = new ClipContext;
               LivingEntity var108;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var108 = _mobEnt.m_5448_();
               } else {
                  var108 = null;
               }

               Vec3 var109 = ((Entity)var108).m_20299_(1.0F);
               LivingEntity var111;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.m_5448_();
               } else {
                  var111 = null;
               }

               Vec3 var112 = ((Entity)var111).m_20299_(1.0F);
               LivingEntity var116;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var116 = _mobEnt.m_5448_();
               } else {
                  var116 = null;
               }

               var112 = var112.m_82549_(((Entity)var116).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var117 = Block.OUTLINE;
               ClipContext.Fluid var121 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.m_5448_();
               } else {
                  var10008 = null;
               }

               var10002.<init>(var109, var112, var117, var121, var10008);
               double var101 = (double)var100.m_45547_(var10002).m_82425_().m_123342_();
               LivingEntity var102;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var102 = _mobEnt.m_5448_();
               } else {
                  var102 = null;
               }

               Level var103 = ((Entity)var102).m_9236_();
               ClipContext var105 = new ClipContext;
               LivingEntity var114;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.m_5448_();
               } else {
                  var114 = null;
               }

               Vec3 var115 = ((Entity)var114).m_20299_(1.0F);
               LivingEntity var118;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var118 = _mobEnt.m_5448_();
               } else {
                  var118 = null;
               }

               Vec3 var119 = ((Entity)var118).m_20299_(1.0F);
               LivingEntity var122;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var122 = _mobEnt.m_5448_();
               } else {
                  var122 = null;
               }

               var119 = var119.m_82549_(((Entity)var122).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var123 = Block.OUTLINE;
               ClipContext.Fluid var124 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.m_5448_();
               } else {
                  var10009 = null;
               }

               var105.<init>(var115, var119, var123, var124, var10009);
               RotateEntityProcedure.execute(var97, var101, (double)var103.m_45547_(var105).m_82425_().m_123343_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)30.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.25F, false);
                  }
               }
            }

            if (forest) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x_pos, y_pos, z_pos, 25, 0.1, 0.1, 0.1, (double)0.5F);
               }
            } else if (set_particle) {
               SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(particleType, x_pos, y_pos, z_pos, 25, 0.1, 0.1, 0.1, (double)0.5F);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, (double)0.5F);
            }

            entity.getPersistentData().m_128347_("Damage", (double)1.5F);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().m_128459_("Damage");
            Level projectileLevel = entity.m_9236_();
            if (!projectileLevel.m_5776_()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new BulletCursePowerProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CURSE_POWER_PROJECTILE.get(), level);
                     entityToSpawn.m_5602_(shooter);
                     entityToSpawn.m_36781_((double)damage);
                     entityToSpawn.m_36735_(knockback);
                     entityToSpawn.m_20225_(true);
                     entityToSpawn.m_36767_(piercing);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, (float)damage, 1, (byte)100);
               _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
               _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)(((double)2.5F + Math.random() * 0.2) * CNT6), 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)pitch);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("Damage", (double)13.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)5.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)45.0F * CNT6 + (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
