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

public class SwordCursedSpiritObliterationItem extends SwordItem {
   public SwordCursedSpiritObliterationItem() {
      super(new Tier() {
         public int m_6609_() {
            return 0;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 1.0E9F;
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
      }, 3, -2.0F, new Item.Properties());
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237113_("Undefined Cursed Tool"));
      list.add(Component.m_237113_("For debug."));
      list.add(Component.m_237113_("§4:)"));
   }
}
