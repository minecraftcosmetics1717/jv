package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.LogicAttackTargetStartProcedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade37Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class TargetEntityLogicAttackStartProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_entity = false;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (entity instanceof CursedSpiritGrade37Entity) {
            if (entity instanceof Mob) {
               Mob _mobEnt5 = (Mob)entity;
               if (_mobEnt5.m_5912_()) {
                  logic_entity = false;
                  return logic_entity;
               }
            }

            logic_entity = LogicAttackTargetStartProcedure.execute(world, entity);
         } else {
            logic_entity = LogicAttackTargetStartProcedure.execute(world, entity);
         }

         return logic_entity;
      }
   }
}
