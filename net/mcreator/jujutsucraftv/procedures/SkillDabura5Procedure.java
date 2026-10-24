package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.DaburaKarabaEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillDabura5Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw_rad = (double)0.0F;
         double range = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double x_pos3 = (double)0.0F;
         double y_pos3 = (double)0.0F;
         double z_pos3 = (double)0.0F;
         double skill = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         skill = entity.getPersistentData().m_128459_("skill");
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:attacking 10 1 true");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)5.0F);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6") >= entity.getPersistentData().m_128459_("cnt6_rnd") && !(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F)) {
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

               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-21.0F);
               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 10, 1, false, false));
                  }
               }

               for(int index0 = 0; (long)index0 < Math.round((double)1.0F + entity.getPersistentData().m_128459_("cnt6")); ++index0) {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
                  z_pos = entity.m_20189_();
                  x_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-15.0F, (double)15.0F);
                  y_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)10.0F);
                  z_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-15.0F, (double)15.0F);
                  x_pos3 = Mth.m_216263_(RandomSource.m_216327_(), (double)-50.0F, (double)50.0F);
                  y_pos3 = Mth.m_216263_(RandomSource.m_216327_(), (double)-15.0F, (double)30.0F);
                  z_pos3 = Mth.m_216263_(RandomSource.m_216327_(), (double)-50.0F, (double)50.0F);
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                        } else {
                           _level.m_7785_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                        }
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, 0.8F);
                     } else {
                        _level.m_7785_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, 0.8F, false);
                     }
                  }

                  for(int index1 = 0; index1 < 5; ++index1) {
                     DisplayParticleGeneratorProcedure.execute(world, (double)0.0F, (double)3.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)5.0F), x_pos2 + x_pos, x_pos2 + x_pos + x_pos3, y_pos2 + y_pos, y_pos2 + y_pos + y_pos3, z_pos2 + z_pos, z_pos2 + z_pos + z_pos3, "jujutsucraftv:particle_lightning_humanoid_dust 1 0.3 0.3 0.2");
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        DisplayParticleGeneratorProcedure.execute(world, (double)0.0F, (double)5.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)5.0F), x_pos2 + x_pos, x_pos2 + x_pos + x_pos3, y_pos2 + y_pos, y_pos2 + y_pos + y_pos3, z_pos2 + z_pos, z_pos2 + z_pos + z_pos3, "jujutsucraftv:particle_light_ash_red_2");
                     }
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
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)1.0F);
            PlayAnimationProcedure.execute(world, entity);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
            z_pos = entity.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.getPersistentData().m_128347_("skill", skill);
                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)3.0F);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.m_20242_(true);
                  entityinstance.m_20331_(true);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label133: {
                           var10001 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label133;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  entityinstance.getPersistentData().m_128347_("light_type", (double)4.0F);
                  entityinstance.getPersistentData().m_128347_("ACT", (double)10.0F);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)100.0F) {
            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get());
               }

               entity.getPersistentData().m_128379_("skill_sublight_speed", false);
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjcv entity_data set_player_select_cursed_technique @s -1");
               }

               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
               if (!(entity instanceof DaburaKarabaEntity) && entity instanceof DaburaKarabaEntity) {
                  DaburaKarabaEntity _datEntSetI = (DaburaKarabaEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(DaburaKarabaEntity.DATA_sub_light, 1);
               }
            }

            entity.getPersistentData().m_128347_("cnt_a", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt_x_play", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
