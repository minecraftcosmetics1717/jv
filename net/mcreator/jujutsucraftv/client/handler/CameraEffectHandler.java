package net.mcreator.jujutsucraftv.client.handler;

import java.util.Random;
import net.mcreator.jujutsucraftv.handler.VariableGravityHandler;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class CameraEffectHandler {
   private static final Random random = new Random();

   @SubscribeEvent
   public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
      if (Minecraft.m_91087_().f_91074_ != null) {
         LocalPlayer player = Minecraft.m_91087_().f_91074_;
         float yaw = event.getYaw();
         float pitch = event.getPitch();
         float roll = event.getRoll();
         MobEffectInstance rotationEffect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.DISPLAY_ROTATION.get());
         if (rotationEffect != null) {
            roll += (float)(rotationEffect.m_19564_() + 1) * 10.0F;
         }

         MobEffectInstance shakeEffect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.DISPLAY_SHEIKH.get());
         if (shakeEffect != null) {
            int level = shakeEffect.m_19564_() + 1;
            float shakeAmount = 0.1F * (float)level;
            yaw += (random.nextFloat() - 0.5F) * shakeAmount * 10.0F;
            pitch += (random.nextFloat() - 0.5F) * shakeAmount * 10.0F;
         }

         MobEffectInstance gravityEffect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.VARIABLE_GRAVITY.get());
         if (gravityEffect != null) {
            Direction gravityDirection = VariableGravityHandler.getGravityDirection(player);
            roll += VariableGravityHandler.getCameraRoll(gravityDirection);
            pitch += VariableGravityHandler.getCameraPitchOffset(gravityDirection);
         }

         if (pitch > 89.0F) {
            pitch = 89.0F;
         }

         if (pitch < -89.0F) {
            pitch = -89.0F;
         }

         event.setYaw(yaw);
         event.setPitch(pitch);
         event.setRoll(roll);
      }
   }
}
