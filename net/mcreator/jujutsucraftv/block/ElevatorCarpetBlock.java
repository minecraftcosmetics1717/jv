package net.mcreator.jujutsucraftv.block;

import net.mcreator.jujutsucraftv.block.entity.ElevatorCarpetBlockEntity;
import net.mcreator.jujutsucraftv.procedures.ElevatorCarpetGuiOpenProcedure;
import net.mcreator.jujutsucraftv.procedures.ElevatorCarpetStandProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ElevatorCarpetBlock extends Block implements EntityBlock {
   public ElevatorCarpetBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(-1.0F, 10.0F).m_60955_().m_60924_((bs, br, bp) -> false));
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

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return m_49796_((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)1.0F, (double)16.0F);
   }

   public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.m_7892_(blockstate, world, pos, entity);
      ElevatorCarpetStandProcedure.execute(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), entity);
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      ElevatorCarpetGuiOpenProcedure.execute(world, (double)x, (double)y, (double)z, entity);
      return InteractionResult.SUCCESS;
   }

   public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.m_7702_(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider menuProvider) {
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return new ElevatorCarpetBlockEntity(pos, state);
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.m_60734_() != newState.m_60734_()) {
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity instanceof ElevatorCarpetBlockEntity) {
            ElevatorCarpetBlockEntity be = (ElevatorCarpetBlockEntity)blockEntity;
            Containers.m_19002_(world, pos, be);
            world.m_46717_(pos, this);
         }

         super.m_6810_(state, world, pos, newState, isMoving);
      }

   }

   public boolean m_7278_(BlockState state) {
      return true;
   }

   public int m_6782_(BlockState blockState, Level world, BlockPos pos) {
      BlockEntity tileentity = world.m_7702_(pos);
      if (tileentity instanceof ElevatorCarpetBlockEntity be) {
         return AbstractContainerMenu.m_38938_(be);
      } else {
         return 0;
      }
   }
}
