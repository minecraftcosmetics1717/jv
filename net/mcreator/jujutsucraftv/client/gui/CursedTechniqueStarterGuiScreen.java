package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.CursedTechniqueStarterGuiButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueStarterGuiMenu;
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

public class CursedTechniqueStarterGuiScreen extends AbstractContainerScreen<CursedTechniqueStarterGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static EditBox skill_number;
   public static EditBox cost;
   Button button_selection;
   private static final ResourceLocation texture;

   public CursedTechniqueStarterGuiScreen(CursedTechniqueStarterGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 110;
      this.f_97727_ = 110;
   }

   public boolean m_7043_() {
      return true;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      skill_number.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      cost.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
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
      } else if (skill_number.m_93696_()) {
         return skill_number.m_7933_(key, b, c);
      } else {
         return cost.m_93696_() ? cost.m_7933_(key, b, c) : super.m_7933_(key, b, c);
      }
   }

   public void m_181908_() {
      super.m_181908_();
      skill_number.m_94120_();
      cost.m_94120_();
   }

   public void m_6574_(Minecraft minecraft, int width, int height) {
      String skill_numberValue = skill_number.m_94155_();
      String costValue = cost.m_94155_();
      super.m_6574_(minecraft, width, height);
      skill_number.m_94144_(skill_numberValue);
      cost.m_94144_(costValue);
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_starter_gui.label_skill_numbernbt"), 9, 6, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_starter_gui.label_cost"), 45, 42, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      skill_number = new EditBox(this.f_96547_, this.f_97735_ + 19, this.f_97736_ + 16, 70, 18, Component.m_237115_("gui.jujutsucraftv.cursed_technique_starter_gui.skill_number"));
      skill_number.m_94199_(32767);
      guistate.put("text:skill_number", skill_number);
      this.m_7787_(skill_number);
      cost = new EditBox(this.f_96547_, this.f_97735_ + 19, this.f_97736_ + 52, 70, 18, Component.m_237115_("gui.jujutsucraftv.cursed_technique_starter_gui.cost"));
      cost.m_94199_(32767);
      guistate.put("text:cost", cost);
      this.m_7787_(cost);
      this.button_selection = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_starter_gui.button_selection"), (e) -> {
         textstate.put("textin:skill_number", skill_number.m_94155_());
         textstate.put("textin:cost", cost.m_94155_());
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueStarterGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         CursedTechniqueStarterGuiButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 18, this.f_97736_ + 78, 72, 20).m_253136_();
      guistate.put("button:button_selection", this.button_selection);
      this.m_142416_(this.button_selection);
   }

   static {
      guistate = CursedTechniqueStarterGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/cursed_technique_starter_gui.png");
   }
}
