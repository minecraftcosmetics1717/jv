package net.mcreator.jujutsucraftv.entity;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.procedures.AiCursedSpirit3MainProcedure;
import net.mcreator.jujutsucraftv.procedures.SetTagCursedSpiritProcedure;
import net.mcreator.jujutsucraftv.procedures.SpawnLevel01Procedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackProcedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackStartProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritGrade321Entity extends Monster {
   public CursedSpiritGrade321Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_321.get(), world);
   }

   public CursedSpiritGrade321Entity(EntityType<CursedSpiritGrade321Entity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_6210_();
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, 1.3, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)(this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_());
         }

         public boolean m_8036_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(2, new LeapAtTargetGoal(this, 0.5F) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(3, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(5, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade321Entity.this.m_20185_();
            double y = CursedSpiritGrade321Entity.this.m_20186_();
            double z = CursedSpiritGrade321Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade321Entity.this;
            Level world = CursedSpiritGrade321Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(6, new RandomStrollGoal(this, 1.2));
      this.f_21345_.m_25352_(7, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(8, new FloatGoal(this));
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagCursedSpiritProcedure.execute(this);
      return retval;
   }

   public void m_6075_() {
      super.m_6075_();
      AiCursedSpirit3MainProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
   }

   public EntityDimensions m_6972_(Pose pose) {
      return super.m_6972_(pose).m_20388_(1.5F);
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_321.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.m_123341_();
         int y = pos.m_123342_();
         int z = pos.m_123343_();
         return SpawnLevel01Procedure.execute();
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, (double)30.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)0.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)4.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)24.0F);
      return builder;
   }
}
