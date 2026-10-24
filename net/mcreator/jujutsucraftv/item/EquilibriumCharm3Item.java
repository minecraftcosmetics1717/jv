package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.mcreator.jujutsucraftv.procedures.ReturnCurseObjectProcedure;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class EquilibriumCharm3Item extends Item implements ICurioItem {
   private static final double DAMAGE = (double)3.0F;
   private static final double ARMOR = (double)3.0F;
   private static final double HEALTH = (double)4.0F;

   public EquilibriumCharm3Item() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.COMMON));
   }

   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
      Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();
      modifiers.put((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get(), new AttributeModifier(uuid, Component.m_237115_("attribute.jujutsucraftv.damage_amplification").getString(), (double)3.0F, Operation.ADDITION));
      modifiers.put(Attributes.f_22284_, new AttributeModifier(uuid, Component.m_237115_("attribute.name.generic.armor").getString(), (double)3.0F, Operation.ADDITION));
      modifiers.put(Attributes.f_22276_, new AttributeModifier(uuid, Component.m_237115_("attribute.name.generic.max_health").getString(), (double)4.0F, Operation.ADDITION));
      return modifiers;
   }

   public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
      List<Component> result = new ArrayList(tooltips);
      String damageName = Component.m_237115_("attribute.jujutsucraftv.damage_amplification").getString();
      String armorName = Component.m_237115_("attribute.name.generic.armor").getString();
      String healthName = Component.m_237115_("attribute.name.generic.max_health").getString();

      for(int i = 0; i < result.size(); ++i) {
         String text = ((Component)result.get(i)).getString();
         if (text.contains(damageName)) {
            result.set(i, Component.m_237113_(damageName + " +3%").m_130940_(ChatFormatting.BLUE));
         } else if (text.contains(armorName)) {
            result.set(i, Component.m_237113_(armorName + " +3").m_130940_(ChatFormatting.BLUE));
         } else if (text.contains(healthName)) {
            result.set(i, Component.m_237113_(healthName + " +4").m_130940_(ChatFormatting.BLUE));
         }
      }

      return result;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      String hoverText = ReturnCurseObjectProcedure.execute();
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
