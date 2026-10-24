package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.item.ClothesMahito2Item;
import net.mcreator.jujutsucraftv.item.model.ClothesMahito2Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ClothesMahito2ArmorRenderer extends GeoArmorRenderer<ClothesMahito2Item> {
   public ClothesMahito2ArmorRenderer() {
      super(new ClothesMahito2Model());
      this.head = new GeoBone((GeoBone)null, "armorHead", false, (double)0.0F, false, false);
      this.body = new GeoBone((GeoBone)null, "armorBody", false, (double)0.0F, false, false);
      this.rightArm = new GeoBone((GeoBone)null, "armorRightArm", false, (double)0.0F, false, false);
      this.leftArm = new GeoBone((GeoBone)null, "armorLeftArm", false, (double)0.0F, false, false);
      this.rightLeg = new GeoBone((GeoBone)null, "armorRightLeg", false, (double)0.0F, false, false);
      this.leftLeg = new GeoBone((GeoBone)null, "armorLeftLeg", false, (double)0.0F, false, false);
      this.rightBoot = new GeoBone((GeoBone)null, "armorRightBoot", false, (double)0.0F, false, false);
      this.leftBoot = new GeoBone((GeoBone)null, "armorLeftBoot", false, (double)0.0F, false, false);
   }

   public RenderType getRenderType(ClothesMahito2Item animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }
}
