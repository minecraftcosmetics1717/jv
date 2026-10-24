package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SoloForbiddenAreaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         boolean have_effect = false;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            label147: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get())) {
                     have_effect = true;
                     break label147;
                  }
               }

               have_effect = false;
            }
         }

         if (have_effect) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("effect.jujutsucraftv.effect_solo_forbidden_area").getString() + ": false"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get());
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell1")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell1")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else {
            level = GetPlayerLevelProcedure.execute(entity);
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 100, false, false));
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123809_, entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), 20, 0.1, 0.3, 0.1, 0.3);
               }

               if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet && entity instanceof Player) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~ ~ 0.1 0.1 0.1 0.1 7");
                  }
               } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/particle jujutsucraft:particle_curse_power_blue ~ ~ ~ 0.1 0.1 0.1 0.1 7");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F || entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-17.0F);
               PlayAnimationProcedure.execute(world, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell2")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, 1.3));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell2")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, 1.3), false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
               for(int index0 = 0; index0 < 5; ++index0) {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-17.0F);
                  PlayAnimationProcedure.execute(world, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell1")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, 1.1));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:kagura_bell1")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, 1.1), false);
                     }
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("effect.jujutsucraftv.effect_solo_forbidden_area").getString() + ": true"), false);
                  }
               }

               if (level >= (double)10.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get(), 1800, 9, true, true));
                     }
                  }
               } else if (level >= (double)5.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get(), 1200, 4, true, true));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get(), 600, 0, true, true));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
