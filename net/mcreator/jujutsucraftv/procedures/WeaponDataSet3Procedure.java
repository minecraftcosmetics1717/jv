package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WeaponDataSet3Procedure {
   private static final ThreadLocal<Boolean> RUNNING = ThreadLocal.withInitial(() -> false);
   private static final String INIT_KEY = "jjcv_weapon_data_initialized";

   public static void execute(ItemStack itemstack) {
      if (itemstack != null && !itemstack.m_41619_()) {
         if (!(Boolean)RUNNING.get()) {
            ResourceLocation itemId = BuiltInRegistries.f_257033_.m_7981_(itemstack.m_41720_());
            if (itemId != null) {
               if ("jujutsucraftv".equals(itemId.m_135827_())) {
                  CompoundTag tag = itemstack.m_41783_();
                  if (tag == null || !tag.m_128471_("jjcv_weapon_data_initialized")) {
                     try {
                        RUNNING.set(true);
                        WeaponDataSetProcedure.execute(itemstack);
                        WeaponDataDisplayUpdateProcedure.execute(itemstack);
                        itemstack.m_41784_().m_128379_("jjcv_weapon_data_initialized", true);
                     } catch (Throwable var7) {
                     } finally {
                        RUNNING.set(false);
                     }

                  }
               }
            }
         }
      }
   }
}
