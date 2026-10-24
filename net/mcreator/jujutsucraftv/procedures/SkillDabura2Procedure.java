package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileLightEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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

public class SkillDabura2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
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
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var68 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var69 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var69 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var68, var69, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
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

            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt5") != (double)1.0F) {
               if (world instanceof ServerLevel) {
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
                           MobEffectInstance var63;
                           int var71;
                           MobEffect var10003;
                           label218: {
                              var63 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var71 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label218;
                                 }
                              }

                              var71 = 0;
                           }

                           var63.<init>(var10003, Integer.MAX_VALUE, var71, false, false);
                           _entity.m_7292_(var63);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("x_plus", (double)0.0F);
                     entityinstance.getPersistentData().m_128347_("y_plus", (double)0.0F);
                     entityinstance.getPersistentData().m_128347_("z_plus", (double)0.0F);
                     entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               for(int index0 = 0; index0 < 6; ++index0) {
                  x_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F);
                  y_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)3.0F);
                  z_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.m_20242_(true);
                        entityinstance.m_20331_(true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var64;
                              MobEffect var66;
                              int var72;
                              label201: {
                                 var64 = new MobEffectInstance;
                                 var66 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var72 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label201;
                                    }
                                 }

                                 var72 = 0;
                              }

                              var64.<init>(var66, Integer.MAX_VALUE, var72, false, false);
                              _entity.m_7292_(var64);
                           }
                        }

                        entityinstance.getPersistentData().m_128347_("x_plus", x_pos2);
                        entityinstance.getPersistentData().m_128347_("y_plus", y_pos2);
                        entityinstance.getPersistentData().m_128347_("z_plus", z_pos2);
                        entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt5", (double)1.0F);
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
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.3F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.3F, false);
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

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)75.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof PlojectileLightEntity && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ((LivingEntity)entityiterator).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)3.0F);
                  }

                  entityiterator.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var65;
                        MobEffect var67;
                        int var73;
                        label170: {
                           var65 = new MobEffectInstance;
                           var67 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var73 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label170;
                              }
                           }

                           var73 = 0;
                        }

                        var65.<init>(var67, Integer.MAX_VALUE, var73, false, false);
                        _entity.m_7292_(var65);
                     }
                  }

                  entityiterator.getPersistentData().m_128347_("x_pos_set", x_pos + entityiterator.getPersistentData().m_128459_("x_plus"));
                  entityiterator.getPersistentData().m_128347_("y_pos_set", y_pos + entityiterator.getPersistentData().m_128459_("y_plus"));
                  entityiterator.getPersistentData().m_128347_("z_pos_set", z_pos + entityiterator.getPersistentData().m_128459_("z_plus"));
                  entityiterator.getPersistentData().m_128347_("x_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_() + entityiterator.getPersistentData().m_128459_("x_plus"));
                  entityiterator.getPersistentData().m_128347_("y_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_() + entityiterator.getPersistentData().m_128459_("y_plus"));
                  entityiterator.getPersistentData().m_128347_("z_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_() + entityiterator.getPersistentData().m_128459_("z_plus"));
               }
            }
         }

         ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)220.0F);
         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)75.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof PlojectileLightEntity && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                  entityiterator.getPersistentData().m_128347_("x_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entityiterator.getPersistentData().m_128347_("y_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
                  entityiterator.getPersistentData().m_128347_("z_look", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
                  entityiterator.getPersistentData().m_128347_("light_type", (double)2.0F);
                  entityiterator.getPersistentData().m_128347_("Damage", (double)22.0F);
                  entityiterator.getPersistentData().m_128347_("ACT", (double)5.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
