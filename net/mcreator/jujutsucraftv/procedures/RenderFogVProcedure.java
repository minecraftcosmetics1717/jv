package net.mcreator.jujutsucraftv.procedures;

import com.mojang.blaze3d.shaders.FogShape;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class RenderFogVProcedure {
   public static ViewportEvent.RenderFog provider = null;

   public static void setDistance(float start, float end) {
      provider.setNearPlaneDistance(start);
      provider.setFarPlaneDistance(end);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }

   }

   public static void setShape(FogShape shape) {
      provider.setFogShape(shape);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }

   }

   @SubscribeEvent
   public static void renderFog(ViewportEvent.RenderFog event) {
      provider = event;
      if (provider.getMode() == FogMode.FOG_TERRAIN) {
         ClientLevel level = Minecraft.m_91087_().f_91073_;
         Entity entity = provider.getCamera().m_90592_();
         if (level != null && entity != null) {
            Vec3 pos = entity.m_20318_((float)provider.getPartialTick());
            execute(provider, entity);
         }
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double color = (double)0.0F;
         double distance = (double)0.0F;
         if (GetDomainExpansionProcedure.execute(entity)) {
            color = entity.getPersistentData().m_128459_("skill_domain") + (double)10.0F;
         } else if (GetNeutralizationProcedure.execute(entity)) {
            color = GetNeutralizationLevelProcedure.execute(entity);
         }

         if (color > (double)10.0F) {
            color -= (double)10.0F;
            if (color != (double)1.0F && color != (double)18.0F) {
               distance = (double)48.0F;
            } else {
               distance = (double)64.0F;
            }

            if (color == (double)60430.0F) {
               setDistance(0.0F, (float)distance);
               setShape(FogShape.SPHERE);
            }
         }

      }
   }
}
