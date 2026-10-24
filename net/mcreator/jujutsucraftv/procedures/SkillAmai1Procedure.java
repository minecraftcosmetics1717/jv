package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SkillAmai1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String ANIME_NAME = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + entity.m_20154_().f_82479_);
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + entity.m_20154_().f_82481_);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            SetPosGoProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity, true, (double)30.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
