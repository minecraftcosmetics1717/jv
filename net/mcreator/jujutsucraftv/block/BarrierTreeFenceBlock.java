package net.mcreator.jujutsucraftv.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BarrierTreeFenceBlock extends FenceBlock {
   public BarrierTreeFenceBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56744_).m_60913_(1.5F, 1.0F).m_60953_((s) -> 5).m_60955_().m_60924_((bs, br, bp) -> false).m_60988_().m_280606_());
   }

   public boolean m_6104_(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.m_60734_() == this ? true : super.m_6104_(state, adjacentBlockState, side);
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 5;
   }
}
