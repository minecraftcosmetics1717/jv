package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class ComputeFogColorVProcedure {
   public static ViewportEvent.ComputeFogColor provider = null;

   public static void setColor(int color) {
      provider.setRed((float)(color >> 16 & 255) / 255.0F);
      provider.setGreen((float)(color >> 8 & 255) / 255.0F);
      provider.setBlue((float)(color & 255) / 255.0F);
   }

   public static void setColor(float level, int color) {
      if (!(level <= 0.0F)) {
         if (level >= 1.0F) {
            provider.setRed((float)(color >> 16 & 255) / 255.0F);
            provider.setGreen((float)(color >> 8 & 255) / 255.0F);
            provider.setBlue((float)(color & 255) / 255.0F);
         } else {
            level = Mth.m_14036_(level, 0.0F, 1.0F);
            provider.setRed(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getRed(), 0.0F, 1.0F), (float)(color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setGreen(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getGreen(), 0.0F, 1.0F), (float)(color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setBlue(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getBlue(), 0.0F, 1.0F), (float)(color & 255) / 255.0F), 0.0F, 1.0F));
         }

      }
   }

   @SubscribeEvent
   public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
      provider = event;
      ClientLevel level = Minecraft.m_91087_().f_91073_;
      Entity entity = provider.getCamera().m_90592_();
      if (level != null && entity != null) {
         Vec3 entPos = entity.m_20318_((float)provider.getPartialTick());
         execute(provider, entity);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double color = (double)0.0F;
         if (GetDomainExpansionProcedure.execute(entity)) {
            color = entity.getPersistentData().m_128459_("skill_domain") + (double)10.0F;
         } else if (GetNeutralizationProcedure.execute(entity)) {
            color = GetNeutralizationLevelProcedure.execute(entity);
         }

         if (color > (double)10.0F) {
            color -= (double)10.0F;
            if (color != (double)1.0F && color != (double)18.0F) {
               if (color != (double)4.0F && color != (double)26.0F && color != (double)43.0F) {
                  if (color != (double)6.0F && color != (double)11.0F && color != (double)23.0F && color != (double)25.0F) {
                     if (color == (double)24.0F) {
                        setColor(-3618561);
                     } else if (color == (double)60430.0F) {
                        setColor(-12829561);
                     }
                  } else {
                     setColor(-16777216);
                  }
               } else {
                  setColor(-14155776);
               }
            } else {
               setColor(-11534336);
            }
         }

      }
   }
}
