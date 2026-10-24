package net.mcreator.jujutsucraftv.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RedBarrierErosionDirtBlock extends Block {
   public RedBarrierErosionDirtBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56739_).m_60978_(0.5F));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
