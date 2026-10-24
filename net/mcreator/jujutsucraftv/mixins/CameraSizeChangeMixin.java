package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.util.SizeChangeCameraAccess;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.client.Camera;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Camera.class})
public abstract class CameraSizeChangeMixin implements SizeChangeCameraAccess {
   @Shadow(
      remap = false,
      aliases = {"f_90562_"}
   )
   private float eyeHeight;
   @Shadow(
      remap = false,
      aliases = {"f_90563_"}
   )
   private float eyeHeightOld;
   @Unique
   private float jjcv$lastSizeChangeScale = 1.0F;

   @Shadow(
      remap = false,
      aliases = {"m_90568_"}
   )
   protected abstract void move(double var1, double var3, double var5);

   @Inject(
      method = {"setup(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V", "m_90575_(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V"},
      at = {@At("HEAD")},
      remap = false,
      require = 0
   )
   private void jjcv$updateSizeChangeCameraEyeHeight(BlockGetter level, Entity entity, boolean detached, boolean mirrored, float partialTick, CallbackInfo ci) {
      if (entity instanceof Player player) {
         float scale = SizeChangeUtil.getScale(player);
         boolean currentlyScaled = Math.abs(scale - 1.0F) >= 1.0E-4F;
         boolean wasScaled = Math.abs(this.jjcv$lastSizeChangeScale - 1.0F) >= 1.0E-4F;
         if (currentlyScaled || wasScaled) {
            float newEyeHeight = player.m_20192_();
            this.eyeHeight = newEyeHeight;
            this.eyeHeightOld = newEyeHeight;
         }

         this.jjcv$lastSizeChangeScale = scale;
      }
   }

   @Inject(
      method = {"setup(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V", "m_90575_(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/world/entity/Entity;ZZF)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$moveThirdPersonCamera(BlockGetter level, Entity entity, boolean detached, boolean mirrored, float partialTick, CallbackInfo ci) {
      if (detached) {
         if (entity instanceof Player) {
            Player player = (Player)entity;
            float scale = SizeChangeUtil.getScale(player);
            if (!(scale <= 1.0F)) {
               double upOffset = Math.min((double)(scale - 1.0F) * 0.35, (double)3.0F);
               double backOffset = Math.min((double)(scale - 1.0F) * 0.45, (double)4.0F);
               this.move(-backOffset, upOffset, (double)0.0F);
            }
         }
      }
   }

   public void jjcv$resetSizeChangeEyeHeight(Player player) {
      float newEyeHeight = player.m_20192_();
      this.eyeHeight = newEyeHeight;
      this.eyeHeightOld = newEyeHeight;
      this.jjcv$lastSizeChangeScale = SizeChangeUtil.getScale(player);
   }
}
