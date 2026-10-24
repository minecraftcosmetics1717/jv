package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.GetSelectCursedTechniqueProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class MiracleSavingsUnstableHandler {
   private static final String UNSTABLE_PENDING_KEY = "jjcv_miracle_unstable_pending";
   private static final String CHARGE_EXP_TAG = "miracle_charge_exp";

   @SubscribeEvent
   public static void onEffectAdded(MobEffectEvent.Added event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         MobEffectInstance addedEffect = event.getEffectInstance();
         if (addedEffect != null) {
            if (addedEffect.m_19544_() == JujutsucraftModMobEffects.UNSTABLE.get()) {
               if (isMiracleTechnique(entity)) {
                  entity.getPersistentData().m_128379_("jjcv_miracle_unstable_pending", true);
               }
            }
         }
      }
   }

   @SubscribeEvent
   public static void onLivingTick(LivingEvent.LivingTickEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (entity.getPersistentData().m_128471_("jjcv_miracle_unstable_pending")) {
            entity.getPersistentData().m_128473_("jjcv_miracle_unstable_pending");
            if (isMiracleTechnique(entity)) {
               executeUnstableMiracleRemove(entity);
            }
         }
      }
   }

   private static boolean isMiracleTechnique(LivingEntity entity) {
      return GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)634.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)634.0F;
   }

   private static void executeUnstableMiracleRemove(LivingEntity entity) {
      if (entity instanceof Player player) {
         if (!player.m_9236_().m_5776_()) {
            player.m_5661_(Component.m_237113_(Component.m_237115_("effect.jujutsucraftv.effect_miracle_savings").getString() + ": false"), false);
         }
      }

      double lifeCount = (double)0.0F;
      MobEffectInstance miracleEffect = entity.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      if (miracleEffect != null && miracleEffect.m_19564_() > 0) {
         lifeCount = (double)Math.min(99, miracleEffect.m_19564_());
      }

      entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
         capability.LifeCount = lifeCount;
         capability.syncPlayerVariables(entity);
      });
      if (entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
         entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      }

      entity.getPersistentData().m_128379_("miracle_charge_exp", false);
      playClickSound(entity);
   }

   private static void playClickSound(LivingEntity entity) {
      Level level = entity.m_9236_();
      if (!level.m_5776_()) {
         SoundEvent sound = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click"));
         if (sound != null) {
            level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), sound, SoundSource.NEUTRAL, 1.0F, 0.5F);
         }
      }
   }
}
