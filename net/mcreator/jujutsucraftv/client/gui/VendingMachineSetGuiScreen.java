package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect0Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect1Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect2Procedure;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineSetGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class VendingMachineSetGuiScreen extends AbstractContainerScreen<VendingMachineSetGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static Checkbox set0;
   public static Checkbox set1;
   public static Checkbox set2;
   private static final ResourceLocation texture;

   public VendingMachineSetGuiScreen(VendingMachineSetGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 180;
      this.f_97727_ = 180;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      RenderSystem.disableBlend();
   }

   public static HashMap<String, String> getTextboxValues() {
      textstate.put("checkboxin:set0", set0.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:set1", set1.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:set2", set2.m_93840_() ? "true" : "false");
      return textstate;
   }

   public HashMap<String, Object> getWidgets() {
      return guistate;
   }

   public boolean m_7933_(int key, int b, int c) {
      if (key == 256) {
         this.f_96541_.f_91074_.m_6915_();
         return true;
      } else {
         return super.m_7933_(key, b, c);
      }
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.vending_machine_set_gui.label_buy"), 89, 5, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.vending_machine_set_gui.label_sell"), 134, 5, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      set0 = new Checkbox(this.f_97735_ + 35, this.f_97736_ + 14, 20, 20, Component.m_237115_("gui.jujutsucraftv.vending_machine_set_gui.set0"), VendingMachineSelect0Procedure.execute(this.world, (double)this.x, (double)this.y, (double)this.z));
      guistate.put("checkbox:set0", set0);
      this.m_142416_(set0);
      set1 = new Checkbox(this.f_97735_ + 35, this.f_97736_ + 41, 20, 20, Component.m_237115_("gui.jujutsucraftv.vending_machine_set_gui.set1"), VendingMachineSelect1Procedure.execute(this.world, (double)this.x, (double)this.y, (double)this.z));
      guistate.put("checkbox:set1", set1);
      this.m_142416_(set1);
      set2 = new Checkbox(this.f_97735_ + 35, this.f_97736_ + 68, 20, 20, Component.m_237115_("gui.jujutsucraftv.vending_machine_set_gui.set2"), VendingMachineSelect2Procedure.execute(this.world, (double)this.x, (double)this.y, (double)this.z));
      guistate.put("checkbox:set2", set2);
      this.m_142416_(set2);
   }

   static {
      guistate = VendingMachineSetGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/vending_machine_set_gui.png");
   }
}
