package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;

public class SelectDomainCheckProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean can_domain = false;
         if (entity instanceof Player) {
            Player player;
            label24: {
               player = (Player)entity;
               if (player instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)player;
                  Level var5 = player.m_9236_();
                  if (var5 instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)var5;
                     if (_serverPlayer.m_8960_().m_135996_(_serverLevel.m_7654_().m_129889_().m_136041_(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).m_8193_()) {
                        break label24;
                     }
                  }
               }

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
               })).checkGamemode(player)) {
                  return can_domain;
               }
            }

            if (player instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)player;
               if (!_serverPlayer.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  can_domain = true;
               }
            }
         }

         return can_domain;
      }
   }
}
