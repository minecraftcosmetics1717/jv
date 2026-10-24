package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.DomainActiveProcedure;
import net.mcreator.jujutsucraftv.procedures.ForestDomainActiveProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({DomainActiveProcedure.class})
public abstract class DomainActiveProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("TAIL")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      double skill_domain = (double)0.0F;
      skill_domain = entity.getPersistentData().m_128459_("skill_domain");
      if (skill_domain == (double)604.0F) {
         ForestDomainActiveProcedure.execute(world, x, y, z, entity);
      }

   }
}
