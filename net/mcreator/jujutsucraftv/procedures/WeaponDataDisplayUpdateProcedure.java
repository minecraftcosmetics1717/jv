package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class WeaponDataDisplayUpdateProcedure {
   public static final String DISPLAY_CURSE_POWER = "jjcv_display_CursePower";
   public static final String DISPLAY_POWER = "jjcv_display_Power";
   public static final String DISPLAY_REACH = "jjcv_display_Reach";
   public static final String DISPLAY_RANGE = "jjcv_display_Range";
   public static final String DISPLAY_KNOCKBACK = "jjcv_display_Knockback";
   public static final String DISPLAY_C_POWER = "jjcv_display_C_Power";
   public static final String DISPLAY_POWER_ENERGY = "jjcv_display_power_energy";
   public static final String DISPLAY_UPDATED = "jjcv_weapon_display_updated";

   public static void execute(ItemStack itemstack) {
      if (itemstack != null && !itemstack.m_41619_()) {
         CompoundTag tag = itemstack.m_41783_();
         if (tag != null) {
            copyDouble(tag, "CursePower", "jjcv_display_CursePower");
            copyDouble(tag, "Power", "jjcv_display_Power");
            copyDouble(tag, "Reach", "jjcv_display_Reach");
            copyDouble(tag, "Range", "jjcv_display_Range");
            copyDouble(tag, "Knockback", "jjcv_display_Knockback");
            copyDouble(tag, "C_Power", "jjcv_display_C_Power");
            copyDouble(tag, "power_energy", "jjcv_display_power_energy");
            tag.m_128379_("jjcv_weapon_display_updated", true);
         }
      }
   }

   private static void copyDouble(CompoundTag tag, String fromKey, String toKey) {
      if (tag.m_128441_(fromKey)) {
         tag.m_128347_(toKey, tag.m_128459_(fromKey));
      } else {
         tag.m_128473_(toKey);
      }

   }
}
