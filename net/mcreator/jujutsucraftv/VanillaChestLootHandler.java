package net.mcreator.jujutsucraftv;

import java.util.Set;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public final class VanillaChestLootHandler {
   private static final ResourceLocation VILLAGE_ARMORER = new ResourceLocation("minecraft", "chests/village/village_armorer");
   private static final ResourceLocation JUNGLE_TEMPLE_DISPENSER = new ResourceLocation("minecraft", "chests/jungle_temple_dispenser");
   private static final ResourceLocation BASTION_TREASURE = new ResourceLocation("minecraft", "chests/shipwreck_treasure");
   private static final ResourceLocation ABANDONED_MINESHAFT = new ResourceLocation("minecraft", "chests/abandoned_mineshaft");
   private static final ResourceLocation DESERT_PYRAMID = new ResourceLocation("minecraft", "chests/desert_pyramid");
   private static final Set<ResourceLocation> TARGET_LOOT_TABLES;

   private VanillaChestLootHandler() {
   }

   @SubscribeEvent
   public static void onLootTableLoad(LootTableLoadEvent event) {
      ResourceLocation lootTableId = event.getName();
      if (TARGET_LOOT_TABLES.contains(lootTableId)) {
         addChancePool(event, "jujutsucraftv_cursed_tool_box_1", (Item)JujutsucraftvModItems.CURSED_TOOL_BOX_1.get(), 30);
         addChancePool(event, "jujutsucraftv_cursed_tool_box_2", (Item)JujutsucraftvModItems.CURSED_TOOL_BOX_2.get(), DESERT_PYRAMID.equals(lootTableId) ? 15 : 5);
      }
   }

   private static void addChancePool(LootTableLoadEvent event, String poolName, Item item, int chance) {
      if (event.getTable().getPool(poolName) == null) {
         int safeChance = Math.max(0, Math.min(100, chance));
         LootPool pool = LootPool.m_79043_().name(poolName).m_165133_(ConstantValue.m_165692_(1.0F)).m_79076_(LootItem.m_79579_(item).m_79707_(safeChance)).m_79076_(EmptyLootItem.m_79533_().m_79707_(100 - safeChance)).m_79082_();
         event.getTable().addPool(pool);
      }
   }

   static {
      TARGET_LOOT_TABLES = Set.of(VILLAGE_ARMORER, JUNGLE_TEMPLE_DISPENSER, BASTION_TREASURE, ABANDONED_MINESHAFT, DESERT_PYRAMID);
   }
}
