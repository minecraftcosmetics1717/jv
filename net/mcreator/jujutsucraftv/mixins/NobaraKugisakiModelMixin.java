package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.NobaraKugisakiEntity;
import net.mcreator.jujutsucraft.entity.model.NobaraKugisakiModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({NobaraKugisakiModel.class})
public abstract class NobaraKugisakiModelMixin {
   @Inject(
      method = {"getTextureResource"},
      at = {@At("TAIL")},
      cancellable = true,
      remap = false
   )
   private void overrideTexture(NobaraKugisakiEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
      cir.setReturnValue(new ResourceLocation("jujutsucraftv", "textures/entities/kugisaki_nobara.png"));
   }
}
