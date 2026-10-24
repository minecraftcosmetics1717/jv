package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import net.mcreator.jujutsucraftv.network.JjcvConfigSyncMessage;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class CloseJjcvConfigGuiProcedure {
   private static final String PROTOCOL_VERSION = "1";
   private static SimpleChannel INSTANCE;
   private static int packetId = 0;

   public static void registerPackets() {
      INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("jujutsucraftv", "config_network"), () -> "1", "1"::equals, "1"::equals);
      INSTANCE.registerMessage(packetId++, JjcvConfigSyncMessage.class, JjcvConfigSyncMessage::encoder, JjcvConfigSyncMessage::new, JjcvConfigSyncMessage::handle);
   }

   public static void execute(LevelAccessor world, HashMap guistate) {
      if (guistate != null && INSTANCE != null) {
         send(1, isChecked(guistate, "checkboxin:jjcv_config_1"));
         send(2, isChecked(guistate, "checkboxin:jjcv_config_2"));
         send(3, isChecked(guistate, "checkboxin:jjcv_config_3"));
         send(4, isChecked(guistate, "checkboxin:jjcv_config_4"));
         send(5, isChecked(guistate, "checkboxin:jjcv_config_5"));
         send(6, isChecked(guistate, "checkboxin:jjcv_config_6"));
         send(7, isChecked(guistate, "checkboxin:jjcv_config_7"));
      }
   }

   private static void send(int id, boolean value) {
      INSTANCE.sendToServer(new JjcvConfigSyncMessage(id, value));
   }

   public static void updateServerVars(LevelAccessor world, int id, boolean value) {
      JujutsucraftvModVariables.MapVariables vars = JujutsucraftvModVariables.MapVariables.get(world);
      switch (id) {
         case 1 -> vars.jjcv_config_add_all_domain = value;
         case 2 -> vars.jjcv_config_add_without_ct_domain = value;
         case 3 -> vars.jjcv_config_gui_jjc_key = value;
         case 4 -> vars.jjcv_config_cp_color_get = value;
         case 5 -> vars.jjcv_config_job_selector_get = value;
         case 6 -> vars.jjcv_config_mahoraga_19 = value;
         case 7 -> vars.jjcv_config_sukuna_dismantle_combo = value;
      }

      vars.syncData(world);
   }

   private static boolean isChecked(HashMap guistate, String key) {
      return guistate.containsKey(key) && ((String)guistate.get(key)).equals("true");
   }
}
