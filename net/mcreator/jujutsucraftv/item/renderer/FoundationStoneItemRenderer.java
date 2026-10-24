package net.mcreator.jujutsucraftv.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashSet;
import java.util.Set;
import net.mcreator.jujutsucraftv.item.FoundationStoneItem;
import net.mcreator.jujutsucraftv.item.model.FoundationStoneItemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FoundationStoneItemRenderer extends GeoItemRenderer<FoundationStoneItem> {
   private ItemStack currentStack;
   private static final ResourceLocation TEXTURE_DEFAULT = new ResourceLocation("jujutsucraftv", "textures/item/foundation_stone.png");
   private static final ResourceLocation TEXTURE_5 = new ResourceLocation("jujutsucraftv", "textures/item/foundation_stone5.png");
   private static final ResourceLocation TEXTURE_7 = new ResourceLocation("jujutsucraftv", "textures/item/foundation_stone7.png");
   private static final float SCALE_RECIPROCAL = 0.0625F;
   protected boolean renderArms;
   protected MultiBufferSource currentBuffer;
   protected RenderType renderType;
   public ItemDisplayContext transformType;
   protected FoundationStoneItem animatable;
   private final Set<String> hiddenBones;
   private final Set<String> suppressedBones;

   public FoundationStoneItemRenderer() {
      super(new FoundationStoneItemModel());
      this.currentStack = ItemStack.f_41583_;
      this.renderArms = false;
      this.hiddenBones = new HashSet();
      this.suppressedBones = new HashSet();
      this.addRenderLayer(new FoundationStoneItemLayer(this));
   }

   public RenderType getRenderType(FoundationStoneItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }

   public void m_108829_(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
      this.currentStack = stack;
      this.transformType = transformType;
      super.m_108829_(stack, transformType, matrixStack, bufferIn, combinedLightIn, combinedOverlayIn);
   }

   public void actuallyRender(PoseStack matrixStackIn, FoundationStoneItem animatable, BakedGeoModel model, RenderType type, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, boolean isRenderer, float partialTicks, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      this.currentBuffer = renderTypeBuffer;
      this.renderType = type;
      this.animatable = animatable;
      super.actuallyRender(matrixStackIn, animatable, model, type, renderTypeBuffer, vertexBuilder, isRenderer, partialTicks, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      if (this.renderArms) {
         this.renderArms = false;
      }

   }

   public ResourceLocation getTextureLocation(FoundationStoneItem instance) {
      int tex = this.getTextureId();
      if (tex == 5) {
         return TEXTURE_5;
      } else {
         return tex == 7 ? TEXTURE_7 : TEXTURE_DEFAULT;
      }
   }

   ResourceLocation getGlowTextureLocation() {
      int tex = this.getTextureId();
      if (tex == 5) {
         return TEXTURE_5;
      } else {
         return tex == 7 ? TEXTURE_7 : TEXTURE_DEFAULT;
      }
   }

   private int getTextureId() {
      if (!this.currentStack.m_41619_() && this.currentStack.m_41782_()) {
         CompoundTag tag = this.currentStack.m_41783_();
         if (tag != null && tag.m_128425_("tex", 99)) {
            return tag.m_128451_("tex");
         }
      }

      return 0;
   }
}
