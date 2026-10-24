package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;

public class CheckGamemodeCreativeProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_entity = false;
         if (!((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            logic_entity = true;
         } else {
            logic_entity = false;
         }

         return logic_entity;
      }
   }
}
