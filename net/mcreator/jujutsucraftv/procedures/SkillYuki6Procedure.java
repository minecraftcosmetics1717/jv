package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier1Entity;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier4Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
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
import net.minecraftforge.registries.ForgeRegistries;

public class SkillYuki6Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
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
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 1) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)5.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6") != entity.getPersistentData().m_128459_("cnt6_rnd") && entity.getPersistentData().m_128459_("cnt6") != (double)5.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 99, false, false));
                  }
               }

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

               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)207.0F);
               PlayAnimationProcedure.execute(world, entity);
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
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F && world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_BARRIER_1.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)0.0F);
               if (entityinstance instanceof Mob) {
                  Mob _mob53 = (Mob)entityinstance;
                  _mob53.m_21557_(true);
               }

               entityinstance.m_20331_(true);
               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 20, 1, false, false));
                  }
               }

               if (entityinstance instanceof PlojectileBarrier1Entity) {
                  PlojectileBarrier1Entity _datEntSetI = (PlojectileBarrier1Entity)entityinstance;
                  _datEntSetI.m_20088_().m_135381_(PlojectileBarrier1Entity.DATA_tex, (int)ReturnEnergyColorVProcedure.execute(entity));
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)7.0F) {
            x_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();

            for(int index0 = 0; index0 < 100; ++index0) {
               if (world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2, z_pos2)).m_60815_()) {
                  ++y_pos2;
               } else if (!world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2 - (double)1.0F, z_pos2)).m_60815_()) {
                  --y_pos2;
               } else if (!world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2, z_pos2)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2 - (double)1.0F, z_pos2)).m_60815_()) {
                  y_pos2 = Math.floor(y_pos2);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_BARRIER_4.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos2, y_pos2, z_pos2), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)0.0F);
                  if (entityinstance instanceof Mob) {
                     Mob _mob75 = (Mob)entityinstance;
                     _mob75.m_21557_(true);
                  }

                  entityinstance.m_20331_(true);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 60, 1, false, false));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label152: {
                           var10001 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label152;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  if (entityinstance instanceof PlojectileBarrier4Entity) {
                     PlojectileBarrier4Entity _datEntSetI = (PlojectileBarrier4Entity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(PlojectileBarrier4Entity.DATA_tex, (int)ReturnEnergyColorVProcedure.execute(entity));
                  }

                  if (ReturnEnergyColorVProcedure.execute(entity) == (double)5.0F) {
                     entityinstance.getPersistentData().m_128359_("particle", "0.8 0 0.8 1");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)7.0F) {
                     entityinstance.getPersistentData().m_128359_("particle", "1 0 0 1");
                  } else {
                     entityinstance.getPersistentData().m_128359_("particle", "0 0.7 1 1");
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)30.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            DamageFoundationStoneProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
