package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.Attack4ConsecutiveAttacksProcedure;
import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadSuperProcedure;
import net.mcreator.jujutsucraft.procedures.AttackSpeedProcedure;
import net.mcreator.jujutsucraft.procedures.AttackStrongMahitoProcedure;
import net.mcreator.jujutsucraft.procedures.AttackStrongOkkotsuProcedure;
import net.mcreator.jujutsucraft.procedures.AttackTackleFlyingProcedure;
import net.mcreator.jujutsucraft.procedures.AttackTackleProcedure;
import net.mcreator.jujutsucraft.procedures.AvoidanceProcedure;
import net.mcreator.jujutsucraft.procedures.LariatProcedure;
import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueSmallpoxDeityBreathProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActDebuggerProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 69900;
         switch (skill) {
            case 5:
               LeepSlashProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               SkillRouzetsuDismantleProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               SkillTest1Procedure.execute(world, entity);
               found = true;
               break;
            case 8:
               AvoidanceProcedure.execute(world, x, y, z, entity);
               found = true;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            default:
               break;
            case 20:
               OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 31:
               entity.f_19864_ = true;
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 32:
               entity.f_19864_ = true;
               AttackOverheadSuperProcedure.execute(world, entity);
               found = true;
               break;
            case 33:
               entity.f_19864_ = true;
               AttackJumpProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 34:
               entity.f_19864_ = true;
               AttackTackleProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 35:
               entity.f_19864_ = true;
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 36:
               entity.f_19864_ = true;
               AttackSpeedProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 37:
               entity.f_19864_ = true;
               AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 38:
               entity.f_19864_ = true;
               AvoidanceProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 39:
               entity.f_19864_ = true;
               LariatProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 40:
               entity.f_19864_ = true;
               Attack4ConsecutiveAttacksProcedure.execute(world, entity);
               found = true;
               break;
            case 41:
               entity.f_19864_ = true;
               AttackStrongOkkotsuProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 42:
               entity.f_19864_ = true;
               AttackVerdictVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 50:
               TechniqueSmallpoxDeityBreathProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 51:
               SkillJinJiroProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
