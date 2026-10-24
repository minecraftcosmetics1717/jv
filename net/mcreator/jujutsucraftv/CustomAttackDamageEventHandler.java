package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class CustomAttackDamageEventHandler {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      new CustomAttackDamageEventHandler();
   }

   @EventBusSubscriber(
      modid = "jujutsucraftv"
   )
   private static class CustomAttackDamageEventHandlerForgeBusEvents {
      @SubscribeEvent
      public static void onLivingDamage(LivingDamageEvent event) {
         Entity attacker = event.getSource().m_7639_();
         if (attacker instanceof LivingEntity) {
            execute(event, (LivingEntity)attacker);
         }

      }

      public static void execute(LivingDamageEvent event, LivingEntity attacker) {
         if (attacker != null) {
            MobEffect attackIncreaseEffect = (MobEffect)JujutsucraftvModMobEffects.ATTACK_DAMAGE_INCREASE.get();
            if (attacker.m_21023_(attackIncreaseEffect)) {
               MobEffectInstance effectInstance = attacker.m_21124_(attackIncreaseEffect);
               int level = effectInstance.m_19564_() + 1;
               float increaseFactor = (float)level * 0.01F;
               float originalDamage = event.getAmount();
               float newDamage = originalDamage * (1.0F + increaseFactor);
               event.setAmount(newDamage);
            }

         }
      }

      @SubscribeEvent
      public static void serverLoad(ServerStartingEvent event) {
      }

      @OnlyIn(Dist.CLIENT)
      @SubscribeEvent
      public static void clientLoad(FMLClientSetupEvent event) {
      }
   }
}
