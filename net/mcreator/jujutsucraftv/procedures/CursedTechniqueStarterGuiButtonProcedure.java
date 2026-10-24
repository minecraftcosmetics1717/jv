package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedTechniqueStarterGuiButtonProcedure {
   public static void execute(Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         double skill = (double)0.0F;
         double cost = (double)0.0F;
         skill = ((<undefinedtype>)(new Object() {
            double convert(String s) {
               try {
                  return Double.parseDouble(s.trim());
               } catch (Exception var3) {
                  return (double)0.0F;
               }
            }
         })).convert(guistate.containsKey("textin:skill_number") ? (String)guistate.get("textin:skill_number") : "");
         cost = ((<undefinedtype>)(new Object() {
            double convert(String s) {
               try {
                  return Double.parseDouble(s.trim());
               } catch (Exception var3) {
                  return (double)0.0F;
               }
            }
         })).convert(guistate.containsKey("textin:cost") ? (String)guistate.get("textin:cost") : "");
         if (entity instanceof LivingEntity) {
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

               var10000.m_41784_().m_128347_("skill", skill);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("cost", cost);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("selected_item", (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41784_().m_128459_("selected_item") > (double)0.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21205_();
                  } else {
                     var10001 = ItemStack.f_41583_;
                  }

                  double var37 = var10001.m_41784_().m_128459_("skill");
                  ItemStack var10002;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.m_21205_();
                  } else {
                     var10002 = ItemStack.f_41583_;
                  }

                  var10000.m_41714_(Component.m_237113_("§5 skill:" + var37 + " cost:" + var10002.m_41784_().m_128459_("cost")));
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_6915_();
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

                  var10000.m_41784_().m_128347_("skill", skill);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("cost", cost);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("selected_item", (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41784_().m_128459_("selected_item") > (double)0.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack var38;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var38 = _livEnt.m_21206_();
                     } else {
                        var38 = ItemStack.f_41583_;
                     }

                     double var39 = var38.m_41784_().m_128459_("skill");
                     ItemStack var40;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var40 = _livEnt.m_21206_();
                     } else {
                        var40 = ItemStack.f_41583_;
                     }

                     var10000.m_41714_(Component.m_237113_("§5 skill:" + var39 + " cost:" + var40.m_41784_().m_128459_("cost")));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_6915_();
                  }
               }
            }
         }

      }
   }
}
