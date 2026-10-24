package net.mcreator.jujutsucraftv.block.model;

import net.mcreator.jujutsucraftv.block.display.VendingMachineDisplayItem;
import net.mcreator.jujutsucraftv.block.renderer.VendingMachineDisplayItemRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VendingMachineDisplayModel extends GeoModel<VendingMachineDisplayItem> {
   public ResourceLocation getAnimationResource(VendingMachineDisplayItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/vending_machine.animation.json");
   }

   public ResourceLocation getModelResource(VendingMachineDisplayItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/vending_machine.geo.json");
   }

   public ResourceLocation getTextureResource(VendingMachineDisplayItem entity) {
      int texture = VendingMachineDisplayItemRenderer.getCurrentTexture();
      if (texture < 1 || texture > 3) {
         texture = 1;
      }

      return new ResourceLocation("jujutsucraftv", "textures/block/vending_machine" + texture + ".png");
   }
}
