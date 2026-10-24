package net.mcreator.jujutsucraftv.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.block.display.VendingMachineDisplayItem;
import net.mcreator.jujutsucraftv.block.model.VendingMachineDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class VendingMachineDisplayItemRenderer extends GeoItemRenderer<VendingMachineDisplayItem> {
   private static final ThreadLocal<Integer> CURRENT_TEXTURE = ThreadLocal.withInitial(() -> 1);

   public VendingMachineDisplayItemRenderer() {
      super(new VendingMachineDisplayModel());
   }

   public static int getCurrentTexture() {
      return (Integer)CURRENT_TEXTURE.get();
   }

   public void m_108829_(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
      int texture = 1;
      if (stack.m_41782_() && stack.m_41783_().m_128441_("VendingMachineTexture")) {
         texture = stack.m_41783_().m_128451_("VendingMachineTexture");
      }

      if (texture < 1 || texture > 3) {
         texture = 1;
      }

      CURRENT_TEXTURE.set(texture);
      super.m_108829_(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
      CURRENT_TEXTURE.set(1);
   }

   public RenderType getRenderType(VendingMachineDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110446_(texture);
   }
}
