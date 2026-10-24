package net.mcreator.jujutsucraftv.block.renderer;

import net.mcreator.jujutsucraftv.block.entity.VendingMachineTileEntity;
import net.mcreator.jujutsucraftv.block.model.VendingMachineBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class VendingMachineTileRenderer extends GeoBlockRenderer<VendingMachineTileEntity> {
   public VendingMachineTileRenderer() {
      super(new VendingMachineBlockModel());
   }

   public RenderType getRenderType(VendingMachineTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110446_(texture);
   }

   public int m_142163_() {
      return 48;
   }
}
