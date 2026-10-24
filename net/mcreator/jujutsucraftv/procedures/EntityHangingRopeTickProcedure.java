package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.entity.EntityHangingRopeEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityHangingRopeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cntx", entity.getPersistentData().m_128459_("cntx") + (double)1.0F);
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator != entity && entity instanceof LivingEntity && !(entity instanceof ItemEntity) && entityiterator.m_20149_().equals(entity.getPersistentData().m_128461_("TARGET_UUID")) && !(entityiterator instanceof EntityHangingRopeEntity) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
               entity.m_146922_(entityiterator.m_146908_());
               entity.m_146926_(0.0F);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entityiterator.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entityiterator.m_146908_(), entityiterator.m_146909_());
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get(), 60, 1, false, false, true));
                  }
               }

               ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(Math.sqrt((double)(entityiterator.m_20205_() + entityiterator.m_20206_()) / 2.4));
               if (entity.getPersistentData().m_128459_("cntx") == (double)10.0F) {
                  entity.getPersistentData().m_128347_("Damage", (double)14.0F);
                  entity.getPersistentData().m_128347_("Range", (double)1.0F);
                  RangeAttackVProcedure.execute(world, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), entity);
                  ((LivingEntity)entityiterator).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-49.0F);
                  PlayAnimationProcedure.execute(world, entityiterator);
                  entity.getPersistentData().m_128347_("cntx", (double)0.0F);
               }

               entityiterator.f_19789_ = 0.0F;
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            entity.m_6021_(entity.m_20185_(), entity.m_20186_() + (double)1.0F + ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22115_(), entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + (double)1.0F + ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22115_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)100.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21223_();
         } else {
            var10000 = -1.0F;
         }

         if (var10000 <= 0.0F) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x, y, z, 15, (double)0.0F, (double)0.0F, (double)0.0F, 0.1);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt41 = (LivingEntity)entity;
            if (_livEnt41.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
               return;
            }
         }

         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
