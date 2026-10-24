package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActGakuganjiProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 61500;
         switch (skill) {
            case 5:
               SoundCursePowerProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               AroundSoundCursePowerProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               FingerSnappingProcedure.execute(world, x, y, z, entity);
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
