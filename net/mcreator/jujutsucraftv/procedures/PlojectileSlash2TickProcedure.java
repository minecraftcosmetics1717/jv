package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraftv.entity.PlojectileSlash2Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileSlash2TickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.f_19789_ = 0.0F;
         if (entity instanceof PlojectileSlash2Entity && entity.getPersistentData().m_128459_("slash") == (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity.getPersistentData().m_128471_("nois")) {
                  if (entity instanceof PlojectileSlash2Entity) {
                     PlojectileSlash2Entity animatable = (PlojectileSlash2Entity)entity;
                     animatable.setTexture("noise_scisser_slash");
                  }

                  if (entity instanceof PlojectileSlash2Entity) {
                     PlojectileSlash2Entity animatable = (PlojectileSlash2Entity)entity;
                     animatable.setGlowTexture("noise_scisser_slash");
                  }
               } else if (entity instanceof PlojectileSlash2Entity) {
                  PlojectileSlash2Entity animatable = (PlojectileSlash2Entity)entity;
                  animatable.setTexture("slash_ripping");
               }

               if (entity.getPersistentData().m_128459_("entity_use") != (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                  BulletDomainHit2Procedure.execute(world, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(entity.getPersistentData().m_128459_("size"));
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
               if (entity.getPersistentData().m_128471_("nois")) {
                  if (entity instanceof PlojectileSlash2Entity) {
                     ((PlojectileSlash2Entity)entity).setAnimation("act5");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)2.0F) {
                  if (entity instanceof PlojectileSlash2Entity) {
                     ((PlojectileSlash2Entity)entity).setAnimation("act2");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)3.0F) {
                  if (entity instanceof PlojectileSlash2Entity) {
                     ((PlojectileSlash2Entity)entity).setAnimation("act3");
                  }
               } else if (entity.getPersistentData().m_128459_("color") == (double)4.0F) {
                  if (entity instanceof PlojectileSlash2Entity) {
                     ((PlojectileSlash2Entity)entity).setAnimation("act4");
                  }
               } else if (entity instanceof PlojectileSlash2Entity) {
                  ((PlojectileSlash2Entity)entity).setAnimation("act1");
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash1")), SoundSource.NEUTRAL, 0.3F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, (double)1.0F));
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash1")), SoundSource.NEUTRAL, 0.3F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, (double)1.0F), false);
                  }
               }

               if (entity.getPersistentData().m_128471_("nois")) {
                  entity.getPersistentData().m_128379_("noParticle", true);
                  entity.getPersistentData().m_128347_("BlockRange", (double)8.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("Range", (double)8.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("Damage", (double)20.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
               } else {
                  entity.getPersistentData().m_128379_("noParticle", true);
                  entity.getPersistentData().m_128347_("BlockRange", (double)5.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("Range", (double)6.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("knockback", 0.2);
                  entity.getPersistentData().m_128347_("Damage", (double)7.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
               }

               BlockDestroyAllDirectionVProcedure.execute(world, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
               RangeAttackVProcedure.execute(world, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_(), entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt59 = (LivingEntity)entity;
               if (_livEnt59.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                  return;
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
