package net.mcreator.jujutsucraftv.init;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_armoury;
import net.mcreator.jujutsucraftv.client.renderer.TrainedCursedSpiritArmoryRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModCuriosRenderers {
   @SubscribeEvent
   public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
      evt.registerLayerDefinition(JujutsucraftvModLayerDefinitions.TRAINED_CURSED_SPIRIT_ARMORY, Modelcursedspirit_armoury::createBodyLayer);
   }

   @SubscribeEvent
   public static void clientSetup(FMLClientSetupEvent evt) {
      CuriosRendererRegistry.register((Item)JujutsucraftvModItems.TRAINED_CURSED_SPIRIT_ARMORY.get(), TrainedCursedSpiritArmoryRenderer::new);
   }
}
