package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.item.DeathPaintingItem;
import net.mcreator.jujutsucraft.item.model.DeathPaintingItemModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({DeathPaintingItemModel.class})
public abstract class DeathPaintingItemModelMixin {
   @Overwrite(
      remap = false
   )
   public ResourceLocation getModelResource(DeathPaintingItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/death_paintings.geo.json");
   }
}
