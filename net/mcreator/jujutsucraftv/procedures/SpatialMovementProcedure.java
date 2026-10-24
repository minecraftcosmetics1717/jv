package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade11Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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

public class SpatialMovementProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double z_pos_a = (double)0.0F;
         double x_pos_a = (double)0.0F;
         double y_pos_a = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
            if (entity instanceof CursedSpiritGrade11Entity) {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            } else if (entity instanceof Player) {
               if (GetFlagShiftProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && (!(entity instanceof Player) && entity.getPersistentData().m_128459_("dis") < (double)31.0F && entity.getPersistentData().m_128459_("act_move") != (double)1.0F || entity.getPersistentData().m_128471_("PRESS_Z"))) {
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

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)207.0F);
            PlayAnimationProcedure.execute(world, entity);
            entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F + entity.getPersistentData().m_128459_("dis"))), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
            entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F + entity.getPersistentData().m_128459_("dis"))), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
            entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)5.0F + entity.getPersistentData().m_128459_("dis"))), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
            if (!(entity instanceof Player)) {
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     entity.getPersistentData().m_128347_("act_move", (double)1.0F);
                  }
               }
            }

            for(int index0 = 0; index0 < 100 && world.m_8055_(BlockPos.m_274561_(x_pos_a, y_pos_a, z_pos_a)).m_60815_(); ++index0) {
               ++y_pos_a;
            }

            if (entity.getPersistentData().m_128459_("dis") < (double)31.0F) {
               if (entity instanceof CursedSpiritGrade11Entity) {
                  entity.getPersistentData().m_128347_("dis", entity.getPersistentData().m_128459_("dis") + (double)2.0F);
               } else {
                  entity.getPersistentData().m_128347_("dis", entity.getPersistentData().m_128459_("dis") + (double)1.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("dis", (double)30.0F);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos")), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle " + ReturnEnergyColor3Procedure.execute(entity) + " ~ ~ ~ 0.01 0.01 0.01 0 5 force");
            }

            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               DisplayParticleCircleProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + 0.2, entity.m_20189_(), (double)20.0F, (double)4.0F, "particle minecraft:composter ~ ~ ~ 0.01 0.01 0.01 1 1");
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123749_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 3, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)9.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (!LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator)) {
                     entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                        }
                     }

                     entityiterator.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                        _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entityiterator.m_146908_(), entityiterator.m_146909_());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 1, false, false));
                  }
               }

               if (entity instanceof CursedSpiritGrade11Entity && Mth.m_216271_(RandomSource.m_216327_(), 0, 2) == 2) {
                  AttackOverheadVProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("act_move", (double)2.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("act_move") == (double)3.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("dis", (double)0.0F);
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               if (entity instanceof CursedSpiritGrade11Entity) {
                  entity.getPersistentData().m_128347_("act_move", (double)0.0F);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("dis", (double)0.0F);
            entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            if (entity instanceof CursedSpiritGrade11Entity) {
               entity.getPersistentData().m_128347_("act_move", (double)0.0F);
            }
         }

      }
   }
}
