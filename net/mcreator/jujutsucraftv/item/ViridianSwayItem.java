package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.mcreator.jujutsucraftv.procedures.CursedToolUseProcedure;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnSpecialCursedtoolProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class ViridianSwayItem extends SwordItem {
   public ViridianSwayItem() {
      super(new Tier() {
         public int m_6609_() {
            return 1200;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 2.0F;
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
      }, 3, -2.2F, new Item.Properties());
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      CursedToolUseProcedure.execute(entity);
      return ar;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ItemInfoReturnSpecialCursedtoolProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
