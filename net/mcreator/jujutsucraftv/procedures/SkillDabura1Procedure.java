package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileLightEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
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

public class SkillDabura1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean forest = false;
         boolean set_particle = false;
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double y_look_plus = (double)0.0F;
         double y_look = (double)0.0F;
         double y_pos3 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double x_pos3 = (double)0.0F;
         double x_look = (double)0.0F;
         double z_look = (double)0.0F;
         double z_pos3 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         if (entity instanceof Player) {
            if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
               if (GetFlagShiftProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
               }
            }
         } else if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
            if (Math.random() >= 0.7) {
               entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("shift_tec") == (double)2.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (!(entity instanceof Player)) {
               LivingEntity var10000;
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

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var104 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var104 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                  LivingEntity var105;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var105 = _mobEnt.m_5448_();
                  } else {
                     var105 = null;
                  }

                  z_pos = ((Entity)var105).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                  }
               }

               if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 3) {
                     entity.getPersistentData().m_128347_("cnt6_rnd", (double)5.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6_rnd", (double)1.0F);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt5") != (double)1.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.m_20242_(true);
                     entityinstance.m_20331_(true);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var111;
                           MobEffect var10003;
                           int var10005;
                           label316: {
                              var111 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label316;
                                 }
                              }

                              var10005 = 0;
                           }

                           var111.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                           _entity.m_7292_(var111);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && !(entity.getPersistentData().m_128459_("cnt6") >= entity.getPersistentData().m_128459_("cnt6_rnd")) && !(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F)) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (!_livEnt.m_21220_().isEmpty()) {
                        int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                        if (cooldownTicks > 0) {
                           _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                        }
                     }
                  }
               }

               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)50.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator instanceof PlojectileLightEntity && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        ((LivingEntity)entityiterator).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
                     }

                     entityiterator.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var112;
                           MobEffect var115;
                           int var117;
                           label289: {
                              var112 = new MobEffectInstance;
                              var115 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var117 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label289;
                                 }
                              }

                              var117 = 0;
                           }

                           var112.<init>(var115, Integer.MAX_VALUE, var117, false, false);
                           _entity.m_7292_(var112);
                        }
                     }

                     entityiterator.getPersistentData().m_128347_("x_pos_set", x_pos);
                     entityiterator.getPersistentData().m_128347_("y_pos_set", y_pos);
                     entityiterator.getPersistentData().m_128347_("z_pos_set", z_pos);
                     entityiterator.getPersistentData().m_128347_("x_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
                     entityiterator.getPersistentData().m_128347_("y_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
                     entityiterator.getPersistentData().m_128347_("z_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
                  }
               }
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)220.0F);
            PlayAnimationProcedure.execute(world, entity);
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)50.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator instanceof PlojectileLightEntity && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                     entityiterator.getPersistentData().m_128347_("x_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
                     entityiterator.getPersistentData().m_128347_("y_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
                     entityiterator.getPersistentData().m_128347_("z_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
                     entityiterator.getPersistentData().m_128347_("light_type", (double)1.0F);
                     entityiterator.getPersistentData().m_128347_("Damage", (double)17.0F);
                     entityiterator.getPersistentData().m_128347_("ACT", (double)10.0F);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               if (!(entity instanceof Player)) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (!(entity instanceof Player)) {
               LivingEntity var106;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var106 = _mobEnt.m_5448_();
               } else {
                  var106 = null;
               }

               if (var106 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var106 = _mobEnt.m_5448_();
                  } else {
                     var106 = null;
                  }

                  x_pos3 = ((Entity)var106).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var106 = _mobEnt.m_5448_();
                  } else {
                     var106 = null;
                  }

                  double var109 = ((Entity)var106).m_20186_();
                  LivingEntity var113;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var113 = _mobEnt.m_5448_();
                  } else {
                     var113 = null;
                  }

                  y_pos3 = var109 + (double)((Entity)var113).m_20206_() * (double)0.5F;
                  LivingEntity var110;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var110 = _mobEnt.m_5448_();
                  } else {
                     var110 = null;
                  }

                  z_pos3 = ((Entity)var110).m_20189_();
                  RotateEntityProcedure.execute(x_pos3, y_pos3, z_pos3, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)30.0F);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && !(entity.getPersistentData().m_128459_("cnt6_rnd") >= entity.getPersistentData().m_128459_("cnt1"))) {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (!_livEnt.m_21220_().isEmpty()) {
                     int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                     if (cooldownTicks > 0) {
                        _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)30.0F && entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-7.0F);
                  PlayAnimationProcedure.execute(world, entity);
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  pitch = Math.toRadians((double)entity.m_146909_());
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6;
                  z_pos = entity.m_20189_();
                  x_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                  x_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F);
                  y_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F);
                  z_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3, (double)1.5F));
                     } else {
                        _level.m_7785_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3, (double)1.5F), false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.m_20242_(true);
                        entityinstance.m_20331_(true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var114;
                              MobEffect var116;
                              int var118;
                              label251: {
                                 var114 = new MobEffectInstance;
                                 var116 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var118 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label251;
                                    }
                                 }

                                 var118 = 0;
                              }

                              var114.<init>(var116, Integer.MAX_VALUE, var118, false, false);
                              _entity.m_7292_(var114);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("x_plus", x_pos2);
                        entityinstance.getPersistentData().m_128347_("y_plus", y_pos2);
                        entityinstance.getPersistentData().m_128347_("z_plus", z_pos2);
                        entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                        entityinstance.getPersistentData().m_128347_("x_pos_set", x_pos + entityinstance.getPersistentData().m_128459_("x_plus"));
                        entityinstance.getPersistentData().m_128347_("y_pos_set", y_pos + entityinstance.getPersistentData().m_128459_("y_plus"));
                        entityinstance.getPersistentData().m_128347_("z_pos_set", z_pos + entityinstance.getPersistentData().m_128459_("z_plus"));
                        entityinstance.getPersistentData().m_128347_("x_look", x_look);
                        entityinstance.getPersistentData().m_128347_("y_look", y_look);
                        entityinstance.getPersistentData().m_128347_("z_look", z_look);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.getPersistentData().m_128347_("light_type", (double)3.0F);
                        entityinstance.getPersistentData().m_128347_("Damage", (double)10.0F);
                        entityinstance.getPersistentData().m_128347_("ACT", (double)10.0F);
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)40.0F) {
                  if (!(entity instanceof Player)) {
                     entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
                  }

                  entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               if (!(entity instanceof Player)) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
