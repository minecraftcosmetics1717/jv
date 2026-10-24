package net.mcreator.jujutsucraftv.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.mcreator.jujutsucraftv.procedures.JjcvActTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugDisplayProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDomainBlockFloorProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDomainBlockInsideProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvGetoGetEntityProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvGiveLootTableChestProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvGivePlayerHeadProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetCursepowerProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetHakiProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetKnockbackProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetNameProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetPowerProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetRangeProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetReachProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvItemDataSetSlashColorProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetCloneMaxProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetMaxCursePowerProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerCursePowerFormerProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerCursePowerProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerFameProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerLevelProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerParticleColorProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetPlayerSelectCurseTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetTechnique1Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvSetTechnique2Procedure;
import net.mcreator.jujutsucraftv.procedures.OpenJjcvConfigGuiProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class JjcvCommand {
   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher().register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.m_82127_("jjcv").requires((s) -> s.m_6761_(2))).then(Commands.m_82127_("act_technique").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("select_technique", DoubleArgumentType.doubleArg()).then(Commands.m_82129_("charge", DoubleArgumentType.doubleArg((double)0.0F, (double)5.0F)).then(Commands.m_82129_("cost", DoubleArgumentType.doubleArg((double)0.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvActTechniqueProcedure.execute(arguments);
         return 0;
      }))))))).then(Commands.m_82127_("config").executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         OpenJjcvConfigGuiProcedure.execute(world, x, y, z, entity);
         return 0;
      }))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.m_82127_("entity_data").then(Commands.m_82127_("set_player_max_curse_power").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_max_curse_power", DoubleArgumentType.doubleArg((double)0.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetMaxCursePowerProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_curse_power").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_curse_power", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerCursePowerProcedure.execute(arguments, entity);
         return 0;
      }))))).then(Commands.m_82127_("set_player_technique").then(((RequiredArgumentBuilder)Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82127_("technique1").then(Commands.m_82129_("second_technique", BoolArgumentType.bool()).then(Commands.m_82129_("technique_number", DoubleArgumentType.doubleArg((double)-1.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetTechnique1Procedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("technique2").then(Commands.m_82129_("technique_number", DoubleArgumentType.doubleArg((double)-1.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetTechnique2Procedure.execute(arguments);
         return 0;
      })))))).then(Commands.m_82127_("set_player_select_cursed_technique").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_select", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerSelectCurseTechniqueProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_particle_color").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("particle_color", DoubleArgumentType.doubleArg((double)0.0F, (double)27.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerParticleColorProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_level").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_level", DoubleArgumentType.doubleArg((double)0.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerLevelProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_curse_power_former").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_curse_former", DoubleArgumentType.doubleArg((double)0.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerCursePowerFormerProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_fame").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("player_fame", DoubleArgumentType.doubleArg((double)0.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetPlayerFameProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("set_player_clone_max").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("clone_max", DoubleArgumentType.doubleArg((double)0.0F, (double)100.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvSetCloneMaxProcedure.execute(arguments);
         return 0;
      }))))).then(((LiteralArgumentBuilder)Commands.m_82127_("set_player_domain_block").then(Commands.m_82127_("inside").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("set_domain_block", StringArgumentType.string()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvDomainBlockInsideProcedure.execute(world, x, y, z, arguments);
         return 0;
      }))))).then(Commands.m_82127_("floor").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("set_domain_block", StringArgumentType.string()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvDomainBlockFloorProcedure.execute(world, x, y, z, arguments);
         return 0;
      }))))))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.m_82127_("item_data").then(Commands.m_82127_("CursePower").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetCursepowerProcedure.execute(world, arguments);
         return 0;
      })))))).then(Commands.m_82127_("name").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("item_name", StringArgumentType.string()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetNameProcedure.execute(world, x, y, z, arguments);
         return 0;
      })))))).then(Commands.m_82127_("Power").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetPowerProcedure.execute(world, arguments);
         return 0;
      })))))).then(Commands.m_82127_("Knockback").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetKnockbackProcedure.execute(world, arguments);
         return 0;
      })))))).then(Commands.m_82127_("Reach").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetReachProcedure.execute(world, arguments);
         return 0;
      })))))).then(Commands.m_82127_("Range").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetRangeProcedure.execute(world, arguments);
         return 0;
      })))))).then(Commands.m_82127_("slash_color").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg((double)0.0F, (double)10.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetSlashColorProcedure.execute(world, x, y, z, arguments);
         return 0;
      })))))).then(Commands.m_82127_("minepiece").then(Commands.m_82127_("Haki").then(Commands.m_82129_("entity", EntityArgument.m_91460_()).then(Commands.m_82129_("offhand", BoolArgumentType.bool()).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvItemDataSetHakiProcedure.execute(world, arguments);
         return 0;
      })))))))).then(Commands.m_82127_("debug_display").executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvDebugDisplayProcedure.execute(entity);
         return 0;
      }))).then(((LiteralArgumentBuilder)Commands.m_82127_("give").then(Commands.m_82127_("player_head").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("head_entity", EntityArgument.m_91466_()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvGivePlayerHeadProcedure.execute(arguments);
         return 0;
      }))))).then(Commands.m_82127_("loot_chest").then(Commands.m_82129_("entity", EntityArgument.m_91470_()).then(Commands.m_82129_("barrel", BoolArgumentType.bool()).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvGiveLootTableChestProcedure.execute(arguments);
         return 0;
      })))))).then(Commands.m_82127_("geto").then(Commands.m_82127_("get_entity").then(Commands.m_82129_("entity", EntityArgument.m_91466_()).then(Commands.m_82129_("entity_type", ResourceArgument.m_247102_(event.getBuildContext(), Registries.f_256939_)).then(Commands.m_82129_("num", DoubleArgumentType.doubleArg((double)1.0F)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7096_();
         double y = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7098_();
         double z = ((CommandSourceStack)arguments.getSource()).m_81371_().m_7094_();
         Entity entity = ((CommandSourceStack)arguments.getSource()).m_81373_();
         if (entity == null && world instanceof ServerLevel _servLevel) {
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = entity.m_6350_();
         }

         JjcvGetoGetEntityProcedure.execute(world, x, y, z, arguments, entity);
         return 0;
      })))))));
   }
}
