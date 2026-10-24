package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.PlojectileSlashKakuronEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class OsukiAxeUseProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 14, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity1 = (LivingEntity)entity;
            if (_livingEntity1.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
               _livingEntity1.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22100_((double)303.0F);
            }
         }

         PlayAnimationVProcedure.execute(world, entity);
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         double var10000 = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         var10000 = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         var10000 = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash2")), SoundSource.NEUTRAL, 1.0F, 1.2F);
            } else {
               _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash2")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SLASH_KAKURON.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F), entity.m_20186_(), entity.m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F)), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               entityinstance.m_146922_((float)Math.round(entity.m_146908_() % 360.0F));
               entityinstance.m_146926_((float)Math.round(entity.m_146909_()));
               entityinstance.m_5618_(entityinstance.m_146908_());
               entityinstance.m_5616_(entityinstance.m_146908_());
               entityinstance.f_19859_ = entityinstance.m_146908_();
               entityinstance.f_19860_ = entityinstance.m_146909_();
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entityinstance instanceof PlojectileSlashKakuronEntity) {
                  PlojectileSlashKakuronEntity animatable = (PlojectileSlashKakuronEntity)entityinstance;
                  animatable.setTexture("slash_osuki_axe");
               }

               ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
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
               entityinstance.getPersistentData().m_128379_("osuki", true);
               entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)1.5F);
               entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)1.5F);
               entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)1.5F);
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10005;
                     label59: {
                        var10001 = new MobEffectInstance;
                        var10003 = MobEffects.f_19600_;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label59;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

               SetRangedAmmoProcedure.execute(entity, entityinstance);
               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (entity instanceof Player) {
            if (LogicCreativeProcedure.execute(entity)) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(itemstack.m_41720_(), 20);
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_(itemstack.m_41720_(), 200);
            }
         }

      }
   }
}
