package net.mcreator.jujutsucraftv.block.entity;

import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.block.VendingMachineBlock;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class VendingMachineTileEntity extends RandomizableContainerBlockEntity implements GeoBlockEntity, WorldlyContainer {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private NonNullList<ItemStack> stacks;
   private final LazyOptional<IItemHandler> handler;
   private final LazyOptional<? extends IItemHandler>[] handlers;
   String prevAnim;

   public VendingMachineTileEntity(BlockPos pos, BlockState state) {
      super((BlockEntityType)JujutsucraftvModBlockEntities.VENDING_MACHINE.get(), pos, state);
      this.stacks = NonNullList.m_122780_(6, ItemStack.f_41583_);
      this.handler = LazyOptional.of(() -> new InvWrapper(this));
      this.handlers = SidedInvWrapper.create(this, Direction.values());
      this.prevAnim = "0";
   }

   public AABB getRenderBoundingBox() {
      return new AABB((double)this.f_58858_.m_123341_(), (double)this.f_58858_.m_123342_(), (double)this.f_58858_.m_123343_(), (double)(this.f_58858_.m_123341_() + 1), (double)(this.f_58858_.m_123342_() + 2), (double)(this.f_58858_.m_123343_() + 1));
   }

   private PlayState predicate(AnimationState event) {
      BlockState var10000 = this.m_58900_();
      String animationprocedure = "" + String.valueOf(var10000.m_61143_(VendingMachineBlock.ANIMATION));
      return animationprocedure.equals("0") ? event.setAndContinue(RawAnimation.begin().thenLoop(animationprocedure)) : PlayState.STOP;
   }

   private PlayState procedurePredicate(AnimationState event) {
      BlockState var10000 = this.m_58900_();
      String animationprocedure = "" + String.valueOf(var10000.m_61143_(VendingMachineBlock.ANIMATION));
      if (!animationprocedure.equals("0") && event.getController().getAnimationState() == State.STOPPED || !animationprocedure.equals(this.prevAnim) && !animationprocedure.equals("0")) {
         if (!animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            Property var4 = this.m_58900_().m_60734_().m_49965_().m_61081_("animation");
            if (var4 instanceof IntegerProperty) {
               IntegerProperty integerProp = (IntegerProperty)var4;
               this.f_58857_.m_7731_(this.m_58899_(), (BlockState)this.m_58900_().m_61124_(integerProp, 0), 3);
            }

            event.getController().forceAnimationReset();
         }
      } else if (animationprocedure.equals("0")) {
         this.prevAnim = "0";
         return PlayState.STOP;
      }

      this.prevAnim = animationprocedure;
      return PlayState.CONTINUE;
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "controller", 0, this::predicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedurecontroller", 0, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void m_142466_(CompoundTag compound) {
      super.m_142466_(compound);
      if (!this.m_59631_(compound)) {
         this.stacks = NonNullList.m_122780_(this.m_6643_(), ItemStack.f_41583_);
      }

      ContainerHelper.m_18980_(compound, this.stacks);
   }

   public void m_183515_(CompoundTag compound) {
      super.m_183515_(compound);
      if (!this.m_59634_(compound)) {
         ContainerHelper.m_18973_(compound, this.stacks);
      }

   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.m_195640_(this);
   }

   public CompoundTag m_5995_() {
      return this.m_187480_();
   }

   public int m_6643_() {
      return this.stacks.size();
   }

   public boolean m_7983_() {
      for(ItemStack itemstack : this.stacks) {
         if (!itemstack.m_41619_()) {
            return false;
         }
      }

      return true;
   }

   public Component m_6820_() {
      return Component.m_237113_("vending_machine");
   }

   public int m_6893_() {
      return 64;
   }

   public AbstractContainerMenu m_6555_(int id, Inventory inventory) {
      return ChestMenu.m_39255_(id, inventory);
   }

   public Component m_5446_() {
      return Component.m_237113_("Vending Machine");
   }

   protected NonNullList<ItemStack> m_7086_() {
      return this.stacks;
   }

   protected void m_6520_(NonNullList<ItemStack> stacks) {
      this.stacks = stacks;
      this.m_6596_();
   }

   public boolean m_7013_(int index, ItemStack stack) {
      return true;
   }

   public int[] m_7071_(Direction side) {
      return IntStream.range(0, this.m_6643_()).toArray();
   }

   public boolean m_7155_(int index, ItemStack stack, @Nullable Direction direction) {
      return this.m_7013_(index, stack);
   }

   public boolean m_7157_(int index, ItemStack stack, Direction direction) {
      return true;
   }

   public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
      if (!this.f_58859_ && capability == ForgeCapabilities.ITEM_HANDLER) {
         return facing == null ? this.handler.cast() : this.handlers[facing.ordinal()].cast();
      } else {
         return super.getCapability(capability, facing);
      }
   }

   public void m_7651_() {
      super.m_7651_();
      this.handler.invalidate();

      for(LazyOptional<? extends IItemHandler> handler : this.handlers) {
         handler.invalidate();
      }

   }
}
