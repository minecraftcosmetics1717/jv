package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck1Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck2Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck3Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck4Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck5Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck6Procedure;
import net.mcreator.jujutsucraftv.procedures.JjcvConfigCheck7Procedure;
import net.mcreator.jujutsucraftv.world.inventory.JjcvConfigGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class JjcvConfigGuiScreen extends AbstractContainerScreen<JjcvConfigGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static Checkbox jjcv_config_1;
   public static Checkbox jjcv_config_2;
   public static Checkbox jjcv_config_3;
   public static Checkbox jjcv_config_4;
   public static Checkbox jjcv_config_5;
   public static Checkbox jjcv_config_6;
   public static Checkbox jjcv_config_7;
   private static final ResourceLocation texture;

   public JjcvConfigGuiScreen(JjcvConfigGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 350;
      this.f_97727_ = 200;
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
      textstate.put("checkboxin:jjcv_config_1", jjcv_config_1.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_2", jjcv_config_2.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_3", jjcv_config_3.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_4", jjcv_config_4.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_5", jjcv_config_5.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_6", jjcv_config_6.m_93840_() ? "true" : "false");
      textstate.put("checkboxin:jjcv_config_7", jjcv_config_7.m_93840_() ? "true" : "false");
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
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_mahoraga_world_slash_always_avai"), 27, 132, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_get_curse_power_color_changer_wh"), 27, 84, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_add_without_ct_domain"), 27, 36, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_wipadd_all_technique_domain"), 27, 12, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_display_jjc_key_guide"), 27, 60, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_get_proffesion_changer_when_used"), 27, 108, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.label_sukuna_dismantle_combo_always_av"), 27, 159, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      jjcv_config_1 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 6, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_1"), JjcvConfigCheck1Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_1", jjcv_config_1);
      this.m_142416_(jjcv_config_1);
      jjcv_config_2 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 30, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_2"), JjcvConfigCheck2Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_2", jjcv_config_2);
      this.m_142416_(jjcv_config_2);
      jjcv_config_3 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 54, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_3"), JjcvConfigCheck3Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_3", jjcv_config_3);
      this.m_142416_(jjcv_config_3);
      jjcv_config_4 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 78, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_4"), JjcvConfigCheck4Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_4", jjcv_config_4);
      this.m_142416_(jjcv_config_4);
      jjcv_config_5 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 102, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_5"), JjcvConfigCheck5Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_5", jjcv_config_5);
      this.m_142416_(jjcv_config_5);
      jjcv_config_6 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 126, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_6"), JjcvConfigCheck6Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_6", jjcv_config_6);
      this.m_142416_(jjcv_config_6);
      jjcv_config_7 = new Checkbox(this.f_97735_ + 3, this.f_97736_ + 153, 20, 20, Component.m_237115_("gui.jujutsucraftv.jjcv_config_gui.jjcv_config_7"), JjcvConfigCheck7Procedure.execute(this.world));
      guistate.put("checkbox:jjcv_config_7", jjcv_config_7);
      this.m_142416_(jjcv_config_7);
   }

   static {
      guistate = JjcvConfigGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/jjcv_config_gui.png");
   }
}
