package net.mcreator.jujutsucraftv.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraft.GenericItemLayer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade013Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade06Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade08Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

@Mixin(
   value = {GenericItemLayer.class},
   remap = false
)
public abstract class GenericItemLayerJJCMixin<T extends LivingEntity & GeoAnimatable> extends BlockAndItemGeoLayer<T> {
   public GenericItemLayerJJCMixin(GeoRenderer<T> renderer) {
      super(renderer);
   }

   @Overwrite
   protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, T animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
      String boneName = bone.getName();
      boolean mainHandBone = boneName.startsWith("itemMainHand");
      boolean offhandBone = boneName.startsWith("itemOffHand");
      boolean headBone = boneName.equals("Head") || boneName.equals("armorHead");
      boolean frontFaceChanged = false;
      poseStack.m_85836_();

      try {
         if (headBone) {
            poseStack.m_85837_((double)0.0F, (double)0.25F, (double)0.0F);
            poseStack.m_85841_(0.625F, 0.625F, 0.625F);
         } else if (mainHandBone || offhandBone) {
            float scaleFactor = 1.0F;
            if (offhandBone) {
               poseStack.m_85841_(-1.0F, 1.0F, 1.0F);
            }

            if (animatable instanceof CursedSpiritGrade06Entity || animatable instanceof CursedSpiritGrade013Entity) {
               scaleFactor = 2.75F;
            }

            if (animatable instanceof CursedSpiritGrade08Entity) {
               scaleFactor = 1.5F;
            }

            poseStack.m_85841_(scaleFactor, scaleFactor, scaleFactor);
            poseStack.m_252781_(Axis.f_252529_.m_252977_(-90.0F));
            if (offhandBone && stack.m_41720_() instanceof ShieldItem) {
               poseStack.m_85837_((double)0.0F, (double)-0.25F, (double)0.0F);
               poseStack.m_252781_(Axis.f_252403_.m_252977_(180.0F));
            }
         }

         if (offhandBone) {
            if (bufferSource instanceof MultiBufferSource.BufferSource) {
               MultiBufferSource.BufferSource buffer = (MultiBufferSource.BufferSource)bufferSource;
               buffer.m_109911_();
            }

            RenderSystem.enableCull();
            GL11.glFrontFace(2304);
            frontFaceChanged = true;
         }

         super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
         if (offhandBone && bufferSource instanceof MultiBufferSource.BufferSource buffer) {
            buffer.m_109911_();
         }
      } finally {
         if (frontFaceChanged) {
            GL11.glFrontFace(2305);
         }

         RenderSystem.enableCull();
         poseStack.m_85849_();
      }

   }
}
