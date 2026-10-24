package net.mcreator.jujutsucraftv.block;

import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TextureSkyBlock extends Block {
   private final ResourceLocation skyId;

   protected TextureSkyBlock(ResourceLocation skyId, BlockBehaviour.Properties properties) {
      super(properties.m_60955_());
      this.skyId = (ResourceLocation)Objects.requireNonNull(skyId);
   }

   public ResourceLocation getSkyId() {
      return this.skyId;
   }

   public RenderShape m_7514_(BlockState state) {
      return RenderShape.INVISIBLE;
   }

   public int m_7753_(BlockState state, BlockGetter level, BlockPos pos) {
      return 0;
   }

   public boolean m_7420_(BlockState state, BlockGetter level, BlockPos pos) {
      return true;
   }

   public float m_7749_(BlockState state, BlockGetter level, BlockPos pos) {
      return 1.0F;
   }
}
