package net.mcreator.jujutsucraftv.item;

import java.util.List;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.GetSelectCursedTechniqueProcedure;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemCollectionOfMiraclesItem extends Item {
   private static final double MIN_LIFE_COUNT = (double)0.0F;
   private static final double MAX_LIFE_COUNT = (double)99.0F;
   private static final int MIN_MIRACLE_AMPLIFIER = 0;
   private static final int MAX_MIRACLE_AMPLIFIER = 99;

   public ItemCollectionOfMiraclesItem() {
      super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.UNCOMMON));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean m_5812_(ItemStack itemstack) {
      return true;
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level level, Player player, InteractionHand hand) {
      ItemStack itemstack = player.m_21120_(hand);
      if (!level.m_5776_()) {
         if (GetSelectCursedTechniqueProcedure.execute(player, (double)1.0F) != (double)634.0F) {
            player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
            return InteractionResultHolder.m_19100_(itemstack);
         }

         int amount = player.m_6144_() ? -1 : 1;
         boolean success;
         if (player.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
            success = changeMiracleSavingsEffectAmplifier(player, amount);
         } else {
            success = addLifeCount(player, (double)amount);
         }

         if (!success) {
            return InteractionResultHolder.m_19100_(itemstack);
         }

         level.m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), SoundEvents.f_11887_, SoundSource.MASTER, 1.0F, 1.0F);
         if (!player.m_150110_().f_35937_) {
            itemstack.m_41774_(1);
         }
      }

      return InteractionResultHolder.m_19092_(itemstack, level.m_5776_());
   }

   private static boolean changeMiracleSavingsEffectAmplifier(Player player, int amount) {
      MobEffectInstance effect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      if (effect == null) {
         return false;
      } else {
         int duration = effect.m_19557_();
         int amplifier = effect.m_19564_();
         boolean ambient = effect.m_19571_();
         boolean visible = effect.m_19572_();
         boolean showIcon = effect.m_19575_();
         int newAmplifier = Math.max(0, Math.min(99, amplifier + amount));
         if (newAmplifier == amplifier) {
            return false;
         } else {
            player.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
            player.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), duration, newAmplifier, ambient, visible, showIcon));
            return true;
         }
      }
   }

   private static boolean addLifeCount(Player player, double amount) {
      JujutsucraftvModVariables.PlayerVariables variables = (JujutsucraftvModVariables.PlayerVariables)player.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables());
      double oldValue = variables.LifeCount;
      double newValue = Math.max((double)0.0F, Math.min((double)99.0F, oldValue + amount));
      if (oldValue == newValue) {
         return false;
      } else {
         variables.LifeCount = newValue;
         variables.syncPlayerVariables(player);
         return true;
      }
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraftv.item_collection_of_miracles.description_0"));
      list.add(Component.m_237115_("item.jujutsucraftv.item_collection_of_miracles.description_1"));
   }
}
