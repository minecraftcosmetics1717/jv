package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.GetDistanceProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GetDistanceVProcedure {
   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         return GetDistanceProcedure.execute(entity);
      }
   }
}
