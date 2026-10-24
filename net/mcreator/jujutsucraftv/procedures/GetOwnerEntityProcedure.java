package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetOwnerEntityProcedure {
   public static Entity execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return null;
      } else {
         String ownerUuidStr = entity.getPersistentData().m_128461_("OWNER_UUID");
         if (!ownerUuidStr.isEmpty()) {
            try {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  return _level.m_8791_(UUID.fromString(ownerUuidStr));
               }
            } catch (Exception var4) {
            }
         }

         return null;
      }
   }
}
