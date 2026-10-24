package net.mcreator.jujutsucraftv.events;

import net.mcreator.jujutsucraftv.potion.SizeChangeMobEffect;
import net.mcreator.jujutsucraftv.util.SizeChangeReady;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
   modid = "jujutsucraftv"
)
public class SizeChangeMobEffectEvent {
   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void onAdded(MobEffectEvent.Added event) {
      LivingEntity var2 = event.getEntity();
      if (var2 instanceof Player player) {
         if (!player.m_9236_().m_5776_()) {
            MobEffectInstance added = event.getEffectInstance();
            if (SizeChangeUtil.isSizeChangeEffect(added)) {
               MobEffectInstance old = event.getOldEffectInstance();
               float scale = SizeChangeUtil.getResultingScale(old, added);
               if (player instanceof SizeChangeReady) {
                  SizeChangeReady ready = (SizeChangeReady)player;
                  ready.jjcv$refreshSizeChange(scale);
               }

            }
         }
      }
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void onRemove(MobEffectEvent.Remove event) {
      LivingEntity var2 = event.getEntity();
      if (var2 instanceof Player player) {
         if (!player.m_9236_().m_5776_()) {
            if (event.getEffect() instanceof SizeChangeMobEffect) {
               if (player instanceof SizeChangeReady) {
                  SizeChangeReady ready = (SizeChangeReady)player;
                  ready.jjcv$refreshSizeChange(1.0F);
               }

            }
         }
      }
   }

   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void onExpired(MobEffectEvent.Expired event) {
      LivingEntity var2 = event.getEntity();
      if (var2 instanceof Player player) {
         if (!player.m_9236_().m_5776_()) {
            if (SizeChangeUtil.isSizeChangeEffect(event.getEffectInstance())) {
               if (player instanceof SizeChangeReady) {
                  SizeChangeReady ready = (SizeChangeReady)player;
                  ready.jjcv$refreshSizeChange(1.0F);
               }

            }
         }
      }
   }
}
