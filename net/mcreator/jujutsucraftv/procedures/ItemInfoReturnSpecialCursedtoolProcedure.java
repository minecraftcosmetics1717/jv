package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ItemInfoReturnSpecialCursedtoolProcedure {
   public static String execute(ItemStack itemstack) {
      String txt = "";
      if (itemstack.m_41720_() == JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get()) {
         String var10000 = Component.m_237115_("jjcv.item.special_cursedtool").getString();
         txt = var10000 + "\n" + Component.m_237115_("jjcv.item.playful_cloud.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get()) {
         String var3 = Component.m_237115_("item.jujutsucraftv.chain_of_a_thousand_miles.description_0").getString();
         txt = var3 + "\n" + Component.m_237115_("item.jujutsucraftv.chain_of_a_thousand_miles.description_1").getString() + "\n" + Component.m_237115_("item.jujutsucraftv.chain_of_a_thousand_miles.description_2").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get()) {
         String var4 = Component.m_237115_("item.jujutsucraftv.combined_chain_of_a_thousand_miles_and_inverted_spear_of_heaven.description_0").getString();
         txt = var4 + "\n" + Component.m_237115_("item.jujutsucraftv.combined_chain_of_a_thousand_miles_and_inverted_spear_of_heaven.description_1").getString() + "\n" + Component.m_237115_("item.jujutsucraftv.combined_chain_of_a_thousand_miles_and_inverted_spear_of_heaven.description_2").getString() + "\n" + Component.m_237115_("item.jujutsucraftv.combined_chain_of_a_thousand_miles_and_inverted_spear_of_heaven.description_3").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.VIRIDIAN_SWAY.get()) {
         String var5 = Component.m_237115_("jjcv.item.special_cursedtool").getString();
         txt = var5 + "\n" + Component.m_237115_("item.jujutsucraftv.viridian_sway.description_0").getString();
      } else if (itemstack.m_41720_() == ((Block)JujutsucraftvModBlocks.NOSTALGIST_HAND.get()).m_5456_()) {
         String var6 = Component.m_237115_("jjcv.item.cursed_object").getString();
         txt = var6 + "\n" + Component.m_237115_("item.jujutsucraftv.nostalgist_arm.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.HEAVENS_CLEAVER.get()) {
         String var7 = Component.m_237115_("jjcv.item.special_cursedtool").getString();
         txt = var7 + "\n" + Component.m_237115_("item.jujutsucraftv.heaven_cleaver.description_0").getString() + "\n" + Component.m_237115_("item.jujutsucraftv.heaven_cleaver.description_1").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_1.get()) {
         txt = Component.m_237115_("item.jujutsucraftv.cursed_object_box_1.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_2.get()) {
         txt = Component.m_237115_("item.jujutsucraftv.cursed_object_box_1.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_3.get()) {
         txt = Component.m_237115_("item.jujutsucraftv.cursed_object_box_1.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_TOOL_BOX_1.get()) {
         txt = Component.m_237115_("item.jujutsucraftv.cursed_tool_box_1.description_0").getString();
      } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_TOOL_BOX_2.get()) {
         txt = Component.m_237115_("item.jujutsucraftv.cursed_tool_box_2.description_0").getString();
      } else {
         txt = Component.m_237115_("jjcv.item.special_cursedtool").getString();
      }

      return txt;
   }
}
