package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRipping1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F && entity.getPersistentData().m_128471_("nois") && !entity.getPersistentData().m_128471_("played_sound")) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.6, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.6, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            entity.getPersistentData().m_128379_("played_sound", true);
         }

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

               double var41 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var42 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var42 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var41, var42, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
            }
         }

         if (entity.getPersistentData().m_128471_("nois")) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:attacking 10 2 true");
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 20, false, false));
               }
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(2.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
               if (entity.getPersistentData().m_128471_("nois")) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)5.0F);
               } else if (Math.random() > 0.7) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)3.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && !(entity.getPersistentData().m_128459_("cnt6") >= entity.getPersistentData().m_128459_("cnt6_rnd")) && !(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F)) {
               if (entity.getPersistentData().m_128471_("nois")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity48 = (LivingEntity)entity;
                     if (_livingEntity48.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
                        _livingEntity48.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22100_((double)301.0F);
                     }
                  }

                  PlayAnimationVProcedure.execute(world, entity);
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

         if (!entity.getPersistentData().m_128471_("nois")) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)207.0F);
            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)9.0F && entity.getPersistentData().m_128471_("nois")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity70 = (LivingEntity)entity;
                  if (_livingEntity70.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
                     _livingEntity70.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22100_((double)302.0F);
                  }
               }

               PlayAnimationVProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SLASH_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos + (entity.getPersistentData().m_128471_("nois") ? (double)0.0F : Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)-2.0F)), y_pos + (entity.getPersistentData().m_128471_("nois") ? (double)0.0F : Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)-0.5F)), z_pos + (entity.getPersistentData().m_128471_("nois") ? (double)0.0F : Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)-2.0F))), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)0.0F);
                     if (entity.getPersistentData().m_128471_("nois")) {
                        entityinstance.getPersistentData().m_128379_("nois", true);
                        entityinstance.getPersistentData().m_128347_("size", (double)7.0F);
                     } else {
                        entityinstance.getPersistentData().m_128347_("size", (double)3.0F + 0.2 * entity.getPersistentData().m_128459_("cnt6") + Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.0F));
                     }

                     entityinstance.m_146922_((float)yaw);
                     entityinstance.m_146926_((float)pitch);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     entityinstance.getPersistentData().m_128347_("color", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 4));
                     entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                     entityinstance.getPersistentData().m_128347_("slash", (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("count", (double)1.0F);
                     entityinstance.m_7618_(Anchor.EYES, new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_()));
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.m_20331_(true);
                     if (entityinstance instanceof Mob) {
                        Mob _mob115 = (Mob)entityinstance;
                        _mob115.m_21557_(true);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var40;
                           int var44;
                           MobEffect var10003;
                           label214: {
                              var40 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var44 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label214;
                                 }
                              }

                              var44 = 0;
                           }

                           var40.<init>(var10003, Integer.MAX_VALUE, var44, false, false);
                           _entity.m_7292_(var40);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 20, 0, false, false));
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt3") >= (Math.ceil(entity.getPersistentData().m_128459_("cnt6")) * (double)1.5F >= (double)8.0F ? (double)8.0F : Math.ceil(entity.getPersistentData().m_128459_("cnt6")) * (double)1.5F) || entity.getPersistentData().m_128471_("nois") && entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (!(entity instanceof Player)) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)3.0F);
               }

               entity.getPersistentData().m_128379_("nois", false);
               entity.getPersistentData().m_128379_("played_sound", false);
               entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
