package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CursedToolUseProcedure {
   @SubscribeEvent
   public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity());
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double cost = (double)0.0F;
         double cost_a = (double)0.0F;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.DEMON_SWORD_BRACELET_SUPERHUMAN_STRENGTH.get()) {
            if (!(entity.getPersistentData().m_128459_("use_item") > (double)0.0F)) {
               if (!GetCanUseTechniqueProcedure.execute(entity)) {
                  double var26 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  cost_a = var26 - var10001.m_41784_().m_128459_("cost");
                  if (!(cost_a > (double)0.0F) && !GetPhysicalGiftedEffectProcedure.execute(entity)) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("use_item", (double)1.0F);
                     CompoundTag var27 = entity.getPersistentData();
                     ItemStack var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21205_();
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     var27.m_128347_("skill", var10002.m_41784_().m_128459_("skill"));
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique 2000 0 true");
                     }

                     ItemStack var28;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var28 = _livEnt.m_21205_();
                     } else {
                        var28 = ItemStack.f_41583_;
                     }

                     cost = var28.m_41784_().m_128459_("cost") * (double)-1.0F;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjc_cursepower " + Math.round(cost) + " @s");
                     }
                  }
               } else if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                  }
               }
            } else {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               cost = var10000.m_41784_().m_128459_("cost") / (double)-20.0F;
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(cost) + " 0 true");
               }

               entity.getPersistentData().m_128347_("use_item", (double)0.0F);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftvModItems.DEMON_SWORD_BRACELET_SUPERHUMAN_STRENGTH.get()) {
               if (!(entity.getPersistentData().m_128459_("use_item") > (double)0.0F)) {
                  if (!GetCanUseTechniqueProcedure.execute(entity)) {
                     double var31 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
                     ItemStack var35;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.m_21206_();
                     } else {
                        var35 = ItemStack.f_41583_;
                     }

                     cost_a = var31 - var35.m_41784_().m_128459_("cost");
                     if (!(cost_a > (double)0.0F) && !GetPhysicalGiftedEffectProcedure.execute(entity)) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("use_item", (double)1.0F);
                        CompoundTag var32 = entity.getPersistentData();
                        ItemStack var36;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var36 = _livEnt.m_21206_();
                        } else {
                           var36 = ItemStack.f_41583_;
                        }

                        var32.m_128347_("skill", var36.m_41784_().m_128459_("skill"));
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique 2000 0 true");
                        }

                        ItemStack var33;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var33 = _livEnt.m_21206_();
                        } else {
                           var33 = ItemStack.f_41583_;
                        }

                        cost = var33.m_41784_().m_128459_("cost") * (double)-1.0F;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjc_cursepower " + Math.round(cost) + " @s");
                        }
                     }
                  } else if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  entity.f_19864_ = true;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  cost = var10000.m_41784_().m_128459_("cost") / (double)-20.0F;
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(cost) + " 0 true");
                  }

                  entity.getPersistentData().m_128347_("use_item", (double)0.0F);
               }
            }
         }

      }
   }
}
