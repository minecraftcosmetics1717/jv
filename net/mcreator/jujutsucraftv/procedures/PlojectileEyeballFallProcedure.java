package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.entity.PlojectileEyeballEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileSixEyeballEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileEyeballFallProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double skill_num = (double)0.0F;
         immediatesourceentity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         if (!(immediatesourceentity instanceof PlojectileEyeballEntity) && !(immediatesourceentity instanceof PlojectileSixEyeballEntity)) {
            skill_num = (double)2.0F;
         } else {
            skill_num = (double)1.0F;
         }

         x_pos = immediatesourceentity.m_20185_();
         y_pos = immediatesourceentity.m_20186_();
         z_pos = immediatesourceentity.m_20189_();
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ 0.5 0.5 0.5 0.3 3");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_EXPLOSION.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               if (skill_num == (double)1.0F) {
                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)100.0F);
                  entityinstance.getPersistentData().m_128347_("effect", (double)3.0F);
                  entityinstance.getPersistentData().m_128347_("explosion_type", (double)1.0F);
                  entityinstance.getPersistentData().m_128347_("BlockRange", (double)15.0F);
                  entityinstance.getPersistentData().m_128347_("BlockDamage", (double)5.0F);
                  old_skill = entity.getPersistentData().m_128459_("skill");
                  old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
                  entityinstance.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
                  entityinstance.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
                  if (GetSixEyeProcedure.execute(entity)) {
                     entityinstance.getPersistentData().m_128347_("Damage", (double)50.0F);
                     entityinstance.getPersistentData().m_128347_("Range", (double)20.0F);
                     entityinstance.getPersistentData().m_128347_("knockback", (double)0.5F);
                  } else {
                     entityinstance.getPersistentData().m_128347_("Damage", (double)40.0F);
                     entityinstance.getPersistentData().m_128347_("Range", (double)20.0F);
                     entityinstance.getPersistentData().m_128347_("knockback", (double)0.5F);
                  }
               } else if (skill_num == (double)2.0F) {
                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)20.0F);
                  entityinstance.getPersistentData().m_128347_("effect", (double)3.0F);
                  entityinstance.getPersistentData().m_128347_("explosion_type", (double)2.0F);
                  entityinstance.getPersistentData().m_128347_("BlockRange", (double)5.0F);
                  entityinstance.getPersistentData().m_128347_("BlockDamage", (double)5.0F);
                  old_skill = entity.getPersistentData().m_128459_("skill");
                  old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
                  entityinstance.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
                  entityinstance.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
                  entityinstance.getPersistentData().m_128347_("Damage", (double)20.0F);
                  entityinstance.getPersistentData().m_128347_("Range", (double)6.0F);
                  entityinstance.getPersistentData().m_128347_("knockback", 0.3);
               }

               entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               entityinstance.getPersistentData().m_128379_("data_set", true);
               entityinstance.getPersistentData().m_128347_("texture_type", (double)1.0F);
               entityinstance.m_20331_(true);
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10005;
                     label51: {
                        var10001 = new MobEffectInstance;
                        var10003 = MobEffects.f_19600_;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label51;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                     _entity.m_7292_(var10001);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 20, 1, false, false));
                  }
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
