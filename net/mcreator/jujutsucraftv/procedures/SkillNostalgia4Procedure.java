package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillNostalgia4Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double y_lookbefore = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_look = (double)0.0F;
         double z_look = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("yaw", Math.toRadians((double)entity.m_146908_()));
            entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
            entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
            entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)1.0F) {
            x_look = entity.getPersistentData().m_128459_("x_pos");
            y_lookbefore = entity.getPersistentData().m_128459_("y_pos");
            z_look = entity.getPersistentData().m_128459_("z_pos");

            for(int index0 = 0; index0 < 50 && world.m_8055_(BlockPos.m_274561_(x_look, y_lookbefore, z_look)).m_60815_(); ++index0) {
               ++y_lookbefore;
            }

            for(int index1 = 0; index1 < 50; ++index1) {
               if (world.m_8055_(BlockPos.m_274561_(x_look, y_lookbefore, z_look)).m_60815_()) {
                  y_lookbefore -= 0.1;
                  break;
               }

               --y_lookbefore;
            }

            range = SetEntitySizeProcedure.execute(entity);
            y_pos = y_lookbefore + (double)0.5F;
            x_power = entity.m_20154_().f_82479_;
            y_power = Math.toRadians((double)-90.0F);
            z_power = entity.m_20154_().f_82481_;
            DisplayparticleGeneratorCircleVProcedure.execute(world, (double)48.0F * range, (double)(90 + Mth.m_216271_(RandomSource.m_216327_(), -10, 10)), (double)0.0F, (double)4.0F * range, (double)1.5F, x_look, x_look, y_pos, y_pos, (double)Mth.m_216271_(RandomSource.m_216327_(), -10, 10), z_look, z_look, "minecraft:squid_ink");
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_look, y_pos, z_look, (int)((double)24.0F * range), (double)0.0F, (double)0.0F, (double)0.0F, (double)0.5F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_look, y_pos, z_look), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x_look, y_pos, z_look, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)13.0F && world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_NOSTALGIA_HAND_LARGE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_lookbefore, z_look), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("skill_on", (double)1.0F);
                  entityinstance.getPersistentData().m_128347_("waza_nosta", (double)5.0F);
                  entityinstance.getPersistentData().m_128347_("color", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 2));
                  entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10004;
                        label60: {
                           var10001 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19557_();
                                 break label60;
                              }
                           }

                           var10004 = 0;
                        }

                        int var10005;
                        label55: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label55;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, var10004, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                  entityinstance.getPersistentData().m_128347_("yaw", Math.toRadians((double)entity.m_146908_()));
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
               entity.getPersistentData().m_128347_("cnt", (double)0.0F);
               entity.getPersistentData().m_128347_("x_pos", (double)0.0F);
               entity.getPersistentData().m_128347_("y_pos", (double)0.0F);
               entity.getPersistentData().m_128347_("z_pos", (double)0.0F);
               entity.getPersistentData().m_128379_("charge", false);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
