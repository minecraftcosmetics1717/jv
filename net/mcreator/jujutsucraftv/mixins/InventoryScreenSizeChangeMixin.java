package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.util.SizeChangeRenderContext;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({InventoryScreen.class})
public abstract class InventoryScreenSizeChangeMixin {
   @Inject(
      method = {"renderEntityInInventory(Lnet/minecraft/client/gui/GuiGraphics;IIILorg/joml/Quaternionf;Lorg/joml/Quaternionf;Lnet/minecraft/world/entity/LivingEntity;)V"},
      at = {@At("HEAD")}
   )
   private static void jjcv$beginInventoryEntityRender(GuiGraphics guiGraphics, int x, int y, int scale, Quaternionf pose, Quaternionf cameraOrientation, LivingEntity entity, CallbackInfo ci) {
      SizeChangeRenderContext.beginInventoryRender();
   }

   @Inject(
      method = {"renderEntityInInventory(Lnet/minecraft/client/gui/GuiGraphics;IIILorg/joml/Quaternionf;Lorg/joml/Quaternionf;Lnet/minecraft/world/entity/LivingEntity;)V"},
      at = {@At("RETURN")}
   )
   private static void jjcv$endInventoryEntityRender(GuiGraphics guiGraphics, int x, int y, int scale, Quaternionf pose, Quaternionf cameraOrientation, LivingEntity entity, CallbackInfo ci) {
      SizeChangeRenderContext.endInventoryRender();
   }
}
