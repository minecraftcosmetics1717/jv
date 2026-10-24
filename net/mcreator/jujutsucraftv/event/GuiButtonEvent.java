package net.mcreator.jujutsucraftv.event;

import net.mcreator.jujutsucraft.client.gui.SelectTechniqueScreen;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.network.OpenJJCVPacket;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class GuiButtonEvent {
   @SubscribeEvent
   public static void onGuiInit(ScreenEvent.Init.Post event) {
      Screen screen = event.getScreen();
      if (screen instanceof SelectTechniqueScreen gui) {
         int left = gui.getGuiLeft();
         int top = gui.getGuiTop();
         ImageButton customButton = new ImageButton(left + 415, top + 87, 16, 64, 0, 0, 64, new ResourceLocation("jujutsucraftv", "textures/screens/atlas/imagebutton_icon_right_arrow_jjcv.png"), 16, 128, (button) -> JujutsucraftvMod.PACKET_HANDLER.sendToServer(new OpenJJCVPacket(0)));
         event.addListener(customButton);
      }

   }
}
