package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({ItemRenderer.class})
public abstract class ItemGlowMixin {
   @ModifyVariable(
      method = {"render"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 6,
      require = 0
   )
   private int jujutsucraftv$makeItemFullBrightDev(int packedLight, ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int originalPackedLight, int packedOverlay, BakedModel model) {
      return this.jujutsucraftv$makeFullBrightIfTarget(stack, packedLight);
   }

   @ModifyVariable(
      method = {"m_115143_"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 6,
      remap = false,
      require = 0
   )
   private int jujutsucraftv$makeItemFullBrightProd(int packedLight, ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int originalPackedLight, int packedOverlay, BakedModel model) {
      return this.jujutsucraftv$makeFullBrightIfTarget(stack, packedLight);
   }

   @Unique
   private int jujutsucraftv$makeFullBrightIfTarget(ItemStack stack, int packedLight) {
      return stack.m_150930_((Item)JujutsucraftvModItems.SOLID_GOLD_SWORD.get()) ? 15728880 : packedLight;
   }
}
