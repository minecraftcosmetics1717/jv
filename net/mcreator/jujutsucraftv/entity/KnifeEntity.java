package net.mcreator.jujutsucraftv.entity;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.procedures.PlojectileBulletShootTickProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class KnifeEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;
   private int aliveTickInGround = 0;

   public KnifeEntity(PlayMessages.SpawnEntity packet, Level world) {
      super((EntityType)JujutsucraftvModEntities.KNIFE.get(), world);
   }

   public KnifeEntity(EntityType<? extends KnifeEntity> type, Level world) {
      super(type, world);
   }

   public KnifeEntity(EntityType<? extends KnifeEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public KnifeEntity(EntityType<? extends KnifeEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack m_7846_() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack m_7941_() {
      return PROJECTILE_ITEM;
   }

   protected void m_7761_(LivingEntity entity) {
      super.m_7761_(entity);
      entity.m_21317_(entity.m_21234_() - 1);
   }

   public void m_8119_() {
      super.m_8119_();
      PlojectileBulletShootTickProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_19749_(), this);
      if (this.f_36703_) {
         ++this.aliveTickInGround;
         if (this.aliveTickInGround > 100) {
            this.m_146870_();
         }
      }

   }

   public static KnifeEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 2.0F, (double)5.0F, 2);
   }

   public static KnifeEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 2.0F, (double)5.0F, 2);
   }

   public static KnifeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      KnifeEntity entityarrow = new KnifeEntity((EntityType)JujutsucraftvModEntities.KNIFE.get(), entity, world);
      entityarrow.m_6686_(entity.m_20252_(1.0F).f_82479_, entity.m_20252_(1.0F).f_82480_, entity.m_20252_(1.0F).f_82481_, power * 2.0F, 0.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36762_(true);
      entityarrow.m_36781_(damage);
      entityarrow.m_36735_(knockback);
      entityarrow.m_20254_(100);
      world.m_7967_(entityarrow);
      world.m_6263_((Player)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1.0F, 1.0F / (random.m_188501_() * 0.5F + 1.0F) + power / 2.0F);
      return entityarrow;
   }

   public static KnifeEntity shoot(LivingEntity entity, LivingEntity target) {
      KnifeEntity entityarrow = new KnifeEntity((EntityType)JujutsucraftvModEntities.KNIFE.get(), entity, entity.m_9236_());
      double dx = target.m_20185_() - entity.m_20185_();
      double dy = target.m_20186_() + (double)target.m_20192_() - 1.1;
      double dz = target.m_20189_() - entity.m_20189_();
      entityarrow.m_6686_(dx, dy - entityarrow.m_20186_() + Math.hypot(dx, dz) * (double)0.2F, dz, 4.0F, 12.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36781_((double)5.0F);
      entityarrow.m_36735_(2);
      entityarrow.m_36762_(true);
      entityarrow.m_20254_(100);
      entity.m_9236_().m_7967_(entityarrow);
      entity.m_9236_().m_6263_((Player)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1.0F, 1.0F / (RandomSource.m_216327_().m_188501_() * 0.5F + 1.0F));
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)JujutsucraftvModItems.KNIFE_BAYER.get());
   }
}
