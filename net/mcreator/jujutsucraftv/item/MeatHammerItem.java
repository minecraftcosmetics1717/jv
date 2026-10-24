package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnCursedtoolProcedure;
import net.mcreator.jujutsucraftv.procedures.OldHammerRightClickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class MeatHammerItem extends PickaxeItem {
   public MeatHammerItem() {
      super(new Tier() {
         public int m_6609_() {
            return 1200;
         }

         public float m_6624_() {
            return 6.0F;
         }

         public float m_6631_() {
            return 3.0F;
         }

         public int m_6604_() {
            return 2;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 1, -3.0F, new Item.Properties());
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      OldHammerRightClickProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ItemInfoReturnCursedtoolProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
