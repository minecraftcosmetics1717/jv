package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AttackStrongOkkotsuProcedure;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.ChangeCurseEnergyProcedure;
import net.mcreator.jujutsucraft.procedures.ChargeParticleProcedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceNearestEnemyProcedure;
import net.mcreator.jujutsucraft.procedures.GetReachProcedure;
import net.mcreator.jujutsucraft.procedures.ParticleGeneratorColorProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraftv.procedures.ReturnEnergyColor3Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({AttackStrongOkkotsuProcedure.class})
public abstract class AttackStrongOkkotsuProcedureMixin {
   @Overwrite(
      remap = false
   )
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean player = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double dis = (double)0.0F;
         double strength = (double)0.0F;
         double range = (double)0.0F;
         double loop_num = (double)0.0F;
         double CNT6 = (double)0.0F;
         double count = (double)0.0F;
         double counter = (double)0.0F;
         double size = (double)0.0F;
         double rad = (double)0.0F;
         double rad_now = (double)0.0F;
         double yaw_now = (double)0.0F;
         double attack_reach = (double)0.0F;
         double dis_start = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double cnt6_old = (double)0.0F;
         double energy_color = (double)0.0F;
         String color3 = "";
         String color1 = "";
         String color2 = "";
         String str2 = "";
         player = entity instanceof Player;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)7.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)6.0F) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  dis = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  if (dis > (double)1.0F && dis < (double)4.0F) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") == (double)0.0F) {
                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)6.0F));
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * (double)2.0F), 0, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  strength = (double)0.5F;
               } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                  strength = 0.2;
               } else {
                  ChangeCurseEnergyProcedure.execute(entity, (double)-1.0F);
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)0.125F);
                  if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                  }

                  strength = 0.1;
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)6.0F) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ChargeParticleProcedure.execute(world, entity, (double)10.0F);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, (double)0.0F);
                  }
               }
            }
         }

         int var108;
         label192: {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var108 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label192;
               }
            }

            var108 = 0;
         }

         strength = (double)Math.min(var108, 50) * CNT6;
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + strength * 0.025);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)8.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt5", (double)(entity.m_146908_() + 15.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               ItemStack var109;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var109 = _livEnt.m_21205_();
               } else {
                  var109 = ItemStack.f_41583_;
               }

               if (var109.m_204117_(ItemTags.create(new ResourceLocation("minecraft:swords")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var109 = _livEnt.m_21205_();
                  } else {
                     var109 = ItemStack.f_41583_;
                  }

                  if (!var109.m_204117_(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))) && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity49 = (LivingEntity)entity;
                  if (_livingEntity49.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity49.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            range = ReturnEntitySizeProcedure.execute(entity);
            if (entity.getPersistentData().m_128459_("cnt2") < (double)4.0F) {
               str2 = ReturnEnergyColor3Procedure.execute(entity);
               size = Math.max(ReturnEntitySizeProcedure.execute(entity), 0.01);
               attack_reach = GetReachProcedure.execute(entity);
               dis_start = 1.7;
               rad_now = Math.toRadians((double)entity.m_146909_());
               yaw_now = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               cnt6_old = entity.getPersistentData().m_128459_("cnt6");
               entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);

               for(int index0 = 0; (long)index0 < Math.round((double)10.0F * size); ++index0) {
                  rad = Math.toRadians(entity.getPersistentData().m_128459_("cnt5") + entity.getPersistentData().m_128459_("cnt4"));
                  dis = dis_start;
                  count = (double)0.0F;
                  counter = (double)0.0F;
                  x_power = Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw_now) * Math.sin(rad_now)));
                  y_power = Math.sin(Math.toRadians(entity.getPersistentData().m_128459_("cnt4"))) * Math.sin(rad_now) * (double)-1.0F;
                  z_power = Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw_now) * Math.sin(rad_now)));
                  ParticleGeneratorColorProcedure.execute(world, range * 0.2, (double)2.0F * range, (double)5.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)4.0F), entity.m_20185_() + x_power * dis_start, entity.m_20185_() + x_power * dis_start + x_power, entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + y_power * dis_start, entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + y_power * dis_start + y_power, entity.m_20189_() + z_power * dis_start, entity.m_20189_() + z_power * dis_start + z_power, str2);

                  for(int index1 = 0; (long)index1 < Math.round((double)30.0F * attack_reach * size * CNT6); ++index1) {
                     x_pos = entity.m_20185_() + x_power * dis;
                     y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + y_power * dis;
                     z_pos = entity.m_20189_() + z_power * dis;
                     ++count;
                     counter -= (double)0.25F;
                     if (counter <= (double)0.0F) {
                        counter = (double)0.5F;
                        entity.getPersistentData().m_128347_("Damage", (double)17.0F * CNT6);
                        entity.getPersistentData().m_128347_("knockback", (double)1.5F * CNT6);
                        entity.getPersistentData().m_128347_("Range", (double)5.0F);
                        entity.getPersistentData().m_128347_("effect", (double)5.0F);
                        entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                        entity.getPersistentData().m_128379_("attack", true);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 4, 0.1, 0.1, 0.1, (double)0.5F);
                        }

                        ParticleGeneratorColorProcedure.execute(world, range * 0.2, (double)4.0F * range, (double)360.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)2.0F), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, str2);
                        entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F + strength / (double)8.0F);
                        entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
                        if (!logic_a) {
                           logic_a = true;
                           entity.getPersistentData().m_128379_("noEffect", false);
                        } else {
                           entity.getPersistentData().m_128379_("noEffect", true);
                        }

                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                           break;
                        }
                     }

                     dis += (double)0.5F;
                  }

                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + Math.random() * (double)10.0F / size);
               }

               entity.getPersistentData().m_128347_("cnt6", cnt6_old);
            }

            if (entity.getPersistentData().m_128459_("cnt2") > (double)10.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }

   }
}
