package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ReturnTxtDrinkProcedure {
   public static String execute(ItemStack itemstack) {
      String txt = "";
      if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_1.get()) {
         String var10000 = Component.m_237115_("jjcv.item.drink_1_des").getString();
         txt = var10000 + "\n" + Component.m_237115_("jjcv.item.drink.cursepower_heal").getString() + "100";
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_2.get()) {
         String var2 = Component.m_237115_("jjcv.item.drink_2_des").getString();
         txt = var2 + "\n" + Component.m_237115_("jjcv.item.drink.cursepower_heal").getString() + "200";
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_3.get()) {
         String var3 = Component.m_237115_("jjcv.item.drink_3_des").getString();
         txt = var3 + "\n" + Component.m_237115_("jjcv.item.drink.cursepower_heal").getString() + "200\n" + Component.m_237115_("jjcv.item.drink.health_heal").getString() + "6";
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_4.get()) {
         String var4 = Component.m_237115_("jjcv.item.drink_4_des").getString();
         txt = var4 + "\n" + Component.m_237115_("jjcv.item.drink.cursepower_heal").getString() + "1000";
      }

      return txt;
   }
}
