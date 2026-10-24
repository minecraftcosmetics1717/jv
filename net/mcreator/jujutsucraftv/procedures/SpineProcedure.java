package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
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
import net.minecraft.world.InteractionHand;
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
import net.minecraftforge.registries.ForgeRegistries;

public class SpineProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String y_pos2 = "";
         double skillnum = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         double yaw = (double)0.0F;
         double x_pos_a = (double)0.0F;
         double y_pos_a = (double)0.0F;
         double z_pos_a = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof Player) {
            if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
               if (GetFlagShiftProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (!_livEnt.m_21220_().isEmpty()) {
                        int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                        if (cooldownTicks > 0) {
                           _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)100.0F) {
                     x_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                     y_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                     z_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();

                     for(int index0 = 0; index0 < 100; ++index0) {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_()) {
                           ++y_pos_a;
                        } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                           --y_pos_a;
                        } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                           y_pos_a = Math.floor(y_pos_a);
                           break;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     x_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F);
                     z_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_SPINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)1.5F, (double)2.0F) * (double)(entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F ? 2 : 1));
                           entityinstance.m_146922_(entity.m_146908_() + 90.0F);
                           entityinstance.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)-20.0F, (double)20.0F));
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if (entityinstance instanceof Mob) {
                              Mob _mob30 = (Mob)entityinstance;
                              _mob30.m_21557_(true);
                           }

                           entityinstance.m_20331_(true);
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var10001;
                                 MobEffect var10003;
                                 int var10005;
                                 label213: {
                                    var10001 = new MobEffectInstance;
                                    var10003 = MobEffects.f_19600_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label213;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                                 _entity.m_7292_(var10001);
                              }
                           }

                           entityinstance.getPersistentData().m_128347_("shift", (double)1.0F);
                           entityinstance.getPersistentData().m_128347_("skill", skillnum);
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
                     entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               } else {
                  entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else if (entity.getPersistentData().m_128459_("shift_tec") == (double)2.0F) {
               x_pos = XLookPositionProcedure.execute(entity, (double)3.0F);
               y_pos = YLookPositionProcedure.execute(entity, (double)3.0F);
               z_pos = ZLookPositionProcedure.execute(entity, (double)3.0F);
               double var10000 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && entity.getPersistentData().m_128471_("PRESS_Z")) {
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
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                        }
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
                  x_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos_a = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();

                  for(int index1 = 0; index1 < 100; ++index1) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_()) {
                        ++y_pos_a;
                     } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                        --y_pos_a;
                     } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                        y_pos_a = Math.floor(y_pos_a);
                        break;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  x_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F);
                  z_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_SPINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)2.5F) * (double)(entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F ? 2 : 1));
                        entityinstance.m_146922_(entity.m_146908_() + 90.0F);
                        entityinstance.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)-20.0F, (double)20.0F));
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof Mob) {
                           Mob _mob90 = (Mob)entityinstance;
                           _mob90.m_21557_(true);
                        }

                        entityinstance.m_20331_(true);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var95;
                              MobEffect var97;
                              int var99;
                              label249: {
                                 var95 = new MobEffectInstance;
                                 var97 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var99 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label249;
                                    }
                                 }

                                 var99 = 0;
                              }

                              var95.<init>(var97, Integer.MAX_VALUE, var99, false, false);
                              _entity.m_7292_(var95);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("skill", skillnum);
                        entityinstance.getPersistentData().m_128347_("shift", (double)0.0F);
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else {
            x_pos = XLookPositionProcedure.execute(entity, (double)3.0F);
            y_pos = YLookPositionProcedure.execute(entity, (double)3.0F);
            z_pos = ZLookPositionProcedure.execute(entity, (double)3.0F);
            double var90 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
               LivingEntity var91;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.m_5448_();
               } else {
                  var91 = null;
               }

               if (var91 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  x_pos_a = ((Entity)var91).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  y_pos_a = ((Entity)var91).m_20186_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.m_5448_();
                  } else {
                     var91 = null;
                  }

                  z_pos_a = ((Entity)var91).m_20189_();

                  for(int index2 = 0; index2 < 100; ++index2) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_()) {
                        ++y_pos_a;
                     } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                        --y_pos_a;
                     } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                        y_pos_a = Math.floor(y_pos_a);
                        break;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  x_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
                  z_pos_a += Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_SPINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)2.5F) * (double)(entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F ? 2 : 1));
                        entityinstance.m_146922_(entity.m_146908_() + 90.0F);
                        entityinstance.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)-20.0F, (double)20.0F));
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof Mob) {
                           Mob _mob141 = (Mob)entityinstance;
                           _mob141.m_21557_(true);
                        }

                        entityinstance.m_20331_(true);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var96;
                              MobEffect var98;
                              int var100;
                              label290: {
                                 var96 = new MobEffectInstance;
                                 var98 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var100 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label290;
                                    }
                                 }

                                 var100 = 0;
                              }

                              var96.<init>(var98, Integer.MAX_VALUE, var100, false, false);
                              _entity.m_7292_(var96);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("skill", skillnum);
                        entityinstance.getPersistentData().m_128347_("shift", (double)0.0F);
                        entityinstance.getPersistentData().m_128347_("entity_use", (double)1.0F);
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
