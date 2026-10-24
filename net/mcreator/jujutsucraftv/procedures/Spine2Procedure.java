package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class Spine2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos_a = (double)0.0F;
         double skillnum = (double)0.0F;
         double x_pos_a = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_a = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double count = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 14, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)3.0F);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6") != entity.getPersistentData().m_128459_("cnt6_rnd") && entity.getPersistentData().m_128459_("cnt6") != (double)5.0F) {
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
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            entity.getPersistentData().m_128347_("dis_a", (double)1.0F);

            for(int index0 = 0; index0 < (entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F ? 10 : 5); ++index0) {
               dis = entity.getPersistentData().m_128459_("dis_a");

               for(int index1 = 0; index1 < 5; ++index1) {
                  if (entity.getPersistentData().m_128459_("cnt_a") != (double)4.0F) {
                     entity.getPersistentData().m_128347_("cnt_a", entity.getPersistentData().m_128459_("cnt_a") + (double)1.0F);
                  } else {
                     yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     pitch = Math.toRadians((double)entity.m_146909_());

                     for(int index2 = 0; index2 < 12; ++index2) {
                        x_pos_a = x_pos - Math.cos(yaw) * Math.cos(pitch) * dis;
                        y_pos_a = y_pos;
                        z_pos_a = z_pos - Math.sin(yaw) * Math.cos(pitch) * dis;

                        for(int index3 = 0; index3 < 100; ++index3) {
                           if (world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_()) {
                              ++y_pos_a;
                           } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                              --y_pos_a;
                           } else if (!world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a - (double)1.0F, z_pos_a)).m_60815_()) {
                              y_pos_a = Math.floor(y_pos_a);
                              break;
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_SPINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F) + dis * (double)1.0F);
                              entityinstance.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-90.0F, (double)90.0F)));
                              entityinstance.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)-60.0F, (double)60.0F));
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
                                 Mob _mob49 = (Mob)entityinstance;
                                 _mob49.m_21557_(true);
                              }

                              entityinstance.m_20331_(true);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                              entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    MobEffectInstance var10001;
                                    MobEffect var10003;
                                    int var10005;
                                    label135: {
                                       var10001 = new MobEffectInstance;
                                       var10003 = MobEffects.f_19600_;
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label135;
                                          }
                                       }

                                       var10005 = 0;
                                    }

                                    var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                                    _entity.m_7292_(var10001);
                                 }
                              }

                              entityinstance.getPersistentData().m_128347_("skill", skillnum);
                              entityinstance.getPersistentData().m_128347_("dis", dis);
                              entityinstance.getPersistentData().m_128347_("shift", (double)3.0F);
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        yaw += Math.toRadians((double)30.0F);
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt_a", (double)0.0F);
               entity.getPersistentData().m_128347_("dis_a", entity.getPersistentData().m_128459_("dis_a") + (double)5.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
            entity.getPersistentData().m_128347_("cnt_a", (double)0.0F);
            entity.getPersistentData().m_128347_("dis_a", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
