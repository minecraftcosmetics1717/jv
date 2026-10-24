package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.entity.EntitySpineEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEntitySpineProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double CNT6 = (double)0.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F && entity.getPersistentData().m_128459_("entity_use") != (double)1.0F && entity.getPersistentData().m_128459_("shift") != (double)3.0F) {
            entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            if (entity instanceof EntitySpineEntity) {
               EntitySpineEntity animatable = (EntitySpineEntity)entity;
               animatable.setTexture("whack_a_mole_domain");
            }

            if (entity instanceof EntitySpineEntity) {
               ((EntitySpineEntity)entity).setAnimation("attack");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.donkey.eat")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F));
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.donkey.eat")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F), false);
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_();
            x_power = (double)0.0F;
            y_power = (double)1.0F;
            z_power = (double)0.0F;
            entity.getPersistentData().m_128347_("effect", (double)1.0F);
            if (entity.getPersistentData().m_128459_("shift") == (double)3.0F) {
               entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F);
               entity.getPersistentData().m_128347_("BlockRange", (double)5.0F);
               entity.getPersistentData().m_128347_("Range", (double)6.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("Damage", ((double)23.0F + entity.getPersistentData().m_128459_("dis")) * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
            } else {
               entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F);
               entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
               entity.getPersistentData().m_128347_("Range", (double)3.0F);
               entity.getPersistentData().m_128347_("knockback", 0.01);
               if (entity.getPersistentData().m_128459_("shift") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("Damage", (double)8.0F);
               } else {
                  entity.getPersistentData().m_128347_("Damage", (double)16.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
               }

               if (entity.getPersistentData().m_128459_("entity_use") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F);
               }
            }

            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            BlockDestroyAllDirectionVProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            double var10000 = x_pos + x_power;
            var10000 = y_pos + y_power;
            var10000 = z_pos + z_power;
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)35.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
