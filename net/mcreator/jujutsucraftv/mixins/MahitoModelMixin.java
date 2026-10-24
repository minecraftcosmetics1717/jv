package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.model.MahitoModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({MahitoModel.class})
public abstract class MahitoModelMixin {
   @Inject(
      method = {"getTextureResource"},
      at = {@At("TAIL")},
      cancellable = true,
      remap = false
   )
   private void overrideTexture(MahitoEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
      cir.setReturnValue(new ResourceLocation("jujutsucraftv", "textures/entities/mahito.png"));
   }
}
