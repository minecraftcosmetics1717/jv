package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CloneDieProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         if ((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) {
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.95F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.95F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 20, (double)1.0F, (double)2.0F, (double)1.0F, (double)0.5F);
            }

            if (entity_a instanceof Player) {
               Player _player = (Player)entity_a;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.clone_die").getString()), true);
               }
            }

            if (world instanceof Level) {
               ((Level)world).m_7785_(entity_a.m_20185_(), entity_a.m_20186_(), entity_a.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.hit_player")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }

            double _setval = ((JujutsucraftvModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax - (double)1.0F;
            (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.CloneMax = _setval;
               capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")));
            });
            _setval = ((JujutsucraftvModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount - (double)1.0F;
            (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.CloneCount = _setval;
               capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")));
            });
            if (entity_a instanceof LivingEntity) {
               LivingEntity _livEnt24 = (LivingEntity)entity_a;
               if (_livEnt24.m_21023_((MobEffect)JujutsucraftvModMobEffects.CLONE_BREAK.get())) {
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label52: {
                           var10001 = new MobEffectInstance;
                           var10003 = (MobEffect)JujutsucraftvModMobEffects.CLONE_BREAK.get();
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.CLONE_BREAK.get())) {
                                 var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.CLONE_BREAK.get()).m_19564_();
                                 break label52;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, 1200, var10005 + 1, false, false);
                        _entity.m_7292_(var10001);
                        return;
                     }
                  }

                  return;
               }
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.CLONE_BREAK.get(), 1200, 0, false, false));
               }
            }
         }

      }
   }
}
