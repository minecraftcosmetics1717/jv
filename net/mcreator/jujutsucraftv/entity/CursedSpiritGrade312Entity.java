package net.mcreator.jujutsucraftv.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.procedures.AiCursedSpirit3MainProcedure;
import net.mcreator.jujutsucraftv.procedures.SetTagCursedSpiritProcedure;
import net.mcreator.jujutsucraftv.procedures.SpawnLevel01Procedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackStartProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritGrade312Entity extends Monster {
   public CursedSpiritGrade312Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_312.get(), world);
   }

   public CursedSpiritGrade312Entity(EntityType<CursedSpiritGrade312Entity> type, Level world) {
      super(type, world);
      this.m_274367_(0.6F);
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.f_21342_ = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation m_6037_(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new Goal() {
         {
            this.m_7021_(EnumSet.of(Flag.MOVE));
         }

         public boolean m_8036_() {
            if (CursedSpiritGrade312Entity.this.m_5448_() != null && !CursedSpiritGrade312Entity.this.m_21566_().m_24995_()) {
               double x = CursedSpiritGrade312Entity.this.m_20185_();
               double y = CursedSpiritGrade312Entity.this.m_20186_();
               double z = CursedSpiritGrade312Entity.this.m_20189_();
               Entity entity = CursedSpiritGrade312Entity.this;
               Level world = CursedSpiritGrade312Entity.this.m_9236_();
               return TargetEntityLogicAttackStartProcedure.execute(world, entity);
            } else {
               return false;
            }
         }

         public boolean m_8045_() {
            return CursedSpiritGrade312Entity.this.m_21566_().m_24995_() && CursedSpiritGrade312Entity.this.m_5448_() != null && CursedSpiritGrade312Entity.this.m_5448_().m_6084_();
         }

         public void m_8056_() {
            LivingEntity livingentity = CursedSpiritGrade312Entity.this.m_5448_();
            Vec3 vec3d = livingentity.m_20299_(1.0F);
            CursedSpiritGrade312Entity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.2);
         }

         public void m_8037_() {
            LivingEntity livingentity = CursedSpiritGrade312Entity.this.m_5448_();
            if (CursedSpiritGrade312Entity.this.m_20191_().m_82381_(livingentity.m_20191_())) {
               CursedSpiritGrade312Entity.this.m_7327_(livingentity);
            } else {
               double d0 = CursedSpiritGrade312Entity.this.m_20280_(livingentity);
               if (d0 < (double)24.0F) {
                  Vec3 vec3d = livingentity.m_20299_(1.0F);
                  CursedSpiritGrade312Entity.this.f_21342_.m_6849_(vec3d.f_82479_, vec3d.f_82480_, vec3d.f_82481_, 1.2);
               }
            }

         }
      });
      this.f_21346_.m_25352_(2, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade312Entity.this.m_20185_();
            double y = CursedSpiritGrade312Entity.this.m_20186_();
            double z = CursedSpiritGrade312Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade312Entity.this;
            Level world = CursedSpiritGrade312Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade312Entity.this.m_20185_();
            double y = CursedSpiritGrade312Entity.this.m_20186_();
            double z = CursedSpiritGrade312Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade312Entity.this;
            Level world = CursedSpiritGrade312Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade312Entity.this.m_20185_();
            double y = CursedSpiritGrade312Entity.this.m_20186_();
            double z = CursedSpiritGrade312Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade312Entity.this;
            Level world = CursedSpiritGrade312Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade312Entity.this.m_20185_();
            double y = CursedSpiritGrade312Entity.this.m_20186_();
            double z = CursedSpiritGrade312Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade312Entity.this;
            Level world = CursedSpiritGrade312Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(5, new RandomStrollGoal(this, 1.2, 20) {
         protected Vec3 m_7037_() {
            RandomSource random = CursedSpiritGrade312Entity.this.m_217043_();
            double dir_x = CursedSpiritGrade312Entity.this.m_20185_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            double dir_y = CursedSpiritGrade312Entity.this.m_20186_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            double dir_z = CursedSpiritGrade312Entity.this.m_20189_() + (double)((random.m_188501_() * 2.0F - 1.0F) * 16.0F);
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.f_21345_.m_25352_(6, new RandomLookAroundGoal(this));
      this.f_21345_.m_25352_(7, new FloatGoal(this));
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

   public boolean m_142535_(float l, float d, DamageSource source) {
      return false;
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

   protected void m_7840_(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void m_20242_(boolean ignored) {
      super.m_20242_(true);
   }

   public void m_8107_() {
      super.m_8107_();
      this.m_20242_(true);
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_312.get(), Type.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.m_123341_();
         int y = pos.m_123342_();
         int z = pos.m_123343_();
         return SpawnLevel01Procedure.execute();
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, (double)20.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)0.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)2.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)24.0F);
      builder = builder.m_22268_(Attributes.f_22280_, 0.3);
      return builder;
   }
}
