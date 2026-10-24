package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.BulletSkeletonBulletHitsBlockProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.ReturnEnergyColor2Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {BulletSkeletonBulletHitsBlockProcedure.class},
   remap = false
)
public abstract class BulletSkeletonBulletHitsBlockProcedureMixin {
   @Overwrite
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double CNT6 = (double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1;
         double range = (double)1.0F + ReturnEntitySizeProcedure.execute(immediatesourceentity);
         double old_skill = entity.getPersistentData().m_128459_("skill");
         boolean set_particle = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet || entity.getPersistentData().m_128471_("EntityParticleSet");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
         entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * range);
         entity.getPersistentData().m_128379_("noParticle", true);
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("Damage", immediatesourceentity.getPersistentData().m_128459_("Damage"));
         entity.getPersistentData().m_128347_("knockback", (double)0.25F * CNT6);
         entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
         entity.getPersistentData().m_128379_("attack", false);
         if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)154.0F || immediatesourceentity.getPersistentData().m_128459_("skill") == (double)60405.0F) {
            entity.getPersistentData().m_128347_("effect", (double)10.0F);
         }

         RangeAttackProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("skill", old_skill);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            double skillId = immediatesourceentity.getPersistentData().m_128459_("skill");
            if (skillId == (double)151.0F) {
               _level.m_8767_(ParticleTypes.f_123765_, x, y, z, (int)Math.round((double)8.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
               _level.m_8767_(ParticleTypes.f_123746_, x, y, z, (int)Math.round((double)8.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
            } else if (skillId != (double)154.0F && skillId != (double)60405.0F) {
               if (set_particle) {
                  SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
                  _level.m_8767_(particleType, x, y, z, (int)Math.round((double)4.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
               } else {
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x, y, z, (int)Math.round((double)4.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
               }
            } else {
               _level.m_8767_(ParticleTypes.f_123745_, x, y, z, (int)Math.round((double)8.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
               if (_level.m_46469_().m_46207_(GameRules.f_46132_) && Math.random() < 0.1 && !_level.m_8055_(BlockPos.m_274561_(x, y, z)).m_60795_()) {
                  FallingBlockEntity.m_201971_(_level, BlockPos.m_274561_(x, y, z), Blocks.f_50084_.m_49966_());
               }
            }

            _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)Math.round((double)2.0F * CNT6 * range), range, range, range, (double)0.25F * CNT6);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.75F, (double)1.0F));
            }
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
