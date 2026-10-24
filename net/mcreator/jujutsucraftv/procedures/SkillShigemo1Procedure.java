package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillShigemo1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         boolean have_effect = false;
         boolean sneaking = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            label103: {
               if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
                  if (GetFlagShiftProcedure.execute(entity)) {
                     entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
                  } else {
                     entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
                     have_effect = true;
                     break label103;
                  }
               }

               have_effect = false;
            }
         }

         if (have_effect) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("effect.jujutsucraftv.effect_miracle_savings").getString() + ": false"), false);
               }
            }

            int var10000;
            label89: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get()).m_19564_();
                     break label89;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 0) {
               double _setval = (double)0.0F;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.LifeCount = _setval;
                  capability.syncPlayerVariables(entity);
               });
            } else {
               label82: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
                        var24 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get()).m_19564_();
                        break label82;
                     }
                  }

                  var24 = (double)0.0F;
               }

               double _setval = var24;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.LifeCount = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
            }

            entity.getPersistentData().m_128379_("miracle_charge_exp", false);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("effect.jujutsucraftv.effect_miracle_savings").getString() + ": true"), false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), Integer.MAX_VALUE, (int)((double)0.0F + ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).LifeCount), false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
                  entity.getPersistentData().m_128379_("miracle_charge_exp", false);
               } else {
                  entity.getPersistentData().m_128379_("miracle_charge_exp", true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 1.3F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 1.3F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            }
         }

      }
   }
}
