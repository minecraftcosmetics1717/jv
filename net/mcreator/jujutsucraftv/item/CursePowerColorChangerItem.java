package net.mcreator.jujutsucraftv.item;

import net.mcreator.jujutsucraftv.procedures.CursePowerColorChangerUseProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CursePowerColorChangerItem extends Item {
   public CursePowerColorChangerItem() {
      super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean m_5812_(ItemStack itemstack) {
      return true;
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      CursePowerColorChangerUseProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
      return ar;
   }
}
