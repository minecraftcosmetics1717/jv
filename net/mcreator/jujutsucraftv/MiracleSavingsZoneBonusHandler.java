package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class MiracleSavingsZoneBonusHandler {
   private static final String CHARGE_EXP_TAG = "miracle_charge_exp";
   private static final int REQUIRED_ZONE_DURATION = 6000;
   private static final int MAX_MIRACLE_LEVEL = 99;
   private static final int MAX_MIRACLE_AMPLIFIER = 98;

   @SubscribeEvent
   public static void onEffectAdded(MobEffectEvent.Added event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         CompoundTag data = entity.getPersistentData();
         if (data.m_128471_("miracle_charge_exp")) {
            MobEffectInstance addedEffect = event.getEffectInstance();
            if (addedEffect != null) {
               if (addedEffect.m_19544_() == JujutsucraftModMobEffects.ZONE.get()) {
                  if (addedEffect.m_19557_() == 6000) {
                     addMiracleSavingsLevel(entity, 1);
                  }
               }
            }
         }
      }
   }

   private static void addMiracleSavingsLevel(LivingEntity entity, int amount) {
      MobEffectInstance effect = entity.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      if (effect != null) {
         int duration = effect.m_19557_();
         int amplifier = effect.m_19564_();
         boolean ambient = effect.m_19571_();
         boolean visible = effect.m_19572_();
         boolean showIcon = effect.m_19575_();
         if (amplifier < 98) {
            int newAmplifier = Math.min(98, amplifier + amount);
            entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
            entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), duration, newAmplifier, ambient, visible, showIcon));
         }
      }
   }
}
