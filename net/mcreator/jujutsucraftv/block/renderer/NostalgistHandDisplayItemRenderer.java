package net.mcreator.jujutsucraftv.block.renderer;

import net.mcreator.jujutsucraftv.block.display.NostalgistHandDisplayItem;
import net.mcreator.jujutsucraftv.block.model.NostalgistHandDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class NostalgistHandDisplayItemRenderer extends GeoItemRenderer<NostalgistHandDisplayItem> {
   public NostalgistHandDisplayItemRenderer() {
      super(new NostalgistHandDisplayModel());
   }

   public RenderType getRenderType(NostalgistHandDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }
}
