package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ReturnTalisimanTxtProcedure {
   public static String execute(ItemStack itemstack) {
      String txt = "";
      if (itemstack.m_41720_() == JujutsucraftvModItems.REGENERATION_ROSARY.get()) {
         String var10000 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var10000 + "\n\n" + Component.m_237115_("jjcv.talis.when_equiped").getString() + "\n" + Component.m_237115_("jjcv.talis.rosary_regeneration").getString() + "\n" + Component.m_237115_("jjcv.talis.effect_not_stack").getString();
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NIGHT_VISION_ROSARY.get()) {
         String var2 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var2 + "\n\n" + Component.m_237115_("jjcv.talis.when_equiped").getString() + "\n" + Component.m_237115_("jjcv.talis.rosary_nightvision").getString() + "\n" + Component.m_237115_("jjcv.talis.effect_not_stack").getString();
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DEEP_SEA_ROSARY.get()) {
         String var3 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var3 + "\n\n" + Component.m_237115_("jjcv.talis.when_equiped").getString() + "\n" + Component.m_237115_("jjcv.talis.rosary_deepsea").getString() + "\n" + Component.m_237115_("jjcv.talis.effect_not_stack").getString();
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.GLORY_BRACELET.get()) {
         String var4 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var4 + "\n\n" + Component.m_237115_("jjcv.talis.when_equiped").getString() + "\n" + Component.m_237115_("jjcv.talis.bracelet_glory").getString() + "\n" + Component.m_237115_("jjcv.talis.effect_not_stack").getString();
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NANAMI_WRISTWATCH.get()) {
         String var5 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var5 + "\n" + Component.m_237115_("jjcv.talis.nanami_watch").getString();
      }

      return txt;
   }
}
