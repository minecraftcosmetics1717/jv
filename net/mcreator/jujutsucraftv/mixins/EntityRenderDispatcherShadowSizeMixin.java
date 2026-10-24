package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityRenderDispatcher.class})
public abstract class EntityRenderDispatcherShadowSizeMixin {
   @Unique
   private Entity jjcv$shadowSizeEntity;

   @Inject(
      method = {"render(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", "m_114384_(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = {@At("HEAD")},
      remap = false,
      require = 0
   )
   private void jjcv$captureShadowEntity(Entity entity, double x, double y, double z, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      this.jjcv$shadowSizeEntity = entity;
   }

   @ModifyArg(
      method = {"render(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", "m_114384_(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/entity/EntityRenderDispatcher;renderShadow(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/Entity;FFLnet/minecraft/world/level/LevelReader;F)V",
   remap = false
),
      index = 6,
      remap = false,
      require = 0
   )
   private float jjcv$scaleShadowRadius(float radius) {
      Entity entity = this.jjcv$shadowSizeEntity;
      if (entity instanceof LivingEntity livingEntity) {
         float scale = SizeChangeUtil.getScale(livingEntity);
         if (Math.abs(scale - 1.0F) < 1.0E-4F) {
            return radius;
         } else {
            float result = radius * scale;
            if (result < 0.01F) {
               result = 0.01F;
            }

            if (result > 32.0F) {
               result = 32.0F;
            }

            return result;
         }
      } else {
         return radius;
      }
   }

   @Inject(
      method = {"render(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", "m_114384_(Lnet/minecraft/world/entity/Entity;DDDFFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = {@At("RETURN")},
      remap = false,
      require = 0
   )
   private void jjcv$clearShadowEntity(Entity entity, double x, double y, double z, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, CallbackInfo ci) {
      this.jjcv$shadowSizeEntity = null;
   }
}
