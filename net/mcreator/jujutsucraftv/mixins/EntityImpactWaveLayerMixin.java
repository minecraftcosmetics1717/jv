package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.entity.layer.EntityImpactWaveLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

@Mixin(
   value = {EntityImpactWaveLayer.class},
   remap = false
)
public abstract class EntityImpactWaveLayerMixin extends GeoRenderLayer<EntityImpactWaveEntity> {
   @Unique
   private static final ResourceLocation LAYER0 = new ResourceLocation("jujutsucraft", "textures/entities/orange.png");
   @Unique
   private static final ResourceLocation LAYER1 = new ResourceLocation("jujutsucraft", "textures/entities/flame_tiger.png");
   @Unique
   private static final ResourceLocation LAYER2 = new ResourceLocation("jujutsucraft", "textures/entities/red.png");
   @Unique
   private static final ResourceLocation LAYER6 = new ResourceLocation("jujutsucraft", "textures/entities/blue.png");
   @Unique
   private static final ResourceLocation LAYER9 = new ResourceLocation("jujutsucraft", "textures/entities/green.png");
   @Unique
   private static final ResourceLocation LAYER10 = new ResourceLocation("jujutsucraft", "textures/entities/purple.png");
   @Unique
   private static final ResourceLocation LAYER11 = new ResourceLocation("jujutsucraft", "textures/entities/yellow.png");
   @Unique
   private static final ResourceLocation LAYER12 = new ResourceLocation("jujutsucraft", "textures/entities/pink.png");
   @Unique
   private static final ResourceLocation LAYER13 = new ResourceLocation("jujutsucraft", "textures/entities/deep_blue.png");
   @Unique
   private static final ResourceLocation LAYER14 = new ResourceLocation("jujutsucraft", "textures/entities/deep_green.png");
   @Unique
   private static final ResourceLocation LAYER15 = new ResourceLocation("jujutsucraft", "textures/entities/black.png");
   @Unique
   private static final ResourceLocation LAYER16 = new ResourceLocation("jujutsucraft", "textures/entities/white.png");

   public EntityImpactWaveLayerMixin(GeoRenderer<EntityImpactWaveEntity> entityRenderer) {
      super(entityRenderer);
   }

   @Overwrite
   public void render(PoseStack poseStack, EntityImpactWaveEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType;
      if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) != 2 && (Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) != 8) {
         if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 1) {
            glowRenderType = RenderType.m_110488_(LAYER1);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 6) {
            glowRenderType = RenderType.m_110488_(LAYER6);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 9) {
            glowRenderType = RenderType.m_110488_(LAYER9);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 10) {
            glowRenderType = RenderType.m_110488_(LAYER10);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 11) {
            glowRenderType = RenderType.m_110488_(LAYER11);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 12) {
            glowRenderType = RenderType.m_110488_(LAYER12);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 13) {
            glowRenderType = RenderType.m_110488_(LAYER13);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 14) {
            glowRenderType = RenderType.m_110488_(LAYER14);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 15) {
            glowRenderType = RenderType.m_110488_(LAYER15);
         } else if ((Integer)animatable.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode) == 16) {
            glowRenderType = RenderType.m_110488_(LAYER16);
         } else {
            glowRenderType = RenderType.m_110488_(LAYER0);
         }
      } else {
         glowRenderType = RenderType.m_110488_(LAYER2);
      }

      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, packedLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
