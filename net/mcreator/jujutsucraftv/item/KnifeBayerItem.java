package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ItemUseBulletProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeBayerItem extends Item {
   public KnifeBayerItem() {
      super((new Item.Properties()).m_41487_(16).m_41497_(Rarity.COMMON));
   }

   public float m_8102_(ItemStack par1ItemStack, BlockState par2Block) {
      return 1.6F;
   }

   public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.m_7167_(equipmentSlot));
         builder.put(Attributes.f_22281_, new AttributeModifier(f_41374_, "Item modifier", (double)1.0F, Operation.ADDITION));
         builder.put(Attributes.f_22283_, new AttributeModifier(f_41375_, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.m_7167_(equipmentSlot);
      }
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.knife_bayer.description_0"));
      list.add(Component.m_237115_("item.jujutsucraftv.knife_bayer.description_1"));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      ItemUseBulletProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }
}
