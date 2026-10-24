package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.procedures.PlayBgmContinueProcedure;
import net.mcreator.jujutsucraftv.procedures.PlayBgmStartProcedure;
import net.mcreator.jujutsucraftv.procedures.PlayBgmTickProcedure;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

public class PlayBgmMobEffect extends MobEffect {
   public PlayBgmMobEffect() {
      super(MobEffectCategory.NEUTRAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      PlayBgmStartProcedure.execute(entity.m_9236_(), entity, amplifier);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      PlayBgmTickProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      PlayBgmContinueProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }

   public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
      consumer.accept(new IClientMobEffectExtensions() {
         public boolean isVisibleInInventory(MobEffectInstance effect) {
            return false;
         }

         public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
            return false;
         }

         public boolean isVisibleInGui(MobEffectInstance effect) {
            return false;
         }
      });
   }
}
