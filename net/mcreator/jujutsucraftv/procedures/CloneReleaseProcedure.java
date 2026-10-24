package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.client.Minecraft;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CloneReleaseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean shift = false;
         String r_m = "";
         double count = (double)0.0F;
         double tick = (double)0.0F;
         Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)500.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if ((Entity)world.m_6443_(CloneEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (double)1000.0F, (double)1000.0F, (double)1000.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
               Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                  return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
               }
            })).compareDistOf(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).findFirst().orElse((Object)null) == entityiterator && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20185_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20185_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), 20, 0.8, (double)1.0F, 0.8, 0.3);
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }

               double _setval = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount - (double)1.0F;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.CloneCount = _setval;
                  capability.syncPlayerVariables(entity);
               });
               ++tick;
               if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift || ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount <= (double)0.0F) {
                  break;
               }
            }
         }

         label63: {
            if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift && !(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount < (double)0.0F)) {
               int var10000;
               label59: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.MOTION.get()).m_19564_();
                        break label59;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 != 100) {
                  break label63;
               }
            }

            double _setval = (double)0.0F;
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.CloneCount = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         if (!(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount < ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax) && !(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount > (double)0.0F)) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
            }

            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         tick *= (double)75.0F;
         if (tick > (double)600.0F) {
            tick = (double)600.0F;
         }

         if (!((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            SetCoolDownProcedure.execute(entity, (double)0.0F, tick);
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
