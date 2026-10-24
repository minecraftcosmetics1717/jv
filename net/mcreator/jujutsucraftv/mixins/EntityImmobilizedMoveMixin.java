package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Entity.class})
public abstract class EntityImmobilizedMoveMixin {
   @Inject(
      method = {"move"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jjcv$immobilizedMove(MoverType moverType, Vec3 movement, CallbackInfo ci) {
      Entity entity = (Entity)this;
      if (entity instanceof LivingEntity livingEntity) {
         MobEffectInstance effect = livingEntity.m_21124_((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get());
         if (effect != null) {
            if (effect.m_19564_() >= 1) {
               entity.m_20256_(Vec3.f_82478_);
               entity.f_19789_ = 0.0F;
               ci.cancel();
            }

         }
      }
   }
}
