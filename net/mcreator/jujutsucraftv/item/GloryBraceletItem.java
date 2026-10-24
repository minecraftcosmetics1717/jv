package net.mcreator.jujutsucraftv.item;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ReturnTalisimanTxtProcedure;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class GloryBraceletItem extends Item implements ICurioItem {
   private static final String CURIO_EQUIPPED_ATTRIBUTES = "";

   public GloryBraceletItem() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.UNCOMMON));
   }

   public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
      List<Component> result = new ArrayList(tooltips);
      if (result.isEmpty() && "".isBlank()) {
         return result;
      } else {
         Component title = Component.m_237115_("item.jujutsucraftv.glory_bracelet.curio_equipped").m_130940_(ChatFormatting.GRAY);
         if (result.isEmpty()) {
            result.add(title);
         } else {
            result.set(0, title);
         }

         return result;
      }
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ReturnTalisimanTxtProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
