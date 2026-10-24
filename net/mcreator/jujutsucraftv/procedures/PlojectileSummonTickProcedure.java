package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModGameRules;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileSummonTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String uuid = "";
         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F) {
            if (entity.getPersistentData().m_128471_("data_set")) {
               if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F || entity.getPersistentData().m_128459_("cnt1") <= (double)18.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/particle jujutsucraft:particle_curse_power_purple ~ ~ ~ 1 3 1 0.1 10");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 10, (double)1.0F, (double)2.0F, (double)1.0F, 0.6);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.ambient")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.ambient")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)15.0F && entity.getPersistentData().m_128459_("summon") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("BlockRange", (double)8.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)6.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_01.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + 0.1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.getPersistentData().m_128379_("drop_chance_record", true);
                        Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)15.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entityiterator instanceof Player && world.m_6106_().m_5470_().m_46207_(JujutsucraftvModGameRules.JJCV_PLAY_BOSS_BGM)) {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.PLAY_BGM.get());
                              }

                              entityiterator.getPersistentData().m_128359_("BGM_OWNER", entityinstance.m_20149_());
                              double _setval = (double)1980.0F;
                              entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 capability.bgm_tick = _setval;
                                 capability.syncPlayerVariables(entityiterator);
                              });
                              _setval = (double)2.0F;
                              entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                 capability.bgm_lv = _setval;
                                 capability.syncPlayerVariables(entityiterator);
                              });
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityiterator;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PLAY_BGM.get(), 1980, 2, false, false));
                                 }
                              }
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }
            } else if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
