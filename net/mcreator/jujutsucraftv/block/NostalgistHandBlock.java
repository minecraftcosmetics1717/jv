package net.mcreator.jujutsucraftv.block;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnSpecialCursedtoolProcedure;
import net.mcreator.jujutsucraftv.procedures.SummonBlockMainProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NostalgistHandBlock extends BaseEntityBlock implements EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.m_61631_("animation", 0, 1);
   public static final DirectionProperty FACING;

   public NostalgistHandBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56761_).m_60913_(1.0F, 10.0F).m_60953_((s) -> 2).m_60955_().m_60924_((bs, br, bp) -> false));
      this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH));
   }

   public RenderShape m_7514_(BlockState state) {
      return RenderShape.ENTITYBLOCK_ANIMATED;
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos blockPos, BlockState blockState) {
      return ((BlockEntityType)JujutsucraftvModBlockEntities.NOSTALGIST_HAND.get()).m_155264_(blockPos, blockState);
   }

   public void m_5871_(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.m_5871_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ItemInfoReturnSpecialCursedtoolProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      VoxelShape var10000;
      switch ((Direction)state.m_61143_(FACING)) {
         case NORTH -> var10000 = m_49796_((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
         case EAST -> var10000 = m_49796_((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
         case WEST -> var10000 = m_49796_((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
         default -> var10000 = m_49796_((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
      }

      return var10000;
   }

   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
      builder.m_61104_(new Property[]{ANIMATION, FACING});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)this.m_49966_().m_61124_(FACING, context.m_8125_().m_122424_());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
      return new ItemStack((ItemLike)JujutsucraftvModBlocks.NOSTALGIST_HAND.get());
   }

   public List<ItemStack> m_49635_(BlockState state, LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.m_49635_(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack((ItemLike)JujutsucraftvModBlocks.NOSTALGIST_HAND.get()));
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.m_6227_(blockstate, world, pos, entity, hand, hit);
      int x = pos.m_123341_();
      int y = pos.m_123342_();
      int z = pos.m_123343_();
      double hitX = hit.m_82450_().f_82479_;
      double hitY = hit.m_82450_().f_82480_;
      double hitZ = hit.m_82450_().f_82481_;
      Direction direction = hit.m_82434_();
      SummonBlockMainProcedure.execute(world, (double)x, (double)y, (double)z, blockstate);
      return InteractionResult.SUCCESS;
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
   }
}
