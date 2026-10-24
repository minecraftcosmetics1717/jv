package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class WeaponDataSetProcedure {
   public static void execute(ItemStack itemstack) {
      ItemStack item_a = ItemStack.f_41583_;
      ArmorDataSetProcedure.execute(itemstack);
      if (itemstack.m_41720_() == JujutsucraftvModItems.FOUNDATION_STONE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)1.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_CURSED_SPIRIT_OBLITERATION.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)-999999.0F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_red");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DX_NICHIRIN_SWORD.get()) {
         itemstack.m_41784_().m_128347_("Range", -0.15);
         itemstack.m_41784_().m_128359_("slash_color", "slash_blue2");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KNIFE_BAYER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)1.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", -0.15);
         itemstack.m_41784_().m_128347_("Knockback", -0.3);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.OLD_HAMMER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_KUKURU.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)2.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NO_INSCRIPTION_SWORD.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)10.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", (double)1.0F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_chain");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)10.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Range", (double)1.25F);
         itemstack.m_41784_().m_128347_("Reach", (double)1.0F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_chain");
      }

      if (itemstack.m_41720_() == Blocks.f_50184_.m_5456_()) {
         itemstack.m_41784_().m_128359_("slash_color", "slash_chain");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.VIBRASLAP.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.ELECTRIC_GUITAR.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NIGHT_OF_FIRE_ART.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KNIFE_YUKI.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", -0.15);
         itemstack.m_41784_().m_128347_("Knockback", -0.3);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.IRON_GREAT_SWORD.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.AKURO_O_OTAKE_AXE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", 0.3);
         itemstack.m_41784_().m_128347_("Knockback", 0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_SAMURAI_IN_ARMOR.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Reach", 0.45);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NANAMI_NECKTIE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Knockback", 0.3);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.MEAT_HAMMER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
         itemstack.m_41784_().m_128347_("Power", 0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.WOODEN_TONFA.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NANAKO_SMARTPHONE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)1.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.MIMIKO_DOLL.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NAGINATA_KUKURU.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)2.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", (double)0.25F);
         itemstack.m_41784_().m_128347_("Range", (double)0.25F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KNIFE_KUKURU.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)2.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", -0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KUMIYA_AXE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)6.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_NOBUAKI.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)4.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)10.0F);
         itemstack.m_41784_().m_128347_("Power", -0.15);
         itemstack.m_41784_().m_128359_("slash_color", "slash_red");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_WHITE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.OSUKI_AXE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)6.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", 0.15);
         itemstack.m_41784_().m_128347_("cool_time", (double)200.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_MARURU.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)6.0F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_white");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SWORD_CROSS.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)6.0F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_white");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.VIRIDIAN_SWAY.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)10.0F);
         itemstack.m_41784_().m_128347_("Range", 0.15);
         itemstack.m_41784_().m_128359_("slash_color", "slash_green");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.YAKUMARU_WEAPON.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.RINDOU_CURSED_CLOTH.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
         itemstack.m_41784_().m_128347_("Knockback", 0.1);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KUNAI.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)1.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Reach", -0.15);
         itemstack.m_41784_().m_128347_("Knockback", -0.3);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.BLOOD_SOAKED_BANDAGE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)1.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.NOIS_SEVER_SCISSORS.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128347_("Reach", (double)0.25F);
         itemstack.m_41784_().m_128347_("Knockback", 0.3);
         itemstack.m_41784_().m_128359_("slash_color", "slash_blue");
         itemstack.m_41784_().m_128347_("cool_time", (double)200.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.DEMON_SWORD_BRACELET_SUPERHUMAN_STRENGTH.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Knockback", 0.3);
         itemstack.m_41784_().m_128359_("slash_color", "slash_purple");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.CLEAVER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)2.0F);
         itemstack.m_41784_().m_128347_("Power", 0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KAKURON_CLEAVER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128347_("Range", 0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.HEAVENS_CLEAVER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)10.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.75F);
         itemstack.m_41784_().m_128347_("Range", (double)0.5F);
         itemstack.m_41784_().m_128347_("Reach", (double)0.25F);
         itemstack.m_41784_().m_128347_("Knockback", (double)0.5F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_purple");
         itemstack.m_41784_().m_128347_("cool_time", (double)300.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.KNIFE_RIPPER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)3.0F);
         itemstack.m_41784_().m_128347_("Power", 0.3);
         itemstack.m_41784_().m_128347_("Reach", -0.15);
         itemstack.m_41784_().m_128347_("Knockback", -0.3);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.STEEL_GAUNTLET.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128347_("Knockback", 0.15);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.SOLID_GOLD_SWORD.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128347_("Range", 0.3);
         itemstack.m_41784_().m_128347_("Reach", 0.3);
         itemstack.m_41784_().m_128359_("slash_color", "slash_glow_yellow");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.LAVA_BATTLEAXE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)8.0F);
         itemstack.m_41784_().m_128347_("Power", 0.6);
         itemstack.m_41784_().m_128347_("Range", (double)0.5F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_flame");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.LAVA_BATTLEAXE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)8.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_flame");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.FORGED_IRON_SWORD.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)8.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.25F);
         itemstack.m_41784_().m_128359_("slash_color", "slash_flame");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.CURSE_POWER_SABER.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Power", 0.3);
         itemstack.m_41784_().m_128347_("Range", 0.3);
         itemstack.m_41784_().m_128347_("tex", (double)1.0F);
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.RIPPING_BLADE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)5.0F);
         itemstack.m_41784_().m_128347_("Range", 0.4);
         itemstack.m_41784_().m_128359_("slash_color", "slash_red");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.BLACK_KNIFE.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)8.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128347_("Range", 0.6);
         itemstack.m_41784_().m_128359_("slash_color", "slash_black");
      }

      if (itemstack.m_41720_() == JujutsucraftvModItems.ROZETSU_HAND.get()) {
         itemstack.m_41784_().m_128347_("CursePower", (double)7.0F);
         itemstack.m_41784_().m_128347_("Power", (double)0.5F);
         itemstack.m_41784_().m_128347_("Range", 0.3);
      }

   }
}
