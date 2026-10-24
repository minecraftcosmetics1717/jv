package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.CursedTechniqueChangerVGui2ButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CursedTechniqueChangerVGui2Screen extends AbstractContainerScreen<CursedTechniqueChangerVGui2Menu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_okkotsutsurugi;
   Button button_random;
   Button button_nonsorcerer;
   Button button_withoutcursedtechnique;
   Button button_daburakaraba;
   ImageButton imagebutton_icon_right_arrow_left;
   ImageButton imagebutton_icon_right_arrow_right;
   private static final ResourceLocation texture;

   public CursedTechniqueChangerVGui2Screen(CursedTechniqueChangerVGui2Menu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 390;
      this.f_97727_ = 230;
   }

   public boolean m_7043_() {
      return true;
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
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_jujutsu_kaisen_modulo"), 5, 8, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_sorcerers"), 82, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_others"), 5, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_curse_users"), 158, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_jujutsu"), 82, 21, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.label_simurian"), 235, 30, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_okkotsutsurugi = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.button_okkotsutsurugi"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(0, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 82, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_okkotsutsurugi", this.button_okkotsutsurugi);
      this.m_142416_(this.button_okkotsutsurugi);
      this.button_random = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.button_random"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(1, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_random", this.button_random);
      this.m_142416_(this.button_random);
      this.button_nonsorcerer = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.button_nonsorcerer"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(2, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_nonsorcerer", this.button_nonsorcerer);
      this.m_142416_(this.button_nonsorcerer);
      this.button_withoutcursedtechnique = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.button_withoutcursedtechnique"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(3, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_withoutcursedtechnique", this.button_withoutcursedtechnique);
      this.m_142416_(this.button_withoutcursedtechnique);
      this.button_daburakaraba = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui_2.button_daburakaraba"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(4, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_daburakaraba", this.button_daburakaraba);
      this.m_142416_(this.button_daburakaraba);
      this.imagebutton_icon_right_arrow_left = new ImageButton(this.f_97735_ + -22, this.f_97736_ + 84, 16, 64, 0, 0, 64, new ResourceLocation("jujutsucraftv:textures/screens/atlas/imagebutton_icon_right_arrow_left.png"), 16, 128, (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(5, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z, textstate);
      });
      guistate.put("button:imagebutton_icon_right_arrow_left", this.imagebutton_icon_right_arrow_left);
      this.m_142416_(this.imagebutton_icon_right_arrow_left);
      this.imagebutton_icon_right_arrow_right = new ImageButton(this.f_97735_ + 392, this.f_97736_ + 84, 16, 64, 0, 0, 64, new ResourceLocation("jujutsucraftv:textures/screens/atlas/imagebutton_icon_right_arrow_right.png"), 16, 128, (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGui2ButtonMessage(6, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGui2ButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z, textstate);
      });
      guistate.put("button:imagebutton_icon_right_arrow_right", this.imagebutton_icon_right_arrow_right);
      this.m_142416_(this.imagebutton_icon_right_arrow_right);
   }

   static {
      guistate = CursedTechniqueChangerVGui2Menu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/cursed_technique_changer_v_gui_2.png");
   }
}
