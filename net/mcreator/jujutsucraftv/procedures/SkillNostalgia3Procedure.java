package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillNostalgia3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double dis = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6;
            z_pos = entity.m_20189_();
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
            label206: {
               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
               PlayAnimationProcedure.execute(world, entity);
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

                     double var60 = Math.pow(((Entity)var10000).m_20185_() - entity.m_20185_(), (double)2.0F);
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     var60 += Math.pow(((Entity)var10001).m_20186_() - entity.m_20186_(), (double)2.0F);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     dis = Math.sqrt(var60 + Math.pow(((Entity)var10001).m_20189_() - entity.m_20189_(), (double)2.0F));
                     if (dis <= (double)16.0F) {
                        CompoundTag var62 = entity.getPersistentData();
                        LivingEntity var10002;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        var62.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                        var62 = entity.getPersistentData();
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        double var68 = ((Entity)var10002).m_20186_();
                        LivingEntity var10003;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        var62.m_128347_("y_pos", var68 + (double)((Entity)var10003).m_20206_() * (double)0.75F);
                        var62 = entity.getPersistentData();
                        LivingEntity var69;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var69 = _mobEnt.m_5448_();
                        } else {
                           var69 = null;
                        }

                        var62.m_128347_("z_pos", ((Entity)var69).m_20189_());
                     } else {
                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                     }
                     break label206;
                  }
               }

               entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
               entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)30.0F) {
            x_pos2 = entity.getPersistentData().m_128459_("x_pos");
            y_pos2 = entity.getPersistentData().m_128459_("y_pos");
            z_pos2 = entity.getPersistentData().m_128459_("z_pos");

            for(int index0 = 0; index0 < 50; ++index0) {
               if (world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2, z_pos2)).m_60815_()) {
                  ++y_pos2;
               } else if (!world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2 - (double)1.0F, z_pos2)).m_60815_()) {
                  --y_pos2;
               } else if (!world.m_8055_(BlockPos.m_274561_(x_pos2, y_pos2, z_pos2)).m_60815_()) {
                  y_pos2 = Math.floor(y_pos2);
                  break;
               }
            }

            for(int index1 = 0; index1 < (entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F ? 2 : 1); ++index1) {
               x_pos2 += Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F);
               z_pos2 += Mth.m_216263_(RandomSource.m_216327_(), (double)-5.0F, (double)5.0F);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos2, y_pos2, z_pos2, 5, (double)0.0F, (double)0.0F, (double)0.0F, 0.025);
               }

               range = SetEntitySizeProcedure.execute(entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos2, y_pos2, z_pos2, (int)((double)24.0F * range), (double)0.0F, (double)0.0F, (double)0.0F, (double)0.5F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos2, y_pos2, z_pos2), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos2, y_pos2, z_pos2, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               DisplayparticleGeneratorCircleVProcedure.execute(world, (double)48.0F * range, (double)90.0F, (double)0.0F, (double)4.0F * range, 0.3, x_pos2, x_pos2, y_pos2, y_pos2, (double)0.0F, z_pos2, z_pos2, "minecraft:squid_ink");
               y_pos2 += (double)entity.m_20206_() * (double)0.75F;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_NOSTALGIA_HAND_SMALL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos2, y_pos2 + (double)1.0F, z_pos2), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_7618_(Anchor.EYES, new Vec3(x_pos2, y, z_pos2));
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("waza_nosta", (double)4.0F);
                     entityinstance.getPersistentData().m_128347_("color", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6));
                     entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                     entityinstance.getPersistentData().m_128347_("cnt6", (double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6"));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var66;
                           MobEffect var70;
                           int var10005;
                           label175: {
                              var66 = new MobEffectInstance;
                              var70 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label175;
                                 }
                              }

                              var10005 = 0;
                           }

                           var66.<init>(var70, Integer.MAX_VALUE, var10005, false, false);
                           _entity.m_7292_(var66);
                        }
                     }

                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)40.0F) {
            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            entity.getPersistentData().m_128347_("x_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("y_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("z_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
