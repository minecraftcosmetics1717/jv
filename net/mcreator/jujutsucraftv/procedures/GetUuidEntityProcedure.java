package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetUuidEntityProcedure {
   public static Entity execute(LevelAccessor world, String uuidString) {
      if (uuidString != null && !uuidString.isEmpty()) {
         if (world instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)world;

            try {
               UUID uuid = UUID.fromString(uuidString);
               return serverLevel.m_8791_(uuid);
            } catch (IllegalArgumentException e) {
               System.err.println("GetEntityByUUIDProcedure: Invalid UUID format for '" + uuidString + "': " + e.getMessage());
               return null;
            } catch (Exception e) {
               System.err.println("GetEntityByUUIDProcedure: An unexpected error occurred while getting entity for UUID '" + uuidString + "': " + e.getMessage());
               e.printStackTrace();
               return null;
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }
}
