package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraftv.client.model.Modelbullet_bayer_knife;
import net.mcreator.jujutsucraftv.entity.KnifeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class KnifeRenderer extends EntityRenderer<KnifeEntity> {
   private static final ResourceLocation texture = new ResourceLocation("jujutsucraftv:textures/entities/bullet_bayer_knife.png");
   private final Modelbullet_bayer_knife model;

   public KnifeRenderer(EntityRendererProvider.Context context) {
      super(context);
      this.model = new Modelbullet_bayer_knife(context.m_174023_(Modelbullet_bayer_knife.LAYER_LOCATION));
   }

   public void render(KnifeEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
      VertexConsumer vb = bufferIn.m_6299_(RenderType.m_110452_(this.getTextureLocation(entityIn)));
      poseStack.m_85836_();
      poseStack.m_252781_(Axis.f_252436_.m_252977_(Mth.m_14179_(partialTicks, entityIn.f_19859_, entityIn.m_146908_()) - 90.0F));
      poseStack.m_252781_(Axis.f_252403_.m_252977_(90.0F + Mth.m_14179_(partialTicks, entityIn.f_19860_, entityIn.m_146909_())));
      this.model.m_7695_(poseStack, vb, packedLightIn, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.m_85849_();
      super.m_7392_(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
   }

   public ResourceLocation getTextureLocation(KnifeEntity entity) {
      return texture;
   }
}
