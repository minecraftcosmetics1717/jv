package net.mcreator.jujutsucraftv.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.mcreator.jujutsucraftv.item.RippingBladeItem;
import net.mcreator.jujutsucraftv.item.model.RippingBladeItemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RippingBladeItemRenderer extends GeoItemRenderer<RippingBladeItem> {
   private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap();
   private ItemStack currentItemStack;
   private static final float SCALE_RECIPROCAL = 0.0625F;
   protected boolean renderArms;
   protected MultiBufferSource currentBuffer;
   protected RenderType renderType;
   public ItemDisplayContext transformType;
   protected RippingBladeItem animatable;
   private final Set<String> hiddenBones;
   private final Set<String> suppressedBones;

   public RippingBladeItemRenderer() {
      super(new RippingBladeItemModel());
      this.currentItemStack = ItemStack.f_41583_;
      this.renderArms = false;
      this.hiddenBones = new HashSet();
      this.suppressedBones = new HashSet();
   }

   public RenderType getRenderType(RippingBladeItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }

   public void m_108829_(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int p_239207_6_) {
      this.transformType = transformType;
      this.currentItemStack = stack;
      super.m_108829_(stack, transformType, matrixStack, bufferIn, combinedLightIn, p_239207_6_);
   }

   public void actuallyRender(PoseStack matrixStackIn, RippingBladeItem animatable, BakedGeoModel model, RenderType type, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, boolean isRenderer, float partialTicks, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      this.currentBuffer = renderTypeBuffer;
      this.renderType = type;
      this.animatable = animatable;
      super.actuallyRender(matrixStackIn, animatable, model, type, renderTypeBuffer, vertexBuilder, isRenderer, partialTicks, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      if (this.renderArms) {
         this.renderArms = false;
      }

   }

   public ResourceLocation getTextureLocation(RippingBladeItem instance) {
      String textureName = this.currentItemStack.m_41782_() ? this.currentItemStack.m_41783_().m_128461_("geckoTexture") : "";
      return textureName.isBlank() ? super.getTextureLocation(instance) : (ResourceLocation)TEXTURE_CACHE.computeIfAbsent(textureName, RippingBladeItemRenderer::resolveTexture);
   }

   private static ResourceLocation resolveTexture(String textureName) {
      String value = textureName.replace('\\', '/');
      String namespace = "jujutsucraftv";
      if (value.contains(":")) {
         ResourceLocation supplied = ResourceLocation.m_135820_(value);
         if (supplied == null) {
            return new ResourceLocation("jujutsucraftv", "textures/item/ripping_blade.png");
         }

         namespace = supplied.m_135827_();
         value = supplied.m_135815_();
      }

      if (!value.startsWith("textures/")) {
         value = "textures/item/" + value;
      }

      if (!value.endsWith(".png")) {
         value = value + ".png";
      }

      ResourceLocation resolved = ResourceLocation.m_135820_(namespace + ":" + value);
      return resolved != null ? resolved : new ResourceLocation("jujutsucraftv", "textures/item/ripping_blade.png");
   }
}
