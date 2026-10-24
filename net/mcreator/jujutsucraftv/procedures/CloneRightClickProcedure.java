package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CloneRightClickProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof TamableAnimal) {
            TamableAnimal _tamIsTamedBy = (TamableAnimal)entity;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               if (_tamIsTamedBy.m_21830_(_livEnt)) {
                  boolean var10000;
                  label51: {
                     if (entity instanceof CloneEntity) {
                        CloneEntity _datEntL1 = (CloneEntity)entity;
                        if ((Boolean)_datEntL1.m_20088_().m_135370_(CloneEntity.DATA_follow)) {
                           var10000 = true;
                           break label51;
                        }
                     }

                     var10000 = false;
                  }

                  if (var10000) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 3000, 1, false, false));
                        }
                     }

                     if (world instanceof Level) {
                        ((Level)world).m_7785_(sourceentity.m_20185_(), sourceentity.m_20186_(), sourceentity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }

                     JujutsucraftvMod.queueServerWork(5, () -> {
                        if (entity instanceof CloneEntity _datEntSetL) {
                           _datEntSetL.m_20088_().m_135381_(CloneEntity.DATA_follow, false);
                        }

                        if (sourceentity instanceof Player _player) {
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.entity.follow_off").getString()), true);
                           }
                        }

                     });
                  } else {
                     label45: {
                        if (entity instanceof CloneEntity) {
                           CloneEntity _datEntL11 = (CloneEntity)entity;
                           if ((Boolean)_datEntL11.m_20088_().m_135370_(CloneEntity.DATA_follow)) {
                              var10000 = true;
                              break label45;
                           }
                        }

                        var10000 = false;
                     }

                     if (!var10000) {
                        if (entity instanceof CloneEntity) {
                           CloneEntity _datEntSetL = (CloneEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(CloneEntity.DATA_follow, true);
                        }

                        if (world instanceof Level) {
                           ((Level)world).m_7785_(sourceentity.m_20185_(), sourceentity.m_20186_(), sourceentity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }

                        JujutsucraftvMod.queueServerWork(5, () -> {
                           if (entity instanceof LivingEntity _entity) {
                              _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.MOTION.get());
                           }

                           if (sourceentity instanceof Player _player) {
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.entity.follow_on").getString()), true);
                              }
                           }

                        });
                     }
                  }
               }
            }
         }

      }
   }
}
