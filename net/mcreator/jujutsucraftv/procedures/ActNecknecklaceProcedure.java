package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActNecknecklaceProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 61400;
         switch (skill) {
            case 5:
               SkillAttackGroundBiteProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               ReleaseSummonEntityProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               SummonSkeletonCursedSpiritProcedure.execute(world, x, y, z, entity);
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
