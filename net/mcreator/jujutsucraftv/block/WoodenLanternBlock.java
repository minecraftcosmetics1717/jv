package net.mcreator.jujutsucraftv.block;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.storage.loot.LootParams;

public class WoodenLanternBlock extends LanternBlock {
   public WoodenLanternBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56736_).m_60978_(1.0F).m_60953_((state) -> 15).m_60955_());
   }

   public List<ItemStack> m_49635_(BlockState state, LootParams.Builder builder) {
      return List.of(new ItemStack(this));
   }
}
