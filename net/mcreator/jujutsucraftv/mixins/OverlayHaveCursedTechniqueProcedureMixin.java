package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.OverlayHaveCursedTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.GetJjcvConfigProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({OverlayHaveCursedTechniqueProcedure.class})
public abstract class OverlayHaveCursedTechniqueProcedureMixin {
   @Inject(
      method = {"execute(Lnet/minecraft/world/entity/Entity;)Z"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void addConfigCheck(Entity entity, CallbackInfoReturnable<Boolean> cir) {
      if (entity != null) {
         LevelAccessor world = entity.m_9236_();
         if (!GetJjcvConfigProcedure.execute(world, (double)3.0F)) {
            cir.setReturnValue(false);
         }

      }
   }
}
