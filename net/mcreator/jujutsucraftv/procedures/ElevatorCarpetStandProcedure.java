package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ElevatorCarpetStandProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockPos pos = BlockPos.m_274561_(x, y, z);
         BlockEntity _be = world.m_7702_(pos);
         if (_be != null) {
            if (entity.getPersistentData().m_128459_("elevator_cooldown") > (double)0.0F) {
               entity.getPersistentData().m_128347_("elevator_cooldown", entity.getPersistentData().m_128459_("elevator_cooldown") - (double)1.0F);
            } else {
               double destX = (double)pos.m_123341_() + (double)0.5F;
               double destZ = (double)pos.m_123343_() + (double)0.5F;
               if (entity.m_6144_()) {
                  double downNum = _be.getPersistentData().m_128459_("down_num");
                  if (downNum > (double)0.0F) {
                     teleport(world, entity, destX, y - downNum, destZ);
                     entity.getPersistentData().m_128347_("elevator_cooldown", (double)15.0F);
                  }
               } else if (!entity.m_20096_() && entity.m_20184_().f_82480_ > (double)0.0F) {
                  double upNum = _be.getPersistentData().m_128459_("up_num");
                  if (upNum > (double)0.0F) {
                     teleport(world, entity, destX, y + upNum, destZ);
                     entity.getPersistentData().m_128347_("elevator_cooldown", (double)15.0F);
                  }
               }

            }
         }
      }
   }

   private static void teleport(LevelAccessor world, Entity entity, double x, double y, double z) {
      if (world instanceof Level _level) {
         if (!_level.m_5776_()) {
            _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 1.0F, 1.2F);
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_8767_(ParticleTypes.f_123760_, x, y + (double)1.0F, z, 10, 0.2, (double)0.5F, 0.2, (double)0.5F);
      }

      entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
      if (entity instanceof ServerPlayer _serverPlayer) {
         _serverPlayer.f_8906_.m_9774_(x, y + 0.1, z, entity.m_146908_(), entity.m_146909_());
      } else {
         entity.m_6021_(x, y + 0.1, z);
      }

   }
}
