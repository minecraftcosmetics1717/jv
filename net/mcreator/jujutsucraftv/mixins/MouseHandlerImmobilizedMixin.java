package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MouseHandler.class})
public abstract class MouseHandlerImmobilizedMixin {
   @Inject(
      method = {"turnPlayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jjcv$immobilizedTurnPlayer(CallbackInfo ci) {
      Player player = Minecraft.m_91087_().f_91074_;
      if (player != null) {
         MobEffectInstance effect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get());
         if (effect != null && effect.m_19564_() >= 2) {
            ci.cancel();
         }

      }
   }
}
