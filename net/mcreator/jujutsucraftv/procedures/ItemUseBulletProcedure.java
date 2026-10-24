package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.KnifeEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemUseBulletProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double cooldown = (double)0.0F;
         double cost_a = (double)0.0F;
         double cost = (double)0.0F;
         if (!GetCoolDownProcedure.execute(entity)) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != JujutsucraftvModItems.KNIFE_BAYER.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() != JujutsucraftvModItems.KNIFE_BAYER.get()) {
                  return;
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.0F, false);
               }
            }

            Level projectileLevel = entity.m_9236_();
            if (!projectileLevel.m_5776_()) {
               int var10004;
               label62: {
                  var25 = new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new KnifeEntity((EntityType)JujutsucraftvModEntities.KNIFE.get(), level);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  };
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label62;
                     }
                  }

                  var10004 = 0;
               }

               Projectile _entityToSpawn = ((<undefinedtype>)var25).getArrow(projectileLevel, (float)((double)3.0F * (1.01 + (double)var10004)), 1);
               _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
               _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.0F);
               projectileLevel.m_7967_(_entityToSpawn);
            }

            if (!((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftvModItems.KNIFE_BAYER.get());
               _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_((Item)JujutsucraftvModItems.KNIFE_BAYER.get(), 5);
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time 1 0 true");
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
            }
         }

      }
   }
}
