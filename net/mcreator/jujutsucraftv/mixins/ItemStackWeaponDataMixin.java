package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.procedures.WeaponDataSet3Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemStack.class})
public abstract class ItemStackWeaponDataMixin {
   @Inject(
      method = {"<init>(Lnet/minecraft/world/level/ItemLike;)V"},
      at = {@At("RETURN")},
      require = 0
   )
   private void jjcv$initWeaponDataItemLike(ItemLike item, CallbackInfo ci) {
      WeaponDataSet3Procedure.execute((ItemStack)this);
   }

   @Inject(
      method = {"<init>(Lnet/minecraft/world/level/ItemLike;I)V"},
      at = {@At("RETURN")},
      require = 0
   )
   private void jjcv$initWeaponDataItemLikeCount(ItemLike item, int count, CallbackInfo ci) {
      WeaponDataSet3Procedure.execute((ItemStack)this);
   }

   @Inject(
      method = {"<init>(Lnet/minecraft/nbt/CompoundTag;)V"},
      at = {@At("RETURN")},
      require = 0
   )
   private void jjcv$initWeaponDataFromNbt(CompoundTag tag, CallbackInfo ci) {
      WeaponDataSet3Procedure.execute((ItemStack)this);
   }
}
