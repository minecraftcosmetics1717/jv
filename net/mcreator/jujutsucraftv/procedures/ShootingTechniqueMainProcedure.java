package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraftv.entity.PlojectileSlashEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShootingTechniqueMainProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double skillnum = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         if (skillnum == (double)60216.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SLASH.get()).m_262496_(_level, new BlockPos(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_(), entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
               }
            }

            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.25F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof PlojectileSlashEntity && entityiterator.getPersistentData().m_128461_("UUID").equals("")) {
                  entityiterator.getPersistentData().m_128347_("skill", skillnum);
                  entityiterator.getPersistentData().m_128347_("Damage", (double)10.0F);
                  entityiterator.getPersistentData().m_128359_("UUID", entity.m_20149_());
               }
            }
         }

      }
   }
}
