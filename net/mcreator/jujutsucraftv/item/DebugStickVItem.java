package net.mcreator.jujutsucraftv.item;

import net.mcreator.jujutsucraftv.procedures.ItemUseDebugStickProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DebugStickVItem extends Item {
   public DebugStickVItem() {
      super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean m_5812_(ItemStack itemstack) {
      return true;
   }

   public InteractionResult m_6880_(ItemStack itemstack, Player player, LivingEntity target, InteractionHand hand) {
      InteractionResult retval = InteractionResult.m_19078_(player.m_9236_().m_5776_());
      ItemUseDebugStickProcedure.execute(target, player);
      return retval;
   }
}
