package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.SummonShikigamiTsuchigumoProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActTsuchigumoProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 63100;
         switch (skill) {
            case 4:
               AttackOverheadVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               SummonShikigamiTsuchigumoProcedure.execute(world, entity);
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
