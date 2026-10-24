package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueStarterGuiMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class UseCursedTechniqueStarterProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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

         if (var10000.m_41720_() == JujutsucraftvModItems.CURSED_TECHNIQUE_STARTER.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41784_().m_128459_("selected_item") > (double)0.0F) {
               if (!(entity.getPersistentData().m_128459_("use_item") > (double)0.0F)) {
                  if (!GetCanUseTechniqueProcedure.execute(entity)) {
                     double var39 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     cost_a = var39 - var10001.m_41784_().m_128459_("cost");
                     if (!(cost_a > (double)0.0F) && !GetPhysicalGiftedEffectProcedure.execute(entity)) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("use_item", (double)1.0F);
                        CompoundTag var40 = entity.getPersistentData();
                        ItemStack var10002;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.m_21205_();
                        } else {
                           var10002 = ItemStack.f_41583_;
                        }

                        var40.m_128347_("skill", var10002.m_41784_().m_128459_("skill"));
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique 2000 0 true");
                        }

                        ItemStack var41;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var41 = _livEnt.m_21205_();
                        } else {
                           var41 = ItemStack.f_41583_;
                        }

                        cost = var41.m_41784_().m_128459_("cost") * (double)-1.0F;
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
            } else if (((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity) && entity instanceof ServerPlayer) {
               ServerPlayer _ent = (ServerPlayer)entity;
               final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
               NetworkHooks.openScreen(_ent, new MenuProvider() {
                  public Component m_5446_() {
                     return Component.m_237113_("CursedTechniqueStarterGui");
                  }

                  public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                     return new CursedTechniqueStarterGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
                  }
               }, _bpos);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftvModItems.CURSED_TECHNIQUE_STARTER.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41784_().m_128459_("selected_item") > (double)0.0F) {
                  if (!(entity.getPersistentData().m_128459_("use_item") > (double)0.0F)) {
                     if (!GetCanUseTechniqueProcedure.execute(entity)) {
                        double var45 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
                        ItemStack var49;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var49 = _livEnt.m_21206_();
                        } else {
                           var49 = ItemStack.f_41583_;
                        }

                        cost_a = var45 - var49.m_41784_().m_128459_("cost");
                        if (!(cost_a > (double)0.0F) && !GetPhysicalGiftedEffectProcedure.execute(entity)) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
                              }
                           }
                        } else {
                           entity.getPersistentData().m_128347_("use_item", (double)1.0F);
                           CompoundTag var46 = entity.getPersistentData();
                           ItemStack var50;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var50 = _livEnt.m_21206_();
                           } else {
                              var50 = ItemStack.f_41583_;
                           }

                           var46.m_128347_("skill", var50.m_41784_().m_128459_("skill"));
                           entity.getPersistentData().m_128379_("PRESS_Z", true);
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique 2000 0 true");
                           }

                           ItemStack var47;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var47 = _livEnt.m_21206_();
                           } else {
                              var47 = ItemStack.f_41583_;
                           }

                           cost = var47.m_41784_().m_128459_("cost") * (double)-1.0F;
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
               } else if (((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity) && entity instanceof ServerPlayer) {
                  ServerPlayer _ent = (ServerPlayer)entity;
                  final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
                  NetworkHooks.openScreen(_ent, new MenuProvider() {
                     public Component m_5446_() {
                        return Component.m_237113_("CursedTechniqueStarterGui");
                     }

                     public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                        return new CursedTechniqueStarterGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
                     }
                  }, _bpos);
               }
            }
         }

      }
   }
}
