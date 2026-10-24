package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActHMimikoProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 62800;
         switch (skill) {
            case 5:
               SkillRope1Procedure.execute(world, entity);
               found = true;
               break;
            case 6:
               SkillRope2Procedure.execute(world, entity);
               found = true;
               break;
            case 20:
               OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
