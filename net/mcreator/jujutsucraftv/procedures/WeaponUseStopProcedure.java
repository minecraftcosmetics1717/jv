package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class WeaponUseStopProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("PRESS_Z", false);
         WeaponUseEndProcedure.execute(world, itemstack);
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), (int)itemstack.m_41784_().m_128459_("COOLDOWN_TICKS"));
         }

      }
   }
}
