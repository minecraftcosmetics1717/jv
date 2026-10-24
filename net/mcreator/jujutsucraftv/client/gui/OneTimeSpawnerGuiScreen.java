package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.OneTimeSpawnerGuiButtonMessage;
import net.mcreator.jujutsucraftv.world.inventory.OneTimeSpawnerGuiMenu;
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

public class OneTimeSpawnerGuiScreen extends AbstractContainerScreen<OneTimeSpawnerGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static EditBox spawn_entity_id;
   public static EditBox count;
   Button button_select;
   private static final ResourceLocation texture;

   public OneTimeSpawnerGuiScreen(OneTimeSpawnerGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 100;
      this.f_97727_ = 110;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      spawn_entity_id.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      count.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
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
      } else if (spawn_entity_id.m_93696_()) {
         return spawn_entity_id.m_7933_(key, b, c);
      } else {
         return count.m_93696_() ? count.m_7933_(key, b, c) : super.m_7933_(key, b, c);
      }
   }

   public void m_181908_() {
      super.m_181908_();
      spawn_entity_id.m_94120_();
      count.m_94120_();
   }

   public void m_6574_(Minecraft minecraft, int width, int height) {
      String spawn_entity_idValue = spawn_entity_id.m_94155_();
      String countValue = count.m_94155_();
      super.m_6574_(minecraft, width, height);
      spawn_entity_id.m_94144_(spawn_entity_idValue);
      count.m_94144_(countValue);
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.one_time_spawner_gui.label_spawn_entity_id"), 10, 15, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.one_time_spawner_gui.label_spawn_count"), 22, 51, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      spawn_entity_id = new EditBox(this.f_96547_, this.f_97735_ + 5, this.f_97736_ + 25, 88, 18, Component.m_237115_("gui.jujutsucraftv.one_time_spawner_gui.spawn_entity_id"));
      spawn_entity_id.m_94199_(32767);
      guistate.put("text:spawn_entity_id", spawn_entity_id);
      this.m_7787_(spawn_entity_id);
      count = new EditBox(this.f_96547_, this.f_97735_ + 5, this.f_97736_ + 61, 88, 18, Component.m_237115_("gui.jujutsucraftv.one_time_spawner_gui.count"));
      count.m_94199_(32767);
      guistate.put("text:count", count);
      this.m_7787_(count);
      this.button_select = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.one_time_spawner_gui.button_select"), (e) -> {
         textstate.put("textin:spawn_entity_id", spawn_entity_id.m_94155_());
         textstate.put("textin:count", count.m_94155_());
         JujutsucraftvMod.PACKET_HANDLER.sendToServer(new OneTimeSpawnerGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         OneTimeSpawnerGuiButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 22, this.f_97736_ + 85, 56, 20).m_253136_();
      guistate.put("button:button_select", this.button_select);
      this.m_142416_(this.button_select);
   }

   static {
      guistate = OneTimeSpawnerGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/one_time_spawner_gui.png");
   }
}
