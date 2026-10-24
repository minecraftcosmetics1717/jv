package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.CursePowerColorChangerGuiButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.CursePowerColorChangerGuiMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CursePowerColorChangerGuiScreen extends AbstractContainerScreen<CursePowerColorChangerGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static EditBox select_curse_color;
   Button button_select;
   private static final ResourceLocation texture;

   public CursePowerColorChangerGuiScreen(CursePowerColorChangerGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 200;
      this.f_97727_ = 150;
   }

   public boolean m_7043_() {
      return true;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      select_curse_color.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
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
      } else {
         return select_curse_color.m_93696_() ? select_curse_color.m_7933_(key, b, c) : super.m_7933_(key, b, c);
      }
   }

   public void m_181908_() {
      super.m_181908_();
      select_curse_color.m_94120_();
   }

   public void m_6574_(Minecraft minecraft, int width, int height) {
      String select_curse_colorValue = select_curse_color.m_94155_();
      super.m_6574_(minecraft, width, height);
      select_curse_color.m_94144_(select_curse_colorValue);
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_curse_power_color"), 54, 8, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_1"), 9, 98, -10040065, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_2_orange"), 9, 107, -26317, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_3_red"), 9, 116, -52327, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_4_green"), 9, 125, -13369549, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_5_purple"), 9, 134, -6750055, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_6_yellow"), 81, 98, -205, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_7_pink"), 81, 107, -3407872, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_8_deepblue"), 81, 116, -16777114, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_9_deepgreen"), 81, 125, -16751104, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_10_black"), 144, 98, -16777216, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_11_white"), 144, 107, -1, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_0"), 30, 26, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.label_23_enchant"), 144, 125, -65281, false);
   }

   public void m_7856_() {
      super.m_7856_();
      select_curse_color = new EditBox(this.f_96547_, this.f_97735_ + 54, this.f_97736_ + 45, 88, 18, Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.select_curse_color"));
      select_curse_color.m_94199_(32767);
      guistate.put("text:select_curse_color", select_curse_color);
      this.m_7787_(select_curse_color);
      this.button_select = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.curse_power_color_changer_gui.button_select"), (e) -> {
         textstate.put("textin:select_curse_color", select_curse_color.m_94155_());
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursePowerColorChangerGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         CursePowerColorChangerGuiButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 70, this.f_97736_ + 71, 56, 20).m_253136_();
      guistate.put("button:button_select", this.button_select);
      this.m_142416_(this.button_select);
   }

   static {
      guistate = CursePowerColorChangerGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/curse_power_color_changer_gui.png");
   }
}
