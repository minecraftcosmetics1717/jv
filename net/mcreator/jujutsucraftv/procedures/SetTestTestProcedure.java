package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SetTestTestProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (GetDomainExpansionProcedure.execute(entity) && !entity.getPersistentData().m_128471_("Failed")) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)1.0F);
         }

      }
   }
}
