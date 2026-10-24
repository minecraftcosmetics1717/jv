package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.mcreator.jujutsucraftv.procedures.UseCursedTechniqueStarterProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CursedTechniqueStarterItem extends Item {
   public CursedTechniqueStarterItem() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.UNCOMMON));
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.cursed_technique_starter.description_0"));
      list.add(Component.m_237115_("item.jujutsucraftv.cursed_technique_starter.description_1"));
      list.add(Component.m_237115_("item.jujutsucraftv.cursed_technique_starter.description_2"));
      list.add(Component.m_237115_("item.jujutsucraftv.cursed_technique_starter.description_3"));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      UseCursedTechniqueStarterProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }

   public InteractionResult m_6225_(UseOnContext context) {
      super.m_6225_(context);
      UseCursedTechniqueStarterProcedure.execute(context.m_43725_(), (double)context.m_8083_().m_123341_(), (double)context.m_8083_().m_123342_(), (double)context.m_8083_().m_123343_(), context.m_43723_());
      return InteractionResult.SUCCESS;
   }
}
