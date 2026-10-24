package net.mcreator.jujutsucraftv.procedures;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.registries.ForgeRegistries;

public class UseCursedObjectBoxProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (world instanceof ServerLevel serverLevel) {
         if (entity instanceof ServerPlayer player) {
            if (itemstack != null && !itemstack.m_41619_()) {
               int lootRolls = 1;
               ResourceLocation lootTableId;
               if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_1.get()) {
                  lootTableId = new ResourceLocation("jujutsucraftv", "chests/cursed_object_box_1");
               } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_2.get()) {
                  lootTableId = new ResourceLocation("jujutsucraftv", "chests/cursed_object_box_2");
               } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_OBJECT_BOX_3.get()) {
                  lootTableId = new ResourceLocation("jujutsucraftv", "chests/cursed_object_box_3");
               } else if (itemstack.m_41720_() == JujutsucraftvModItems.CURSED_TOOL_BOX_1.get()) {
                  lootTableId = new ResourceLocation("jujutsucraft", "entities/stevenson_screen");
               } else {
                  if (itemstack.m_41720_() != JujutsucraftvModItems.CURSED_TOOL_BOX_2.get()) {
                     return;
                  }

                  lootTableId = new ResourceLocation("jujutsucraft", "entities/stevenson_screen");
                  lootRolls = 3;
               }

               SoundEvent sound = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minecraft", "block.chest.open"));
               if (sound != null) {
                  serverLevel.m_5594_((Player)null, player.m_20183_(), sound, SoundSource.NEUTRAL, 1.0F, 0.8F + player.m_217043_().m_188501_() * 0.4F);
               }

               LootTable lootTable = serverLevel.m_7654_().m_278653_().m_278676_(lootTableId);
               LootParams lootParams = (new LootParams.Builder(serverLevel)).m_287286_(LootContextParams.f_81460_, player.m_20182_()).m_287289_(LootContextParams.f_81455_, player).m_287239_(player.m_36336_()).m_287235_(LootContextParamSets.f_81411_);

               for(int roll = 0; roll < lootRolls; ++roll) {
                  ObjectListIterator var11 = lootTable.m_287195_(lootParams).iterator();

                  while(var11.hasNext()) {
                     ItemStack rewardStack = (ItemStack)var11.next();
                     if (!rewardStack.m_41619_()) {
                        ItemStack remainingStack = rewardStack.m_41777_();
                        player.m_150109_().m_36054_(remainingStack);
                        if (!remainingStack.m_41619_()) {
                           player.m_36176_(remainingStack, false);
                        }
                     }
                  }
               }

               player.f_36096_.m_38946_();
               if (!player.m_7500_()) {
                  itemstack.m_41774_(1);
               }

            }
         }
      }
   }
}
