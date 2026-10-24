package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.TakadaEntity;
import net.mcreator.jujutsucraft.entity.model.TakadaModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({TakadaModel.class})
public abstract class TakadaModelMixin {
   @Inject(
      method = {"getModelResource"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private void overrideModel(TakadaEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
      cir.setReturnValue(new ResourceLocation("jujutsucraftv", "geo/human.geo.json"));
   }

   @Inject(
      method = {"getTextureResource"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private void overrideTexture(TakadaEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
      cir.setReturnValue(new ResourceLocation("jujutsucraftv", "textures/entities/takada.png"));
   }
}
