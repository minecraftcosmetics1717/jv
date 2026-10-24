package net.mcreator.jujutsucraftv.entity;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.procedures.AiCursedSpirit2MainProcedure;
import net.mcreator.jujutsucraftv.procedures.LogicIWaterProcedure;
import net.mcreator.jujutsucraftv.procedures.LogicNotWaterProcedure;
import net.mcreator.jujutsucraftv.procedures.SetTagCursedSpiritProcedure;
import net.mcreator.jujutsucraftv.procedures.SpawnLevel02Procedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackProcedure;
import net.mcreator.jujutsucraftv.procedures.TargetEntityLogicAttackStartProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.MoveControl.Operation;
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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CursedSpiritGrade221Entity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   public static final EntityDataAccessor<String> GLOW_TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public CursedSpiritGrade221Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_221.get(), world);
   }

   public CursedSpiritGrade221Entity(EntityType<CursedSpiritGrade221Entity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.f_21364_ = 40;
      this.m_21557_(false);
      this.m_274367_(0.6F);
      this.m_21441_(BlockPathTypes.WATER, 0.0F);
      this.f_21342_ = new MoveControl(this) {
         public void m_8126_() {
            if (CursedSpiritGrade221Entity.this.m_20069_()) {
               CursedSpiritGrade221Entity.this.m_20256_(CursedSpiritGrade221Entity.this.m_20184_().m_82520_((double)0.0F, 0.005, (double)0.0F));
            }

            if (this.f_24981_ == Operation.MOVE_TO && !CursedSpiritGrade221Entity.this.m_21573_().m_26571_()) {
               double dx = this.f_24975_ - CursedSpiritGrade221Entity.this.m_20185_();
               double dy = this.f_24976_ - CursedSpiritGrade221Entity.this.m_20186_();
               double dz = this.f_24977_ - CursedSpiritGrade221Entity.this.m_20189_();
               float f = (float)(Mth.m_14136_(dz, dx) * (180D / Math.PI)) - 90.0F;
               float f1 = (float)(this.f_24978_ * CursedSpiritGrade221Entity.this.m_21051_(Attributes.f_22279_).m_22135_());
               CursedSpiritGrade221Entity.this.m_146922_(this.m_24991_(CursedSpiritGrade221Entity.this.m_146908_(), f, 10.0F));
               CursedSpiritGrade221Entity.this.f_20883_ = CursedSpiritGrade221Entity.this.m_146908_();
               CursedSpiritGrade221Entity.this.f_20885_ = CursedSpiritGrade221Entity.this.m_146908_();
               if (CursedSpiritGrade221Entity.this.m_20069_()) {
                  CursedSpiritGrade221Entity.this.m_7910_((float)CursedSpiritGrade221Entity.this.m_21051_(Attributes.f_22279_).m_22135_());
                  float f2 = -((float)(Mth.m_14136_(dy, (double)((float)Math.sqrt(dx * dx + dz * dz))) * (180D / Math.PI)));
                  f2 = Mth.m_14036_(Mth.m_14177_(f2), -85.0F, 85.0F);
                  CursedSpiritGrade221Entity.this.m_146926_(this.m_24991_(CursedSpiritGrade221Entity.this.m_146909_(), f2, 5.0F));
                  float f3 = Mth.m_14089_(CursedSpiritGrade221Entity.this.m_146909_() * ((float)Math.PI / 180F));
                  CursedSpiritGrade221Entity.this.m_21564_(f3 * f1);
                  CursedSpiritGrade221Entity.this.m_21567_((float)((double)f1 * dy));
               } else {
                  CursedSpiritGrade221Entity.this.m_7910_(f1 * 0.05F);
               }
            } else {
               CursedSpiritGrade221Entity.this.m_7910_(0.0F);
               CursedSpiritGrade221Entity.this.m_21567_(0.0F);
               CursedSpiritGrade221Entity.this.m_21564_(0.0F);
            }

         }
      };
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "cursedspirit_mermaid");
      this.f_19804_.m_135372_(GLOW_TEXTURE, "");
   }

   public void setTexture(String texture) {
      this.f_19804_.m_135381_(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.f_19804_.m_135370_(TEXTURE);
   }

   public void setGlowTexture(String texture) {
      this.f_19804_.m_135381_(GLOW_TEXTURE, texture == null ? "" : texture.replace(".png", ""));
   }

   public String getGlowTexture() {
      return (String)this.f_19804_.m_135370_(GLOW_TEXTURE);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected PathNavigation m_6037_(Level world) {
      return new WaterBoundPathNavigation(this, world);
   }

   protected void m_8099_() {
      super.m_8099_();
      this.f_21345_.m_25352_(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double m_6639_(LivingEntity entity) {
            return (double)(this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + entity.m_20205_());
         }

         public boolean m_8036_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackProcedure.execute(entity);
         }
      });
      this.f_21346_.m_25352_(2, new HurtByTargetGoal(this, new Class[0]));
      this.f_21346_.m_25352_(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21346_.m_25352_(4, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8036_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }

         public boolean m_8045_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8045_() && TargetEntityLogicAttackStartProcedure.execute(world, entity);
         }
      });
      this.f_21345_.m_25352_(5, new RandomStrollGoal(this, (double)0.5F) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8036_() && LogicNotWaterProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(6, new RandomSwimmingGoal(this, (double)1.0F, 40) {
         public boolean m_8036_() {
            double x = CursedSpiritGrade221Entity.this.m_20185_();
            double y = CursedSpiritGrade221Entity.this.m_20186_();
            double z = CursedSpiritGrade221Entity.this.m_20189_();
            Entity entity = CursedSpiritGrade221Entity.this;
            Level world = CursedSpiritGrade221Entity.this.m_9236_();
            return super.m_8036_() && LogicIWaterProcedure.execute(entity);
         }
      });
      this.f_21345_.m_25352_(7, new RandomLookAroundGoal(this));
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

   public boolean m_6469_(DamageSource source, float amount) {
      return source.m_276093_(DamageTypes.f_268722_) ? false : super.m_6469_(source, amount);
   }

   public SpawnGroupData m_6518_(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
      SpawnGroupData retval = super.m_6518_(world, difficulty, reason, livingdata, tag);
      SetTagCursedSpiritProcedure.execute(this);
      return retval;
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

   }

   public void m_6075_() {
      super.m_6075_();
      AiCursedSpirit2MainProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      this.m_6210_();
   }

   public EntityDimensions m_6972_(Pose p_33597_) {
      return super.m_6972_(p_33597_).m_20388_(1.0F);
   }

   public boolean m_6040_() {
      return true;
   }

   public boolean m_6914_(LevelReader world) {
      return world.m_45784_(this);
   }

   public boolean m_6063_() {
      return false;
   }

   public static void init() {
      SpawnPlacements.m_21754_((EntityType)JujutsucraftvModEntities.CURSED_SPIRIT_GRADE_221.get(), Type.IN_WATER, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
         int x = pos.m_123341_();
         int y = pos.m_123342_();
         int z = pos.m_123343_();
         return SpawnLevel02Procedure.execute(world);
      });
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, (double)130.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)2.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)6.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)48.0F);
      builder = builder.m_22268_((Attribute)ForgeMod.SWIM_SPEED.get(), 0.3);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.m_5912_()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
      } else if (this.m_21224_()) {
         return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
      } else if (this.m_20072_()) {
         return event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
      } else {
         return this.m_5912_() && event.isMoving() ? event.setAndContinue(RawAnimation.begin().thenLoop("sprint")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
      }
   }

   private PlayState attackingPredicate(AnimationState event) {
      double d1 = this.m_20185_() - this.f_19790_;
      double d0 = this.m_20189_() - this.f_19792_;
      float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
      if (this.m_21324_(event.getPartialTick()) > 0.0F && !this.swinging) {
         this.swinging = true;
         this.lastSwing = this.m_9236_().m_46467_();
      }

      if (this.swinging && this.lastSwing + 7L <= this.m_9236_().m_46467_()) {
         this.swinging = false;
      }

      if (this.swinging && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("punch_right"));
      } else {
         return PlayState.CONTINUE;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED || !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      } else if (this.animationprocedure.equals("empty")) {
         this.prevAnim = "empty";
         return PlayState.STOP;
      }

      this.prevAnim = this.animationprocedure;
      return PlayState.CONTINUE;
   }

   protected void m_6153_() {
      ++this.f_20919_;
      if (this.f_20919_ == 20) {
         this.m_142687_(RemovalReason.KILLED);
         this.m_21226_();
      }

   }

   public String getSyncedAnimation() {
      return (String)this.f_19804_.m_135370_(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.f_19804_.m_135381_(ANIMATION, animation);
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 1, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 1, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.m_135353_(CursedSpiritGrade221Entity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(CursedSpiritGrade221Entity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(CursedSpiritGrade221Entity.class, EntityDataSerializers.f_135030_);
      GLOW_TEXTURE = SynchedEntityData.m_135353_(CursedSpiritGrade221Entity.class, EntityDataSerializers.f_135030_);
   }
}
