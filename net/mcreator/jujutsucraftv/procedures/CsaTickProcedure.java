package net.mcreator.jujutsucraftv.procedures;

import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import top.theillusivec4.curios.api.CuriosApi;

public class CsaTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity lv = (LivingEntity)entity;
            CuriosApi.getCuriosHelper().findCurios(lv, (Item)JujutsucraftvModItems.TRAINED_CURSED_SPIRIT_ARMORY.get()).forEach((item) -> {
               ItemStack itemstackiterator;
               ItemStack var10000;
               label201: {
                  itemstackiterator = item.stack();
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt1135$temp = _plrSlotItem.f_36096_;
                     if (patt1135$temp instanceof Supplier _splr) {
                        Object patt1176$temp = _splr.get();
                        if (patt1176$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(0)).m_7993_();
                           break label201;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               ItemStack _setstack;
               ItemStack var10001;
               label195: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 0;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt1378$temp = _plrSlotItem.f_36096_;
                     if (patt1378$temp instanceof Supplier _splr) {
                        Object patt1419$temp = _splr.get();
                        if (patt1419$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(0)).m_7993_();
                           break label195;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label189: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(0, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt1917$temp = _plrSlotItem.f_36096_;
                     if (patt1917$temp instanceof Supplier _splr) {
                        Object patt1958$temp = _splr.get();
                        if (patt1958$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(1)).m_7993_();
                           break label189;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label183: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 1;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt2160$temp = _plrSlotItem.f_36096_;
                     if (patt2160$temp instanceof Supplier _splr) {
                        Object patt2201$temp = _splr.get();
                        if (patt2201$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(1)).m_7993_();
                           break label183;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label177: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(1, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt2699$temp = _plrSlotItem.f_36096_;
                     if (patt2699$temp instanceof Supplier _splr) {
                        Object patt2740$temp = _splr.get();
                        if (patt2740$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(2)).m_7993_();
                           break label177;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label171: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 2;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt2942$temp = _plrSlotItem.f_36096_;
                     if (patt2942$temp instanceof Supplier _splr) {
                        Object patt2983$temp = _splr.get();
                        if (patt2983$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(2)).m_7993_();
                           break label171;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label165: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(2, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt3481$temp = _plrSlotItem.f_36096_;
                     if (patt3481$temp instanceof Supplier _splr) {
                        Object patt3522$temp = _splr.get();
                        if (patt3522$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(3)).m_7993_();
                           break label165;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label159: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 3;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt3724$temp = _plrSlotItem.f_36096_;
                     if (patt3724$temp instanceof Supplier _splr) {
                        Object patt3765$temp = _splr.get();
                        if (patt3765$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(3)).m_7993_();
                           break label159;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label153: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(3, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt4263$temp = _plrSlotItem.f_36096_;
                     if (patt4263$temp instanceof Supplier _splr) {
                        Object patt4304$temp = _splr.get();
                        if (patt4304$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(4)).m_7993_();
                           break label153;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label147: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 4;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt4506$temp = _plrSlotItem.f_36096_;
                     if (patt4506$temp instanceof Supplier _splr) {
                        Object patt4547$temp = _splr.get();
                        if (patt4547$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(4)).m_7993_();
                           break label147;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label141: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(4, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt5045$temp = _plrSlotItem.f_36096_;
                     if (patt5045$temp instanceof Supplier _splr) {
                        Object patt5086$temp = _splr.get();
                        if (patt5086$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(5)).m_7993_();
                           break label141;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label135: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 5;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt5288$temp = _plrSlotItem.f_36096_;
                     if (patt5288$temp instanceof Supplier _splr) {
                        Object patt5329$temp = _splr.get();
                        if (patt5329$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(5)).m_7993_();
                           break label135;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label129: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(5, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt5827$temp = _plrSlotItem.f_36096_;
                     if (patt5827$temp instanceof Supplier _splr) {
                        Object patt5868$temp = _splr.get();
                        if (patt5868$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(6)).m_7993_();
                           break label129;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label123: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 6;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt6070$temp = _plrSlotItem.f_36096_;
                     if (patt6070$temp instanceof Supplier _splr) {
                        Object patt6111$temp = _splr.get();
                        if (patt6111$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(6)).m_7993_();
                           break label123;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label117: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(6, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt6609$temp = _plrSlotItem.f_36096_;
                     if (patt6609$temp instanceof Supplier _splr) {
                        Object patt6650$temp = _splr.get();
                        if (patt6650$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(7)).m_7993_();
                           break label117;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label111: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 7;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt6852$temp = _plrSlotItem.f_36096_;
                     if (patt6852$temp instanceof Supplier _splr) {
                        Object patt6893$temp = _splr.get();
                        if (patt6893$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(7)).m_7993_();
                           break label111;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               label105: {
                  _setstack.m_41764_(var10001.m_41613_());
                  itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                        itemHandlerModifiable.setStackInSlot(7, _setstack);
                     }

                  });
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt7391$temp = _plrSlotItem.f_36096_;
                     if (patt7391$temp instanceof Supplier _splr) {
                        Object patt7432$temp = _splr.get();
                        if (patt7432$temp instanceof Map _slt) {
                           var10000 = ((Slot)_slt.get(8)).m_7993_();
                           break label105;
                        }
                     }
                  }

                  var10000 = ItemStack.f_41583_;
               }

               label99: {
                  _setstack = var10000.m_41777_();
                  int _sltid = 8;
                  if (entity instanceof Player _plrSlotItem) {
                     AbstractContainerMenu patt7634$temp = _plrSlotItem.f_36096_;
                     if (patt7634$temp instanceof Supplier _splr) {
                        Object patt7675$temp = _splr.get();
                        if (patt7675$temp instanceof Map _slt) {
                           var10001 = ((Slot)_slt.get(8)).m_7993_();
                           break label99;
                        }
                     }
                  }

                  var10001 = ItemStack.f_41583_;
               }

               _setstack.m_41764_(var10001.m_41613_());
               itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                     itemHandlerModifiable.setStackInSlot(8, _setstack);
                  }

               });
            });
         }

      }
   }
}
