package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileSlashEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

public class LeepSlashProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skillnum = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = XLookPositionProcedure.execute(entity, (double)1.0F);
         y_pos = YLookPositionProcedure.execute(entity, (double)1.0F);
         z_pos = ZLookPositionProcedure.execute(entity, (double)1.0F);
         double var10000 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
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
                  if (skillnum == (double)60216.0F) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }
                  }

                  if (skillnum == (double)69905.0F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }
               } else {
                  if (skillnum == (double)60216.0F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }

                  if (skillnum == (double)69905.0F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }
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
                     if (skillnum == (double)60216.0F) {
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
                           _level.m_8767_(ParticleTypes.f_123746_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                        }
                     }

                     if (skillnum == (double)69905.0F) {
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

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("count_cnt6", (double)1.0F);
                  } else {
                     entity.getPersistentData().m_128347_("count_cnt6", (double)4.0F);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            for(int index0 = 0; index0 < (int)entity.getPersistentData().m_128459_("count_cnt6"); ++index0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               LivingEntity var54;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var54 = _mobEnt.m_5448_();
               } else {
                  var54 = null;
               }

               if (var54 instanceof LivingEntity) {
                  RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
               }

               int var10001;
               label152: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label152;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(40 + var10001 * 8);
               if (skillnum == (double)69905.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var55 = _level.m_7654_().m_129892_();
                     CommandSourceStack var56 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     long var10002 = Math.round(HP);
                     var55.m_230957_(var56, "summon jujutsucraftv:plojectile_slash ~ ~ ~ {Health:" + var10002 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + Math.round(entity.m_146908_() % 360.0F) + "F," + Math.round(entity.m_146909_()) + "F]}");
                  }

                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof PlojectileSlashEntity && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == (double)0.0F && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals("")) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityiterator.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                        entityiterator.getPersistentData().m_128347_("skill", skillnum);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffect var10003;
                              int var10005;
                              label165: {
                                 var57 = new MobEffectInstance;
                                 var10003 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label165;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var57.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                              _entity.m_7292_(var57);
                           }
                        }

                        entityiterator.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.5F);
                        entityiterator.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.5F);
                        entityiterator.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.5F);
                        entityiterator.getPersistentData().m_128347_("count_cnt6", entity.getPersistentData().m_128459_("count_cnt6"));
                        break;
                     }
                  }

                  if (skillnum == (double)60216.0F && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.8F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.8F, 1.0F, false);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
