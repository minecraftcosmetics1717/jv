package net.mcreator.jujutsucraftv.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class VendingMachinePurchaseHelper {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, int sellSlot, int costSlot) {
      if (entity != null) {
         if (!world.m_5776_()) {
            if (entity instanceof Player) {
               Player player = (Player)entity;
               BlockPos pos = BlockPos.m_274561_(x, y, z);
               ItemStack sellStack = getBlockItemStack(world, pos, sellSlot);
               ItemStack costStack = getBlockItemStack(world, pos, costSlot);
               if (!sellStack.m_41619_() && !costStack.m_41619_() && costStack.m_41613_() > 0) {
                  boolean var10000;
                  label35: {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer serverPlayer = (ServerPlayer)entity;
                        if (serverPlayer.f_8941_.m_9290_().m_46408_()) {
                           var10000 = true;
                           break label35;
                        }
                     }

                     var10000 = false;
                  }

                  boolean creative = var10000;
                  if (!creative && countMatchingItems(player, costStack) < costStack.m_41613_()) {
                     fail(world, pos, player);
                     close(player);
                  } else {
                     playPurchasedSound(world, pos);
                     if (!creative) {
                        removeMatchingItems(player, costStack, costStack.m_41613_());
                     }

                     ItemHandlerHelper.giveItemToPlayer(player, sellStack.m_41777_());
                     player.m_150109_().m_6596_();
                     close(player);
                  }
               } else {
                  fail(world, pos, player);
                  close(player);
               }
            }
         }
      }
   }

   private static ItemStack getBlockItemStack(LevelAccessor world, BlockPos pos, int slotid) {
      AtomicReference<ItemStack> retval = new AtomicReference(ItemStack.f_41583_);
      BlockEntity blockEntity = world.m_7702_(pos);
      if (blockEntity != null) {
         blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
            if (slotid >= 0 && slotid < capability.getSlots()) {
               retval.set(capability.getStackInSlot(slotid).m_41777_());
            }

         });
      }

      return (ItemStack)retval.get();
   }

   private static int countMatchingItems(Player player, ItemStack target) {
      if (target.m_41619_()) {
         return 0;
      } else {
         int count = 0;

         for(ItemStack stack : player.m_150109_().f_35974_) {
            if (!stack.m_41619_() && ItemStack.m_150942_(stack, target)) {
               count += stack.m_41613_();
            }
         }

         for(ItemStack stack : player.m_150109_().f_35976_) {
            if (!stack.m_41619_() && ItemStack.m_150942_(stack, target)) {
               count += stack.m_41613_();
            }
         }

         return count;
      }
   }

   private static void removeMatchingItems(Player player, ItemStack target, int amount) {
      if (!target.m_41619_() && amount > 0) {
         int remaining = amount;

         for(ItemStack stack : player.m_150109_().f_35974_) {
            if (remaining <= 0) {
               return;
            }

            if (!stack.m_41619_() && ItemStack.m_150942_(stack, target)) {
               int remove = Math.min(stack.m_41613_(), remaining);
               stack.m_41774_(remove);
               remaining -= remove;
            }
         }

         for(ItemStack stack : player.m_150109_().f_35976_) {
            if (remaining <= 0) {
               return;
            }

            if (!stack.m_41619_() && ItemStack.m_150942_(stack, target)) {
               int remove = Math.min(stack.m_41613_(), remaining);
               stack.m_41774_(remove);
               remaining -= remove;
            }
         }

      }
   }

   private static void playPurchasedSound(LevelAccessor world, BlockPos pos) {
      if (world instanceof Level level) {
         if (!level.m_5776_()) {
            level.m_5594_((Player)null, pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:purchased_vending_machine")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, 1.2));
         }
      }

   }

   private static void fail(LevelAccessor world, BlockPos pos, Player player) {
      if (world instanceof Level level) {
         if (!level.m_5776_()) {
            level.m_5594_((Player)null, pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 0.5F);
         }
      }

      if (!player.m_9236_().m_5776_()) {
         player.m_5661_(Component.m_237115_("jjcv.message.not_have_required_item_count"), true);
      }

   }

   private static void close(Player player) {
      if (player instanceof ServerPlayer serverPlayer) {
         serverPlayer.m_6915_();
      }

   }
}
