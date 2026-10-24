package net.mcreator.jujutsucraftv.block.entity;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OneTimeSpawnerBlockEntity extends BlockEntity {
   public OneTimeSpawnerBlockEntity(BlockPos pos, BlockState state) {
      super((BlockEntityType)JujutsucraftvModBlockEntities.ONE_TIME_SPAWNER.get(), pos, state);
   }

   public void m_142466_(CompoundTag tag) {
      super.m_142466_(tag);
   }

   protected void m_183515_(CompoundTag tag) {
      super.m_183515_(tag);
   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.m_195640_(this);
   }

   public CompoundTag m_5995_() {
      return this.m_187480_();
   }
}
