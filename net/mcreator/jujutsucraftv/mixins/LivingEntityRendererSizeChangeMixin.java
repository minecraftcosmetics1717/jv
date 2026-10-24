package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.util.SizeChangeRenderContext;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntityRenderer.class})
public abstract class LivingEntityRendererSizeChangeMixin<T extends LivingEntity, M extends EntityModel<T>> {
   @Inject(
      method = {"render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;scale(Lnet/minecraft/world/entity/LivingEntity;Lcom/mojang/blaze3d/vertex/PoseStack;F)V",
   shift = Shift.AFTER,
   remap = false
)},
      remap = false,
      require = 0
   )
   private void jjcv$scaleSizeChangedEntityDev(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      this.jjcv$applySizeScale(entity, poseStack);
   }

   @Inject(
      method = {"m_7392_(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;m_7546_(Lnet/minecraft/world/entity/LivingEntity;Lcom/mojang/blaze3d/vertex/PoseStack;F)V",
   shift = Shift.AFTER,
   remap = false
)},
      remap = false,
      require = 0
   )
   private void jjcv$scaleSizeChangedEntityProd(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      this.jjcv$applySizeScale(entity, poseStack);
   }

   @Unique
   private void jjcv$applySizeScale(T entity, PoseStack poseStack) {
      if (!SizeChangeRenderContext.isInventoryRender()) {
         float scale = SizeChangeUtil.getScale(entity);
         if (!(Math.abs(scale - 1.0F) < 1.0E-4F)) {
            poseStack.m_85841_(scale, scale, scale);
         }
      }
   }
}
