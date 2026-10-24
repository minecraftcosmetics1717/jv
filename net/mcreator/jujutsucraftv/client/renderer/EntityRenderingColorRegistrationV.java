package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.renderer.layer.EntityRenderingColorGeoV;
import net.mcreator.jujutsucraftv.client.renderer.layer.EntityRenderingColorVanillaV;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class EntityRenderingColorRegistrationV {
   @SubscribeEvent
   public static void addLayers(EntityRenderersEvent.AddLayers event) {
      for(EntityType<?> entityType : ForgeRegistries.ENTITY_TYPES) {
         EntityRenderer renderer;
         try {
            renderer = event.getRenderer(entityType);
         } catch (Exception var5) {
            continue;
         }

         if (renderer != null) {
            if (renderer instanceof GeoEntityRenderer) {
               GeoEntityRenderer geoRenderer = (GeoEntityRenderer)renderer;
               geoRenderer.addRenderLayer(new EntityRenderingColorGeoV(geoRenderer));
            } else if (renderer instanceof LivingEntityRenderer) {
               LivingEntityRenderer livingRenderer = (LivingEntityRenderer)renderer;
               livingRenderer.m_115326_(new EntityRenderingColorVanillaV(livingRenderer));
            }
         }
      }

      for(String skin : event.getSkins()) {
         LivingEntityRenderer playerRenderer = event.getSkin(skin);
         if (playerRenderer != null) {
            playerRenderer.m_115326_(new EntityRenderingColorVanillaV(playerRenderer));
         }
      }

   }
}
