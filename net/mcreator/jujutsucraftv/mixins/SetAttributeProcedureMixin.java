package net.mcreator.jujutsucraftv.mixins;

import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.procedures.SetAttributeMainhandProcedure;
import net.mcreator.jujutsucraft.procedures.SetAttributeProcedure;
import net.mcreator.jujutsucraftv.procedures.WeaponDataSet3Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {SetAttributeProcedure.class},
   remap = false
)
public abstract class SetAttributeProcedureMixin {
   @Overwrite
   public static void execute(ItemStack itemstack, List<Component> tooltip) {
      execute((Event)null, itemstack, tooltip);
   }

   @Overwrite
   private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
      if (tooltip != null && itemstack != null && !itemstack.m_41619_()) {
         SetAttributeMainhandProcedure.execute(itemstack);
         WeaponDataSet3Procedure.execute(itemstack);
         CompoundTag tag = itemstack.m_41783_();
         if (tag != null) {
            double curseValue = getDisplayOrNormalDouble(itemstack, "jjcv_display_CursePower", "CursePower");
            if (curseValue != (double)0.0F) {
               String color = curseValue > (double)0.0F ? "§c" : "§9";
               tooltip.add(Component.m_237113_(color + Component.m_237115_("jujutsu.overlay.curse_power").getString() + " Lv." + formatNumber(curseValue)));
            }

            addBarTooltip(tooltip, itemstack, "jjcv_display_Power", "Power", "jujutsu.overlay.weight");
            addBarTooltip(tooltip, itemstack, "jjcv_display_Reach", "Reach", "jujutsu.overlay.reach");
            addBarTooltip(tooltip, itemstack, "jjcv_display_Range", "Range", "jujutsu.overlay.range");
            addBarTooltip(tooltip, itemstack, "jjcv_display_Knockback", "Knockback", "jujutsu.overlay.knockback");
            if (isItem(itemstack, JujutsucraftModItems.HANAMI_HAND)) {
               String label = Component.m_237115_("jujutsu.overlay.curse_power").getString();
               double cPower = getDisplayOrNormalDouble(itemstack, "jjcv_display_C_Power", "C_Power");
               tooltip.add(Component.m_237113_("§c" + label + ": " + Math.round(Math.ceil(Math.sqrt(cPower)))));
            }

            if (isItem(itemstack, JujutsucraftModItems.DRAGON_BONE)) {
               double energy = getDisplayOrNormalDouble(itemstack, "jjcv_display_power_energy", "power_energy");
               String color = energy >= (double)5.0F ? "§9" : "§7";
               tooltip.add(Component.m_237113_(color + "Energy: " + Math.round(energy)));
            }

         }
      }
   }

   private static void addBarTooltip(List<Component> tooltip, ItemStack itemstack, String displayKey, String normalKey, String translationKey) {
      double value = getDisplayOrNormalDouble(itemstack, displayKey, normalKey);
      if (value != (double)0.0F) {
         double num2 = value * (double)4.0F;
         String color = num2 > (double)0.0F ? "§9" : "§c";
         String str = color;
         double num1 = (double)-4.0F;

         for(int index = 0; index < 9; ++index) {
            if (num1 >= num2) {
               str = str + "§r§8";
            }

            str = str + "■";
            ++num1;
         }

         String label = Component.m_237115_(translationKey).getString();
         tooltip.add(Component.m_237113_(label + " " + str + " §7(" + formatSignedNumber(value) + ")"));
      }
   }

   private static double getDisplayOrNormalDouble(ItemStack itemstack, String displayKey, String normalKey) {
      if (itemstack != null && !itemstack.m_41619_()) {
         CompoundTag tag = itemstack.m_41783_();
         if (tag == null) {
            return (double)0.0F;
         } else if (tag.m_128441_(displayKey)) {
            return tag.m_128459_(displayKey);
         } else {
            return tag.m_128441_(normalKey) ? tag.m_128459_(normalKey) : (double)0.0F;
         }
      } else {
         return (double)0.0F;
      }
   }

   private static String formatSignedNumber(double value) {
      double rounded = (double)Math.round(value * (double)100.0F) / (double)100.0F;
      String text;
      if (rounded == Math.rint(rounded)) {
         text = String.valueOf((int)rounded);
      } else {
         text = String.valueOf(rounded);
      }

      return rounded > (double)0.0F ? "+" + text : text;
   }

   private static String formatNumber(double value) {
      double rounded = (double)Math.round(value * (double)100.0F) / (double)100.0F;
      return rounded == Math.rint(rounded) ? String.valueOf((int)rounded) : String.valueOf(rounded);
   }

   private static boolean isItem(ItemStack itemstack, RegistryObject<? extends Item> item) {
      return itemstack != null && !itemstack.m_41619_() && item != null && item.isPresent() && itemstack.m_41720_() == item.get();
   }
}
