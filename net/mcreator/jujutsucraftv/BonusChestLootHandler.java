package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.LootNumberProviderType;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.NumberProviders;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public final class BonusChestLootHandler {
   private static final ResourceLocation BONUS_CHEST = new ResourceLocation("minecraft", "chests/spawn_bonus_chest");
   private static final String POOL_NAME = "jujutsucraftv_cursed_object_box_1";
   private static final NumberProvider ONLINE_PLAYER_COUNT = new NumberProvider() {
      public float m_142688_(LootContext context) {
         return (float)Math.max(1, context.m_78952_().m_7654_().m_7416_());
      }

      public LootNumberProviderType m_142587_() {
         return NumberProviders.f_165731_;
      }
   };

   private BonusChestLootHandler() {
   }

   @SubscribeEvent
   public static void onLootTableLoad(LootTableLoadEvent event) {
      if (BONUS_CHEST.equals(event.getName()) && event.getTable().getPool("jujutsucraftv_cursed_object_box_1") == null) {
         event.getTable().addPool(LootPool.m_79043_().name("jujutsucraftv_cursed_object_box_1").m_165133_(ConstantValue.m_165692_(1.0F)).m_79076_(LootItem.m_79579_((ItemLike)JujutsucraftvModItems.CURSED_OBJECT_BOX_1.get()).m_79078_(SetItemCountFunction.m_165412_(ONLINE_PLAYER_COUNT))).m_79082_());
      }
   }
}
