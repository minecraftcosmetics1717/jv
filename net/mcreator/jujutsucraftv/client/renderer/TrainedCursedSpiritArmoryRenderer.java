package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_armoury;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModLayerDefinitions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class TrainedCursedSpiritArmoryRenderer implements ICurioRenderer {
   private static final ResourceLocation TEXTURE = new ResourceLocation("jujutsucraftv", "textures/entities/cursedspirit_armoury.png");
   private final Modelcursedspirit_armoury model;

   public TrainedCursedSpiritArmoryRenderer() {
      this.model = new Modelcursedspirit_armoury(Minecraft.m_91087_().m_167973_().m_171103_(JujutsucraftvModLayerDefinitions.TRAINED_CURSED_SPIRIT_ARMORY));
   }

   public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      LivingEntity entity = slotContext.entity();
      ICurioRenderer.translateIfSneaking(matrixStack, entity);
      ICurioRenderer.rotateIfSneaking(matrixStack, entity);
      this.model.m_6839_(entity, limbSwing, limbSwingAmount, partialTicks);
      this.model.m_6973_(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
      VertexConsumer vertexconsumer = ItemRenderer.m_115184_(renderTypeBuffer, RenderType.m_110431_(TEXTURE), false, stack.m_41790_());
      this.model.m_7695_(matrixStack, vertexconsumer, light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
