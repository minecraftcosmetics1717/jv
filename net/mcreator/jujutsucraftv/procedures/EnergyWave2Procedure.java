package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.entity.BulletCursePowerProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceProcedure;
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

public class EnergyWave2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean forest = false;
         boolean set_particle = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double damage = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
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

            double var103 = ((Entity)var10000).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            y_pos = var103 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
            LivingEntity var104;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var104 = _mobEnt.m_5448_();
            } else {
               var104 = null;
            }

            z_pos = ((Entity)var104).m_20189_();
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
         if (entity.getPersistentData().m_128459_("cnt1") < (double)45.0F * CNT6 + (double)5.0F) {
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

         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
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
                  if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
                     label335: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                           label328: {
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
                                    break label328;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                                 break label335;
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
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
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

               Level var112 = ((Entity)var10000).m_9236_();
               ClipContext var114 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var120 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var122 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var122 = var122.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var126 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var114.<init>(var120, var122, var126, var10006, var10007);
               double var113 = (double)var112.m_45547_(var114).m_82425_().m_123341_();
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.m_5448_();
               } else {
                  var115 = null;
               }

               Level var116 = ((Entity)var115).m_9236_();
               ClipContext var10002 = new ClipContext;
               LivingEntity var124;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.m_5448_();
               } else {
                  var124 = null;
               }

               Vec3 var125 = ((Entity)var124).m_20299_(1.0F);
               LivingEntity var127;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var127 = _mobEnt.m_5448_();
               } else {
                  var127 = null;
               }

               Vec3 var128 = ((Entity)var127).m_20299_(1.0F);
               LivingEntity var132;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var132 = _mobEnt.m_5448_();
               } else {
                  var132 = null;
               }

               var128 = var128.m_82549_(((Entity)var132).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var133 = Block.OUTLINE;
               ClipContext.Fluid var137 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.m_5448_();
               } else {
                  var10008 = null;
               }

               var10002.<init>(var125, var128, var133, var137, var10008);
               double var117 = (double)var116.m_45547_(var10002).m_82425_().m_123342_();
               LivingEntity var118;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var118 = _mobEnt.m_5448_();
               } else {
                  var118 = null;
               }

               Level var119 = ((Entity)var118).m_9236_();
               ClipContext var121 = new ClipContext;
               LivingEntity var130;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var130 = _mobEnt.m_5448_();
               } else {
                  var130 = null;
               }

               Vec3 var131 = ((Entity)var130).m_20299_(1.0F);
               LivingEntity var134;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var134 = _mobEnt.m_5448_();
               } else {
                  var134 = null;
               }

               Vec3 var135 = ((Entity)var134).m_20299_(1.0F);
               LivingEntity var138;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var138 = _mobEnt.m_5448_();
               } else {
                  var138 = null;
               }

               var135 = var135.m_82549_(((Entity)var138).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var139 = Block.OUTLINE;
               ClipContext.Fluid var140 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.m_5448_();
               } else {
                  var10009 = null;
               }

               var121.<init>(var131, var135, var139, var140, var10009);
               RotateEntityProcedure.execute(var113, var117, (double)var119.m_45547_(var121).m_82425_().m_123343_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < (double)45.0F * CNT6) {
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

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)1.5F * CNT6);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().m_128459_("Damage");
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)2.0F));
            entity.m_146926_((float)(pitch + (Math.random() - (double)0.5F) * (double)2.0F));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

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
