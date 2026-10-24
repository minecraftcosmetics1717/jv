package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables.MapVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionCreateBarrierProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DaburaDomainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double num2 = (double)0.0F;
         double dis = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         dis = MapVariables.get(world).DomainExpansionRadius;
         entity.getPersistentData().m_128347_("select", (double)630.0F);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)33.0F && entity.getPersistentData().m_128459_("cnt1") == (double)34.0F) {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            entity.m_146922_(entity.m_146908_());
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

            x_pos = (double)(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis - (double)8.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
            y_pos = (double)(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis - (double)8.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
            z_pos = (double)(entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() - entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis - (double)8.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
            x_pos = entity.getPersistentData().m_128459_("x_pos_doma") + x_pos;
            y_pos = entity.getPersistentData().m_128459_("y_pos_doma") + y_pos;
            z_pos = entity.getPersistentData().m_128459_("z_pos_doma") + z_pos;
            SetPosBackProcedure.execute(entity, (double)2.5F);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.DOMAIN_OBJECT_DABURA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  if (entityinstance instanceof TamableAnimal) {
                     TamableAnimal _toTame = (TamableAnimal)entityinstance;
                     if (entity instanceof Player) {
                        Player _owner = (Player)entity;
                        _toTame.m_21828_(_owner);
                     }
                  }

                  ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(1.2);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(0.0F);
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.m_20331_(true);
                  if (entityinstance instanceof Mob) {
                     Mob _mob18 = (Mob)entityinstance;
                     _mob18.m_21557_(true);
                  }

                  entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            yaw += Math.toRadians((double)60.0F);

            for(int index0 = 0; index0 < 5; ++index0) {
               x_pos = entity.getPersistentData().m_128459_("x_pos_doma") - Math.cos(yaw) * Math.cos(pitch) * (dis - (double)6.0F);
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma") + (double)entity.m_20206_() * (double)0.75F - Math.sin(pitch) * (double)-1.0F * (dis - (double)6.0F);
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma") - Math.sin(yaw) * Math.cos(pitch) * (dis - (double)6.0F);

               for(int index1 = 0; index1 < 100; ++index1) {
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     ++y_pos;
                  } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                     --y_pos;
                  } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                     y_pos = Math.floor(y_pos);
                     break;
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.DOMAIN_OBJECT_DABURA_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma") + (double)1.0F, entity.getPersistentData().m_128459_("z_pos_doma")));
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                     entityinstance.m_20331_(true);
                     if (entityinstance instanceof Mob) {
                        Mob _mob40 = (Mob)entityinstance;
                        _mob40.m_21557_(true);
                     }

                     entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               yaw += Math.toRadians((double)60.0F);
            }
         }

      }
   }
}
