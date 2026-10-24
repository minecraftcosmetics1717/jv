package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.Cockroach1Procedure;
import net.mcreator.jujutsucraft.procedures.TechniqueSkeleton1Procedure;
import net.mcreator.jujutsucraft.procedures.TechniqueSkullProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActBlindnessProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 60200;
         switch (skill) {
            case 5:
               entity.getPersistentData().m_128347_("skill", (double)152.0F);
               TechniqueSkullProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               TechniqueSkeleton1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 15:
               Cockroach1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 20:
               BlindnessDomainProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
