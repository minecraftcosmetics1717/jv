package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.AttackStrongMahitoProcedure;
import net.mcreator.jujutsucraft.procedures.OtakeFlameProcedure;
import net.mcreator.jujutsucraft.procedures.OtakeThunderProcedure;
import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActAkurooProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         skill %= 62400;
         switch (skill) {
            case 4:
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               return true;
            case 5:
               AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
               return true;
            case 6:
               OtakeFlameProcedure.execute(world, entity);
               return true;
            case 7:
               OtakeThunderProcedure.execute(world, entity);
               return true;
            case 20:
               OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
               return true;
            default:
               return false;
         }
      }
   }
}
