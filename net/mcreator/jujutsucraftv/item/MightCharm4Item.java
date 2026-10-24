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
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class MightCharm4Item extends Item implements ICurioItem {
   private static final double DAMAGE_AMPLIFICATION = (double)10.0F;

   public MightCharm4Item() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.COMMON));
   }

   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
      Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();
      modifiers.put((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get(), new AttributeModifier(uuid, Component.m_237115_("attribute.jujutsucraftv.damage_amplification").getString(), (double)10.0F, Operation.ADDITION));
      return modifiers;
   }

   public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
      List<Component> result = new ArrayList(tooltips);
      String attributeName = Component.m_237115_("attribute.jujutsucraftv.damage_amplification").getString();
      int percent = 10;

      for(int i = 0; i < result.size(); ++i) {
         if (((Component)result.get(i)).getString().contains(attributeName)) {
            result.set(i, Component.m_237113_(attributeName + " +" + percent + "%").m_130940_(ChatFormatting.BLUE));
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
