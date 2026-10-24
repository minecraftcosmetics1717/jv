package net.mcreator.jujutsucraftv.item;

import java.awt.Color;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ItemUseAdbancementProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMasterRainbowEyeItem extends Item {
   public ItemMasterRainbowEyeItem() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.EPIC));
   }

   public Component m_7626_(ItemStack itemstack) {
      return this.itemnameanimation$animate(super.m_7626_(itemstack));
   }

   private Component itemnameanimation$animate(Component original) {
      String text = original.getString();
      if (text.isEmpty()) {
         return original;
      } else {
         double time = (double)System.nanoTime() * 1.0E-9 * (double)2.0F;
         double strength = Math.max(0.1, Math.min((double)3.0F, (double)1.0F));
         MutableComponent result = Component.m_237119_();

         for(int index = 0; index < text.length(); ++index) {
            char character = text.charAt(index);
            int rgb = itemnameanimation$color(index, text.length(), time, strength);
            Style style = original.m_7383_().m_131148_(TextColor.m_131266_(rgb));
            result.m_7220_(Component.m_237113_(String.valueOf(character)).m_6270_(style));
         }

         return result;
      }
   }

   private static int itemnameanimation$color(int index, int length, double time, double strength) {
      float hue = (float)(((double)index / (double)Math.max(1, length) + time * 0.16) % (double)1.0F);
      return Color.HSBtoRGB(hue, (float)Math.min((double)1.0F, 0.7 * strength), 1.0F) & 16777215;
   }

   private static int itemnameanimation$mix(int first, int second, double amount) {
      amount = Math.max((double)0.0F, Math.min((double)1.0F, amount));
      int red = (int)((double)(first >> 16 & 255) * ((double)1.0F - amount) + (double)(second >> 16 & 255) * amount);
      int green = (int)((double)(first >> 8 & 255) * ((double)1.0F - amount) + (double)(second >> 8 & 255) * amount);
      int blue = (int)((double)(first & 255) * ((double)1.0F - amount) + (double)(second & 255) * amount);
      return red << 16 | green << 8 | blue;
   }

   private static int itemnameanimation$brightness(int color, double brightness) {
      brightness = Math.max((double)0.0F, Math.min((double)1.0F, brightness));
      int red = (int)((double)(color >> 16 & 255) * brightness);
      int green = (int)((double)(color >> 8 & 255) * brightness);
      int blue = (int)((double)(color & 255) * brightness);
      return red << 16 | green << 8 | blue;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean m_5812_(ItemStack itemstack) {
      return true;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.item_master_rainbow_eye.description_0"));
      list.add(Component.m_237115_("item.jujutsucraftv.item_master_rainbow_eye.description_1"));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      ItemUseAdbancementProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }
}
