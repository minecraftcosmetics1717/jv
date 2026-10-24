package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.ReverseCursedTechniqueOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftv.procedures.GetSelectCursedTechniqueProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
   value = {ReverseCursedTechniqueOnEffectActiveTickProcedure.class},
   remap = false
)
public abstract class ReverseCursedTechniqueOnEffectActiveTickProcedureMixin {
   @ModifyVariable(
      method = {"execute"},
      at = @At(
   value = "STORE",
   ordinal = 0
),
      ordinal = 3,
      remap = false
   )
   private static double modifyRCTAmount(double originalAmount, LevelAccessor world, double x, double y, double z, Entity entity) {
      return entity != null && entity.getPersistentData().m_128471_("PRESS_M") && GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) != (double)617.0F && GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) != (double)617.0F && GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) != (double)45.0F && GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) != (double)45.0F && !entity.getPersistentData().m_128471_("CursedSpirit") ? (double)10.0F : originalAmount;
   }
}
