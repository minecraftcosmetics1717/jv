package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.mcreator.jujutsucraftv.procedures.HeavenCleaverUseProcedure;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnSpecialCursedtoolProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class HeavensCleaverItem extends AxeItem {
   public HeavensCleaverItem() {
      super(new Tier() {
         public int m_6609_() {
            return 2800;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 6.0F;
         }

         public int m_6604_() {
            return 4;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 1.0F, -3.99F, new Item.Properties());
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      HeavenCleaverUseProcedure.execute(world, entity, (ItemStack)ar.m_19095_());
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
