package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.chat.Component;

public class ReturnCurseObjectProcedure {
   public static String execute() {
      String txt = "";
      txt = Component.m_237115_("jjcv.item.cursed_object").getString();
      return txt;
   }
}
