package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.ChargeParticleProcedure;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EnergyWave111Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double HP = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
            }
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            if ((entity.getPersistentData().m_128459_("cnt1") == (double)1.0F || Math.random() < (double)0.25F) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().m_128459_("skill") > (double)0.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt23 = (LivingEntity)entity;
                  if (_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (GetDistanceProcedure.execute(entity) < (double)10.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)13.0F));
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)1.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }

            entity.getPersistentData().m_128347_("Damage", (double)6.0F);
            DamageFixProcedure.execute(entity);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity34 = (LivingEntity)entity;
            if (_livingEntity34.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity34.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F && entity.getPersistentData().m_128459_("cnt1") < (double)60.0F) {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            entity.getPersistentData().m_128347_("Damage", (double)12.0F * CNT6);
            DamageFixProcedure.execute(entity);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)21.0F) {
               HP = (double)40.0F;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livInstance = (LivingEntity)entityinstance;
                        _livInstance.f_20884_ = _livInstance.m_146908_();
                        _livInstance.f_20886_ = _livInstance.m_146908_();
                        if (_livInstance.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livInstance.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }

                        _livInstance.m_21153_((float)HP);
                        if (_livInstance.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livInstance.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     if (entity instanceof Player && ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("owner_set_curse_power_color", true);
                        entityinstance.getPersistentData().m_128347_("set_curse_power_color", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     if (entityinstance instanceof EntityImpactWaveEntity) {
                        EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                        animatable.setTexture("blue");
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)30.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.25F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
