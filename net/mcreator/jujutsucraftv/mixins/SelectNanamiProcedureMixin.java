package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.SelectNanamiProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.procedures.CheckGamemodeCreativeProcedure;
import net.mcreator.jujutsucraftv.procedures.CheckHaveItemProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({SelectNanamiProcedure.class})
public abstract class SelectNanamiProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null && CheckGamemodeCreativeProcedure.execute(entity) && entity instanceof Player player) {
         giveItemIfNotOwned(world, player, new ItemStack((ItemLike)JujutsucraftvModItems.NANAMI_NECKTIE.get()));
      }

   }

   private static void giveItemIfNotOwned(LevelAccessor world, Player player, ItemStack itemStack) {
      if (!CheckHaveItemProcedure.execute(world, player, itemStack)) {
         ItemStack stackToGive = itemStack.m_41777_();
         stackToGive.m_41764_(1);
         ItemHandlerHelper.giveItemToPlayer(player, stackToGive);
      }

   }
}
