package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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
public class CustomDamageReductionEventHandler {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      new CustomDamageReductionEventHandler();
   }

   @EventBusSubscriber(
      modid = "jujutsucraftv"
   )
   private static class CustomDamageReductionEventHandlerForgeBusEvents {
      @SubscribeEvent
      public static void onLivingDamage(LivingDamageEvent event) {
         if (event.getEntity() instanceof LivingEntity) {
            execute(event, event.getEntity());
         }

      }

      public static void execute(LivingDamageEvent event, LivingEntity entity) {
         MobEffect damageReductionEffect = (MobEffect)JujutsucraftvModMobEffects.DAMAGE_REDUCTION.get();
         if (entity.m_21023_(damageReductionEffect)) {
            MobEffectInstance effectInstance = entity.m_21124_(damageReductionEffect);
            int level = effectInstance.m_19564_() + 1;
            float reductionFactor = (float)level * 0.01F;
            if (reductionFactor > 1.0F) {
               reductionFactor = 1.0F;
            }

            float originalDamage = event.getAmount();
            float newDamage = originalDamage * (1.0F - reductionFactor);
            event.setAmount(newDamage);
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
