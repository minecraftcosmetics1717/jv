package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.item.NoisSeverScissorsItem;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WeaponUseStartProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double cool_down = (double)0.0F;
         if (!(entity instanceof Player)) {
            if (itemstack.m_41720_() == JujutsucraftvModItems.HEAVENS_CLEAVER.get()) {
               HeavenCleaverUseProcedure.execute(world, entity, itemstack);
            }

            if (itemstack.m_41720_() == JujutsucraftvModItems.OSUKI_AXE.get()) {
               OsukiAxeUseProcedure.execute(world, entity, itemstack);
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.NOIS_SEVER_SCISSORS.get()) {
            if (LogicCreativeProcedure.execute(entity)) {
               cool_down = (double)20.0F;
            } else {
               cool_down = (double)200.0F;
            }

            entity.getPersistentData().m_128379_("nois", true);
            entity.getPersistentData().m_128347_("skill", (double)63505.0F);
            if (itemstack.m_41720_() instanceof NoisSeverScissorsItem) {
               String geckoGlowTextureName = "nihiladmiari_light";
               if (geckoGlowTextureName != null && !geckoGlowTextureName.isBlank()) {
                  if (geckoGlowTextureName.equalsIgnoreCase("empty")) {
                     itemstack.m_41784_().m_128359_("geckoGlowTexture", "empty");
                  } else {
                     itemstack.m_41784_().m_128359_("geckoGlowTexture", geckoGlowTextureName.trim());
                  }
               } else {
                  itemstack.m_41784_().m_128473_("geckoGlowTexture");
               }
            }
         }

         if (!itemstack.m_204117_(ItemTags.create(new ResourceLocation("forge:charge_instance")))) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:cursed_technique infinite 0 true");
            }

            entity.getPersistentData().m_128379_("PRESS_Z", true);
            itemstack.m_41784_().m_128347_("COOLDOWN_TICKS", cool_down);
         }

      }
   }
}
