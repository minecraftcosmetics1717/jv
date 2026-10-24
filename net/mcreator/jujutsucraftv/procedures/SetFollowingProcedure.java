package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.minecraft.world.entity.Entity;

public class SetFollowingProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean follow_a = false;
         if (entity instanceof CloneEntity) {
            boolean var10000;
            label17: {
               if (entity instanceof CloneEntity) {
                  CloneEntity _datEntL1 = (CloneEntity)entity;
                  if ((Boolean)_datEntL1.m_20088_().m_135370_(CloneEntity.DATA_follow)) {
                     var10000 = true;
                     break label17;
                  }
               }

               var10000 = false;
            }

            follow_a = var10000;
         }

         return follow_a;
      }
   }
}
