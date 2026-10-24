package net.mcreator.jujutsucraftv.events;

import net.mcreator.jujutsucraftv.potion.SizeChangeMobEffect;
import net.mcreator.jujutsucraftv.util.SizeChangeCameraAccess;
import net.mcreator.jujutsucraftv.util.SizeChangeReady;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   value = {Dist.CLIENT}
)
public class SizeChangeClientEvent {
   @SubscribeEvent(
      priority = EventPriority.LOWEST
   )
   public static void onAdded(MobEffectEvent.Added event) {
      LivingEntity var2 = event.getEntity();
      if (var2 instanceof Player player) {
         if (player.m_9236_().m_5776_()) {
            MobEffectInstance added = event.getEffectInstance();
            if (SizeChangeUtil.isSizeChangeEffect(added)) {
               MobEffectInstance old = event.getOldEffectInstance();
               float scale = SizeChangeUtil.getResultingScale(old, added);
               refresh(player, scale);
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
         if (player.m_9236_().m_5776_()) {
            if (event.getEffect() instanceof SizeChangeMobEffect) {
               refresh(player, 1.0F);
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
         if (player.m_9236_().m_5776_()) {
            if (SizeChangeUtil.isSizeChangeEffect(event.getEffectInstance())) {
               refresh(player, 1.0F);
            }
         }
      }
   }

   private static void refresh(Player player, float scale) {
      if (player instanceof SizeChangeReady ready) {
         ready.jjcv$refreshSizeChange(scale);
      }

      Minecraft minecraft = Minecraft.m_91087_();
      if (minecraft.f_91074_ == player) {
         Camera var4 = minecraft.f_91063_.m_109153_();
         if (var4 instanceof SizeChangeCameraAccess) {
            SizeChangeCameraAccess camera = (SizeChangeCameraAccess)var4;
            camera.jjcv$resetSizeChangeEyeHeight(player);
         }

      }
   }
}
