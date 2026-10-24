package net.mcreator.jujutsucraftv.item;

import io.netty.buffer.Unpooled;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.item.inventory.TrainedCursedSpiritArmoryInventoryCapability;
import net.mcreator.jujutsucraftv.world.inventory.CursedSpiritArmouryGuiMenu;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class TrainedCursedSpiritArmoryItem extends Item implements ICurioItem {
   public TrainedCursedSpiritArmoryItem() {
      super((new Item.Properties()).m_41487_(1).m_41486_().m_41497_(Rarity.RARE));
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.trained_cursed_spirit_armory.description_0"));
      list.add(Component.m_237115_("item.jujutsucraftv.trained_cursed_spirit_armory.description_1"));
      list.add(Component.m_237115_("item.jujutsucraftv.trained_cursed_spirit_armory.description_2"));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, final Player entity, final InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      ItemStack itemstack = (ItemStack)ar.m_19095_();
      if (entity instanceof ServerPlayer serverPlayer) {
         NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
            public Component m_5446_() {
               return Component.m_237113_("Trained Cursed Spirit Armory");
            }

            public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
               FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
               packetBuffer.m_130064_(entity.m_20183_());
               packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
               return new CursedSpiritArmouryGuiMenu(id, inventory, packetBuffer);
            }
         }, (buf) -> {
            buf.m_130064_(entity.m_20183_());
            buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
         });
      }

      return ar;
   }

   public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag compound) {
      return new TrainedCursedSpiritArmoryInventoryCapability();
   }

   public CompoundTag getShareTag(ItemStack stack) {
      CompoundTag nbt = super.getShareTag(stack);
      if (nbt != null) {
         stack.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
            if (capability instanceof ItemStackHandler handler) {
               nbt.m_128365_("Inventory", handler.serializeNBT());
            }

         });
      }

      return nbt;
   }

   public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
      super.readShareTag(stack, nbt);
      if (nbt != null && nbt.m_128441_("Inventory")) {
         stack.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
            if (capability instanceof ItemStackHandler handler) {
               handler.deserializeNBT(nbt.m_128469_("Inventory"));
            }

         });
      }

   }
}
