package net.mcreator.jujutsucraftv.item;

import net.mcreator.jujutsucraftv.procedures.UseCursedTechniqueChangerProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CursedTechniqueChangerVItem extends Item {
   public CursedTechniqueChangerVItem() {
      super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean m_5812_(ItemStack itemstack) {
      return true;
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      UseCursedTechniqueChangerProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }

   public InteractionResult m_6225_(UseOnContext context) {
      super.m_6225_(context);
      UseCursedTechniqueChangerProcedure.execute(context.m_43725_(), (double)context.m_8083_().m_123341_(), (double)context.m_8083_().m_123342_(), (double)context.m_8083_().m_123343_(), context.m_43723_());
      return InteractionResult.SUCCESS;
   }
}
