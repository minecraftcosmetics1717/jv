package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.entity.EbinaNijiEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonOnetTimeProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().m_128471_("summoned") && entity instanceof EbinaNijiEntity && world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_210.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               if (entityinstance instanceof TamableAnimal) {
                  TamableAnimal _toTame = (TamableAnimal)entityinstance;
                  if (entity instanceof Player) {
                     Player _owner = (Player)entity;
                     _toTame.m_21828_(_owner);
                  }
               }

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entity.getPersistentData().m_128379_("summoned", true);
               _serverLevel.m_7967_(entityinstance);
            }
         }

      }
   }
}
