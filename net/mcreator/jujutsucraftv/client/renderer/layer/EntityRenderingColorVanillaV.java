package net.mcreator.jujutsucraftv.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.client.renderer.EntityRenderingColorV;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class EntityRenderingColorVanillaV<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
   private static final ResourceLocation WHITE_TEXTURE = new ResourceLocation("jujutsucraftv", "textures/misc/entity_white.png");

   public EntityRenderingColorVanillaV(RenderLayerParent<T, M> parent) {
      super(parent);
   }

   public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
      MobEffectInstance effect = entity.m_21124_((MobEffect)JujutsucraftvModMobEffects.ENTITY_RENDERING_COLOR.get());
      if (effect != null) {
         float[] color = EntityRenderingColorV.getColor(effect.m_19564_());
         RenderType colorRenderType = RenderType.m_110473_(WHITE_TEXTURE);
         VertexConsumer colorBuffer = bufferSource.m_6299_(colorRenderType);
         poseStack.m_85836_();
         poseStack.m_85841_(1.002F, 1.002F, 1.002F);
         this.m_117386_().m_7695_(poseStack, colorBuffer, packedLight, OverlayTexture.f_118083_, color[0], color[1], color[2], 1.0F);
         poseStack.m_85849_();
      }
   }
}
