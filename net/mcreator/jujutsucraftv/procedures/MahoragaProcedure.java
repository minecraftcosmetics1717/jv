package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class MahoragaProcedure extends SwitchSkillProcedure {
   public static boolean execute(LevelAccessor world, Player player, int selected) {
      boolean found = false;
      switch (selected) {
         case 4:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack4").getString(), (double)50.0F, false, true);
            break;
         case 5:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack6").getString(), (double)50.0F, false, true);
            break;
         case 6:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack7").getString(), (double)50.0F, false, true);
            break;
         case 7:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.air_cannon").getString(), (double)250.0F, false, true);
            break;
         case 8:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.mahoraga8").getString(), (double)150.0F, false, true);
            break;
         case 9:
            found = setInfo(player, selected, Component.m_237115_("jjcv.skill.default.5").getString(), (double)250.0F, false, true);
            break;
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 16:
         case 17:
         case 18:
         default:
            found = switchDefault(player, selected);
            break;
         case 15:
            found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.mahoraga15").getString(), (double)300.0F, false, true);
            break;
         case 19:
            if (GetJjcvConfigProcedure.execute(world, (double)6.0F)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.mahoraga19").getString(), (double)500.0F, false, false);
            } else if (isMahoragaHelmetEquipped(player)) {
               ItemStack headStack = player.m_6844_(EquipmentSlot.HEAD);
               if (headStack.m_41784_().m_128459_("skill205") >= (double)1000.0F) {
                  found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.mahoraga19").getString(), (double)500.0F, false, false);
               }
            }
            break;
         case 20:
            if (GetJjcvConfigProcedure.execute(world, (double)1.0F) && SelectDomainCheckProcedure.execute(player)) {
               found = setInfo(player, selected, Component.m_237115_("jujutsu.technique.kashimo_domain").getString(), (double)1000.0F, false, false);
            }
      }

      return found;
   }

   private static boolean isMahoragaHelmetEquipped(Player player) {
      ItemStack headStack = player.m_6844_(EquipmentSlot.HEAD);
      return headStack.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get() || headStack.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get();
   }
}
