package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ItemInHandLayer.class})
public abstract class ItemInHandLayerOffhandFlipMixin {
   @Unique
   private static final TagKey<Item> JUJUTSUCRAFTV_OFFHAND_FLIP_TAG;

   @Unique
   private boolean jujutsucraftv$shouldFlipOffhandItem(LivingEntity entity, ItemStack stack) {
      if (!(entity instanceof Player)) {
         return false;
      } else if (stack != null && !stack.m_41619_()) {
         return entity.m_21206_() != stack ? false : stack.m_204117_(JUJUTSUCRAFTV_OFFHAND_FLIP_TAG);
      } else {
         return false;
      }
   }

   @Redirect(
      method = {"renderArmWithItem"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"
)
   )
   private void jujutsucraftv$renderFlippedOffhandItem(ItemInHandRenderer itemInHandRenderer, LivingEntity entity, ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
      if (!this.jujutsucraftv$shouldFlipOffhandItem(entity, stack)) {
         itemInHandRenderer.m_269530_(entity, stack, displayContext, leftHand, poseStack, bufferSource, packedLight);
      } else {
         poseStack.m_85836_();
         poseStack.m_85841_(-1.0F, 1.0F, 1.0F);
         RenderSystem.enableCull();
         GL11.glFrontFace(2304);
         itemInHandRenderer.m_269530_(entity, stack, displayContext, false, poseStack, bufferSource, packedLight);
         GL11.glFrontFace(2305);
         poseStack.m_85849_();
      }
   }

   static {
      JUJUTSUCRAFTV_OFFHAND_FLIP_TAG = TagKey.m_203882_(Registries.f_256913_, new ResourceLocation("forge", "offhand_flip"));
   }
}
