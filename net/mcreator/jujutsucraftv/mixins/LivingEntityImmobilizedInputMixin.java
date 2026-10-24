package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntity.class})
public abstract class LivingEntityImmobilizedInputMixin {
   @ModifyVariable(
      method = {"travel"},
      at = @At("HEAD"),
      argsOnly = true
   )
   private Vec3 jjcv$immobilizedTravel(Vec3 movement) {
      LivingEntity entity = (LivingEntity)this;
      return entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get()) ? Vec3.f_82478_ : movement;
   }

   @Inject(
      method = {"jumpFromGround"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jjcv$immobilizedJump(CallbackInfo ci) {
      LivingEntity entity = (LivingEntity)this;
      if (entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get())) {
         ci.cancel();
      }

   }
}
