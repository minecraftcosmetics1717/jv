package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActBagmaskProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 61000;
         switch (skill) {
            case 4:
               AttackOverheadVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               CloningTechniqueProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               CloneChangeBodyProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               CloneReleaseProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 20:
               BagmaskDomainProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
