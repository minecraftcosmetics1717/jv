package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ReleaseSummonEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double amount = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 100, false, false));
            }
         }

         Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)500.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof LivingEntity && (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") || entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F) && !(entityiterator instanceof Player) && entityiterator.getPersistentData().m_128471_("Summon") && entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_sand.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_sand.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123783_, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
            }
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
