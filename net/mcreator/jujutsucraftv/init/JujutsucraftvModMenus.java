package net.mcreator.jujutsucraftv.init;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.world.inventory.CursePowerColorChangerGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.CursedSpiritArmouryGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui2Menu;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui3Menu;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui4Menu;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueStarterGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.ElevatorCarpetSettingGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.JjcvConfigGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.OneTimeSpawnerGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineSetGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineShopGuiMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY;
   public static final RegistryObject<MenuType<CursedTechniqueChangerVGuiMenu>> CURSED_TECHNIQUE_CHANGER_V_GUI;
   public static final RegistryObject<MenuType<CursedTechniqueStarterGuiMenu>> CURSED_TECHNIQUE_STARTER_GUI;
   public static final RegistryObject<MenuType<OneTimeSpawnerGuiMenu>> ONE_TIME_SPAWNER_GUI;
   public static final RegistryObject<MenuType<CursePowerColorChangerGuiMenu>> CURSE_POWER_COLOR_CHANGER_GUI;
   public static final RegistryObject<MenuType<CursedSpiritArmouryGuiMenu>> CURSED_SPIRIT_ARMOURY_GUI;
   public static final RegistryObject<MenuType<JjcvConfigGuiMenu>> JJCV_CONFIG_GUI;
   public static final RegistryObject<MenuType<CursedTechniqueChangerVGui2Menu>> CURSED_TECHNIQUE_CHANGER_V_GUI_2;
   public static final RegistryObject<MenuType<CursedTechniqueChangerVGui3Menu>> CURSED_TECHNIQUE_CHANGER_V_GUI_3;
   public static final RegistryObject<MenuType<CursedTechniqueChangerVGui4Menu>> CURSED_TECHNIQUE_CHANGER_V_GUI_4;
   public static final RegistryObject<MenuType<ElevatorCarpetSettingGuiMenu>> ELEVATOR_CARPET_SETTING_GUI;
   public static final RegistryObject<MenuType<VendingMachineShopGuiMenu>> VENDING_MACHINE_SHOP_GUI;
   public static final RegistryObject<MenuType<VendingMachineSetGuiMenu>> VENDING_MACHINE_SET_GUI;

   public static void setText(String boxname, String value, @Nullable ServerPlayer player) {
      if (player != null) {
         JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new GuiSyncMessage(boxname, value));
      } else {
         JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new GuiSyncMessage(boxname, value));
      }

   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(GuiSyncMessage.class, GuiSyncMessage::buffer, GuiSyncMessage::new, GuiSyncMessage::handleData);
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "jujutsucraftv");
      CURSED_TECHNIQUE_CHANGER_V_GUI = REGISTRY.register("cursed_technique_changer_v_gui", () -> IForgeMenuType.create(CursedTechniqueChangerVGuiMenu::new));
      CURSED_TECHNIQUE_STARTER_GUI = REGISTRY.register("cursed_technique_starter_gui", () -> IForgeMenuType.create(CursedTechniqueStarterGuiMenu::new));
      ONE_TIME_SPAWNER_GUI = REGISTRY.register("one_time_spawner_gui", () -> IForgeMenuType.create(OneTimeSpawnerGuiMenu::new));
      CURSE_POWER_COLOR_CHANGER_GUI = REGISTRY.register("curse_power_color_changer_gui", () -> IForgeMenuType.create(CursePowerColorChangerGuiMenu::new));
      CURSED_SPIRIT_ARMOURY_GUI = REGISTRY.register("cursed_spirit_armoury_gui", () -> IForgeMenuType.create(CursedSpiritArmouryGuiMenu::new));
      JJCV_CONFIG_GUI = REGISTRY.register("jjcv_config_gui", () -> IForgeMenuType.create(JjcvConfigGuiMenu::new));
      CURSED_TECHNIQUE_CHANGER_V_GUI_2 = REGISTRY.register("cursed_technique_changer_v_gui_2", () -> IForgeMenuType.create(CursedTechniqueChangerVGui2Menu::new));
      CURSED_TECHNIQUE_CHANGER_V_GUI_3 = REGISTRY.register("cursed_technique_changer_v_gui_3", () -> IForgeMenuType.create(CursedTechniqueChangerVGui3Menu::new));
      CURSED_TECHNIQUE_CHANGER_V_GUI_4 = REGISTRY.register("cursed_technique_changer_v_gui_4", () -> IForgeMenuType.create(CursedTechniqueChangerVGui4Menu::new));
      ELEVATOR_CARPET_SETTING_GUI = REGISTRY.register("elevator_carpet_setting_gui", () -> IForgeMenuType.create(ElevatorCarpetSettingGuiMenu::new));
      VENDING_MACHINE_SHOP_GUI = REGISTRY.register("vending_machine_shop_gui", () -> IForgeMenuType.create(VendingMachineShopGuiMenu::new));
      VENDING_MACHINE_SET_GUI = REGISTRY.register("vending_machine_set_gui", () -> IForgeMenuType.create(VendingMachineSetGuiMenu::new));
   }

   public static class GuiSyncMessage {
      private final String textboxid;
      private final String data;

      public GuiSyncMessage(FriendlyByteBuf buffer) {
         this.textboxid = buffer.m_130238_().getString();
         this.data = buffer.m_130238_().getString();
      }

      public GuiSyncMessage(String textboxid, String data) {
         this.textboxid = textboxid;
         this.data = data;
      }

      public static void buffer(GuiSyncMessage message, FriendlyByteBuf buffer) {
         buffer.m_130083_(Component.m_237113_(message.textboxid));
         buffer.m_130083_(Component.m_237113_(message.data));
      }

      public static void handleData(GuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               JujutsucraftvModScreens.handleTextBoxMessage(message);
            }

         });
         context.setPacketHandled(true);
      }

      String editbox() {
         return this.textboxid;
      }

      String value() {
         return this.data;
      }
   }
}
