package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class JaronaTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, 5, 199, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 5, 14, false, false));
            }
         }

         if (entity.m_20142_()) {
            entity.getPersistentData().m_128347_("jarona_color", entity.getPersistentData().m_128459_("jarona_color") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("jarona_color") == (double)1.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 1 0 0 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)2.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0.7 0.3 0 0.16 ~ ~0.3 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)3.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0.5 0.4 0 0.16 ~ ~0.3 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)4.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0 1 0 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)5.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0 0.7 0.3 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)6.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0 0.5 0.4 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)7.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0 0 1 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)8.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0.3 0 0.7 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
            }

            if (entity.getPersistentData().m_128459_("jarona_color") == (double)9.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_lightning_humanoid_dust 0.4 0 0.5 0.16 ~ ~0.4 ~ 0 0 0 0 1 force");
               }

               entity.getPersistentData().m_128347_("jarona_color", (double)0.0F);
            }
         }

      }
   }
}
