package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.UUID;
import net.mcreator.jujutsucraftv.procedures.ReturnCurseObjectProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
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

public class ProtectiveCharm4Item extends Item implements ICurioItem {
   public ProtectiveCharm4Item() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.COMMON));
   }

   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
      Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();
      modifiers.put(Attributes.f_22284_, new AttributeModifier(uuid, Component.m_237115_("attributes.name.generic.armor").getString(), (double)7.0F, Operation.ADDITION));
      return modifiers;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ReturnCurseObjectProcedure.execute();
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
