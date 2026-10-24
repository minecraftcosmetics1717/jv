package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CloneChangeBodyProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_pos2 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double x_pos3 = (double)0.0F;
         double y_pos3 = (double)0.0F;
         double z_pos3 = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();
            x_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos2 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
            Vec3 _center = new Vec3(x_pos2, y_pos2, z_pos2);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)250.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if ((Entity)world.m_6443_(CloneEntity.class, AABB.m_165882_(new Vec3(x_pos2, y_pos2, z_pos2), (double)500.0F, (double)500.0F, (double)500.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x_pos2, y_pos2, z_pos2)).findFirst().orElse((Object)null) == entityiterator && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                  x_pos3 = entityiterator.m_20185_();
                  y_pos3 = entityiterator.m_20186_();
                  z_pos3 = entityiterator.m_20189_();
                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "tp @s " + x_pos + " " + y_pos + " " + z_pos);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos3 + " " + y_pos3 + " " + z_pos3);
                  }
                  break;
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
