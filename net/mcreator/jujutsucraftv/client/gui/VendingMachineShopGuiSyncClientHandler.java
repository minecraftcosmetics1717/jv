package net.mcreator.jujutsucraftv.client.gui;

import net.mcreator.jujutsucraftv.network.VendingMachineShopGuiSyncMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public class VendingMachineShopGuiSyncClientHandler {
   public static void handle(VendingMachineShopGuiSyncMessage message) {
      Minecraft minecraft = Minecraft.m_91087_();
      Screen var3 = minecraft.f_91080_;
      if (var3 instanceof VendingMachineShopGuiScreen screen) {
         screen.receiveSyncedData(message.getX(), message.getY(), message.getZ(), message.getStacks(), message.isSelect0(), message.isSelect1(), message.isSelect2());
      }

   }
}
