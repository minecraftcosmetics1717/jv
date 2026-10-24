package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EnergyWave1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         double num3 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         boolean tamamo_no_mae = false;
         boolean set_particle = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         tamamo_no_mae = entity.getPersistentData().m_128459_("skill") == (double)154.0F;
         set_particle = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet;
         if (tamamo_no_mae) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
               }
            }

            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123745_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 20, 0.2, 0.2, 0.2, (double)0.0F);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
               if (!tamamo_no_mae && world instanceof ServerLevel) {
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
            } else if (tamamo_no_mae) {
               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)30.0F));
            }

            if (tamamo_no_mae) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123745_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, 0.2, 0.2, 0.2, (double)0.0F);
               }
            } else if ((entity.getPersistentData().m_128459_("cnt1") == (double)1.0F || Math.random() < (double)0.25F) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity20 = (LivingEntity)entity;
            if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity20.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F && entity.getPersistentData().m_128459_("cnt1") < (double)60.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)26.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)35.0F) {
               if (tamamo_no_mae) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                     }
                  }
               } else {
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

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)6.0F, (double)6.0F, (double)6.0F, (double)4.0F);
                  }
               }
            }

            if (tamamo_no_mae) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, 100, 0.2, 0.2, 0.2, (double)0.25F);
               }
            } else if (set_particle) {
               SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(particleType, x, y + (double)entity.m_20206_() * (double)0.5F, z, 100, 0.2, 0.2, 0.2, (double)4.0F);
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x, y + (double)entity.m_20206_() * (double)0.5F, z, 100, 0.2, 0.2, 0.2, (double)4.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 4, 0.2, 0.2, 0.2, (double)4.0F);
               }
            }

            if (!tamamo_no_mae) {
               num1 = Math.toRadians(Math.random() * (double)360.0F);
               num2 = entity.getPersistentData().m_128459_("cnt2") * (double)2.0F % (double)16.0F;

               for(int index0 = 0; index0 < 72; ++index0) {
                  x_pos = x + Math.sin(num1) * num2;
                  z_pos = z + Math.cos(num1) * num2;
                  if (set_particle) {
                     SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(particleType, x_pos, y, z_pos, 1, (double)0.25F, (double)0.25F, (double)0.25F, 0.1);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y, z_pos, 1, (double)0.25F, (double)0.25F, (double)0.25F, 0.1);
                  }

                  num1 += Math.toRadians(Math.random() * (double)10.0F);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)(tamamo_no_mae ? 14 : 13));
            entity.getPersistentData().m_128347_("Range", tamamo_no_mae ? Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)2.0F, (double)32.0F) : Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)48.0F));
            entity.getPersistentData().m_128347_("knockback", tamamo_no_mae ? (double)0.25F : (double)0.5F);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("Damage", (double)(tamamo_no_mae ? 15 : 14));
            entity.getPersistentData().m_128347_("Range", Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)24.0F));
            entity.getPersistentData().m_128347_("knockback", tamamo_no_mae ? (double)0.75F : (double)1.5F);
            RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
            entity.getPersistentData().m_128347_("BlockRange", tamamo_no_mae ? Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)2.0F, (double)16.0F) : Math.min(entity.getPersistentData().m_128459_("cnt2") * (double)4.0F, (double)24.0F));
            entity.getPersistentData().m_128347_("BlockDamage", 0.2);
            BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
