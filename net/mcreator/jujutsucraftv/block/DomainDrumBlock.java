package net.mcreator.jujutsucraftv.block;

import net.mcreator.jujutsucraftv.block.entity.DomainDrumBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainDrumBlock extends Block implements EntityBlock {
   public DomainDrumBlock() {
      super(Properties.m_284310_().m_60918_(new ForgeSoundType(1.0F, 1.0F, () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.break")), () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:djambe")), () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.place")), () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo_wood.hit")), () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:djambe")))).m_60913_(-1.0F, 3600000.0F).m_60953_((s) -> 15));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
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
      return new DomainDrumBlockEntity(pos, state);
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.m_60734_() != newState.m_60734_()) {
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity instanceof DomainDrumBlockEntity) {
            DomainDrumBlockEntity be = (DomainDrumBlockEntity)blockEntity;
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
      if (tileentity instanceof DomainDrumBlockEntity be) {
         return AbstractContainerMenu.m_38938_(be);
      } else {
         return 0;
      }
   }
}
