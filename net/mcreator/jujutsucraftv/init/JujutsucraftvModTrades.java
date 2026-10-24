package net.mcreator.jujutsucraftv.init;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.FORGE
)
public class JujutsucraftvModTrades {
   @SubscribeEvent
   public static void registerTrades(VillagerTradesEvent event) {
      if (event.getType() == JujutsucraftvModVillagerProfessions.JUJUTSU_WINDOW.get()) {
         ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack(Items.f_42417_, 10), new ItemStack((ItemLike)JujutsucraftvModItems.CURSED_TOOL_BOX_1.get()), 10, 10, 0.05F));
      }

      if (event.getType() == JujutsucraftvModVillagerProfessions.JUJUTSU_WINDOW.get()) {
         ((List)event.getTrades().get(2)).add(new BasicItemListing(new ItemStack(Items.f_42616_, 10), new ItemStack((ItemLike)JujutsucraftvModItems.DRINKS_1.get()), 32, 10, 0.05F));
      }

      if (event.getType() == JujutsucraftvModVillagerProfessions.JUJUTSU_WINDOW.get()) {
         ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack(Items.f_42417_, 5), new ItemStack((ItemLike)JujutsucraftvModItems.CURSE_POWER_COLOR_CHANGER.get()), 30, 10, 0.05F));
      }

      if (event.getType() == JujutsucraftvModVillagerProfessions.JUJUTSU_WINDOW.get()) {
         ((List)event.getTrades().get(5)).add(new BasicItemListing(new ItemStack(Items.f_42417_, 30), new ItemStack((ItemLike)JujutsucraftvModItems.CURSED_OBJECT_BOX_1.get()), 10, 5, 0.05F));
      }

   }
}
