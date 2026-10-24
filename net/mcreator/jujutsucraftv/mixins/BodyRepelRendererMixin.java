package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.client.renderer.BodyRepelRenderer;
import net.mcreator.jujutsucraft.entity.BodyRepelEntity;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {BodyRepelRenderer.class},
   remap = false
)
public abstract class BodyRepelRendererMixin {
   private static final ResourceLocation[] JJCV_TEXTURES = new ResourceLocation[]{new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_1.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_2.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_3.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_4.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_5.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_6.png"), new ResourceLocation("jujutsucraft:textures/entities/mahitohand4_7.png")};

   @Inject(
      method = {"getTextureLocation"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void jjcv$getTextureLocation(BodyRepelEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
      cir.setReturnValue(JJCV_TEXTURES[Math.floorMod(entity.m_20148_().hashCode(), JJCV_TEXTURES.length)]);
   }
}
