package net.mcreator.jujutsucraftv.block;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.block.entity.VendingMachineTileEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.mcreator.jujutsucraftv.procedures.VendingMachineRightClickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VendingMachineBlock extends BaseEntityBlock implements EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.m_61631_("animation", 0, 1);
   public static final IntegerProperty TEXTURE = IntegerProperty.m_61631_("texture", 1, 3);
   public static final IntegerProperty PART = IntegerProperty.m_61631_("part", 0, 1);
   public static final DirectionProperty FACING;
   private static final VoxelShape SHAPE_NORTH;
   private static final VoxelShape SHAPE_SOUTH;
   private static final VoxelShape SHAPE_EAST;
   private static final VoxelShape SHAPE_WEST;

   public VendingMachineBlock() {
      super(Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(2.0F, 2.0F).m_60999_().m_60955_().m_60924_((bs, br, bp) -> false));
      this.m_49959_((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_(FACING, Direction.NORTH)).m_61124_(ANIMATION, 0)).m_61124_(TEXTURE, 1)).m_61124_(PART, 0));
   }

   public RenderShape m_7514_(BlockState state) {
      return (Integer)state.m_61143_(PART) == 0 ? RenderShape.ENTITYBLOCK_ANIMATED : RenderShape.INVISIBLE;
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos blockPos, BlockState blockState) {
      return (Integer)blockState.m_61143_(PART) == 0 ? ((BlockEntityType)JujutsucraftvModBlockEntities.VENDING_MACHINE.get()).m_155264_(blockPos, blockState) : null;
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return getShapeByFacing(state);
   }

   public VoxelShape m_5939_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return getShapeByFacing(state);
   }

   public VoxelShape m_6079_(BlockState state, BlockGetter world, BlockPos pos) {
      return getShapeByFacing(state);
   }

   private static VoxelShape getShapeByFacing(BlockState state) {
      VoxelShape var10000;
      switch ((Direction)state.m_61143_(FACING)) {
         case EAST -> var10000 = SHAPE_EAST;
         case WEST -> var10000 = SHAPE_WEST;
         case SOUTH -> var10000 = SHAPE_SOUTH;
         default -> var10000 = SHAPE_NORTH;
      }

      return var10000;
   }

   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
      builder.m_61104_(new Property[]{ANIMATION, TEXTURE, PART, FACING});
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      Level world = context.m_43725_();
      BlockPos pos = context.m_8083_();
      if (pos.m_123342_() >= world.m_151558_() - 1) {
         return null;
      } else if (!world.m_8055_(pos.m_7494_()).m_60629_(context)) {
         return null;
      } else {
         int texture = 1;
         ItemStack stack = context.m_43722_();
         if (stack.m_41782_() && stack.m_41783_().m_128441_("VendingMachineTexture")) {
            texture = Mth.m_14045_(stack.m_41783_().m_128451_("VendingMachineTexture"), 1, 3);
         } else {
            texture = Mth.m_216271_(world.m_213780_(), 1, 3);
         }

         return (BlockState)((BlockState)((BlockState)((BlockState)this.m_49966_().m_61124_(FACING, context.m_8125_().m_122424_())).m_61124_(ANIMATION, 0)).m_61124_(TEXTURE, texture)).m_61124_(PART, 0);
      }
   }

   public void m_6402_(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
      if (!world.m_5776_()) {
         BlockState upperState = (BlockState)state.m_61124_(PART, 1);
         world.m_7731_(pos.m_7494_(), upperState, 3);
         BlockEntity blockEntity = world.m_7702_(pos);
         if (blockEntity != null && stack.m_41782_() && stack.m_41783_().m_128441_("BlockEntityTag")) {
            CompoundTag blockEntityTag = stack.m_41783_().m_128469_("BlockEntityTag").m_6426_();
            blockEntityTag.m_128405_("x", pos.m_123341_());
            blockEntityTag.m_128405_("y", pos.m_123342_());
            blockEntityTag.m_128405_("z", pos.m_123343_());
            blockEntity.m_142466_(blockEntityTag);
            blockEntity.m_6596_();
            world.m_7260_(pos, state, state, 3);
         }
      }

   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.m_61124_(FACING, rot.m_55954_((Direction)state.m_61143_(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.m_60717_(mirrorIn.m_54846_((Direction)state.m_61143_(FACING)));
   }

   public List<ItemStack> m_49635_(BlockState state, LootParams.Builder builder) {
      return Collections.emptyList();
   }

   public void m_5707_(Level world, BlockPos pos, BlockState state, Player player) {
      if (!world.m_5776_() && (Integer)state.m_61143_(PART) == 1) {
         BlockPos basePos = pos.m_7495_();
         BlockState baseState = world.m_8055_(basePos);
         BlockEntity baseBlockEntity = world.m_7702_(basePos);
         if (baseState.m_60713_(this) && (Integer)baseState.m_61143_(PART) == 0) {
            if (!player.m_7500_() && canSilkPickup(player.m_21205_())) {
               ItemStack drop = this.createSilkDrop(baseState, baseBlockEntity);
               if (!drop.m_41619_()) {
                  Containers.m_18992_(world, (double)basePos.m_123341_() + (double)0.5F, (double)basePos.m_123342_() + (double)0.5F, (double)basePos.m_123343_() + (double)0.5F, drop);
               }
            }

            world.m_7731_(basePos, Blocks.f_50016_.m_49966_(), 35);
         }
      }

      super.m_5707_(world, pos, state, player);
   }

   public void m_6240_(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
      if (!world.m_5776_() && (Integer)state.m_61143_(PART) == 0) {
         if (!player.m_7500_() && canSilkPickup(tool)) {
            ItemStack drop = this.createSilkDrop(state, blockEntity);
            if (!drop.m_41619_()) {
               Containers.m_18992_(world, (double)pos.m_123341_() + (double)0.5F, (double)pos.m_123342_() + (double)0.5F, (double)pos.m_123343_() + (double)0.5F, drop);
            }
         }

         BlockPos upperPos = pos.m_7494_();
         BlockState upperState = world.m_8055_(upperPos);
         if (upperState.m_60713_(this) && (Integer)upperState.m_61143_(PART) == 1) {
            world.m_7731_(upperPos, Blocks.f_50016_.m_49966_(), 35);
         }
      }

      super.m_6240_(world, player, pos, state, blockEntity, tool);
   }

   private static boolean canSilkPickup(ItemStack tool) {
      if (tool != null && !tool.m_41619_()) {
         if (EnchantmentHelper.m_44843_(Enchantments.f_44985_, tool) <= 0) {
            return false;
         } else if (!tool.m_204117_(ItemTags.f_271360_)) {
            return false;
         } else {
            Item var2 = tool.m_41720_();
            if (var2 instanceof TieredItem) {
               TieredItem tieredItem = (TieredItem)var2;
               return tieredItem.m_43314_().m_6604_() >= Tiers.DIAMOND.m_6604_();
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private ItemStack createSilkDrop(BlockState baseState, @Nullable BlockEntity blockEntity) {
      ItemStack stack = new ItemStack(this, 1);
      stack.m_41784_().m_128405_("VendingMachineTexture", (Integer)baseState.m_61143_(TEXTURE));
      if (blockEntity instanceof VendingMachineTileEntity vendingMachineTileEntity) {
         CompoundTag blockEntityTag = vendingMachineTileEntity.m_187482_();
         CompoundTag forgeData = vendingMachineTileEntity.getPersistentData().m_6426_();
         if (!forgeData.m_128456_()) {
            blockEntityTag.m_128365_("ForgeData", forgeData);
         }

         stack.m_41700_("BlockEntityTag", blockEntityTag);
      }

      return stack;
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (!state.m_60713_(newState.m_60734_()) && !world.m_5776_()) {
         if ((Integer)state.m_61143_(PART) == 0) {
            BlockPos upperPos = pos.m_7494_();
            BlockState upperState = world.m_8055_(upperPos);
            if (upperState.m_60713_(this) && (Integer)upperState.m_61143_(PART) == 1) {
               world.m_7731_(upperPos, Blocks.f_50016_.m_49966_(), 35);
            }
         } else {
            BlockPos basePos = pos.m_7495_();
            BlockState baseState = world.m_8055_(basePos);
            if (baseState.m_60713_(this) && (Integer)baseState.m_61143_(PART) == 0) {
               world.m_7731_(basePos, Blocks.f_50016_.m_49966_(), 35);
            }
         }
      }

      super.m_6810_(state, world, pos, newState, isMoving);
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      BlockPos basePos = (Integer)blockstate.m_61143_(PART) == 1 ? pos.m_7495_() : pos;
      BlockState baseState = world.m_8055_(basePos);
      if (!baseState.m_60713_(this)) {
         return InteractionResult.PASS;
      } else {
         if (!world.m_5776_()) {
            VendingMachineRightClickProcedure.execute(world, (double)basePos.m_123341_(), (double)basePos.m_123342_(), (double)basePos.m_123343_(), entity);
         }

         return InteractionResult.m_19078_(world.m_5776_());
      }
   }

   public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
      BlockPos basePos = (Integer)state.m_61143_(PART) == 1 ? pos.m_7495_() : pos;
      BlockEntity tileEntity = worldIn.m_7702_(basePos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider menuProvider) {
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.m_8133_(state, world, pos, eventID, eventParam);
      BlockPos basePos = (Integer)state.m_61143_(PART) == 1 ? pos.m_7495_() : pos;
      BlockEntity blockEntity = world.m_7702_(basePos);
      return blockEntity != null && blockEntity.m_7531_(eventID, eventParam);
   }

   static {
      FACING = HorizontalDirectionalBlock.f_54117_;
      SHAPE_NORTH = m_49796_((double)0.0F, (double)0.0F, (double)2.0F, (double)16.0F, (double)16.0F, (double)14.0F);
      SHAPE_SOUTH = m_49796_((double)0.0F, (double)0.0F, (double)2.0F, (double)16.0F, (double)16.0F, (double)14.0F);
      SHAPE_EAST = m_49796_((double)2.0F, (double)0.0F, (double)0.0F, (double)14.0F, (double)16.0F, (double)16.0F);
      SHAPE_WEST = m_49796_((double)2.0F, (double)0.0F, (double)0.0F, (double)14.0F, (double)16.0F, (double)16.0F);
   }
}
