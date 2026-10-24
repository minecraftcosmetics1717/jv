package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillYuki3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (!_livEnt.m_21220_().isEmpty()) {
                  int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                  if (cooldownTicks > 0) {
                     _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 99, false, false));
               }
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "attribute @s jujutsucraft:animation_1 base set 207");
            }

            PlayAnimationProcedure.execute(world, entity);
            DisplayParticleCircleProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + 0.2, entity.m_20189_(), (double)20.0F, (double)10.0F, "/particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~ ~ 0.01 0.01 0.01 0 1");
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 2.0F);
            } else {
               _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)5.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator != entity && (!LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator))) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~ ~ 0.01 1 0.01 0.5 10");
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_REGENERATION.get(), 300, 0, true, false));
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            DamageFoundationStoneProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
