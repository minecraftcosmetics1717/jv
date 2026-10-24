package net.mcreator.jujutsucraftv.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.OgiZeninPassiveSkillProcedure;
import net.mcreator.jujutsucraft.procedures.WhenRespawnProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CursedTechniqueSelectedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerFlag_A = true;
            capability.PlayerFlag_B = false;
            capability.PlayerProfession = (double)0.0F;
            capability.syncPlayerVariables(entity);
         });
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_((Item)JujutsucraftvModItems.CURSED_TECHNIQUE_CHANGER_V.get(), 10);
         }

         boolean isCreative = false;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _serverPlayer = (ServerPlayer)entity;
            isCreative = _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
         } else if (entity.m_9236_().m_5776_() && entity instanceof Player) {
            Player _player = (Player)entity;
            isCreative = Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
         }

         if (!isCreative && entity.getPersistentData().m_128471_("used_jjc_changer")) {
            entity.getPersistentData().m_128379_("used_jjc_changer", false);
            executeCommand(entity, "clear @s jujutsucraft:cursed_technique_changer 1");
         } else if (!isCreative) {
            executeCommand(entity, "clear @s jujutsucraftv:cursed_technique_changer_v 1");
         }

         entity.getPersistentData().m_128379_("have_jjc_changer", false);
         entity.getPersistentData().m_128379_("used_jjc_changer", false);
         entity.getPersistentData().m_128379_("used_jjcv_changer", false);
         executeCommand(entity, "effect clear @s");
         executeCommand(entity, "advancement revoke @s only jujutsucraft:update");
         executeCommand(entity, "advancement grant @s only jujutsucraft:update");
         if (GetJjcvConfigProcedure.execute(world, (double)4.0F)) {
            int techniqueId = (int)GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F);
            if (techniqueId != -1 && techniqueId != 0) {
               executeCommand(entity, "give @s jujutsucraftv:curse_power_color_changer");
            }
         }

         if (GetJjcvConfigProcedure.execute(world, (double)5.0F) && GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) > (double)0.0F) {
            executeCommand(entity, "give @s jujutsucraft:profession_changer 1");
         }

         entity.getPersistentData().m_128347_("select", (double)0.0F);
         entity.getPersistentData().m_128347_("skill_domain", (double)0.0F);
         if (entity instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer)entity;
            Advancement advancement = player.m_20194_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"));
            if (advancement != null) {
               AdvancementProgress advancementProgress = player.m_8960_().m_135996_(advancement);
               if (!advancementProgress.m_8193_()) {
                  for(String criteria : advancementProgress.m_8219_()) {
                     player.m_8960_().m_135998_(advancement, criteria);
                  }
               }
            }
         }

         entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerParticleSet = false;
            capability.PlayerDomainInside = false;
            capability.PlayerDomainFloor = false;
            capability.syncPlayerVariables(entity);
         });
         OgiZeninPassiveSkillProcedure.execute(entity);
         WhenRespawnProcedure.execute(world, x, y, z, entity);
         double curseTechnique = (Double)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).map((cap) -> cap.PlayerCurseTechnique).orElse((double)0.0F);
         if (curseTechnique != (double)0.0F && entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:advancement_select_technique"));
            if (_adv != null) {
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         }

         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var10000.ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ItemStack stack = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
               if (stack.m_41784_().m_128471_("DistributionItem") && entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().m_36022_((p) -> stack.m_41720_() == p.m_41720_(), stack.m_41613_(), _player.f_36095_.m_39730_());
               }
            }
         }

      }
   }

   private static void executeCommand(Entity entity, String command) {
      if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
         entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), command);
      }

   }
}
