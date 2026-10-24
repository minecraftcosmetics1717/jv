package net.mcreator.jujutsucraftv.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class GrayDoorBlock extends DoorBlock {
   public GrayDoorBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(2.0F, 1.0F).m_60955_().m_60924_((bs, br, bp) -> false).m_60988_(), BlockSetType.f_271479_);
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }
}
