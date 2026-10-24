package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class NanamiWristwatchUseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(Boolean)(() -> {
            if (entity instanceof LivingEntity _curioEntity) {
               Item _curioItem = (Item)JujutsucraftvModItems.NANAMI_WRISTWATCH.get();
               if (_curioEntity instanceof Player _curioPlayer) {
                  if (_curioPlayer.m_36335_().m_41519_(_curioItem)) {
                     return true;
                  }
               }

               ICuriosItemHandler _curioInventory = (ICuriosItemHandler)CuriosApi.getCuriosInventory(_curioEntity).orElse((Object)null);
               if (_curioInventory == null) {
                  return false;
               } else {
                  long _curioTime = _curioEntity.m_9236_().m_46467_();

                  for(SlotResult _curioResult : _curioInventory.findCurios(_curioItem)) {
                     ItemStack _curioStack = _curioResult.stack();
                     if (_curioStack.m_41782_() && _curioStack.m_41783_().m_128454_("adornedCurioCooldownUntil") > _curioTime) {
                        return true;
                     }
                  }

                  return false;
               }
            } else {
               return false;
            }
         }).get()) {
            if (!GetPhysicalGiftedEffectProcedure.execute(entity)) {
               if (!CheckOvertimeProcedure.execute(world, entity) && !LogicCreativeProcedure.execute(entity)) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("skill", (double)1311.0F);
                  entity.getPersistentData().m_128379_("PRESS_Z", true);
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique 2000 0 true");
                  }

                  entity.getPersistentData().m_128379_("curios_watch_use", true);
                  SkillOvertimeProcedure.execute(world, x, y, z, entity);
                  if (LogicCreativeProcedure.execute(entity)) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _curioEntity = (LivingEntity)entity;
                        Item _curioItem = (Item)JujutsucraftvModItems.NANAMI_WRISTWATCH.get();
                        int _curioTicks = Math.max(0, (int)Math.floor((double)20.0F));
                        long _curioCooldownEnd = _curioEntity.m_9236_().m_46467_() + (long)_curioTicks;
                        ICuriosItemHandler _curioInventory = (ICuriosItemHandler)CuriosApi.getCuriosInventory(_curioEntity).orElse((Object)null);
                        boolean _curioEquipped = false;
                        if (_curioInventory != null) {
                           for(SlotResult _curioResult : _curioInventory.findCurios(_curioItem)) {
                              _curioEquipped = true;
                              _curioResult.stack().m_41784_().m_128356_("adornedCurioCooldownUntil", _curioCooldownEnd);
                           }
                        }

                        if (_curioEquipped && _curioEntity instanceof Player) {
                           Player _curioPlayer = (Player)_curioEntity;
                           _curioPlayer.m_36335_().m_41524_(_curioItem, _curioTicks);
                        }
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _curioEntity = (LivingEntity)entity;
                     Item _curioItem = (Item)JujutsucraftvModItems.NANAMI_WRISTWATCH.get();
                     int _curioTicks = Math.max(0, (int)Math.floor((double)6000.0F));
                     long _curioCooldownEnd = _curioEntity.m_9236_().m_46467_() + (long)_curioTicks;
                     ICuriosItemHandler _curioInventory = (ICuriosItemHandler)CuriosApi.getCuriosInventory(_curioEntity).orElse((Object)null);
                     boolean _curioEquipped = false;
                     if (_curioInventory != null) {
                        for(SlotResult _curioResult : _curioInventory.findCurios(_curioItem)) {
                           _curioEquipped = true;
                           _curioResult.stack().m_41784_().m_128356_("adornedCurioCooldownUntil", _curioCooldownEnd);
                        }
                     }

                     if (_curioEquipped && _curioEntity instanceof Player) {
                        Player _curioPlayer = (Player)_curioEntity;
                        _curioPlayer.m_36335_().m_41524_(_curioItem, _curioTicks);
                     }
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use_ct").getString()), true);
            }
         }

      }
   }
}
