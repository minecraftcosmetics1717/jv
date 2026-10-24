package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraftv.handler.VariableGravityHandler;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityRenderDispatcher.class})
public abstract class EntityRenderDispatcherGravityMixin {
   @Unique
   private static final ThreadLocal<Boolean> jjcv$variableGravityPushed = ThreadLocal.withInitial(() -> false);

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/EntityRenderer;render(Lnet/minecraft/world/entity/Entity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
   shift = Shift.BEFORE
)}
   )
   private <E extends Entity> void jjcv$variableGravityRenderPre(E entity, double x, double y, double z, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      jjcv$variableGravityPushed.set(false);
      if (entity instanceof LivingEntity livingEntity) {
         if (VariableGravityHandler.hasVariableGravity(livingEntity)) {
            Direction gravityDirection = VariableGravityHandler.getGravityDirection(livingEntity);
            if (gravityDirection != Direction.DOWN) {
               poseStack.m_85836_();
               jjcv$variableGravityPushed.set(true);
               poseStack.m_85837_((double)0.0F, (double)livingEntity.m_20206_() * (double)0.5F, (double)0.0F);
               this.jjcv$applyGravityRotation(poseStack, gravityDirection);
               poseStack.m_85837_((double)0.0F, (double)(-livingEntity.m_20206_()) * (double)0.5F, (double)0.0F);
            }
         }
      }
   }

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/EntityRenderer;render(Lnet/minecraft/world/entity/Entity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
   shift = Shift.AFTER
)}
   )
   private <E extends Entity> void jjcv$variableGravityRenderPost(E entity, double x, double y, double z, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      if ((Boolean)jjcv$variableGravityPushed.get()) {
         poseStack.m_85849_();
         jjcv$variableGravityPushed.set(false);
      }

   }

   @Unique
   private void jjcv$applyGravityRotation(PoseStack poseStack, Direction gravityDirection) {
      switch (gravityDirection) {
         case UP -> poseStack.m_252781_(Axis.f_252403_.m_252977_(180.0F));
         case EAST -> poseStack.m_252781_(Axis.f_252403_.m_252977_(90.0F));
         case WEST -> poseStack.m_252781_(Axis.f_252403_.m_252977_(-90.0F));
         case SOUTH -> poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0F));
         case NORTH -> poseStack.m_252781_(Axis.f_252529_.m_252977_(90.0F));
      }

   }
}
