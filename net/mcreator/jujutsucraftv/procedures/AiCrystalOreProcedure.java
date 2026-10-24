package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.PlojectileCrystalEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class AiCrystalOreProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof PlojectileCrystalEntity) {
               PlojectileCrystalEntity var10000 = (PlojectileCrystalEntity)entity;
               RandomSource var10001 = RandomSource.m_216327_();
               var10000.setAnimation("act" + Mth.m_216271_(var10001, 1, 3));
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.8));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.8), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 200, 1, false, false));
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)4.0F && entity.getPersistentData().m_128459_("entity_use") != (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)7.0F) {
            entity.m_20242_(false);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)8.0F) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22135_() / (double)2.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (!GetEntityStoppedProcedure.execute(entity) && !LogicAttackProcedure.execute(world, entity, entityiterator) && !LogicBetrayalProcedure.execute(world, entity, entityiterator)) {
                  if (!GetOwnerDomainExpansionProcedure.execute(world, entity)) {
                     SetPosGoProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity, true, (double)3.0F);
                     entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)1.0F);
                  }
               } else if (!entity.getPersistentData().m_128471_("hitted")) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                  entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionVProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F + ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22135_());
                  entity.getPersistentData().m_128347_("knockback", 0.3);
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                  RangeAttackVProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128379_("hitted", true);
                  JujutsucraftvMod.queueServerWork(100, () -> {
                     if (world instanceof ServerLevel _level) {
                        Commands var10000 = _level.m_7654_().m_129892_();
                        CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                        double var10002 = entity.getPersistentData().m_128459_("cnt6");
                        var10000.m_230957_(var10001, "particle block minecraft:amethyst_cluster ~ ~ ~ 0.1 0.1 0.1 1.3 " + var10002 * (double)5.0F);
                     }

                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                  });
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt36 = (LivingEntity)entity;
            if (_livEnt36.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
               return;
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Commands var29 = _level.m_7654_().m_129892_();
            CommandSourceStack var30 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
            double var10002 = entity.getPersistentData().m_128459_("cnt6");
            var29.m_230957_(var30, "particle block minecraft:amethyst_cluster ~ ~ ~ 0.1 0.1 0.1 1.3 " + var10002 * (double)5.0F);
         }

         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
