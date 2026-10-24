package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class DxNichirinSwordItem extends SwordItem {
   public DxNichirinSwordItem() {
      super(new Tier() {
         public int m_6609_() {
            return 100;
         }

         public float m_6624_() {
            return 0.0F;
         }

         public float m_6631_() {
            return -1.0F;
         }

         public int m_6604_() {
            return 0;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 3, -3.0F, new Item.Properties());
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.dx_nichirin_sword.description_0"));
   }
}
