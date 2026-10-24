package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnCursedtoolProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class NanamiNecktieItem extends TieredItem {
   public NanamiNecktieItem() {
      super(new Tier() {
         public int m_6609_() {
            return 1200;
         }

         public float m_6624_() {
            return 0.0F;
         }

         public float m_6631_() {
            return 2.0F;
         }

         public int m_6604_() {
            return 0;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, new Item.Properties());
   }

   public boolean m_8096_(BlockState blockstate) {
      return !blockstate.m_204336_(BlockTags.f_144286_) && !blockstate.m_204336_(BlockTags.f_144285_) && !blockstate.m_204336_(BlockTags.f_144284_);
   }

   public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
      return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
   }

   public float m_8102_(ItemStack itemstack, BlockState blockstate) {
      return 0.0F;
   }

   public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.m_7167_(equipmentSlot));
         builder.put(Attributes.f_22281_, new AttributeModifier(f_41374_, "Tool modifier", (double)3.0F, Operation.ADDITION));
         builder.put(Attributes.f_22283_, new AttributeModifier(f_41375_, "Tool modifier", (double)-2.0F, Operation.ADDITION));
         return builder.build();
      } else {
         return super.m_7167_(equipmentSlot);
      }
   }

   public boolean m_6813_(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
      itemstack.m_41622_(1, entity, (i) -> i.m_21166_(EquipmentSlot.MAINHAND));
      return true;
   }

   public boolean m_7579_(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      itemstack.m_41622_(2, entity, (i) -> i.m_21166_(EquipmentSlot.MAINHAND));
      return true;
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ItemInfoReturnCursedtoolProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }
}
