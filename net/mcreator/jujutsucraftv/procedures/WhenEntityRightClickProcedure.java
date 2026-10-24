package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiVesselEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiBoogieWoogieEntity;
import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiShrineEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityRightClickProcedure {
   @SubscribeEvent
   public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
      if (event.getHand() == event.getEntity().m_7655_()) {
         execute(event, event.getLevel(), event.getTarget(), event.getEntity());
      }
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      execute((Event)null, world, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double count = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         if (sourceentity.m_6144_() && !entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity && sourceentity.m_20149_().equals(entity.getPersistentData().m_128461_("OWNER_UUID")) && (entity instanceof RozetsuShikigamiBoogieWoogieEntity || entity instanceof RozetsuShikigamiShrineEntity)) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         ItemStack var10000;
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)sourceentity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get() && !entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity && sourceentity.m_20149_().equals(entity.getPersistentData().m_128461_("OWNER_UUID")) && entity instanceof RozetsuShikigamiVesselEntity) {
            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity) && !sourceentity.m_9236_().m_5776_() && sourceentity.m_20194_() != null) {
               sourceentity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, sourceentity.m_20182_(), sourceentity.m_20155_(), sourceentity.m_9236_() instanceof ServerLevel ? (ServerLevel)sourceentity.m_9236_() : null, 4, sourceentity.m_7755_().getString(), sourceentity.m_5446_(), sourceentity.m_9236_().m_7654_(), sourceentity), "/clear @s jujutsucraft:sukuna_finger 1");
            }

            for(int index0 = 0; index0 < 3; ++index0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            entity.getPersistentData().m_128347_("in_sukuna_finger", entity.getPersistentData().m_128459_("in_sukuna_finger") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("in_sukuna_finger") == (double)2.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)0.5F;
               z_pos = entity.m_20189_();
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.burn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               for(int index1 = 0; index1 < 5; ++index1) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var30 = _level.m_7654_().m_129892_();
                     CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     String var10002 = ReturnEnergyColor3Procedure.execute(entity);
                     var30.m_230957_(var10001, "/particle " + var10002 + " ~ ~ ~ 0.1 " + entity.m_20206_() + " 0.1 0.3 15");
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ROZETSU_SHIKIGAMI_SHRINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(sourceentity.m_146908_());
                     entityinstance.m_146926_(sourceentity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", sourceentity.m_20149_());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           double var32;
                           double var34;
                           label146: {
                              var31 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var32 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)sourceentity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var34 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label146;
                                 }
                              }

                              var34 = (double)0.0F;
                           }

                           int var10003;
                           label141: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)sourceentity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label141;
                                 }
                              }

                              var10003 = 0;
                           }

                           var31.m_22100_(var32 + (var34 + (double)(var10003 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var33;
                           MobEffect var35;
                           int var10005;
                           label133: {
                              var33 = new MobEffectInstance;
                              var35 = MobEffects.f_19606_;
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)sourceentity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label133;
                                 }
                              }

                              var10005 = 0;
                           }

                           var33.<init>(var35, Integer.MAX_VALUE, Math.max(var10005, 0), false, false);
                           _entity.m_7292_(var33);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", sourceentity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", sourceentity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", sourceentity instanceof Player || sourceentity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", sourceentity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", sourceentity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (sourceentity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (!sourceentity.m_9236_().m_5776_() && sourceentity.m_20194_() != null) {
                  sourceentity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, sourceentity.m_20182_(), sourceentity.m_20155_(), sourceentity.m_9236_() instanceof ServerLevel ? (ServerLevel)sourceentity.m_9236_() : null, 4, sourceentity.m_7755_().getString(), sourceentity.m_5446_(), sourceentity.m_9236_().m_7654_(), sourceentity), "/advancement grant @s only jujutsucraftv:skill_rozetsu_5");
               }
            }
         }

      }
   }
}
