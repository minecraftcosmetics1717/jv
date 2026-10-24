package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.ElevatorCarpetSettingGuiButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.ElevatorCarpetSettingGuiMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ElevatorCarpetSettingGuiScreen extends AbstractContainerScreen<ElevatorCarpetSettingGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static EditBox up_num;
   public static EditBox down_num;
   public static Checkbox up_check;
   public static Checkbox down_check;
   Button button_select;
   private static final ResourceLocation texture;

   public ElevatorCarpetSettingGuiScreen(ElevatorCarpetSettingGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 100;
      this.f_97727_ = 130;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      up_num.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      down_num.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      RenderSystem.disableBlend();
   }

   public HashMap<String, Object> getWidgets() {
      return guistate;
   }

   public boolean m_7933_(int key, int b, int c) {
      if (key == 256) {
         this.f_96541_.f_91074_.m_6915_();
         return true;
      } else if (up_num.m_93696_()) {
         return up_num.m_7933_(key, b, c);
      } else {
         return down_num.m_93696_() ? down_num.m_7933_(key, b, c) : super.m_7933_(key, b, c);
      }
   }

   public void m_181908_() {
      super.m_181908_();
      up_num.m_94120_();
      down_num.m_94120_();
   }

   public void m_6574_(Minecraft minecraft, int width, int height) {
      String up_numValue = up_num.m_94155_();
      String down_numValue = down_num.m_94155_();
      super.m_6574_(minecraft, width, height);
      up_num.m_94144_(up_numValue);
      down_num.m_94144_(down_numValue);
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.label_set_movement_pos"), 7, 13, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.label_up"), 4, 31, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.label_down"), 1, 70, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      up_num = new EditBox(this.f_96547_, this.f_97735_ + 32, this.f_97736_ + 35, 49, 18, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.up_num"));
      up_num.m_94199_(32767);
      guistate.put("text:up_num", up_num);
      this.m_7787_(up_num);
      down_num = new EditBox(this.f_96547_, this.f_97735_ + 32, this.f_97736_ + 71, 49, 18, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.down_num"));
      down_num.m_94199_(32767);
      guistate.put("text:down_num", down_num);
      this.m_7787_(down_num);
      this.button_select = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.button_select"), (e) -> {
         textstate.put("textin:up_num", up_num.m_94155_());
         textstate.put("textin:down_num", down_num.m_94155_());
         textstate.put("checkboxin:up_check", up_check.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:down_check", down_check.m_93840_() ? "true" : "false");
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new ElevatorCarpetSettingGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         ElevatorCarpetSettingGuiButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 22, this.f_97736_ + 100, 56, 20).m_253136_();
      guistate.put("button:button_select", this.button_select);
      this.m_142416_(this.button_select);
      up_check = new Checkbox(this.f_97735_ + 4, this.f_97736_ + 46, 20, 20, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.up_check"), false);
      guistate.put("checkbox:up_check", up_check);
      this.m_142416_(up_check);
      down_check = new Checkbox(this.f_97735_ + 4, this.f_97736_ + 82, 20, 20, Component.m_237115_("gui.jujutsucraftv.elevator_carpet_setting_gui.down_check"), false);
      guistate.put("checkbox:down_check", down_check);
      this.m_142416_(down_check);
   }

   static {
      guistate = ElevatorCarpetSettingGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/elevator_carpet_setting_gui.png");
   }
}
