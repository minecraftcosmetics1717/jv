package net.mcreator.jujutsucraftv.block.model;

import net.mcreator.jujutsucraftv.block.entity.NostalgistHandTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NostalgistHandBlockModel extends GeoModel<NostalgistHandTileEntity> {
   public ResourceLocation getAnimationResource(NostalgistHandTileEntity animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/nostalgist_hand.animation.json");
   }

   public ResourceLocation getModelResource(NostalgistHandTileEntity animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/nostalgist_hand.geo.json");
   }

   public ResourceLocation getTextureResource(NostalgistHandTileEntity animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/block/cursedspirit_nostalgy.png");
   }
}
