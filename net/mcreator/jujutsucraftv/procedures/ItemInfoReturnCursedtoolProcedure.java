package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ItemInfoReturnCursedtoolProcedure {
   public static String execute(ItemStack itemstack) {
      String txt = "";
      if (itemstack.m_41720_() != JujutsucraftvModItems.LAVA_BATTLEAXE.get() && itemstack.m_41720_() != JujutsucraftvModItems.FORGED_IRON_SWORD.get()) {
         if (itemstack.m_41720_() == JujutsucraftvModItems.CURSE_POWER_SABER.get()) {
            String var3 = Component.m_237115_("jjcv.item.cursedtool").getString();
            txt = var3 + "\n" + Component.m_237115_("item.jujutsucraftv.curse_power_saber.description_0").getString() + "\n" + Component.m_237115_("item.jujutsucraftv.curse_power_saber.description_1").getString();
         } else if (itemstack.m_41720_() == JujutsucraftvModItems.NOIS_SEVER_SCISSORS.get()) {
            String var4 = Component.m_237115_("jjcv.item.cursedtool").getString();
            txt = var4 + "\n" + Component.m_237115_("item.jujutsucraftv.nois_sever_scissors.description_0").getString();
         } else if (itemstack.m_41720_() == JujutsucraftvModItems.OSUKI_AXE.get()) {
            String var5 = Component.m_237115_("jjcv.item.cursedtool").getString();
            txt = var5 + "\n" + Component.m_237115_("item.jujutsucraftv.osuki_axe.description_0").getString();
         } else {
            txt = Component.m_237115_("jjcv.item.cursedtool").getString();
         }
      } else {
         String var10000 = Component.m_237115_("jjcv.item.otherdimention").getString();
         txt = "§c" + var10000 + Component.m_237115_("jjcv.item.cursedtool").getString();
      }

      return txt;
   }
}
