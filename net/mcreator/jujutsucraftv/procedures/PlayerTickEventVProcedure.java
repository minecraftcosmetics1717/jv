package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTickEventVProcedure {
   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String old_name = "";
         double PlayerCT1 = (double)0.0F;
         double PlayerCT2 = (double)0.0F;
         boolean changeTechnique = false;
         boolean do_change_skill = false;
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) >= (double)600.0F) {
            PlayerCT1 = GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F);
            PlayerCT2 = GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F);
            if (entity.m_6144_()) {
               if (!GetFlagShiftProcedure.execute(entity)) {
                  SetFlagShiftProcedure.execute(entity, true);
                  changeTechnique = true;
               }
            } else if (GetFlagShiftProcedure.execute(entity)) {
               SetFlagShiftProcedure.execute(entity, false);
               changeTechnique = true;
            }

            if (changeTechnique && PlayerCT1 == (double)610.0F) {
               if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount < (double)0.0F) {
                  double _setval = (double)0.0F;
                  entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.CloneCount = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }

               if (GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)5.0F || GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)7.0F) {
                  do_change_skill = true;
               }
            }

            if (changeTechnique && PlayerCT1 == (double)611.0F && GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)6.0F) {
               do_change_skill = true;
            }

            if (changeTechnique && PlayerCT1 == (double)620.0F && (GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)8.0F || GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)6.0F)) {
               do_change_skill = true;
            }

            if (changeTechnique && PlayerCT1 == (double)634.0F && GetPlayerSelectCurseTechniqueProcedure.execute(entity) == (double)5.0F) {
               do_change_skill = true;
            }

            if (do_change_skill) {
               old_name = GetPlayerSelectCurseTechniqueNameProcedure.execute(entity);
               SetNoChangeTechniqueProcedure.execute(entity, true);
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               if (!old_name.equals(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName) && !entity.m_20193_().m_5776_() && entity.m_20194_() != null && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
               }
            }
         }

         if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
            boolean var10000;
            label123: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr0 = (ServerPlayer)entity;
                  if (_plr0.m_9236_() instanceof ServerLevel && _plr0.m_8960_().m_135996_(_plr0.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"))).m_8193_()) {
                     var10000 = true;
                     break label123;
                  }
               }

               var10000 = false;
            }

            if (!var10000) {
               boolean _setval = false;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerParticleSet = _setval;
                  capability.syncPlayerVariables(entity);
               });
               double _setval = (double)1.0F;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerParticleColor = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }
         }

         if (entity.getPersistentData().m_128471_("hovering") && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            entity.getPersistentData().m_128379_("hovering", false);
            entity.m_20242_(false);
         }

         if (entity.getPersistentData().m_128471_("skill_sublight_speed")) {
            label115: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get())) {
                     break label115;
                  }
               }

               entity.getPersistentData().m_128379_("skill_sublight_speed", false);
            }
         }

         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
            double var28;
            label108: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
                     var28 = _livingEntity12.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22115_();
                     break label108;
                  }
               }

               var28 = (double)0.0F;
            }

            if (var28 != (double)0.0F && entity instanceof LivingEntity) {
               LivingEntity _livingEntity13 = (LivingEntity)entity;
               if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
                  _livingEntity13.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22100_((double)0.0F);
               }
            }
         }

      }
   }
}
