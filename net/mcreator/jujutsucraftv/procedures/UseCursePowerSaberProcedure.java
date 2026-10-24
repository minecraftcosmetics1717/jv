package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class UseCursePowerSaberProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (!GetPhysicalGiftedEffectProcedure.execute(entity)) {
            if (!itemstack.m_41784_().m_128471_("act")) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_on")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.3));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_on")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.3), false);
                  }
               }

               itemstack.m_41784_().m_128347_("tex", ReturnEnergyColorVProcedure.execute(entity));
               if (ReturnEnergyColorVProcedure.execute(entity) > (double)0.0F) {
                  if (ReturnEnergyColorVProcedure.execute(entity) == (double)2.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_yellow");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)3.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_green");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)4.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_purple");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)5.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_purple");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)6.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_yellow");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)7.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_red");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)8.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_blue");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)9.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_green");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)10.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_black");
                  } else if (ReturnEnergyColorVProcedure.execute(entity) == (double)11.0F) {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_white");
                  } else {
                     itemstack.m_41784_().m_128359_("slash_color", "slash_blue");
                  }
               }

               itemstack.m_41784_().m_128379_("act", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(itemstack.m_41720_(), 20);
               }
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_off")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.3));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_off")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.3), false);
                  }
               }

               itemstack.m_41784_().m_128379_("act", false);
               itemstack.m_41784_().m_128347_("tex", (double)1.0F);
               itemstack.m_41784_().m_128359_("slash_color", "slash_blue");
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(itemstack.m_41720_(), 20);
               }
            }
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
               }
            }

            itemstack.m_41784_().m_128347_("tex", (double)1.0F);
            itemstack.m_41784_().m_128359_("slash_color", "");
            itemstack.m_41784_().m_128379_("act", false);
         }

      }
   }
}
