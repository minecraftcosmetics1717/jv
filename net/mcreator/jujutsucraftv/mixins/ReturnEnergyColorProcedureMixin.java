package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ReturnEnergyColorProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {ReturnEnergyColorProcedure.class},
   remap = false
)
public abstract class ReturnEnergyColorProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void onExecuteHead(Entity entity, CallbackInfoReturnable<Double> cir) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity)entity;
            if (living.m_21023_((MobEffect)JujutsucraftvModMobEffects.RAINBOW_EYE.get())) {
               cir.setReturnValue((double)12.0F);
               return;
            }
         }

         if (entity.getPersistentData().m_128471_("ParticleSet")) {
            cir.setReturnValue(entity.getPersistentData().m_128459_("EntitySetParticle"));
         } else {
            JujutsucraftvModVariables.PlayerVariables vVars = (JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables());
            if (vVars.PlayerParticleSet) {
               cir.setReturnValue(vVars.PlayerParticleColor);
            } else {
               JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               if (pVars.PlayerCurseTechnique == (double)605.0F) {
                  cir.setReturnValue((double)2.0F);
               }
            }
         }
      }
   }
}
