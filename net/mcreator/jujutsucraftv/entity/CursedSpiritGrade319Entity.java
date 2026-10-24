package net.mcreator.jujutsucraftv.entity;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.procedures.AiCursedSpirit3MainProcedure;
import net.mcreator.jujutsucraftv.procedures.LogicIWaterProcedure;
import net.mcreator.jujutsucraftv.procedures.LogicNotWaterProcedure;
import net.mcreator.jujutsucraftv.procedures.SetTagCursedSpiritProcedure;
import net.mcreator.jujutsucraftv.procedures.SpawnLevel01Procedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackProcedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackStartProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.MoveControl.Operation;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritGrade319Entity extends Monster {
   public CursedSpiritGrade319Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_319.get(), world);
   }

   public CursedSpiritGrade319Entity(EntityType<CursedSpiritGrade319Entity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 30;
      this.m_21557_(false);
      this.m_21441_(BlockPathTypes.WATER, 0.0F);
      this.f_21342_ = new MoveControl(this) {
         public void m_8126_() {
            if (CursedSpiritGrade319Entity.this.m_20069_()) {
               CursedSpiritGrade319Entity.this.m_20256_(CursedSpiritGrade319Entity.this.m_20184_().m_82520_((double)0.0F, 0.005, (double)0.0F));
            }

            if (this.f_24981_ == Operation.MOVE_TO && !CursedSpiritGrade319Entity.this.m_21573_().m_26571_()) {
               double dx = this.f_24975_ - CursedSpiritGrade319Entity.this.m_20185_();
               double dy = this.f_24976_ - CursedSpiritGrade319Entity.this.m_20186_();
               double dz = this.f_24977_ - CursedSpiritGrade319Entity.this.m_20189_();
               float f = (float)(Mth.m_14136_(dz, dx) * (180D / Math.PI)) - 90.0F;
               float f1 = (float)(this.f_24978_ * CursedSpiritGrade319Entity.this.m_21051_(Attributes.f_22279_).m_22135_());
               CursedSpiritGrade319Entity.this.m_146922_(this.m_24991_(CursedSpiritGrade319Entity.this.m_146908_(), f, 10.0F));
               CursedSpiritGrade319Entity.this.f_20883_ = CursedSpiritGrade319Entity.this.m_146908_();
               CursedSpiritGrade319Entity.this.f_20885_ = CursedSpiritGrade319Entity.this.m_146908_();
               if (CursedSpiritGrade319Entity.this.m_20069_()) {
                  CursedSpiritGrade319Entity.this.m_7910_((float)CursedSpiritGrade319Entity.this.m_21051_(Attributes.f_22279_).m_22135_());
                  float f2 = -((float)(Mth.m_14136_(dy, (double)((float)Math.sqrt(dx * dx + dz * dz))) * (180D / Math.PI)));
                  f2 = Mth.m_14036_(Mth.m_14177_(f2), -85.0F, 85.0F);
                  CursedSpiritGrade319Entity.this.m_146926_(this.m_24991_(CursedSpiritGrade319Entity.this.m_146909_(), f2, 5.0F));
                  float f3 = Mth.m_14089_(CursedSpiritGrade319Entity.this.m_146909_() * ((float)Math.PI / 180F));
                  CursedSpiritGrade319Entity.this.m_21564_(f3 * f1);
                  CursedSpiritGrade319Entity.this.m_21567_((float)((double)f1 * dy));
               } else {
                  CursedSpiritGrade319Entity.this.m_7910_(f1 * 0.05F);
               }
            } else {
               CursedSpiritGrade319Entity.this.m_7910_(0.0F);
               CursedSpiritGrade319Entity.this.m_21567_(0.0F);
               CursedSpiritGrade319Entity.this.m_21564_(0.0F);
            }

         }
      };
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation m_6037_(Level world) {
      return new WaterBoundPathNavigation(this, world);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, (double)1.5F, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)9.0F;
         }

         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(2, new MeleeAttackGoal(this, (double)1.5F, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)(this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_());
         }

         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(3, new LeapAtTargetGoal(this, 0.5F) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && LogicNotWaterProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && LogicNotWaterProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(4, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(5, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(6, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(7, new RandomSwimmingGoal(this, 1.6, 40) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && LogicIWaterProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && LogicIWaterProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(8, new RandomStrollGoal(this, (double)1.0F) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && LogicNotWaterProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && LogicNotWaterProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(9, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(10, new FloatGoal(this) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8036_() && LogicNotWaterProcedure.execute(entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade319Entity.this.m_20185_();
            double y = CursedSpiritGrade319Entity.this.m_20186_();
            double z = CursedSpiritGrade319Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade319Entity.this;
            Level world = CursedSpiritGrade319Entity.this.m_9236_();
            return super.m_8045_() && LogicNotWaterProcedure.execute(entity);
         }
      });
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

   public boolean m_6914_(LevelReader world) {
      return world.m_45784_(this);
   }

   public boolean m_6040_() {
      double x = this.m_20185_();
      double y = this.m_20186_();
      double z = this.m_20189_();
      Level world = this.m_9236_();
      return true;
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_319.get(), Type.IN_WATER, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.m_123341_();
         int y = pos.m_123342_();
         int z = pos.m_123343_();
         return SpawnLevel01Procedure.execute();
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, (double)0.5F);
      builder = builder.m_22268_(Attributes.f_22276_, (double)70.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)10.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)10.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)24.0F);
      builder = builder.m_22268_((Attribute)ForgeMod.SWIM_SPEED.get(), (double)0.5F);
      return builder;
   }
}
