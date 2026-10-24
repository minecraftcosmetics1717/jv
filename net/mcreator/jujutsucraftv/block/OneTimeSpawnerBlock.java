package net.mcreator.jujutsucraftv.block;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.block.entity.OneTimeSpawnerBlockEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.mcreator.jujutsucraftv.procedures.OneTimeSpawnerTickProcedure;
import net.mcreator.jujutsucraftv.procedures.OneTimeSpawnerUseProcedure;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class OneTimeSpawnerBlock extends Block implements EntityBlock {
   public OneTimeSpawnerBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56739_).m_60913_(-1.0F, 3600000.0F).m_60955_());
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.m_83040_();
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.m_6227_(blockstate, world, pos, entity, hand, hit);
      if (!world.m_5776_()) {
         OneTimeSpawnerUseProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), entity);
      }

      return InteractionResult.SUCCESS;
   }

   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return new OneTimeSpawnerBlockEntity(pos, state);
   }

   @Nullable
   public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(Level level, BlockState state, BlockEntityType<T> type) {
      return level.m_5776_() ? null : (level1, pos, state1, blockEntity) -> {
         if (blockEntity instanceof OneTimeSpawnerBlockEntity be) {
            OneTimeSpawnerTickProcedure.execute(level1, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), be);
         }

      };
   }

   @OnlyIn(Dist.CLIENT)
   public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
      event.getBlockColors().m_92589_((bs, world, pos, index) -> world != null && pos != null ? BiomeColors.m_108793_(world, pos) : GrassColor.m_46415_((double)0.5F, (double)1.0F), new Block[]{(Block)JujutsucraftvModBlocks.ONE_TIME_SPAWNER.get()});
   }
}
