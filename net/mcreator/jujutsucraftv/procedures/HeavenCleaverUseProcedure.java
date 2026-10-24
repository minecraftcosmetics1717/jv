package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HeavenCleaverUseProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double old_skill = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            if (_plrCldCheck1.m_36335_().m_41519_(itemstack.m_41720_())) {
               return;
            }
         }

         Item var10000 = itemstack.m_41720_();
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.m_21205_();
         } else {
            var10001 = ItemStack.f_41583_;
         }

         if (var10000 == var10001.m_41720_()) {
            if (!(entity instanceof Player)) {
               LivingEntity var49;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               if (var49 instanceof LivingEntity) {
                  EntityAnchorArgument.Anchor var51 = Anchor.EYES;
                  Vec3 var10002 = new Vec3;
                  LivingEntity var10004;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10004 = _mobEnt.m_5448_();
                  } else {
                     var10004 = null;
                  }

                  double var54 = ((Entity)var10004).m_20185_();
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  double var55 = ((Entity)var10005).m_20186_();
                  LivingEntity var10006;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10006 = _mobEnt.m_5448_();
                  } else {
                     var10006 = null;
                  }

                  var55 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10006 = _mobEnt.m_5448_();
                  } else {
                     var10006 = null;
                  }

                  var10002.<init>(var54, var55, ((Entity)var10006).m_20189_());
                  entity.m_7618_(var51, var10002);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            damage = entity.getPersistentData().m_128459_("cnt6");
            HP = (double)40.0F;
            float var50 = entity.m_146908_();
            Item var52 = itemstack.m_41720_();
            ItemStack var53;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var53 = _livEnt.m_21205_();
            } else {
               var53 = ItemStack.f_41583_;
            }

            yaw = Math.toRadians((double)(var50 + (float)(var52 == var53.m_41720_() ? 180 : 0)));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)0.0F;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)0.0F;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)0.0F;
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.2F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)((double)1.0F * CNT6), 1.2F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_WEAPON.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     ItemStack _setstack = itemstack.m_41777_();
                     _setstack.m_41764_(itemstack.m_41613_());
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity37 = (LivingEntity)entityinstance;
                     if (_livingEntity37.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity37.m_21051_(Attributes.f_22276_).m_22100_((double)0.0F);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") * (double)1.0F);
                  entityinstance.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.getPersistentData().m_128359_("particle", ReturnEnergyColor3Procedure.execute(entity));
                  entityinstance.getPersistentData().m_128359_("AXE_UUID", entity.m_20149_());
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)-5.0F);
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_2"))).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
            PlayAnimationProcedure.execute(world, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

      }
   }
}
