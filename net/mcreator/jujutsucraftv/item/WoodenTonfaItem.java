package net.mcreator.jujutsucraftv.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class WoodenTonfaItem extends PickaxeItem {
   public WoodenTonfaItem() {
      super(new Tier() {
         public int m_6609_() {
            return 1500;
         }

         public float m_6624_() {
            return 2.0F;
         }

         public float m_6631_() {
            return 0.0F;
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
      }, 1, -2.4F, new Item.Properties());
   }
}
