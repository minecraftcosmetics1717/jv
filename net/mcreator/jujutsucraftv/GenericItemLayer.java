package net.mcreator.jujutsucraftv;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.lwjgl.opengl.GL11;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class GenericItemLayer<T extends LivingEntity & GeoAnimatable> extends BlockAndItemGeoLayer<T> {
   private final DynamicGeoEntityRenderer<T> renderer;

   public GenericItemLayer(DynamicGeoEntityRenderer<T> renderer) {
      super(renderer);
      this.renderer = renderer;
   }

   @Nullable
   protected ItemStack getStackForBone(GeoBone bone, T animatable) {
      ItemStack mainHandItem = animatable.m_21205_();
      ItemStack offhandItem = animatable.m_21206_();
      ItemStack headItem = animatable.m_6844_(EquipmentSlot.HEAD);
      Item var7 = headItem.m_41720_();
      if (var7 instanceof ArmorItem armorItem) {
         if (armorItem.m_40402_().m_20751_().equals("head")) {
            headItem = ItemStack.f_41583_;
         }
      }

      switch (bone.getName()) {
         case "itemMainHand":
         case "itemMainHand2":
         case "itemMainHand3":
            return mainHandItem;
         case "itemOffHand":
         case "itemOffHand2":
         case "itemOffHand3":
            return offhandItem;
         case "Head":
         case "armorHead":
            return headItem;
         default:
            return null;
      }
   }

   protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, T animatable) {
      return !bone.getName().equals("Head") && !bone.getName().equals("armorHead") ? ItemDisplayContext.THIRD_PERSON_RIGHT_HAND : ItemDisplayContext.HEAD;
   }

   protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, T animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
      ItemStack mainHandItem = animatable.m_21205_();
      ItemStack offhandItem = animatable.m_21206_();
      String boneName = bone.getName();
      boolean isOffhand = boneName.startsWith("itemOffHand") && stack == offhandItem;
      poseStack.m_85836_();
      if (stack == mainHandItem) {
         poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0F));
         if (stack.m_41720_() instanceof ShieldItem) {
            poseStack.m_252880_(0.0F, -0.25F, 0.0F);
            poseStack.m_252781_(Axis.f_252403_.m_252977_(180.0F));
         }
      } else if (stack == offhandItem) {
         if (isOffhand) {
            poseStack.m_85841_(-1.0F, 1.0F, 1.0F);
         }

         poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0F));
         if (stack.m_41720_() instanceof ShieldItem) {
            poseStack.m_252880_(0.0F, -0.25F, 0.0F);
            poseStack.m_252781_(Axis.f_252403_.m_252977_(180.0F));
         }
      } else if (boneName.equals("Head") || boneName.equals("armorHead")) {
         poseStack.m_252880_(0.0F, 0.25F, 0.0F);
         poseStack.m_85841_(0.625F, 0.625F, 0.625F);
      }

      if (isOffhand) {
         if (bufferSource instanceof MultiBufferSource.BufferSource) {
            MultiBufferSource.BufferSource bs = (MultiBufferSource.BufferSource)bufferSource;
            bs.m_109911_();
         }

         RenderSystem.enableCull();
         GL11.glFrontFace(2304);
         super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
         if (bufferSource instanceof MultiBufferSource.BufferSource) {
            MultiBufferSource.BufferSource bs = (MultiBufferSource.BufferSource)bufferSource;
            bs.m_109911_();
         }

         GL11.glFrontFace(2305);
      } else {
         super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
      }

      poseStack.m_85849_();
   }
}
