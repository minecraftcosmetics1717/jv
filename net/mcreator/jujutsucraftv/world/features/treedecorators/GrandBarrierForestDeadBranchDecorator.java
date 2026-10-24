package net.mcreator.jujutsucraftv.world.features.treedecorators;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class GrandBarrierForestDeadBranchDecorator extends TreeDecorator {
   public static final Codec<GrandBarrierForestDeadBranchDecorator> CODEC = Codec.unit(GrandBarrierForestDeadBranchDecorator::new);
   public static final TreeDecoratorType<?> DECORATOR_TYPE;

   @SubscribeEvent
   public static void registerTreeDecorator(RegisterEvent event) {
      event.register(Keys.TREE_DECORATOR_TYPES, (registerHelper) -> registerHelper.register("grand_barrier_forest_tree_dead_branch_decorator", DECORATOR_TYPE));
   }

   protected TreeDecoratorType<?> m_6663_() {
      return DECORATOR_TYPE;
   }

   public void m_214187_(TreeDecorator.Context context) {
      BlockPos top = null;
      ObjectListIterator var3 = context.m_226068_().iterator();

      while(var3.hasNext()) {
         BlockPos log = (BlockPos)var3.next();
         if (top == null || log.m_123342_() > top.m_123342_()) {
            top = log;
         }
      }

      if (top != null) {
         BlockState branch = ((Block)JujutsucraftvModBlocks.ROCK_BARRIER_TREE.get()).m_49966_();
         int count = 3 + context.m_226067_().m_188503_(2);

         for(int index = 0; index < count; ++index) {
            Direction direction = Direction.m_122407_(index + context.m_226067_().m_188503_(2) & 3);
            BlockPos branchPos = top.m_6625_(1 + context.m_226067_().m_188503_(3));
            int length = 2 + context.m_226067_().m_188503_(2);
            int placed = 0;

            for(int step = 0; step < length; ++step) {
               BlockPos next = branchPos.m_121945_(direction);
               if (!context.m_226059_(next)) {
                  break;
               }

               context.m_226061_(next, orientedBranch(branch, direction));
               branchPos = next;
               ++placed;
            }

            if (placed > 0 && context.m_226067_().m_188499_()) {
               Direction side = context.m_226067_().m_188499_() ? direction.m_122427_() : direction.m_122428_();
               BlockPos tip = branchPos.m_121945_(side);
               if (context.m_226059_(tip)) {
                  context.m_226061_(tip, orientedBranch(branch, side));
               }
            }
         }

      }
   }

   private static BlockState orientedBranch(BlockState state, Direction direction) {
      if (state.m_61138_(BlockStateProperties.f_61365_)) {
         state = (BlockState)state.m_61124_(BlockStateProperties.f_61365_, direction.m_122434_());
      }

      if (!(state.m_60734_() instanceof WallBlock)) {
         return state;
      } else {
         state = (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)state.m_61124_(WallBlock.f_57949_, false)).m_61124_(WallBlock.f_57951_, WallSide.NONE)).m_61124_(WallBlock.f_57952_, WallSide.NONE)).m_61124_(WallBlock.f_57950_, WallSide.NONE)).m_61124_(WallBlock.f_57953_, WallSide.NONE);
         BlockState var10000;
         switch (direction.m_122434_()) {
            case X -> var10000 = (BlockState)((BlockState)state.m_61124_(WallBlock.f_57950_, WallSide.LOW)).m_61124_(WallBlock.f_57953_, WallSide.LOW);
            case Z -> var10000 = (BlockState)((BlockState)state.m_61124_(WallBlock.f_57951_, WallSide.LOW)).m_61124_(WallBlock.f_57952_, WallSide.LOW);
            default -> var10000 = state;
         }

         return var10000;
      }
   }

   static {
      DECORATOR_TYPE = new TreeDecoratorType(CODEC);
   }
}
