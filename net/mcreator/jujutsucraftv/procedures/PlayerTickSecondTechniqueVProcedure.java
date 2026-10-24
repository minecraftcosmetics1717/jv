package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTickSecondTechniqueVProcedure {
   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double old_select = (double)0.0F;
         double old_technique = (double)0.0F;
         boolean changeTechnique = false;
         boolean old_second = false;
         boolean switched = false;

         for(int index0 = 0; index0 < 2; ++index0) {
            old_second = changeTechnique;
            changeTechnique = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()) && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)(_livEnt0.m_21023_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()) ? _livEnt0.m_21124_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()).m_19564_() : 0) && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)(_livEnt0.m_21023_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()) ? _livEnt0.m_21124_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()).m_19564_() : 0)) {
                  double newTechniqueValue = (double)_livEnt0.m_21124_((MobEffect)JujutsucraftvModMobEffects.SECOND_TECHNIQUE.get()).m_19564_();
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCurseTechnique = newTechniqueValue;
                     capability.syncPlayerVariables(entity);
                  });
                  changeTechnique = true;
               }
            }

            if (!changeTechnique) {
               break;
            }

            double newSelectValue = entity.m_6144_() ? (double)50.0F : (double)0.0F;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerSelectCurseTechnique = newSelectValue;
               capability.syncPlayerVariables(entity);
            });
            boolean noChangeTechniqueValue = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = noChangeTechniqueValue;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            if (old_second == ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique) {
               break;
            }
         }

      }
   }
}
