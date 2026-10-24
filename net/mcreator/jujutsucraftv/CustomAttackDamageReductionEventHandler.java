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
public class CustomAttackDamageReductionEventHandler {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      new CustomAttackDamageReductionEventHandler();
   }

   @EventBusSubscriber(
      modid = "jujutsucraftv"
   )
   private static class CustomAttackDamageReductionEventHandlerForgeBusEvents {
      @SubscribeEvent
      public static void onLivingDamage(LivingDamageEvent event) {
         Entity attacker = event.getSource().m_7639_();
         if (attacker instanceof LivingEntity) {
            execute(event, (LivingEntity)attacker);
         }

      }

      public static void execute(LivingDamageEvent event, LivingEntity attacker) {
         if (attacker != null) {
            MobEffect attackReductionEffect = (MobEffect)JujutsucraftvModMobEffects.ATTACK_DAMAGE_REDUCTION.get();
            if (attacker.m_21023_(attackReductionEffect)) {
               MobEffectInstance effectInstance = attacker.m_21124_(attackReductionEffect);
               int level = effectInstance.m_19564_() + 1;
               float reductionFactor = (float)level * 0.01F;
               float originalDamage = event.getAmount();
               float newDamage = originalDamage * (1.0F - reductionFactor);
               if (newDamage < 0.0F) {
                  newDamage = 0.0F;
               }

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
