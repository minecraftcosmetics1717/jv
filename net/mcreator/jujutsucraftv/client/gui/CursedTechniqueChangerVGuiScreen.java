package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.CursedTechniqueChangerVGuiButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CursedTechniqueChangerVGuiScreen extends AbstractContainerScreen<CursedTechniqueChangerVGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_nonsorcerer;
   Button button_withoutcursedtechnique;
   Button button_random;
   Button button_blindness;
   Button button_tamamonomaeincarnate;
   Button button_forest;
   Button button_insect;
   Button button_mammoth;
   Button button_kuchisakeonna;
   Button button_ganesha;
   Button button_bayer;
   Button button_bagmask;
   Button button_esokechizu;
   Button button_esokechizu1;
   Button button_whackamole;
   Button button_necknecklace;
   Button button_gakuganji;
   Button button_utahime;
   Button button_hazenoki;
   Button button_amairin;
   Button button_samurai_in_armor;
   Button button_akuroo_otaka;
   Button button_hasabamimiko;
   Button button_tsuchigumo;
   Button button_shigemoharuta;
   Button button_hasabananako;
   ImageButton imagebutton_icon_left_arrow_jjc;
   ImageButton imagebutton_icon_right_arrow_right;
   private static final ResourceLocation texture;

   public CursedTechniqueChangerVGuiScreen(CursedTechniqueChangerVGuiMenu container, Inventory inventory, Component text) {
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
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_other"), 5, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_cursed_spirits"), 235, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_curse_users"), 158, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_jujutsu_sorcers"), 82, 21, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_sorcerers"), 82, 30, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.label_jujutsu_kaisennot_added_to_jjc"), 5, 8, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_nonsorcerer = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_nonsorcerer"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_nonsorcerer", this.button_nonsorcerer);
      this.m_142416_(this.button_nonsorcerer);
      this.button_withoutcursedtechnique = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_withoutcursedtechnique"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(1, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_withoutcursedtechnique", this.button_withoutcursedtechnique);
      this.m_142416_(this.button_withoutcursedtechnique);
      this.button_random = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_random"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(2, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 5, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_random", this.button_random);
      this.m_142416_(this.button_random);
      this.button_blindness = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_blindness"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(3, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 134, 72, 20).m_253136_();
      guistate.put("button:button_blindness", this.button_blindness);
      this.m_142416_(this.button_blindness);
      this.button_tamamonomaeincarnate = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_tamamonomaeincarnate"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(4, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 179, 72, 20).m_253136_();
      guistate.put("button:button_tamamonomaeincarnate", this.button_tamamonomaeincarnate);
      this.m_142416_(this.button_tamamonomaeincarnate);
      this.button_forest = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_forest"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(5, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 311, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_forest", this.button_forest);
      this.m_142416_(this.button_forest);
      this.button_insect = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_insect"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(6, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_insect", this.button_insect);
      this.m_142416_(this.button_insect);
      this.button_mammoth = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_mammoth"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(7, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_mammoth", this.button_mammoth);
      this.m_142416_(this.button_mammoth);
      this.button_kuchisakeonna = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_kuchisakeonna"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(8, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 8, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 201, 72, 20).m_253136_();
      guistate.put("button:button_kuchisakeonna", this.button_kuchisakeonna);
      this.m_142416_(this.button_kuchisakeonna);
      this.button_ganesha = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_ganesha"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(9, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 9, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 311, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_ganesha", this.button_ganesha);
      this.m_142416_(this.button_ganesha);
      this.button_bayer = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_bayer"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(10, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 10, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_bayer", this.button_bayer);
      this.m_142416_(this.button_bayer);
      this.button_bagmask = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_bagmask"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(11, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 11, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_bagmask", this.button_bagmask);
      this.m_142416_(this.button_bagmask);
      this.button_esokechizu = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_esokechizu"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(12, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 12, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 82, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_esokechizu", this.button_esokechizu);
      this.m_142416_(this.button_esokechizu);
      this.button_esokechizu1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_esokechizu1"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(13, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 13, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_esokechizu1", this.button_esokechizu1);
      this.m_142416_(this.button_esokechizu1);
      this.button_whackamole = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_whackamole"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(14, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 14, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_whackamole", this.button_whackamole);
      this.m_142416_(this.button_whackamole);
      this.button_necknecklace = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_necknecklace"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(15, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 15, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 111, 72, 20).m_253136_();
      guistate.put("button:button_necknecklace", this.button_necknecklace);
      this.m_142416_(this.button_necknecklace);
      this.button_gakuganji = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_gakuganji"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(16, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 16, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 82, this.f_97736_ + 44, 72, 20).m_253136_();
      guistate.put("button:button_gakuganji", this.button_gakuganji);
      this.m_142416_(this.button_gakuganji);
      this.button_utahime = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_utahime"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(17, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 17, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 82, this.f_97736_ + 66, 72, 20).m_253136_();
      guistate.put("button:button_utahime", this.button_utahime);
      this.m_142416_(this.button_utahime);
      this.button_hazenoki = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_hazenoki"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(18, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 18, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 156, 72, 20).m_253136_();
      guistate.put("button:button_hazenoki", this.button_hazenoki);
      this.m_142416_(this.button_hazenoki);
      this.button_amairin = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_amairin"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(19, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 19, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 82, this.f_97736_ + 111, 72, 20).m_253136_();
      guistate.put("button:button_amairin", this.button_amairin);
      this.m_142416_(this.button_amairin);
      this.button_samurai_in_armor = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_samurai_in_armor"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(20, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 20, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 235, this.f_97736_ + 156, 72, 20).m_253136_();
      guistate.put("button:button_samurai_in_armor", this.button_samurai_in_armor);
      this.m_142416_(this.button_samurai_in_armor);
      this.button_akuroo_otaka = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_akuroo_otaka"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(21, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 21, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 311, this.f_97736_ + 89, 72, 20).m_253136_();
      guistate.put("button:button_akuroo_otaka", this.button_akuroo_otaka);
      this.m_142416_(this.button_akuroo_otaka);
      this.button_hasabamimiko = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_hasabamimiko"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(22, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 22, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 111, 72, 20).m_253136_();
      guistate.put("button:button_hasabamimiko", this.button_hasabamimiko);
      this.m_142416_(this.button_hasabamimiko);
      this.button_tsuchigumo = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_tsuchigumo"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(23, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 23, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 311, this.f_97736_ + 111, 72, 20).m_253136_();
      guistate.put("button:button_tsuchigumo", this.button_tsuchigumo);
      this.m_142416_(this.button_tsuchigumo);
      this.button_shigemoharuta = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_shigemoharuta"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(24, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 24, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 179, 72, 20).m_253136_();
      guistate.put("button:button_shigemoharuta", this.button_shigemoharuta);
      this.m_142416_(this.button_shigemoharuta);
      this.button_hasabananako = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.cursed_technique_changer_v_gui.button_hasabananako"), (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(25, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 25, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 158, this.f_97736_ + 134, 72, 20).m_253136_();
      guistate.put("button:button_hasabananako", this.button_hasabananako);
      this.m_142416_(this.button_hasabananako);
      this.imagebutton_icon_left_arrow_jjc = new ImageButton(this.f_97735_ + -22, this.f_97736_ + 84, 16, 64, 0, 0, 64, new ResourceLocation("jujutsucraftv:textures/screens/atlas/imagebutton_icon_left_arrow_jjc.png"), 16, 128, (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(26, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 26, this.x, this.y, this.z, textstate);
      });
      guistate.put("button:imagebutton_icon_left_arrow_jjc", this.imagebutton_icon_left_arrow_jjc);
      this.m_142416_(this.imagebutton_icon_left_arrow_jjc);
      this.imagebutton_icon_right_arrow_right = new ImageButton(this.f_97735_ + 397, this.f_97736_ + 84, 16, 64, 0, 0, 64, new ResourceLocation("jujutsucraftv:textures/screens/atlas/imagebutton_icon_right_arrow_right.png"), 16, 128, (e) -> {
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new CursedTechniqueChangerVGuiButtonMessage(27, this.x, this.y, this.z, textstate));
         CursedTechniqueChangerVGuiButtonMessage.handleButtonAction(this.entity, 27, this.x, this.y, this.z, textstate);
      });
      guistate.put("button:imagebutton_icon_right_arrow_right", this.imagebutton_icon_right_arrow_right);
      this.m_142416_(this.imagebutton_icon_right_arrow_right);
   }

   static {
      guistate = CursedTechniqueChangerVGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/cursed_technique_changer_v_gui.png");
   }
}
