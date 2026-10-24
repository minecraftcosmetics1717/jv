package net.mcreator.jujutsucraftv.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RockBarrierTreeBlock extends Block {
   public RockBarrierTreeBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56742_).m_60913_(1.5F, 1.0F));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
