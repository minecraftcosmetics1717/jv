package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HandGunItem extends Item {
   public HandGunItem() {
      super((new Item.Properties()).m_41503_(1200));
   }

   public float m_8102_(ItemStack itemstack, BlockState blockstate) {
      return 1.0F;
   }

   public boolean m_6813_(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      itemstack.m_41622_(1, entity, (i) -> i.m_21166_(EquipmentSlot.MAINHAND));
      return true;
   }

   public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      itemstack.m_41622_(2, entity, (i) -> i.m_21166_(EquipmentSlot.MAINHAND));
      return true;
   }

   public int m_6473_() {
      return 2;
   }

   public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.m_7167_(equipmentSlot));
         builder.put(Attributes.f_22281_, new AttributeModifier(f_41374_, "Tool modifier", (double)1.0F, Operation.ADDITION));
         builder.put(Attributes.f_22283_, new AttributeModifier(f_41375_, "Tool modifier", -2.8, Operation.ADDITION));
         return builder.build();
      } else {
         return super.m_7167_(equipmentSlot);
      }
   }
}
