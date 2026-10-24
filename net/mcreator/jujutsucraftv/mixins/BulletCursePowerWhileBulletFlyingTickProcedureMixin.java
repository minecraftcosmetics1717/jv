package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.AIBulletProcedure;
import net.mcreator.jujutsucraft.procedures.BulletCursePowerWhileBulletFlyingTickProcedure;
import net.mcreator.jujutsucraft.procedures.BulletDomainHitProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.ReturnEnergyColor2Procedure;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({BulletCursePowerWhileBulletFlyingTickProcedure.class})
public abstract class BulletCursePowerWhileBulletFlyingTickProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediateSourceEntity, CallbackInfo ci) {
      if (entity != null && immediateSourceEntity != null) {
         double yPower = (double)0.0F;
         double zPower = (double)0.0F;
         double oldSkill = (double)0.0F;
         double num = (double)0.0F;
         double xPower = (double)0.0F;
         double xPos = (double)0.0F;
         double yPos = (double)0.0F;
         double zPos = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double oldCooldown = (double)0.0F;
         boolean set_particle = false;
         BulletDomainHitProcedure.execute(world, entity, immediateSourceEntity);
         immediateSourceEntity.getPersistentData().m_128347_("cnt_life", immediateSourceEntity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         set_particle = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet;
         if (immediateSourceEntity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediateSourceEntity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediateSourceEntity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            if (entity.getPersistentData().m_128459_("cnt7") > (double)0.0F) {
               immediateSourceEntity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("cnt7"));
               immediateSourceEntity.getPersistentData().m_128347_("cnt6", (double)1.0F + entity.getPersistentData().m_128459_("cnt7") * 0.03);
            } else {
               immediateSourceEntity.getPersistentData().m_128347_("Damage", (double)13.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
               immediateSourceEntity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            }

            immediateSourceEntity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
            immediateSourceEntity.getPersistentData().m_128347_("old_x", immediateSourceEntity.m_20185_());
            immediateSourceEntity.getPersistentData().m_128347_("old_y", immediateSourceEntity.m_20186_());
            immediateSourceEntity.getPersistentData().m_128347_("old_z", immediateSourceEntity.m_20189_());
         }

         oldSkill = entity.getPersistentData().m_128459_("skill");
         oldCooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("skill", immediateSourceEntity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", immediateSourceEntity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
         xPos = immediateSourceEntity.getPersistentData().m_128459_("old_x");
         yPos = immediateSourceEntity.getPersistentData().m_128459_("old_y");
         zPos = immediateSourceEntity.getPersistentData().m_128459_("old_z");
         xPower = x - xPos;
         yPower = y - yPos;
         zPower = z - zPos;
         distance = Math.sqrt(xPower * xPower + yPower * yPower + zPower * zPower);
         if (distance > (double)1.0F) {
            xPower /= distance;
            yPower /= distance;
            zPower /= distance;
         }

         for(int index = 0; index < (int)Math.round(Math.max(distance * (double)4.0F, (double)1.0F)); ++index) {
            ++num;
            if (num > (double)0.0F) {
               num = (double)-4.0F;
               entity.getPersistentData().m_128347_("Damage", immediateSourceEntity.getPersistentData().m_128459_("Damage"));
               entity.getPersistentData().m_128347_("Range", (double)3.0F);
               if (immediateSourceEntity.getPersistentData().m_128459_("skill") == (double)3606.0F) {
                  entity.getPersistentData().m_128347_("knockback", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("knockback", (double)0.25F);
               }

               RangeAttackProcedure.execute(world, xPos, yPos, zPos, entity);
               AIBulletProcedure.execute();
            }

            if (immediateSourceEntity.getPersistentData().m_128459_("skill") != (double)154.0F && immediateSourceEntity.getPersistentData().m_128459_("skill") != (double)60405.0F) {
               if (immediateSourceEntity.getPersistentData().m_128459_("skill") == (double)3606.0F) {
                  if (Math.random() < 0.1 && world instanceof ServerLevel) {
                     ServerLevel serverLevel = (ServerLevel)world;
                     serverLevel.m_8767_(ParticleTypes.f_123762_, xPos, yPos, zPos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel serverLevel = (ServerLevel)world;
                  if (set_particle) {
                     SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
                     serverLevel.m_8767_(particleType, xPos, yPos, zPos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
                  } else {
                     serverLevel.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), xPos, yPos, zPos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
                  }
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel serverLevel = (ServerLevel)world;
               serverLevel.m_8767_(ParticleTypes.f_123745_, xPos, yPos, zPos, 1, (double)0.25F, (double)0.25F, (double)0.25F, 0.1);
               serverLevel.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), xPos, yPos, zPos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
            }

            xPos += xPower * (double)0.25F;
            yPos += yPower * (double)0.25F;
            zPos += zPower * (double)0.25F;
         }

         immediateSourceEntity.getPersistentData().m_128347_("old_x", x);
         immediateSourceEntity.getPersistentData().m_128347_("old_y", y);
         immediateSourceEntity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("skill", oldSkill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", oldCooldown);
         if (immediateSourceEntity.getPersistentData().m_128459_("cnt_life") > (double)60.0F && !immediateSourceEntity.m_20193_().f_46443_) {
            immediateSourceEntity.m_146870_();
         }

         ci.cancel();
      } else {
         ci.cancel();
      }
   }
}
