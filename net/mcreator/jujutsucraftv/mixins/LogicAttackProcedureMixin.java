package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {LogicAttackProcedure.class},
   remap = false
)
public abstract class LogicAttackProcedureMixin {
   @Redirect(
      method = {"execute"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/nbt/CompoundTag;getBoolean(Ljava/lang/String;)Z",
   ordinal = 7
)
   )
   private static boolean jujutsucraft$redirectEntityCursedSpiritCheck(CompoundTag tag, String key) {
      if (!"CursedSpirit".equals(key)) {
         return tag.m_128471_(key);
      } else {
         return tag.m_128471_("CursedSpirit") || tag.m_128471_("Rumel");
      }
   }

   @Redirect(
      method = {"execute"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/nbt/CompoundTag;getBoolean(Ljava/lang/String;)Z",
   ordinal = 9
)
   )
   private static boolean jujutsucraft$redirectEntityIteratorCursedSpiritCheck(CompoundTag tag, String key) {
      if (!"CursedSpirit".equals(key)) {
         return tag.m_128471_(key);
      } else {
         return tag.m_128471_("CursedSpirit") || tag.m_128471_("Rumel");
      }
   }
}
