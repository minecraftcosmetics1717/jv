package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Entity.class})
public abstract class EntitySizeStepHeightMixin {
   @Unique
   private double jjcv$sizeStepOldY;
   @Unique
   private boolean jjcv$checkingSizeStep;

   @Inject(
      method = {"maxUpStep"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void jjcv$scaleStepHeight(CallbackInfoReturnable<Float> cir) {
      if (this instanceof Player player) {
         float scale = SizeChangeUtil.getScale(player);
         if (scale != 1.0F) {
            float original = cir.getReturnValueF();
            if (!(original <= 0.0F)) {
               if (scale < 1.0F) {
                  cir.setReturnValue(Math.max(0.01F, original * scale));
               } else {
                  cir.setReturnValue(Math.min(original * scale, 2.0F));
               }
            }
         }
      }
   }

   @Inject(
      method = {"move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V"},
      at = {@At("HEAD")}
   )
   private void jjcv$beforeSizeStepMove(MoverType moverType, Vec3 movement, CallbackInfo ci) {
      this.jjcv$checkingSizeStep = false;
      if (this instanceof Player player) {
         if (moverType == MoverType.SELF) {
            if (!(SizeChangeUtil.getScale(player) <= 1.0F)) {
               if (player.m_20096_()) {
                  if (!(movement.f_82480_ > (double)0.0F)) {
                     this.jjcv$sizeStepOldY = player.m_20186_();
                     this.jjcv$checkingSizeStep = true;
                  }
               }
            }
         }
      }
   }

   @Inject(
      method = {"move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V"},
      at = {@At("RETURN")}
   )
   private void jjcv$afterSizeStepMove(MoverType moverType, Vec3 movement, CallbackInfo ci) {
      if (this.jjcv$checkingSizeStep) {
         this.jjcv$checkingSizeStep = false;
         Player player = (Player)this;
         double climbed = player.m_20186_() - this.jjcv$sizeStepOldY;
         if (climbed > 0.001) {
            player.m_183634_();
         }

      }
   }
}
