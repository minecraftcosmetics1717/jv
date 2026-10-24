package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueFoxFireProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueTamamonoMae1Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActTamamonomaeIncarnateProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 60300;
         switch (skill) {
            case 5:
               TechniqueTamamonoMae1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               TechniqueFoxFireProcedure.execute(world, x, y, z, entity);
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
