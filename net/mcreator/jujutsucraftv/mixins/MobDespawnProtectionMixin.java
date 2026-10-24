package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Mob.class})
public abstract class MobDespawnProtectionMixin {
   @Inject(
      method = {"checkDespawn"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jjcv$cancelNaturalDespawnWhenProtected(CallbackInfo ci) {
      Mob mob = (Mob)this;
      if (mob.m_21023_((MobEffect)JujutsucraftvModMobEffects.DESPAWN_PROTECTION.get())) {
         ci.cancel();
      }

   }
}
