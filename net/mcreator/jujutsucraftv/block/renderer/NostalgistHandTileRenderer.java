package net.mcreator.jujutsucraftv.block.renderer;

import net.mcreator.jujutsucraftv.block.entity.NostalgistHandTileEntity;
import net.mcreator.jujutsucraftv.block.model.NostalgistHandBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class NostalgistHandTileRenderer extends GeoBlockRenderer<NostalgistHandTileEntity> {
   public NostalgistHandTileRenderer() {
      super(new NostalgistHandBlockModel());
   }

   public RenderType getRenderType(NostalgistHandTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }
}
