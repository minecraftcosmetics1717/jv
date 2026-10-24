package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
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

public class SkillNostalgia2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 255, false, false));
               }
            }

            entity.getPersistentData().m_128347_("start_p", Math.toRadians((double)entity.m_146909_()));
            entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)entity.m_146908_()));
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               CompoundTag var48 = entity.getPersistentData();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               var48.m_128347_("x_pos_after", ((Entity)var10002).m_20185_());
               var48 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.m_5448_();
               } else {
                  var10002 = null;
               }

               double var56 = ((Entity)var10002).m_20186_();
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               var48.m_128347_("y_pos_after", var56 + (double)((Entity)var10003).m_20206_() * (double)0.75F);
               var48 = entity.getPersistentData();
               LivingEntity var57;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var57 = _mobEnt.m_5448_();
               } else {
                  var57 = null;
               }

               var48.m_128347_("z_pos_after", ((Entity)var57).m_20189_());
            } else {
               entity.getPersistentData().m_128347_("x_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
               entity.getPersistentData().m_128347_("z_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-4.0F);
            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 255, false, false));
               }
            }

            entity.getPersistentData().m_128347_("start_p", Math.toRadians((double)entity.m_146909_()));
            entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)entity.m_146908_()));
            LivingEntity var51;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var51 = _mobEnt.m_5448_();
            } else {
               var51 = null;
            }

            if (var51 instanceof LivingEntity) {
               CompoundTag var52 = entity.getPersistentData();
               LivingEntity var58;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               var52.m_128347_("x_pos_after", ((Entity)var58).m_20185_());
               var52 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               double var60 = ((Entity)var58).m_20186_();
               LivingEntity var62;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var62 = _mobEnt.m_5448_();
               } else {
                  var62 = null;
               }

               var52.m_128347_("y_pos_after", var60 + (double)((Entity)var62).m_20206_() * (double)0.75F);
               var52 = entity.getPersistentData();
               LivingEntity var61;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var61 = _mobEnt.m_5448_();
               } else {
                  var61 = null;
               }

               var52.m_128347_("z_pos_after", ((Entity)var61).m_20189_());
            } else {
               entity.getPersistentData().m_128347_("x_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
               entity.getPersistentData().m_128347_("z_pos_after", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)20.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.death")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.death")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            range = SetEntitySizeProcedure.execute(entity);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
            z_pos = entity.m_20189_();
            x_power = entity.m_20154_().f_82479_;
            y_power = entity.m_20154_().f_82480_;
            z_power = entity.m_20154_().f_82481_;

            for(int index0 = 0; index0 < 8; ++index0) {
               DisplayparticleGeneratorCircleVProcedure.execute(world, (double)1.0F * range, (double)entity.m_146909_(), (double)0.5F * range, (double)1.0F * range, 0.6, x_pos, x_pos + x_power * range, y_pos, y_pos + y_power * range, (double)entity.m_146908_(), z_pos, z_pos + z_power * range, Math.random() < (double)0.5F ? "minecraft:sculk_soul" : "minecraft:squid_ink");
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_NOSTALGIA_HAND_SMALL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F) * range, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F) * range, z_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F) * range), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("x_pos_after", entity.getPersistentData().m_128459_("x_pos_after"));
                  entityinstance.getPersistentData().m_128347_("y_pos_after", entity.getPersistentData().m_128459_("y_pos_after"));
                  entityinstance.getPersistentData().m_128347_("z_pos_after", entity.getPersistentData().m_128459_("z_pos_after"));
                  entityinstance.getPersistentData().m_128347_("waza_nosta", (double)3.0F);
                  entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffect var63;
                        MobEffectInstance var10001;
                        int var10005;
                        label126: {
                           var10001 = new MobEffectInstance;
                           var63 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label126;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var63, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") >= (double)4.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)16.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
