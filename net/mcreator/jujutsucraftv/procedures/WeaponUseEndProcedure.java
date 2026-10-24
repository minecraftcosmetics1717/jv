package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.item.NoisSeverScissorsItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WeaponUseEndProcedure {
   public static void execute(LevelAccessor world, ItemStack itemstack) {
      if (itemstack.m_41720_() == JujutsucraftvModItems.NOIS_SEVER_SCISSORS.get()) {
         JujutsucraftvMod.queueServerWork(20, () -> {
            if (itemstack.m_41720_() instanceof NoisSeverScissorsItem) {
               String geckoGlowTextureName = "empty";
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

         });
      }

   }
}
