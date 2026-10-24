package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.ItemInsectRightClickedInAirProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {ItemInsectRightClickedInAirProcedure.class},
   remap = false
)
public abstract class ItemInsectRightClickedInAirProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/item/ItemStack;m_41774_(I)V",
   shift = Shift.AFTER,
   remap = false
)},
      remap = false
   )
   private static void jujutsucraftv$giveRepellingPills(LevelAccessor world, Entity entity, ItemStack itemstack, CallbackInfo ci) {
      if (entity instanceof ServerPlayer player) {
         MinecraftServer server = player.m_20194_();
         if (server != null) {
            server.m_6937_(new TickTask(server.m_129921_() + 1, () -> {
               ItemStack reward = new ItemStack((ItemLike)JujutsucraftvModItems.ITEM_INSECT_REPELLING_PILLS.get(), 1);
               player.m_150109_().m_150079_(reward);
            }));
         }
      }
   }
}
