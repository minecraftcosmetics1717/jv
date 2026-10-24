package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier2Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillYuki4Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
            if (GetFlagShiftProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && entity.getPersistentData().m_128471_("PRESS_Z")) {
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

            DisplayParticleCircleProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + 0.2, entity.m_20189_(), (double)20.0F, (double)10.0F, "/particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~ ~ 0.01 0.01 0.01 0 1");
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 1.5F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.prepare_blindness")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
               }
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
            PlayAnimationProcedure.execute(world, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 99, false, false));
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_BARRIER_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_7618_(Anchor.EYES, new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_()));
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)0.0F);
                     if (entityinstance instanceof Mob) {
                        Mob _mob34 = (Mob)entityinstance;
                        _mob34.m_21557_(true);
                     }

                     entityinstance.m_20331_(true);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 40, 1, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PLOJECTILE_FOLLOW.get(), 50, 1, false, false));
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("size_set", (double)6.0F);
                     if (entityinstance instanceof PlojectileBarrier2Entity) {
                        PlojectileBarrier2Entity _datEntSetI = (PlojectileBarrier2Entity)entityinstance;
                        _datEntSetI.m_20088_().m_135381_(PlojectileBarrier2Entity.DATA_tex, (int)ReturnEnergyColorVProcedure.execute(entity));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)5.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (!LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator)) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.TECHNIQUE_DAMAGE_BOOST.get(), 1200, 1, true, false));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PHYSICAL_DAMAGE_BOOST.get(), 1200, 1, true, false));
                        }
                     }
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_BARRIER_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_7618_(Anchor.EYES, new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_()));
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                     if (entityinstance instanceof Mob) {
                        Mob _mob66 = (Mob)entityinstance;
                        _mob66.m_21557_(true);
                     }

                     entityinstance.m_20331_(true);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 40, 1, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PLOJECTILE_FOLLOW.get(), 50, 1, false, false));
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("size_set", (double)2.0F);
                     if (entityinstance instanceof PlojectileBarrier2Entity) {
                        PlojectileBarrier2Entity _datEntSetI = (PlojectileBarrier2Entity)entityinstance;
                        _datEntSetI.m_20088_().m_135381_(PlojectileBarrier2Entity.DATA_tex, (int)ReturnEnergyColorVProcedure.execute(entity));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.TECHNIQUE_DAMAGE_BOOST.get(), 1200, 2, true, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PHYSICAL_DAMAGE_BOOST.get(), 1200, 2, true, false));
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            DamageFoundationStoneProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
