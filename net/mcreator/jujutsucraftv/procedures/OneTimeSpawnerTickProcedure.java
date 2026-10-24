package net.mcreator.jujutsucraftv.procedures;

import java.util.Optional;
import net.mcreator.jujutsucraftv.block.entity.OneTimeSpawnerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class OneTimeSpawnerTickProcedure {
   public static void execute(Level level, double x, double y, double z, OneTimeSpawnerBlockEntity blockEntity) {
      if (level instanceof ServerLevel serverLevel) {
         CompoundTag nbt = blockEntity.getPersistentData();
         if (nbt.m_128471_("selected")) {
            BlockPos pos = BlockPos.m_274561_(x, y, z);
            Vec3 center = new Vec3(x + (double)0.5F, y, z + (double)0.5F);
            boolean playerNearby = !level.m_6443_(Player.class, (new AABB(center, center)).m_82400_((double)15.0F), (p) -> {
               if (!(p instanceof ServerPlayer sp)) {
                  return false;
               } else {
                  GameType gameMode = sp.f_8941_.m_9290_();
                  return gameMode == GameType.SURVIVAL || gameMode == GameType.ADVENTURE;
               }
            }).isEmpty();
            if (playerNearby) {
               String entityId = nbt.m_128461_("entity_id");
               int count = (int)nbt.m_128459_("entity_count");
               if (count <= 0) {
                  count = 1;
               }

               if (!entityId.isEmpty()) {
                  Optional<EntityType<?>> entityType = EntityType.m_20632_(entityId);

                  for(int i = 0; i < count; ++i) {
                     entityType.ifPresent((type) -> {
                        Entity spawnedEntity = type.m_20615_(serverLevel);
                        if (spawnedEntity != null) {
                           spawnedEntity.m_7678_(x + (double)0.5F, y, z + (double)0.5F, level.f_46441_.m_188501_() * 360.0F, 0.0F);
                           serverLevel.m_7967_(spawnedEntity);
                        }

                     });
                  }
               }

               level.m_7731_(pos, Blocks.f_50016_.m_49966_(), 3);
            }

         }
      }
   }
}
