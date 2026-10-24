package net.mcreator.jujutsucraftv.client.skyblock;

import net.mcreator.jujutsucraftv.block.TextureSkyBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE,
   value = {Dist.CLIENT}
)
public final class TextureSkyBlockHighlightHandler {
   private TextureSkyBlockHighlightHandler() {
   }

   @SubscribeEvent
   public static void onRenderBlockHighlight(RenderHighlightEvent.Block event) {
      Minecraft minecraft = Minecraft.m_91087_();
      if (minecraft.f_91073_ != null) {
         BlockState state = minecraft.f_91073_.m_8055_(event.getTarget().m_82425_());
         if (state.m_60734_() instanceof TextureSkyBlock) {
            event.setCanceled(true);
         }

      }
   }
}
