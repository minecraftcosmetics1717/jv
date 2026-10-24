package net.mcreator.jujutsucraftv.block;

import net.mcreator.jujutsucraftv.block.entity.DomainSkyBlueBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DomainSkyBlueBlock extends TextureSkyBlock implements EntityBlock {
   public DomainSkyBlueBlock() {
      super(new ResourceLocation("jujutsucraftv", "domain_sky_blue"), Properties.m_284310_().m_60918_(SoundType.f_56744_).m_60913_(-1.0F, 3600000.0F));
   }

   public MenuProvider m_7246_(BlockState state, Level world, BlockPos pos) {
      BlockEntity blockEntity = world.m_7702_(pos);
      MenuProvider var10000;
      if (blockEntity instanceof MenuProvider menuProvider) {
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return new DomainSkyBlueBlockEntity(pos, state);
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity != null && blockEntity.m_7531_(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.m_60734_() != newState.m_60734_()) {
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity instanceof DomainSkyBlueBlockEntity) {
            DomainSkyBlueBlockEntity be = (DomainSkyBlueBlockEntity)blockEntity;
            Containers.m_19002_(world, pos, be);
            world.m_46717_(pos, this);
         }

         super.m_6810_(state, world, pos, newState, isMoving);
      }

   }

   public boolean m_7278_(BlockState state) {
      return true;
   }

   public int m_6782_(BlockState state, Level world, BlockPos pos) {
      BlockEntity blockEntity = world.m_7702_(pos);
      if (blockEntity instanceof DomainSkyBlueBlockEntity be) {
         return AbstractContainerMenu.m_38938_(be);
      } else {
         return 0;
      }
   }
}
