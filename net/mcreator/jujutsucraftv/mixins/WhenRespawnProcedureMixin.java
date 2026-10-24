package net.mcreator.jujutsucraftv.mixins;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.WhenRespawnProcedure;
import net.mcreator.jujutsucraftv.procedures.ReturnCursePowerFormerVProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {WhenRespawnProcedure.class},
   remap = false
)
public abstract class WhenRespawnProcedureMixin {
   @Inject(
      method = {"execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/mcreator/jujutsucraft/network/JujutsucraftModVariables$PlayerVariables;PlayerCursePowerFormer:D",
   opcode = 181,
   ordinal = 2,
   shift = Shift.AFTER
)}
   )
   private static void jjcv$replacePlayerCursePowerFormer(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null) {
         JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         if (pVars != null) {
            pVars.PlayerCursePowerFormer = ReturnCursePowerFormerVProcedure.execute(world, entity);
         }
      }
   }
}
