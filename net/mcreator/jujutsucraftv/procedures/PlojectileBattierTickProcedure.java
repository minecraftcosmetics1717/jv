package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier0Entity;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier1Entity;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier2Entity;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier3Entity;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier4Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileBattierTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double y_look = (double)0.0F;
         double x_look = (double)0.0F;
         double z_look = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity instanceof PlojectileBarrier1Entity) {
            label208: {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.5F);
                  if (entity instanceof PlojectileBarrier1Entity) {
                     ((PlojectileBarrier1Entity)entity).setAnimation("act");
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                     break label208;
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (entity instanceof PlojectileBarrier2Entity) {
            label209: {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(entity.getPersistentData().m_128459_("size_set"));
                  if (entity instanceof PlojectileBarrier2Entity) {
                     ((PlojectileBarrier2Entity)entity).setAnimation("act");
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                     break label209;
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (entity instanceof PlojectileBarrier0Entity) {
            label210: {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               entity.getPersistentData().m_128347_("count", entity.getPersistentData().m_128459_("count") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                     if (entity instanceof PlojectileBarrier0Entity) {
                        ((PlojectileBarrier0Entity)entity).setAnimation("act2");
                     }
                  } else {
                     ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                     if (entity instanceof PlojectileBarrier0Entity) {
                        ((PlojectileBarrier0Entity)entity).setAnimation("act");
                     }
                  }

                  RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)4.0F && entity.getPersistentData().m_128459_("entity_use") != (double)1.0F) {
                  entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                  BulletDomainHit2Procedure.execute(world, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
                  SetPosGoProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity, true, (double)3.0F);
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - 0.1);
                  entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionVProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("Range", SetEntitySizeProcedure.execute(entity) + (double)2.0F);
                  entity.getPersistentData().m_128347_("knockback", 0.1);
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  RangeAttackVProcedure.execute(world, x, y, z, entity);
                  if (entity.m_20096_()) {
                     JujutsucraftvMod.queueServerWork(20, () -> {
                        if (!entity.m_9236_().m_5776_()) {
                           entity.m_146870_();
                        }

                     });
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt50 = (LivingEntity)entity;
                  if (_livEnt50.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                     break label210;
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (entity instanceof PlojectileBarrier3Entity) {
            label211: {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
                  ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(entity.getPersistentData().m_128459_("size_set"));
                  if (entity instanceof PlojectileBarrier3Entity) {
                     ((PlojectileBarrier3Entity)entity).setAnimation("act");
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt59 = (LivingEntity)entity;
                  if (_livEnt59.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                     break label211;
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

         if (entity instanceof PlojectileBarrier4Entity) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            entity.getPersistentData().m_128347_("count", entity.getPersistentData().m_128459_("count") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               entity.m_7618_(Anchor.EYES, new Vec3(entity.m_20185_() + (double)Mth.m_216271_(RandomSource.m_216327_(), -3, 3), entity.m_20186_(), entity.m_20189_() + (double)Mth.m_216271_(RandomSource.m_216327_(), -3, 3)));
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  if (entity instanceof PlojectileBarrier4Entity) {
                     ((PlojectileBarrier4Entity)entity).setAnimation("act_pentagon");
                  }
               } else if (entity instanceof PlojectileBarrier4Entity) {
                  ((PlojectileBarrier4Entity)entity).setAnimation("act_triangle");
               }

               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:attacking 5 1 true");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F && entity.getPersistentData().m_128459_("entity_use") != (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)3.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if ((LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator)) && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get(), 60, 1, false, false, true));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)10.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
               for(int index0 = 0; index0 < 2; ++index0) {
                  x_pos = entity.m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
                  entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F);
                  entity.getPersistentData().m_128379_("noEffect", true);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  x_look = x_pos;
                  y_look = y_pos + (double)Mth.m_216271_(RandomSource.m_216327_(), 8, 10);
                  z_look = z_pos;
                  double var10010 = 0.1 * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6"));
                  double var10012 = 0.1 * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6"));
                  CompoundTag var10020 = entity.getPersistentData();
                  DisplayBeamGenerator2Procedure.execute(world, entity, false, true, false, true, false, (double)10.0F, 0.3, (double)1.0F, var10010, (double)5.0F, var10012, x_pos, x_pos, y_pos, y_look, z_pos, z_pos, (double)0.0F, "jujutsucraftv:particle_barrier_dust " + var10020.m_128461_("particle"));
               }

               if (entity.getPersistentData().m_128459_("count") >= (double)2.0F) {
                  DisplayBeamGenerator2Procedure.execute(world, entity, false, true, false, true, false, (double)10.0F, 0.3, (double)1.0F, 0.1, (double)1.0F, 0.1, x_pos, x_look, y_pos, y_look - (double)3.0F, z_pos, z_look, (double)0.0F, "jujutsucraftv:particle_vertical_barrier_black");
                  entity.getPersistentData().m_128347_("count", (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)35.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)45.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)1.0F;
               z_pos = entity.m_20189_();
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6, 0.8));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.6, 0.8), false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)40.0F) {
                  entity.getPersistentData().m_128347_("Range", (double)7.0F);
                  entity.getPersistentData().m_128347_("Damage", (double)23.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                  entity.getPersistentData().m_128379_("noEffect", true);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  RangeAttackVProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Commands var10000 = _level.m_7654_().m_129892_();
                  CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                  String var10002 = entity.getPersistentData().m_128461_("particle");
                  var10000.m_230957_(var10001, "particle jujutsucraftv:particle_barrier_shard_dust " + var10002 + " ~ ~ ~ 0.6 0.6 0.6 " + Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 1.2) + " 10 force");
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)50.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt122 = (LivingEntity)entity;
               if (_livEnt122.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
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
