package net.mcreator.jujutsucraftv.client.skyblock;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.block.TextureSkyBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TextureSkyBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
   public TextureSkyBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
   }

   public void m_6922_(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
      Block var8 = blockEntity.m_58900_().m_60734_();
      if (var8 instanceof TextureSkyBlock skyBlock) {
         TextureSkyRenderHandler.submit(skyBlock.getSkyId(), blockEntity.m_58899_());
      }

   }

   public boolean m_5932_(T blockEntity) {
      return true;
   }

   public int m_142163_() {
      return 256;
   }
}
