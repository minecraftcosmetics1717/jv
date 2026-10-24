package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CursePowerColorChangerGuiSelectProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         double num1 = (double)0.0F;
         num1 = ((<undefinedtype>)(new Object() {
            double convert(String s) {
               try {
                  return Double.parseDouble(s.trim());
               } catch (Exception var3) {
                  return (double)0.0F;
               }
            }
         })).convert(guistate.containsKey("textin:select_curse_color") ? (String)guistate.get("textin:select_curse_color") : "");
         if (num1 > (double)0.0F && num1 < (double)28.0F) {
            if (num1 != (double)12.0F) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjcv entity_data set_player_particle_color @s " + num1);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                  }
               }

               for(int index0 = 0; index0 < 5; ++index0) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~1 ~ 0.5 0.5 0.5 0.05 3");
                  }
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
               })).checkGamemode(entity) && entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftvModItems.CURSE_POWER_COLOR_CHANGER.get());
                  _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_select_color_12").getString()), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_select_color").getString()), true);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

      }
   }
}
