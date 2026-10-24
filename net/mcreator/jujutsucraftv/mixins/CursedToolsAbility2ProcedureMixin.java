package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.CursedToolsAbility2Procedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(
   value = {CursedToolsAbility2Procedure.class},
   remap = false
)
public abstract class CursedToolsAbility2ProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;",
   ordinal = 5
)},
      locals = LocalCapture.CAPTURE_FAILSOFT,
      remap = false
   )
   private static void injectSharpenedPlayfulCloud(Entity entity, CallbackInfo ci, boolean logic_a, double power, ItemStack mainHandItem) {
      if (mainHandItem.m_41720_() == JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get()) {
         entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.3);
         if (entity.getPersistentData().m_128459_("knockback") >= (double)1.0F) {
            entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (double)1.25F);
         }
      }

   }
}
