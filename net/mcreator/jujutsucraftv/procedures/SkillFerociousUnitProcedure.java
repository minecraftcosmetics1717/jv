package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
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

public class SkillFerociousUnitProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z, final Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F && !entity.getPersistentData().m_128471_("played_sound")) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            entity.getPersistentData().m_128379_("played_sound", true);
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get(), 10, 1, false, false));
            }
         }

         ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)2015.0F);
         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.5F) {
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

                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)0.0F) {
                     entity.getPersistentData().m_128359_("charge_box", "■■■■■");
                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)1.0F) {
                        entity.getPersistentData().m_128359_("charge_box", "■■■■");
                        if (entity.getPersistentData().m_128459_("cnt6") >= (double)2.0F) {
                           entity.getPersistentData().m_128359_("charge_box", "■■■");
                           if (entity.getPersistentData().m_128459_("cnt6") >= (double)3.0F) {
                              entity.getPersistentData().m_128359_("charge_box", "■■");
                              if (entity.getPersistentData().m_128459_("cnt6") >= (double)4.0F) {
                                 entity.getPersistentData().m_128359_("charge_box", "■");
                                 if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                                    entity.getPersistentData().m_128359_("charge_box", "");
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        String var10001 = entity.getPersistentData().m_128461_("charge_box");
                        _player.m_5661_(Component.m_237113_(var10001 + Component.m_237115_("jjcv.long_press").getString() + entity.getPersistentData().m_128461_("charge_box")), true);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               } else {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)2.0F);
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
               }

               entity.getPersistentData().m_128347_("cnt1", (double)2.0F);
            }
         }

         final int _ppvTimes50 = Math.max(0, 1);
         final int _ppvDelay50 = Math.max(0, 5);
         ((<undefinedtype>)(new Object() {
            private int _ppvIteration = 0;

            public void run() {
               if (this._ppvIteration < _ppvTimes50) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var10000 = _level.m_7654_().m_129892_();
                     CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     String var10002 = ReturnEnergyColor3Procedure.execute(entity);
                     var10000.m_230957_(var10001, "/particle " + var10002 + " ~ ~ ~ 0.1 " + entity.m_20206_() + " 0.1 0.25 10");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var3 = _level.m_7654_().m_129892_();
                     CommandSourceStack var4 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     String var5 = ReturnEnergyColor3Procedure.execute(entity);
                     var3.m_230957_(var4, "/particle " + var5 + " ~ ~ ~ 0.1 " + entity.m_20206_() + " 0.1 1 10");
                  }

                  ++this._ppvIteration;
                  if (this._ppvIteration < _ppvTimes50) {
                     JujutsucraftvMod.queueServerWork(_ppvDelay50, this::run);
                  }

               }
            }
         })).run();
         if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F) {
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)75.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:rouzetsu_mobs"))) && !entityiterator.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_())) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        Commands var10000 = _level.m_7654_().m_129892_();
                        CommandSourceStack var22 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        String var10002 = ReturnEnergyColor3Procedure.execute(entity);
                        var10000.m_230957_(var22, "/particle " + var10002 + " ~ ~ ~ 0.1 " + entityiterator.m_20206_() + " 0.1 1 10");
                     }

                     if (!entityiterator.m_9236_().m_5776_()) {
                        entityiterator.m_146870_();
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_FEROCIOUS_UNIT.get(), 3600, 0, false, false, true));
                  }
               }

               entity.getPersistentData().m_128359_("charge_box", "");
               entity.getPersistentData().m_128379_("noChangeTechnique", true);
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128379_("played_sound", false);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               entity.getPersistentData().m_128359_("charge_box", "");
               entity.getPersistentData().m_128379_("played_sound", false);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
