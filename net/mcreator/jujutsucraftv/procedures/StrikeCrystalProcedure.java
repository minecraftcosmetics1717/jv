package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade18Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class StrikeCrystalProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skillnum = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && (entity.getPersistentData().m_128471_("PRESS_Z") || entity instanceof CursedSpiritGrade18Entity && !(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F))) {
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

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)12.0F) {
            x_pos = entity.m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-6.0F, (double)6.0F);
            y_pos = entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)6.0F);
            z_pos = entity.m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-6.0F, (double)6.0F);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_CRYSTAL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livInstance = (LivingEntity)entityinstance;
                     _livInstance.m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? Mth.m_216263_(RandomSource.m_216327_(), (double)3.0F, (double)6.0F) : Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)3.0F));
                  }

                  entityinstance.m_20242_(true);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  entityinstance.getPersistentData().m_128347_("Range", (double)Math.round(((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22135_()));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label114: {
                           var10001 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label114;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                     entityinstance.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                     entityinstance.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  } else {
                     LivingEntity var10000;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 != null) {
                        CompoundTag var37 = entityinstance.getPersistentData();
                        LivingEntity var10002;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        var37.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                        var37 = entityinstance.getPersistentData();
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        var37.m_128347_("y_pos", ((Entity)var10002).m_20186_());
                        var37 = entityinstance.getPersistentData();
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        var37.m_128347_("z_pos", ((Entity)var10002).m_20189_());
                     } else {
                        entityinstance.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                        entityinstance.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                        entityinstance.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)50.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                     }
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt_x_play", (double)0.0F);
         }

      }
   }
}
