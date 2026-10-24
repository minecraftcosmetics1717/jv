package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.PlojectileEyeballEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileSixEyeballEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EyeExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_blood_red ~ ~1.5 ~ 0.1 0.1 0.1 0.5 1");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:crush")), SoundSource.NEUTRAL, 1.0F, 1.3F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:crush")), SoundSource.NEUTRAL, 1.0F, 1.3F, false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 1, false, false));
               }
            }

            ExplosionCompensationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            if (GetSixEyeProcedure.execute(entity)) {
               Level projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new PlojectileSixEyeballEntity((EntityType)JujutsucraftvModEntities.PLOJECTILE_SIX_EYEBALL.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 3.0F, 0, (byte)1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            } else {
               Level projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new PlojectileEyeballEntity((EntityType)JujutsucraftvModEntities.PLOJECTILE_EYEBALL.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        entityToSpawn.m_36767_(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, 3.0F, 0, (byte)1);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
