package net.mcreator.jujutsucraftv.entity;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.procedures.PlojectileBattierTickProcedure;
import net.mcreator.jujutsucraftv.procedures.SetEntitySizeProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
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

public class PlojectileBarrier0Entity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   public static final EntityDataAccessor<Integer> DATA_tex;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public PlojectileBarrier0Entity(PlayMessages.SpawnEntity packet, Level world) {
      this((EntityType)JujutsucraftvModEntities.PLOJECTILE_BARRIER_0.get(), world);
   }

   public PlojectileBarrier0Entity(EntityType<PlojectileBarrier0Entity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.f_21364_ = 0;
      this.m_21557_(false);
      this.m_274367_(0.6F);
      this.m_21530_();
   }

   protected void m_8097_() {
      super.m_8097_();
      this.f_19804_.m_135372_(SHOOT, false);
      this.f_19804_.m_135372_(ANIMATION, "undefined");
      this.f_19804_.m_135372_(TEXTURE, "plojectile_barrier_base");
      this.f_19804_.m_135372_(DATA_tex, 0);
   }

   public void setTexture(String texture) {
      this.f_19804_.m_135381_(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.f_19804_.m_135370_(TEXTURE);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void m_8099_() {
      super.m_8099_();
   }

   public MobType m_6336_() {
      return MobType.f_21640_;
   }

   public boolean m_6785_(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent m_7975_(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent m_5592_() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean m_6469_(DamageSource source, float amount) {
      if (source.m_276093_(DamageTypes.f_268631_)) {
         return false;
      } else if (source.m_7640_() instanceof AbstractArrow) {
         return false;
      } else if (source.m_7640_() instanceof Player) {
         return false;
      } else if (!(source.m_7640_() instanceof ThrownPotion) && !(source.m_7640_() instanceof AreaEffectCloud)) {
         if (source.m_276093_(DamageTypes.f_268671_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268585_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268722_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268450_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268565_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268714_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268526_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268482_)) {
            return false;
         } else if (source.m_276093_(DamageTypes.f_268493_)) {
            return false;
         } else {
            return source.m_276093_(DamageTypes.f_268641_) ? false : super.m_6469_(source, amount);
         }
      } else {
         return false;
      }
   }

   public void m_7380_(CompoundTag compound) {
      super.m_7380_(compound);
      compound.m_128359_("Texture", this.getTexture());
      compound.m_128405_("Datatex", (Integer)this.f_19804_.m_135370_(DATA_tex));
   }

   public void m_7378_(CompoundTag compound) {
      super.m_7378_(compound);
      if (compound.m_128441_("Texture")) {
         this.setTexture(compound.m_128461_("Texture"));
      }

      if (compound.m_128441_("Datatex")) {
         this.f_19804_.m_135381_(DATA_tex, compound.m_128451_("Datatex"));
      }

   }

   public void m_6075_() {
      super.m_6075_();
      PlojectileBattierTickProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this);
      this.m_6210_();
   }

   public EntityDimensions m_6972_(Pose p_33597_) {
      Level world = this.m_9236_();
      double x = this.m_20185_();
      double y = ((Entity)this).m_20186_();
      double z = ((Entity)this).m_20189_();
      return super.m_6972_(p_33597_).m_20388_((float)SetEntitySizeProcedure.execute(this));
   }

   public boolean m_6094_() {
      return false;
   }

   protected void m_7324_(Entity entityIn) {
   }

   protected void m_6138_() {
   }

   public static void init() {
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.m_21552_();
      builder = builder.m_22268_(Attributes.f_22279_, 0.3);
      builder = builder.m_22268_(Attributes.f_22276_, (double)50.0F);
      builder = builder.m_22268_(Attributes.f_22284_, (double)0.0F);
      builder = builder.m_22268_(Attributes.f_22281_, (double)3.0F);
      builder = builder.m_22268_(Attributes.f_22277_, (double)16.0F);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("idle")) : PlayState.STOP;
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
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 1, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.m_135353_(PlojectileBarrier0Entity.class, EntityDataSerializers.f_135035_);
      ANIMATION = SynchedEntityData.m_135353_(PlojectileBarrier0Entity.class, EntityDataSerializers.f_135030_);
      TEXTURE = SynchedEntityData.m_135353_(PlojectileBarrier0Entity.class, EntityDataSerializers.f_135030_);
      DATA_tex = SynchedEntityData.m_135353_(PlojectileBarrier0Entity.class, EntityDataSerializers.f_135028_);
   }
}
