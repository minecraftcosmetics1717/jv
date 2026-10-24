package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PlayBgmTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("BGM_OWNER")) instanceof LivingEntity)) {
            int amplifier = (Integer)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).map((capability) -> (int)capability.bgm_lv).orElse(0);
            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               String var10000;
               switch (amplifier) {
                  case 2 -> var10000 = "jujutsucraftv:bgm_nostalgia";
                  default -> var10000 = null;
               }

               String soundId = var10000;
               if (soundId != null) {
                  serverPlayer.f_8906_.m_9829_(new ClientboundStopSoundPacket(new ResourceLocation(soundId), SoundSource.RECORDS));
               }
            }

            entity.getPersistentData().m_128359_("BGM_OWNER", "");
            double _setval = (double)0.0F;
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.bgm_lv = _setval;
               capability.syncPlayerVariables(entity);
            });
            _setval = (double)0.0F;
            entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.bgm_tick = _setval;
               capability.syncPlayerVariables(entity);
            });
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.PLAY_BGM.get());
            }
         }

      }
   }
}
