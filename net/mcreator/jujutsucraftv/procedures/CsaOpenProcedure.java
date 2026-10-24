package net.mcreator.jujutsucraftv.procedures;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
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
import top.theillusivec4.curios.api.CuriosApi;

public class CsaOpenProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity lv = (LivingEntity)entity;
            CuriosApi.getCuriosHelper().findCurios(lv, (Item)JujutsucraftvModItems.TRAINED_CURSED_SPIRIT_ARMORY.get()).forEach((item) -> {
               ItemStack itemstackiterator = item.stack();
               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt1046$temp = _player.f_36096_;
                  if (patt1046$temp instanceof Supplier _current) {
                     Object patt1093$temp = _current.get();
                     if (patt1093$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(0, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(0, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(0)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt2191$temp = _player.f_36096_;
                  if (patt2191$temp instanceof Supplier _current) {
                     Object patt2238$temp = _current.get();
                     if (patt2238$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(1, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(1, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(1)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt3336$temp = _player.f_36096_;
                  if (patt3336$temp instanceof Supplier _current) {
                     Object patt3383$temp = _current.get();
                     if (patt3383$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(2, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(2, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(2)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt4481$temp = _player.f_36096_;
                  if (patt4481$temp instanceof Supplier _current) {
                     Object patt4528$temp = _current.get();
                     if (patt4528$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(3, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(3, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(3)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt5626$temp = _player.f_36096_;
                  if (patt5626$temp instanceof Supplier _current) {
                     Object patt5673$temp = _current.get();
                     if (patt5673$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(4, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(4, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(4)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt6771$temp = _player.f_36096_;
                  if (patt6771$temp instanceof Supplier _current) {
                     Object patt6818$temp = _current.get();
                     if (patt6818$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(5, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(5, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(5)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt7916$temp = _player.f_36096_;
                  if (patt7916$temp instanceof Supplier _current) {
                     Object patt7963$temp = _current.get();
                     if (patt7963$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(6, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(6, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(6)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt9061$temp = _player.f_36096_;
                  if (patt9061$temp instanceof Supplier _current) {
                     Object patt9108$temp = _current.get();
                     if (patt9108$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(7, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(7, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(7)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               if (entity instanceof Player _player) {
                  AbstractContainerMenu patt10206$temp = _player.f_36096_;
                  if (patt10206$temp instanceof Supplier _current) {
                     Object patt10253$temp = _current.get();
                     if (patt10253$temp instanceof Map _slots) {
                        ItemStack _setstack = ((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(8, itemstackiterator).m_41777_();
                        _setstack.m_41764_(((<undefinedtype>)(new Object() {
                           public ItemStack getItemStack(int sltid, ItemStack _isc) {
                              AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                              _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                              return (ItemStack)_retval.get();
                           }
                        })).getItemStack(8, itemstackiterator).m_41613_());
                        ((Slot)_slots.get(8)).m_5852_(_setstack);
                        _player.f_36096_.m_38946_();
                     }
                  }
               }

               entity.getPersistentData().m_128347_("csa_change_count", (double)0.0F);
            });
         }

      }
   }
}
