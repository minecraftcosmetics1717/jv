package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
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

public class SkillNostalgia1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rad = (double)0.0F;
         double y_alter = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 90.0F)));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 55, false, false));
               }
            }

            rad = entity.getPersistentData().m_128459_("start_r");
            x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * entity.getPersistentData().m_128459_("cnt1");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * entity.getPersistentData().m_128459_("cnt1");

            for(int index0 = 0; index0 < 50 && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index0) {
               ++y_pos;
            }

            for(int index1 = 0; index1 < 50; ++index1) {
               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  y_pos -= 0.1;
                  break;
               }

               y_pos -= (double)0.5F;
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_NOSTALGIA_HAND_SMALL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)-4.0F, (double)4.0F), y_pos + 1.2, z_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)-4.0F, (double)4.0F)), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)0.75F, (double)1.0F));
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entityinstance.getPersistentData().m_128347_("waza_nosta", (double)1.0F);
                  entityinstance.m_7618_(Anchor.EYES, new Vec3(x_pos, y, z_pos));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, Integer.MAX_VALUE, 76, false, false));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label57: {
                           var10001 = new MobEffectInstance;
                           var10003 = MobEffects.f_19600_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label57;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var10001);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
