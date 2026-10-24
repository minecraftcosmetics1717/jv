package net.mcreator.jujutsucraftv.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CheckHaveItemProcedure {
   public static boolean execute(LevelAccessor world, Entity entity, ItemStack item) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_b = false;
         logic_b = false;
         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var10000.ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
               if (itemstackiterator.m_41720_() == item.m_41720_()) {
                  logic_b = true;
                  break;
               }
            }
         }

         return logic_b;
      }
   }
}
