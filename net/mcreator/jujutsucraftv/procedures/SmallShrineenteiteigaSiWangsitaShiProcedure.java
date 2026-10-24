package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallShrineenteiteigaSiWangsitaShiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double random = (double)0.0F;
      random = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 1000);
      if (random >= (double)1.0F != random <= (double)500.0F && world.m_6106_().m_5470_().m_46207_(GameRules.f_46134_)) {
         if (random > (double)500.0F == random <= (double)800.0F) {
            JujutsucraftvMod.queueServerWork(10, () -> {
               for(int index0 = 0; index0 < Mth.m_216271_(RandomSource.m_216327_(), 3, 6); ++index0) {
                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 3) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var10000 = _level.m_7654_().m_129892_();
                        CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F), y, z + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F)), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        RandomSource var10002 = RandomSource.m_216327_();
                        var10000.m_230957_(var10001, "/summon jujutsucraftv:cursed_spirit_grade_3" + Mth.m_216271_(var10002, 1, 15));
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var12 = _level.m_7654_().m_129892_();
                     CommandSourceStack var13 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F), y, z + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F)), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     RandomSource var14 = RandomSource.m_216327_();
                     var12.m_230957_(var13, "/summon jujutsucraft:cursed_spirit_grade_3" + Mth.m_216271_(var14, 1, 24));
                  }

                  if (world instanceof Level _level) {
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                  }
               }

            });
         }

         if (random > (double)800.0F == random <= (double)900.0F) {
            JujutsucraftvMod.queueServerWork(10, () -> {
               for(int index1 = 0; index1 < Mth.m_216271_(RandomSource.m_216327_(), 1, 3); ++index1) {
                  if (world instanceof ServerLevel _level) {
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F), y, z + Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F)), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraft:cursed_spirit_grade_25");
                  }

                  if (world instanceof Level _level) {
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
                  }
               }

            });
         }

         if (random > (double)900.0F == random <= (double)970.0F) {
            JujutsucraftvMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _level) {
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraft:cursed_spirit_grade_111");
               }

               if (world instanceof Level _level) {
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.5F);
               }

            });
         }

         if (random > (double)970.0F == random <= (double)1000.0F) {
            JujutsucraftvMod.queueServerWork(10, () -> {
               if (world instanceof ServerLevel _level) {
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraft:cursed_spirit_grade_01");
               }

               if (world instanceof Level _level) {
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof ServerLevel _level) {
                  _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 15, (double)1.0F, (double)2.0F, (double)1.0F, (double)0.5F);
               }

            });
         }
      } else {
         JujutsucraftvMod.queueServerWork(10, () -> {
            if (world instanceof ServerLevel _level) {
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/loot spawn ~ ~1 ~ loot jujutsucraft:entities/stevenson_screen");
            }

         });
      }

   }
}
