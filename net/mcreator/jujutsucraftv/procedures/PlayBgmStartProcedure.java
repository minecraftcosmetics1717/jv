package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class PlayBgmStartProcedure {
   public static void execute(LevelAccessor world, Entity entity, int amplifier) {
      if (entity instanceof ServerPlayer) {
         ServerPlayer serverPlayer = (ServerPlayer)entity;
         String var10000;
         switch (amplifier) {
            case 2 -> var10000 = "jujutsucraftv:bgm_nostalgia";
            default -> var10000 = null;
         }

         String soundId = var10000;
         if (soundId != null) {
            SoundEvent sound = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundId));
            if (sound != null) {
               serverPlayer.m_6330_(sound, SoundSource.RECORDS, 1.0F, 1.0F);
            }

         }
      }
   }
}
