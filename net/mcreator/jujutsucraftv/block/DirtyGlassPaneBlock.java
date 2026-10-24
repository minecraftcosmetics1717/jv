package net.mcreator.jujutsucraftv.block;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class DirtyGlassPaneBlock extends IronBarsBlock {
   public DirtyGlassPaneBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56744_).m_60978_(0.3F).m_60955_().m_60924_((bs, br, bp) -> false));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 4;
   }

   @OnlyIn(Dist.CLIENT)
   public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
      event.getBlockColors().m_92589_((bs, world, pos, index) -> world != null && pos != null ? BiomeColors.m_108793_(world, pos) : GrassColor.m_46415_((double)0.5F, (double)1.0F), new Block[]{(Block)JujutsucraftvModBlocks.DIRTY_GLASS_PANE.get()});
   }
}
