package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.DaburaKarabaEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectSublightSpeedTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.m_20096_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:double_jump_effect 5 4 true");
         }

         if (entity instanceof DaburaKarabaEntity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 1 0.3 0.3 0.2 ~ ~0.4 ~ 0 0 0 0 1 force");
         }

         if (entity.m_20142_()) {
            entity.getPersistentData().m_128347_("cnt_sublight_speed", entity.getPersistentData().m_128459_("cnt_sublight_speed") + (double)1.0F);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3, (double)1.5F));
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.3, (double)1.5F), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  MobEffectInstance var10001;
                  MobEffect var10003;
                  int var10005;
                  label109: {
                     var10001 = new MobEffectInstance;
                     var10003 = MobEffects.f_19596_;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get())) {
                           var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get()).m_19564_();
                           break label109;
                        }
                     }

                     var10005 = 0;
                  }

                  var10001.<init>(var10003, 10, (var10005 + 1) * 10 - 1, false, false);
                  _entity.m_7292_(var10001);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_DECAY.get(), 10, 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.ATTACK_DAMAGE_INCREASE.get(), 10, 2, false, false));
               }
            }

            if (entity instanceof DaburaKarabaEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.DAMAGE_REDUCTION.get(), 10, 2, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.DAMAGE_REDUCTION.get(), 10, 0, false, false));
               }
            }

            if (!(entity instanceof DaburaKarabaEntity) && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 1 0.3 0.3 0.16 ~ ~0.3 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("cnt_sublight_speed") == (double)3.0F) {
               entity.getPersistentData().m_128347_("BlockRange", (double)6.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)5.0F);
               entity.getPersistentData().m_128379_("noParticle", true);
               entity.getPersistentData().m_128379_("noEffect", true);
               BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)3.0F, entity.m_20189_(), entity);
               if (!(entity instanceof DaburaKarabaEntity)) {
                  float var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21223_();
                  } else {
                     var10000 = -1.0F;
                  }

                  if (!(var10000 < 1.0F) && !((<undefinedtype>)(new Object() {
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
                        _entity.f_20916_ = 0;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var16;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var16 = _livEnt.m_21223_();
                        } else {
                           var16 = -1.0F;
                        }

                        _entity.m_21153_((float)((double)var16 - (double)0.25F));
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt_sublight_speed", (double)0.0F);
            }
         } else {
            entity.getPersistentData().m_128379_("effect_sublight_speed", false);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 3, 0.1, (double)1.0F, 0.1, Mth.m_216263_(RandomSource.m_216327_(), 0.1, 0.2));
         }

      }
   }
}
