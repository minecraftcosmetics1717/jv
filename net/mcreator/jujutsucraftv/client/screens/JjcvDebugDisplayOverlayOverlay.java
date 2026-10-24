package net.mcreator.jujutsucraftv.client.screens;

import net.mcreator.jujutsucraftv.procedures.JjcvDebugData10Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData2Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData3Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData4Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData5Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData6Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData7Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData8Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugData9Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvDebugGetDataProcedure;
import net.mcreator.jujutsucraftv.procedures.PlayerCheckBugmaskProcedure;
import net.mcreator.jujutsucraftv.procedures.ShowDebugDisplayProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class JjcvDebugDisplayOverlayOverlay {
   @SubscribeEvent(
      priority = EventPriority.LOW
   )
   public static void eventHandler(RenderGuiEvent.Pre event) {
      int w = event.getWindow().m_85445_();
      int h = event.getWindow().m_85446_();
      Level world = null;
      double x = (double)0.0F;
      double y = (double)0.0F;
      double z = (double)0.0F;
      Player entity = Minecraft.m_91087_().f_91074_;
      if (entity != null) {
         world = entity.m_9236_();
         x = entity.m_20185_();
         y = entity.m_20186_();
         z = entity.m_20189_();
      }

      if (ShowDebugDisplayProcedure.execute(entity)) {
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugGetDataProcedure.execute(entity), w - 115, h - 61, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData2Procedure.execute(entity), w - 115, h - 52, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData3Procedure.execute(entity), w - 115, h - 34, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData4Procedure.execute(entity), w - 115, h - 16, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData5Procedure.execute(entity), w - 115, h - 43, -1, false);
         if (PlayerCheckBugmaskProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData6Procedure.execute(entity), w - 115, h - 97, -1, false);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData7Procedure.execute(entity), w - 115, h - 25, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData8Procedure.execute(entity), w - 115, h - 70, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData9Procedure.execute(entity), w - 115, h - 79, -1, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, JjcvDebugData10Procedure.execute(entity), w - 115, h - 88, -1, false);
      }

   }
}
