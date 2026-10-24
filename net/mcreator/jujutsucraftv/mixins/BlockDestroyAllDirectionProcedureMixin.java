package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
   value = {BlockDestroyAllDirectionProcedure.class},
   remap = false
)
public abstract class BlockDestroyAllDirectionProcedureMixin {
   @ModifyVariable(
      method = {"execute"},
      at = @At(
   value = "STORE",
   ordinal = 0
),
      name = {"type_flame"},
      remap = false
   )
   private static boolean modifyTypeFlame(boolean originalValue, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = entity.getPersistentData().m_128459_("skill");
         if (num1 == (double)107.0F || num1 >= (double)405.0F && num1 <= (double)420.0F || num1 >= (double)2605.0F && num1 <= (double)2620.0F || num1 == (double)60404.0F || num1 == (double)62404.0F) {
            return true;
         }

         if (entity.getPersistentData().m_128471_("effect_sublight_speed")) {
            return true;
         }
      }

      return originalValue;
   }
}
