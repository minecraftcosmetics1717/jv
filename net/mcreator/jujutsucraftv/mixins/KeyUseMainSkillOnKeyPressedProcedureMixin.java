package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.KeyUseMainSkillOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.procedures.GetPerfectPhysicalGiftedEffectProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {KeyUseMainSkillOnKeyPressedProcedure.class},
   remap = false
)
public abstract class KeyUseMainSkillOnKeyPressedProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void jujutsucraftv$replaceMainSkill(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null) {
         JujutsucraftModVariables.PlayerVariables vars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
         double p_skill1 = vars.SecondTechnique ? vars.PlayerCurseTechnique2 : vars.PlayerCurseTechnique;
         double select = (double)0.0F;
         boolean matched = false;
         if (p_skill1 == (double)-1.0F) {
            if (GetPerfectPhysicalGiftedEffectProcedure.execute(entity)) {
               select = (double)10.0F;
            } else {
               select = (double)1.0F;
            }

            matched = true;
         } else if (p_skill1 == (double)602.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)603.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)604.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)605.0F) {
            select = (double)6.0F;
            matched = true;
         } else if (p_skill1 == (double)606.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)607.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)608.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)609.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)610.0F) {
            select = (double)6.0F;
            matched = true;
         } else if (p_skill1 == (double)611.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)612.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)613.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)614.0F) {
            select = (double)6.0F;
            matched = true;
         } else if (p_skill1 == (double)615.0F) {
            select = (double)7.0F;
            matched = true;
         } else if (p_skill1 == (double)618.0F) {
            select = (double)5.0F;
            matched = true;
         } else if (p_skill1 == (double)630.0F) {
            select = (double)5.0F;
            matched = true;
         }

         if (matched) {
            double oldSelect = vars.PlayerSelectCurseTechnique;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.use_mainSkill = true;
               capability.PlayerSelectCurseTechnique = select;
               capability.noChangeTechnique = true;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            JujutsucraftModVariables.PlayerVariables updatedVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            if (updatedVars.PlayerSelectCurseTechnique == select) {
               KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.use_mainSkill = false;
               capability.PlayerSelectCurseTechnique = oldSelect;
               capability.noChangeTechnique = true;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            ci.cancel();
         }
      }
   }
}
