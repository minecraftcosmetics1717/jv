package net.mcreator.jujutsucraftv.client.skyblock;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public final class TextureSkyClientEvents {
   private TextureSkyClientEvents() {
   }

   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         if (!Minecraft.m_91087_().m_91385_().isStencilEnabled()) {
            Minecraft.m_91087_().m_91385_().enableStencil();
         }

      });
   }

   @SubscribeEvent
   public static void registerReloadListeners(RegisterClientReloadListenersEvent event) {
      event.registerReloadListener(new TextureSkyManager());
   }

   @SubscribeEvent
   public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)JujutsucraftvModBlockEntities.DOMAIN_SKY_BLUE.get(), TextureSkyBlockEntityRenderer::new);
      event.registerBlockEntityRenderer((BlockEntityType)JujutsucraftvModBlockEntities.DOMAIN_SKY_NIGHT.get(), TextureSkyBlockEntityRenderer::new);
      event.registerBlockEntityRenderer((BlockEntityType)JujutsucraftvModBlockEntities.DOMAIN_SKY_EYE.get(), TextureSkyBlockEntityRenderer::new);
   }
}
