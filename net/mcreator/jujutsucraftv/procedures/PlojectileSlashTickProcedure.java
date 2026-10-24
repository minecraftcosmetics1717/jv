package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.PlojectileSlashEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileSlashTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range_fix = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity.getPersistentData().m_128459_("moving") != (double)1.0F) {
            if (entity.getPersistentData().m_128459_("skill") == (double)69905.0F) {
               x_power = entity.getPersistentData().m_128459_("x_power") * (double)3.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)3.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)3.0F;
               entity.m_20242_(true);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 100, 0, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("count_cnt6") == (double)4.0F) {
                  x_power *= Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F);
                  z_power *= Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F);
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                  if (entity instanceof PlojectileSlashEntity) {
                     ((PlojectileSlashEntity)entity).setAnimation("vartical");
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)10.0F);
                  entity.getPersistentData().m_128347_("Range", (double)1.0F);
                  entity.getPersistentData().m_128347_("Knockback", 0.3);
                  entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F);
               } else {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F);
                  entity.getPersistentData().m_128347_("Knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("BlockRange", (double)5.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F);
               }

               if (entity instanceof PlojectileSlashEntity) {
                  PlojectileSlashEntity animatable = (PlojectileSlashEntity)entity;
                  animatable.setTexture("slash_entity_red");
               }

               entity.getPersistentData().m_128379_("noParticle", true);
            }

            entity.m_20256_(new Vec3(x_power, y_power, z_power));
            range_fix = (double)1.0F;
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
            entity.getPersistentData().m_128347_("moving", (double)1.0F);
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("skill") == (double)69905.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123746_, x, y, z, 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(((double)1.0F + (double)0.5F * SetEntitySizeProcedure.execute(entity)) / (double)2.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && entityiterator instanceof LivingEntity && !entityiterator.m_20149_().equals(entity.getPersistentData().m_128461_("OWNER_UUID")) && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 30, 0, false, false));
                  }
               }
            }
         }

         if (entity.m_20096_()) {
            entity.getPersistentData().m_128347_("BlockRange", entity.getPersistentData().m_128459_("BlockRange") * range_fix);
            entity.getPersistentData().m_128347_("BlockDamage", entity.getPersistentData().m_128459_("BlockDamage") * CNT6);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x, y, z, 1, (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.0F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 1, (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.5F + (double)0.5F * SetEntitySizeProcedure.execute(entity), (double)0.5F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
               }
            }

            JujutsucraftvMod.queueServerWork(30, () -> {
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

            });
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt53 = (LivingEntity)entity;
            if (_livEnt53.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
               return;
            }
         }

         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
