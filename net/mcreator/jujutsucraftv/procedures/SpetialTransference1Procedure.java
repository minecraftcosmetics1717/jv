package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpetialTransference1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String pos = "";
         double slot = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
            if (GetFlagShiftProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (!_livEnt.m_21220_().isEmpty()) {
                  int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                  if (cooldownTicks > 0) {
                     _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                  }
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "attribute @s jujutsucraft:animation_1 base set 207");
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               DisplayParticleCircleProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + 0.2, entity.m_20189_(), (double)20.0F, (double)4.0F, "particle minecraft:composter ~ ~ ~ 0.01 0.01 0.01 1 1");
            }

            slot = (double)GetPlayerSelectSlotProcedure.execute(entity);
            if (slot == (double)0.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot0);
            }

            if (slot == (double)1.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot1);
            }

            if (slot == (double)2.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot2);
            }

            if (slot == (double)3.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot3);
            }

            if (slot == (double)4.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot4);
            }

            if (slot == (double)5.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot5);
            }

            if (slot == (double)6.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot6);
            }

            if (slot == (double)7.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot7);
            }

            if (slot == (double)8.0F) {
               entity.getPersistentData().m_128359_("pos", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).uiui_slot8);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123749_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
            }

            if (!entity.getPersistentData().m_128461_("pos").isEmpty()) {
               String[] parts = entity.getPersistentData().m_128461_("pos").trim().split(" ");
               if (parts.length != 3) {
                  return;
               }

               try {
                  entity.getPersistentData().m_128347_("x_pos", Double.parseDouble(parts[0].trim()));
                  entity.getPersistentData().m_128347_("y_pos", Double.parseDouble(parts[1].trim()));
                  entity.getPersistentData().m_128347_("z_pos", Double.parseDouble(parts[2].trim()));
               } catch (NumberFormatException var17) {
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.message.not_set_slot_pos").getString()), true);
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", (double)15.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)9.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (!LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator)) {
                     entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                        }
                     }

                     entityiterator.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                        _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entityiterator.m_146908_(), entityiterator.m_146909_());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
