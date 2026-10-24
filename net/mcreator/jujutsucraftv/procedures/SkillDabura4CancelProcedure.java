package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillDabura4CancelProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         skill = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.5F) {
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

                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
                     entity.getPersistentData().m_128359_("charge_box", "■■■■■");
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)1.0F) {
                        entity.getPersistentData().m_128359_("charge_box", "■■■■");
                        if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.0F) {
                           entity.getPersistentData().m_128359_("charge_box", "■■■");
                           if (entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F) {
                              entity.getPersistentData().m_128359_("charge_box", "■■");
                              if (entity.getPersistentData().m_128459_("cnt6") >= (double)4.0F) {
                                 entity.getPersistentData().m_128359_("charge_box", "■");
                                 if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                                    entity.getPersistentData().m_128359_("charge_box", "");
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        String var10001 = entity.getPersistentData().m_128461_("charge_box");
                        _player.m_5661_(Component.m_237113_(var10001 + Component.m_237115_("jjcv.long_press").getString() + entity.getPersistentData().m_128461_("charge_box")), true);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               } else {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)2.0F);
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
               }

               entity.getPersistentData().m_128347_("cnt1", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F) {
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (skill == (double)63010.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge2")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 5, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get());
                  }

                  entity.getPersistentData().m_128379_("skill_sublight_speed", false);
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjcv entity_data set_player_select_cursed_technique @s -1");
                  }
               }

               if (skill == (double)4314.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_FEROCIOUS_UNIT.get());
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 5, (double)1.0F, (double)entity.m_20206_(), (double)1.0F, 0.1);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjcv entity_data set_player_select_cursed_technique @s -1");
                  }
               }

               entity.getPersistentData().m_128379_("noChangeTechnique", true);
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128359_("charge_box", "");
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               entity.getPersistentData().m_128359_("charge_box", "");
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
