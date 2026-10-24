package net.mcreator.jujutsucraftv.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SlightlyBrightRedstoneLampBlock extends Block {
   public SlightlyBrightRedstoneLampBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56744_).m_60978_(0.3F).m_60953_((s) -> 7));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
