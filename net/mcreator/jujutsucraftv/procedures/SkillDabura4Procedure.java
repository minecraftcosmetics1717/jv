package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillDabura4Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get(), 10, 1, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)3.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.3F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 1.3F, false);
               }
            }

            for(int index0 = 0; index0 < 5; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 1, 0.3, (double)1.0F, 0.3, 0.1);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 0.8F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, 0.8F, false);
               }
            }

            for(int index1 = 0; index1 < 5; ++index1) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 5, 0.3, (double)1.0F, 0.3, 0.15);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)11.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)14.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)13.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_SUBLIGHT_SPEED.get(), 1200, 15, false, false, true));
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.NEUTRAL, 1.0F, 1.6F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")), SoundSource.NEUTRAL, 1.0F, 1.6F, false);
               }
            }

            for(int index2 = 0; index2 < 5; ++index2) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 10, 0.3, (double)1.0F, 0.3, (double)0.5F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/jjcv entity_data set_player_select_cursed_technique @s -1");
            }

            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            if (!(entity instanceof Player) && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.DESPAWN_PROTECTION.get(), 1200, 1, false, false));
               }
            }

            entity.getPersistentData().m_128379_("skill_sublight_speed", true);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
