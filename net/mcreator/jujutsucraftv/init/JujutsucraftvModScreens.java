package net.mcreator.jujutsucraftv.init;

import java.util.HashMap;
import net.mcreator.jujutsucraftv.client.gui.CursePowerColorChangerGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.CursedSpiritArmouryGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.CursedTechniqueChangerVGui2Screen;
import net.mcreator.jujutsucraftv.client.gui.CursedTechniqueChangerVGui3Screen;
import net.mcreator.jujutsucraftv.client.gui.CursedTechniqueChangerVGui4Screen;
import net.mcreator.jujutsucraftv.client.gui.CursedTechniqueChangerVGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.CursedTechniqueStarterGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.ElevatorCarpetSettingGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.JjcvConfigGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.OneTimeSpawnerGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.VendingMachineSetGuiScreen;
import net.mcreator.jujutsucraftv.client.gui.VendingMachineShopGuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftvModScreens {
   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_TECHNIQUE_CHANGER_V_GUI.get(), CursedTechniqueChangerVGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_TECHNIQUE_STARTER_GUI.get(), CursedTechniqueStarterGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.ONE_TIME_SPAWNER_GUI.get(), OneTimeSpawnerGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSE_POWER_COLOR_CHANGER_GUI.get(), CursePowerColorChangerGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_SPIRIT_ARMOURY_GUI.get(), CursedSpiritArmouryGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.JJCV_CONFIG_GUI.get(), JjcvConfigGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_TECHNIQUE_CHANGER_V_GUI_2.get(), CursedTechniqueChangerVGui2Screen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_TECHNIQUE_CHANGER_V_GUI_3.get(), CursedTechniqueChangerVGui3Screen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.CURSED_TECHNIQUE_CHANGER_V_GUI_4.get(), CursedTechniqueChangerVGui4Screen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.ELEVATOR_CARPET_SETTING_GUI.get(), ElevatorCarpetSettingGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.VENDING_MACHINE_SHOP_GUI.get(), VendingMachineShopGuiScreen::new);
         MenuScreens.m_96206_((MenuType)JujutsucraftvModMenus.VENDING_MACHINE_SET_GUI.get(), VendingMachineSetGuiScreen::new);
      });
   }

   static void handleTextBoxMessage(JujutsucraftvModMenus.GuiSyncMessage message) {
      String editbox = message.editbox();
      String value = message.value();
      Screen currentScreen = Minecraft.m_91087_().f_91080_;
      if (currentScreen instanceof WidgetScreen sc) {
         HashMap<String, Object> widgets = sc.getWidgets();
         Object obj = widgets.get("text:" + editbox);
         if (obj instanceof EditBox box) {
            box.m_94144_(value);
         }
      }

   }

   public interface WidgetScreen {
      HashMap<String, Object> getWidgets();
   }
}
