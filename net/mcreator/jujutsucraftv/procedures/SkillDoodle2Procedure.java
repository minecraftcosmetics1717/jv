package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillDoodle2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean set_particle = false;
         boolean tamamo_no_mae = false;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var10000 = entity.m_20194_().m_129892_();
            CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
            CompoundTag var10002 = entity.getPersistentData();
            var10000.m_230957_(var10001, "/effect give @s jujutsucraft:cooldown_time " + var10002.m_128459_("COOLDOWN_TICKS") + " 0 false");
         }

         set_particle = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123760_, x, y, z, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }

            if ((entity.getPersistentData().m_128459_("cnt1") == (double)1.0F || Math.random() < (double)0.25F) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:electrick_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:electrick_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }
         }

         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/attribute @s jujutsucraft:animation_1 base set 2015");
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F && entity.getPersistentData().m_128459_("cnt1") < (double)60.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)26.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)35.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                  }
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F;
            z_pos = entity.m_20189_();
            range = ReturnEntitySizeProcedure.execute(entity);
            DisplayparticleGeneratorCircleVProcedure.execute(world, (double)48.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)-360.0F, (double)360.0F), 0.1 * range, (double)2.0F * range, (double)6.0F * range, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)-360.0F, (double)360.0F), z_pos, z_pos, "jujutsucraftv:particle_cursed_text_1");
            entity.getPersistentData().m_128347_("Damage", (double)16.0F);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)48.0F));
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("Damage", (double)22.0F);
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)24.0F));
            entity.getPersistentData().m_128347_("knockback", (double)1.5F);
            RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)24.0F));
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
