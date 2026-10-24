package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileBulletShootTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double speed = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         immediatesourceentity.getPersistentData().m_128347_("cnt1", immediatesourceentity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt1") == (double)3.0F && immediatesourceentity.getPersistentData().m_128459_("entity_use") != (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, immediatesourceentity);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt1") == (double)4.0F) {
            speed = (double)2.5F;
            Vec3 viewDirection = entity.m_20154_();
            Vec3 horizontalViewDirection = (new Vec3(viewDirection.f_82479_, (double)0.0F, viewDirection.f_82481_)).m_82541_();
            Vec3 movement = horizontalViewDirection.m_82490_(speed);
            entity.m_20256_(movement);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
            if (immediatesourceentity.getPersistentData().m_128459_("cnt1") >= (double)100.0F && !immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }

            if (immediatesourceentity.getPersistentData().m_128459_("bullet_hit") != (double)1.0F && immediatesourceentity.getPersistentData().m_128459_("skill") == (double)60905.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_(), 1, 0.01, 0.01, 0.01, (double)0.0F);
            }

            Vec3 _center = new Vec3(immediatesourceentity.m_20185_(), immediatesourceentity.m_20186_(), immediatesourceentity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) && !entity.getPersistentData().m_128461_("OWNER_UUID").equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                  x_pos = immediatesourceentity.m_20185_();
                  y_pos = immediatesourceentity.m_20186_();
                  z_pos = immediatesourceentity.m_20189_();
                  immediatesourceentity.getPersistentData().m_128347_("Range", (double)1.0F);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, immediatesourceentity);
                  if (!immediatesourceentity.m_9236_().m_5776_()) {
                     immediatesourceentity.m_146870_();
                  }
               }
            }

            if (immediatesourceentity.m_20096_()) {
               x_pos = immediatesourceentity.m_20185_();
               y_pos = immediatesourceentity.m_20186_();
               z_pos = immediatesourceentity.m_20189_();
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.hit")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               immediatesourceentity.getPersistentData().m_128347_("BlockRange", (double)1.0F);
               immediatesourceentity.getPersistentData().m_128347_("BlockDamage", (double)1.0F);
               immediatesourceentity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               JujutsucraftvMod.queueServerWork(60, () -> {
                  if (!immediatesourceentity.m_9236_().m_5776_()) {
                     immediatesourceentity.m_146870_();
                  }

               });
            }
         }

      }
   }
}
