package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.SelectedProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.GetJjcvConfigProcedure;
import net.mcreator.jujutsucraftv.procedures.GetSelectCursedTechniqueProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({SelectedProcedure.class})
public abstract class SelectedProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("TAIL")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null) {
         boolean isCreative = false;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _serverPlayer = (ServerPlayer)entity;
            isCreative = _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
         } else if (entity.m_9236_().m_5776_() && entity instanceof Player) {
            Player _player = (Player)entity;
            if (Minecraft.m_91087_().m_91403_() != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null) {
               isCreative = Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
            }
         }

         if (!isCreative && entity.getPersistentData().m_128471_("used_jjcv_changer")) {
            if (entity.getPersistentData().m_128471_("have_jjc_changer") && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "give @s jujutsucraft:cursed_technique_changer 1");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear @s jujutsucraftv:cursed_technique_changer_v 1");
            }
         }

         entity.getPersistentData().m_128379_("have_jjc_changer", false);
         entity.getPersistentData().m_128379_("used_jjc_changer", false);
         entity.getPersistentData().m_128379_("used_jjcv_changer", false);
         entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerParticleSet = false;
            capability.PlayerDomainInside = false;
            capability.PlayerDomainFloor = false;
            capability.syncPlayerVariables(entity);
         });
         if (GetJjcvConfigProcedure.execute(world, (double)4.0F) && !(GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) <= (double)0.0F) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "give @s jujutsucraftv:curse_power_color_changer");
         }

         if (GetJjcvConfigProcedure.execute(world, (double)5.0F) && !(GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) <= (double)0.0F) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "give @s jujutsucraft:profession_changer 1");
         }
      }

   }
}
