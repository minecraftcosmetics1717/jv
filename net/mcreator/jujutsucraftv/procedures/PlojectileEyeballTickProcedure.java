package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileEyeballEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileSixEyeballEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileToothEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class PlojectileEyeballTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().m_128347_("cnt1", immediatesourceentity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!immediatesourceentity.getPersistentData().m_128471_("set_data")) {
            immediatesourceentity.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
            if (immediatesourceentity instanceof Projectile) {
               Projectile _projectile = (Projectile)immediatesourceentity;
               _projectile.m_5602_(entity);
            }

            if (immediatesourceentity instanceof PlojectileToothEntity) {
               immediatesourceentity.getPersistentData().m_128347_("target_area_size", (double)5.0F);
            }

            if (immediatesourceentity instanceof PlojectileEyeballEntity || immediatesourceentity instanceof PlojectileSixEyeballEntity) {
               immediatesourceentity.getPersistentData().m_128347_("target_area_size", (double)5.0F);
            }

            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            SetRangedAmmoProcedure.execute(entity, immediatesourceentity);
            immediatesourceentity.getPersistentData().m_128379_("set_data", true);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, immediatesourceentity);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt1") >= (double)2.0F) {
            if (Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)5.0F) >= (double)3.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_blood_red ~ ~ ~ 0.01 0.01 0.01 0.1 1");
            }

            if (immediatesourceentity.getPersistentData().m_128471_("set_data")) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(immediatesourceentity.getPersistentData().m_128459_("target_area_size") / (double)2.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (immediatesourceentity.getPersistentData().m_128471_("stop_now") || LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) && !entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                     PlojectileEyeballFallProcedure.execute(world, entity, immediatesourceentity);
                  }
               }
            }
         }

      }
   }
}
