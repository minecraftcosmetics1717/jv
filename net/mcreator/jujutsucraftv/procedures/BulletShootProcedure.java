package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.entity.KnifeEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletShootProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skillnum = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         double plus_pos = (double)0.0F;
         double yaw = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("shift_tec") == (double)0.0F) {
            if (GetFlagShiftProcedure.execute(entity)) {
               entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (!_livEnt.m_21220_().isEmpty()) {
                     int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                     if (cooldownTicks > 0) {
                        _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.5F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.5F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  double var10000 = x_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)-1.0F);
                  var10000 = y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)-1.0F);
                  var10000 = z_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)-1.0F);
                  entity.getPersistentData().m_128347_("Damage", (double)5.0F);
                  Level projectileLevel = entity.m_9236_();
                  if (!projectileLevel.m_5776_()) {
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new KnifeEntity((EntityType)JujutsucraftvModEntities.KNIFE.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, (float)entity.getPersistentData().m_128459_("Damage"), 1);
                     _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                     _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.05F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               entity.getPersistentData().m_128347_("count", (double)0.0F);
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            }
         } else if (entity.getPersistentData().m_128459_("shift_tec") == (double)2.0F) {
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.5F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.5F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
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

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     if (skillnum == (double)60905.0F && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), 0.1, 0.1, 0.1, 0.1);
                     }
                  } else if (skillnum == (double)60905.0F && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), 0.1, 0.1, 0.1, 0.1);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     entity.getPersistentData().m_128347_("count", entity.getPersistentData().m_128459_("count") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                        entity.getPersistentData().m_128347_("count", (double)2.0F);
                        if (skillnum == (double)60905.0F) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, 0.1, 0.1, 0.1, 0.1);
                           }
                        }
                     }
                  }
               }
            }

            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            entity.getPersistentData().m_128347_("count", (double)Math.round(entity.getPersistentData().m_128459_("count")));
            if (entity.getPersistentData().m_128459_("count") < (double)1.0F) {
               entity.getPersistentData().m_128347_("count", (double)1.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)6.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               x_pos += Math.random() * (double)1.0F == (double)0.0F ? Math.random() * (double)-2.0F : Math.random() * (double)2.0F;
               y_pos += Math.random() * (double)1.0F == (double)0.0F ? Math.random() * (double)-2.0F : Math.random() * (double)2.0F;
               z_pos += Math.random() * (double)1.0F == (double)0.0F ? Math.random() * (double)-2.0F : Math.random() * (double)2.0F;
               entity.getPersistentData().m_128347_("Damage", (double)7.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));

               for(int index0 = 0; index0 < (int)entity.getPersistentData().m_128459_("count"); ++index0) {
                  Level projectileLevel = entity.m_9236_();
                  if (!projectileLevel.m_5776_()) {
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new KnifeEntity((EntityType)JujutsucraftvModEntities.KNIFE.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, (float)entity.getPersistentData().m_128459_("Damage"), 1);
                     _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                     _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.05F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)12.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               entity.getPersistentData().m_128347_("count", (double)0.0F);
               entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            }
         }

      }
   }
}
