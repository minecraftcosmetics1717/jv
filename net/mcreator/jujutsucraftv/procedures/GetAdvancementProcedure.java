package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class GetAdvancementProcedure {
   public static boolean execute(Entity entity, String txt) {
      if (entity != null && txt != null && !txt.isBlank()) {
         if (entity instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer)entity;
            ResourceLocation advancementId = ResourceLocation.m_135820_(txt.trim());
            if (advancementId == null) {
               return false;
            } else {
               Advancement advancement = player.f_8924_.m_129889_().m_136041_(advancementId);
               if (advancement == null) {
                  return false;
               } else {
                  AdvancementProgress progress = player.m_8960_().m_135996_(advancement);
                  return progress.m_8193_();
               }
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
