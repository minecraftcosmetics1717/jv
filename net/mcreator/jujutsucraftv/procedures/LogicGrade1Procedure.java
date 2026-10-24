package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class LogicGrade1Procedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _plr0 = (ServerPlayer)entity;
            if (_plr0.m_9236_() instanceof ServerLevel && _plr0.m_8960_().m_135996_(_plr0.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_()) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
