package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemRenderer.class})
public abstract class ItemRendererOffhandFlipMixin {
   @Unique
   private int jjcv$offhandFlipDepth;

   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void jjcv$beginOffhandFlip(ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, BakedModel model, CallbackInfo ci) {
      if (jjcv$isLeftHand(displayContext, leftHand) && !stack.m_41619_()) {
         if (this.jjcv$offhandFlipDepth++ == 0) {
            if (bufferSource instanceof MultiBufferSource.BufferSource) {
               MultiBufferSource.BufferSource buffer = (MultiBufferSource.BufferSource)bufferSource;
               buffer.m_109911_();
            }

            RenderSystem.enableCull();
            GL11.glFrontFace(2304);
         }

      }
   }

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V",
   ordinal = 0,
   shift = Shift.BEFORE
)}
   )
   private void jjcv$applyOffhandFlip(ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, BakedModel model, CallbackInfo ci) {
      if (jjcv$isLeftHand(displayContext, leftHand) && !stack.m_41619_()) {
         poseStack.m_85841_(-1.0F, 1.0F, 1.0F);
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("RETURN")}
   )
   private void jjcv$endOffhandFlip(ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, BakedModel model, CallbackInfo ci) {
      if (jjcv$isLeftHand(displayContext, leftHand) && !stack.m_41619_()) {
         --this.jjcv$offhandFlipDepth;
         if (this.jjcv$offhandFlipDepth <= 0) {
            this.jjcv$offhandFlipDepth = 0;
            if (bufferSource instanceof MultiBufferSource.BufferSource) {
               MultiBufferSource.BufferSource buffer = (MultiBufferSource.BufferSource)bufferSource;
               buffer.m_109911_();
            }

            GL11.glFrontFace(2305);
            RenderSystem.enableCull();
         }

      }
   }

   @Unique
   private static boolean jjcv$isLeftHand(ItemDisplayContext displayContext, boolean leftHand) {
      return leftHand && (displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND);
   }
}
