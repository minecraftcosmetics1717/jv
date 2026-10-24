package net.mcreator.jujutsucraftv.block.model;

import net.mcreator.jujutsucraftv.block.VendingMachineBlock;
import net.mcreator.jujutsucraftv.block.entity.VendingMachineTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VendingMachineBlockModel extends GeoModel<VendingMachineTileEntity> {
   public ResourceLocation getAnimationResource(VendingMachineTileEntity animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/vending_machine.animation.json");
   }

   public ResourceLocation getModelResource(VendingMachineTileEntity animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/vending_machine.geo.json");
   }

   public ResourceLocation getTextureResource(VendingMachineTileEntity animatable) {
      int texture = 1;
      if (animatable != null && animatable.m_58900_().m_61138_(VendingMachineBlock.TEXTURE)) {
         texture = (Integer)animatable.m_58900_().m_61143_(VendingMachineBlock.TEXTURE);
      }

      return new ResourceLocation("jujutsucraftv", "textures/block/vending_machine" + texture + ".png");
   }
}
