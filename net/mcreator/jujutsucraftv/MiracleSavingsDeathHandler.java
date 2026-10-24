package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class MiracleSavingsDeathHandler {
   private static final String MIRACLE_REVIVED_TICK_KEY = "jjcv_miracle_savings_revived_tick";

   @SubscribeEvent
   public static void onLivingHurt(LivingHurtEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (!event.getSource().m_276093_(DamageTypes.f_286979_)) {
            if (hasRevivedThisTick(entity)) {
               event.setCanceled(true);
               event.setAmount(0.0F);
            }

         }
      }
   }

   @SubscribeEvent
   public static void onLivingDamage(LivingDamageEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (!event.getSource().m_276093_(DamageTypes.f_286979_)) {
            if (hasRevivedThisTick(entity)) {
               event.setCanceled(true);
               event.setAmount(0.0F);
            } else if (entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
               if (!(event.getAmount() < entity.m_21223_())) {
                  if (useMiracleSavings(entity)) {
                     event.setCanceled(true);
                     event.setAmount(0.0F);
                  }

               }
            }
         }
      }
   }

   @SubscribeEvent
   public static void onLivingDeath(LivingDeathEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (!event.getSource().m_276093_(DamageTypes.f_286979_)) {
            if (hasRevivedThisTick(entity)) {
               event.setCanceled(true);
            } else if (entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
               if (useMiracleSavings(entity)) {
                  event.setCanceled(true);
               }

            }
         }
      }
   }

   private static boolean useMiracleSavings(LivingEntity entity) {
      MobEffectInstance effect = entity.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      if (effect == null) {
         return false;
      } else {
         int duration = effect.m_19557_();
         int amplifier = effect.m_19564_();
         boolean ambient = effect.m_19571_();
         boolean visible = effect.m_19572_();
         boolean showIcon = effect.m_19575_();
         if (amplifier <= 0) {
            return false;
         } else {
            markRevivedThisTick(entity);
            entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
            entity.m_21153_(Math.max(1.0F, entity.m_21233_() * 0.5F));
            entity.f_19802_ = 20;
            entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), duration, amplifier - 1, ambient, visible, showIcon));
            playMiracleSavingsSound(entity);
            return true;
         }
      }
   }

   private static void markRevivedThisTick(LivingEntity entity) {
      entity.getPersistentData().m_128356_("jjcv_miracle_savings_revived_tick", entity.m_9236_().m_46467_());
   }

   private static boolean hasRevivedThisTick(LivingEntity entity) {
      return entity.getPersistentData().m_128454_("jjcv_miracle_savings_revived_tick") == entity.m_9236_().m_46467_();
   }

   private static void playMiracleSavingsSound(LivingEntity entity) {
      if (!entity.m_9236_().m_5776_()) {
         entity.m_9236_().m_6263_((Player)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_12521_, SoundSource.MASTER, 1.0F, 1.5F);
      }
   }
}
