package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class CheckOvertimeProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         label18: {
            if (world instanceof Level) {
               Level _lvl0 = (Level)world;
               if (_lvl0.m_46461_()) {
                  break label18;
               }
            }

            if (!GetZoneProcedure.execute(entity)) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
