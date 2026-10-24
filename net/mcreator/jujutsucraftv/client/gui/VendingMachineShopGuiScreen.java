package net.mcreator.jujutsucraftv.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.List;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModScreens;
import net.mcreator.jujutsucraftv.network.VendingMachineShopGuiButtonMessage;
import net.mcreator.jujutsucraftv.network.VendingMachineShopGuiSyncMessage;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineShopGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VendingMachineShopGuiScreen extends AbstractContainerScreen<VendingMachineShopGuiMenu> implements JujutsucraftvModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   private final ItemStack[] syncedStacks;
   private final boolean[] syncedSelects;
   Button button_select0;
   Button button_select1;
   Button button_select2;
   private static final int SLOT_SELL0 = 0;
   private static final int SLOT_SELL1 = 1;
   private static final int SLOT_SELL2 = 2;
   private static final int SLOT_COST0 = 3;
   private static final int SLOT_COST1 = 4;
   private static final int SLOT_COST2 = 5;
   private static final ResourceLocation texture;

   public VendingMachineShopGuiScreen(VendingMachineShopGuiMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.syncedStacks = new ItemStack[]{ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_};
      this.syncedSelects = new boolean[]{false, false, false};
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 176;
      this.f_97727_ = 166;
   }

   public boolean m_7043_() {
      return true;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
      this.renderVendingTooltips(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      RenderSystem.disableBlend();
      if (this.isSelected(0)) {
         this.renderVendingItem(guiGraphics, 0, 32, 25);
         this.renderVendingItem(guiGraphics, 3, 74, 25);
      }

      if (this.isSelected(1)) {
         this.renderVendingItem(guiGraphics, 1, 32, 73);
         this.renderVendingItem(guiGraphics, 4, 74, 73);
      }

      if (this.isSelected(2)) {
         this.renderVendingItem(guiGraphics, 2, 32, 118);
         this.renderVendingItem(guiGraphics, 5, 74, 118);
      }

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
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.vending_machine_shop_gui.label_sell"), 32, 7, -1, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraftv.vending_machine_shop_gui.label_buy"), 74, 7, -1, false);
   }

   private boolean isSelected(int index) {
      return index >= 0 && index < this.syncedSelects.length && this.syncedSelects[index];
   }

   private ItemStack getSyncedStack(int slot) {
      if (slot >= 0 && slot < this.syncedStacks.length) {
         ItemStack stack = this.syncedStacks[slot];
         return stack == null ? ItemStack.f_41583_ : stack;
      } else {
         return ItemStack.f_41583_;
      }
   }

   public void receiveSyncedData(int sx, int sy, int sz, List<ItemStack> stacks, boolean select0, boolean select1, boolean select2) {
      if (sx == this.x && sy == this.y && sz == this.z) {
         for(int i = 0; i < this.syncedStacks.length; ++i) {
            if (i < stacks.size() && stacks.get(i) != null) {
               this.syncedStacks[i] = ((ItemStack)stacks.get(i)).m_41777_();
            } else {
               this.syncedStacks[i] = ItemStack.f_41583_;
            }
         }

         this.syncedSelects[0] = select0;
         this.syncedSelects[1] = select1;
         this.syncedSelects[2] = select2;
      }
   }

   private void renderVendingItem(GuiGraphics guiGraphics, int slot, int guiX, int guiY) {
      ItemStack stack = this.getSyncedStack(slot);
      if (!stack.m_41619_()) {
         int px = this.f_97735_ + guiX;
         int py = this.f_97736_ + guiY;
         guiGraphics.m_280480_(stack, px, py);
         guiGraphics.m_280370_(this.f_96547_, stack, px, py);
      }
   }

   private void renderVendingTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      if (this.isSelected(0)) {
         this.renderVendingTooltip(guiGraphics, 0, 32, 25, mouseX, mouseY);
         this.renderVendingTooltip(guiGraphics, 3, 74, 25, mouseX, mouseY);
      }

      if (this.isSelected(1)) {
         this.renderVendingTooltip(guiGraphics, 1, 32, 73, mouseX, mouseY);
         this.renderVendingTooltip(guiGraphics, 4, 74, 73, mouseX, mouseY);
      }

      if (this.isSelected(2)) {
         this.renderVendingTooltip(guiGraphics, 2, 32, 118, mouseX, mouseY);
         this.renderVendingTooltip(guiGraphics, 5, 74, 118, mouseX, mouseY);
      }

   }

   private void renderVendingTooltip(GuiGraphics guiGraphics, int slot, int guiX, int guiY, int mouseX, int mouseY) {
      ItemStack stack = this.getSyncedStack(slot);
      if (!stack.m_41619_()) {
         int px = this.f_97735_ + guiX;
         int py = this.f_97736_ + guiY;
         if (mouseX >= px && mouseX < px + 16 && mouseY >= py && mouseY < py + 16) {
            guiGraphics.m_280153_(this.f_96547_, stack, mouseX, mouseY);
         }

      }
   }

   public void m_7856_() {
      super.m_7856_();
      JujutsucraftvMod.PACKET_HANDLER.sendToServer(new VendingMachineShopGuiSyncMessage(this.x, this.y, this.z));
      this.button_select0 = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.vending_machine_shop_gui.button_select0"), (e) -> {
         if (this.isSelected(0)) {
            JujutsucraftvMod.PACKET_HANDLER.sendToServer(new VendingMachineShopGuiButtonMessage(0, this.x, this.y, this.z, textstate));
         }

      }).m_252987_(this.f_97735_ + 96, this.f_97736_ + 25, 63, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (VendingMachineShopGuiScreen.this.isSelected(0)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_select0", this.button_select0);
      this.m_142416_(this.button_select0);
      this.button_select1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.vending_machine_shop_gui.button_select1"), (e) -> {
         if (this.isSelected(1)) {
            JujutsucraftvMod.PACKET_HANDLER.sendToServer(new VendingMachineShopGuiButtonMessage(1, this.x, this.y, this.z, textstate));
         }

      }).m_252987_(this.f_97735_ + 96, this.f_97736_ + 73, 63, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (VendingMachineShopGuiScreen.this.isSelected(1)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_select1", this.button_select1);
      this.m_142416_(this.button_select1);
      this.button_select2 = Button.m_253074_(Component.m_237115_("gui.jujutsucraftv.vending_machine_shop_gui.button_select2"), (e) -> {
         if (this.isSelected(2)) {
            JujutsucraftvMod.PACKET_HANDLER.sendToServer(new VendingMachineShopGuiButtonMessage(2, this.x, this.y, this.z, textstate));
         }

      }).m_252987_(this.f_97735_ + 96, this.f_97736_ + 118, 63, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (VendingMachineShopGuiScreen.this.isSelected(2)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_select2", this.button_select2);
      this.m_142416_(this.button_select2);
   }

   static {
      guistate = VendingMachineShopGuiMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraftv:textures/screens/vending_machine_shop_gui.png");
   }
}
