package net.mcreator.jujutsucraftv.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashSet;
import java.util.Set;
import net.mcreator.jujutsucraftv.item.CursePowerSaberItem;
import net.mcreator.jujutsucraftv.item.model.CursePowerSaberItemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CursePowerSaberItemRenderer extends GeoItemRenderer<CursePowerSaberItem> {
   private ItemStack currentStack;
   private static final ResourceLocation TEXTURE_DEFAULT = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber.png");
   private static final ResourceLocation TEXTURE_1 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber1.png");
   private static final ResourceLocation TEXTURE_2 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber2.png");
   private static final ResourceLocation TEXTURE_3 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber3.png");
   private static final ResourceLocation TEXTURE_4 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber4.png");
   private static final ResourceLocation TEXTURE_5 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber5.png");
   private static final ResourceLocation TEXTURE_6 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber6.png");
   private static final ResourceLocation TEXTURE_7 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber7.png");
   private static final ResourceLocation TEXTURE_8 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber8.png");
   private static final ResourceLocation TEXTURE_9 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber9.png");
   private static final ResourceLocation TEXTURE_10 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber10.png");
   private static final ResourceLocation TEXTURE_11 = new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber11.png");
   private static final float SCALE_RECIPROCAL = 0.0625F;
   protected boolean renderArms;
   protected MultiBufferSource currentBuffer;
   protected RenderType renderType;
   public ItemDisplayContext transformType;
   protected CursePowerSaberItem animatable;
   private final Set<String> hiddenBones;
   private final Set<String> suppressedBones;

   public CursePowerSaberItemRenderer() {
      super(new CursePowerSaberItemModel());
      this.currentStack = ItemStack.f_41583_;
      this.renderArms = false;
      this.hiddenBones = new HashSet();
      this.suppressedBones = new HashSet();
   }

   public RenderType getRenderType(CursePowerSaberItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }

   public void m_108829_(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
      this.currentStack = stack;
      this.transformType = transformType;
      Item var8 = stack.m_41720_();
      if (var8 instanceof CursePowerSaberItem saberItem) {
         saberItem.setClientRenderStack(stack);
      }

      super.m_108829_(stack, transformType, matrixStack, bufferIn, combinedLightIn, combinedOverlayIn);
   }

   public void actuallyRender(PoseStack matrixStackIn, CursePowerSaberItem animatable, BakedGeoModel model, RenderType type, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, boolean isRenderer, float partialTicks, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      this.currentBuffer = renderTypeBuffer;
      this.renderType = type;
      this.animatable = animatable;
      int light = isAct(this.currentStack) ? 15728880 : packedLightIn;
      super.actuallyRender(matrixStackIn, animatable, model, type, renderTypeBuffer, vertexBuilder, isRenderer, partialTicks, light, packedOverlayIn, red, green, blue, alpha);
      if (this.renderArms) {
         this.renderArms = false;
      }

   }

   public ResourceLocation getTextureLocation(CursePowerSaberItem instance) {
      if (!this.currentStack.m_41619_() && this.currentStack.m_41782_()) {
         CompoundTag tag = this.currentStack.m_41783_();
         if (tag != null && tag.m_128425_("tex", 99)) {
            int tex = (int)tag.m_128459_("tex");
            if (tex == 1) {
               return TEXTURE_1;
            }

            if (tex == 2) {
               return TEXTURE_2;
            }

            if (tex == 3) {
               return TEXTURE_3;
            }

            if (tex == 4) {
               return TEXTURE_4;
            }

            if (tex == 5) {
               return TEXTURE_5;
            }

            if (tex == 6) {
               return TEXTURE_6;
            }

            if (tex == 7) {
               return TEXTURE_7;
            }

            if (tex == 8) {
               return TEXTURE_8;
            }

            if (tex == 9) {
               return TEXTURE_9;
            }

            if (tex == 10) {
               return TEXTURE_10;
            }

            if (tex != 11 && tex != 0) {
               return TEXTURE_1;
            }

            return TEXTURE_11;
         }
      }

      return TEXTURE_DEFAULT;
   }

   private static boolean isAct(ItemStack stack) {
      if (stack != null && !stack.m_41619_()) {
         CompoundTag tag = stack.m_41783_();
         return tag != null && tag.m_128471_("act");
      } else {
         return false;
      }
   }
}
