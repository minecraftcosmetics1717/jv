package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class JjcvGetoGetEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity instanceof Player player) {
         if (arguments != null) {
            if (world instanceof ServerLevel) {
               ServerLevel sourceLevel = (ServerLevel)world;

               EntityType<?> entityType;
               double num;
               try {
                  entityType = (EntityType)ResourceArgument.m_246781_(arguments, "entity_type", Registries.f_256939_).m_203334_();
                  num = DoubleArgumentType.getDouble(arguments, "num");
               } catch (Exception var31) {
                  return;
               }

               if (entityType != null && !(num < (double)1.0F)) {
                  ServerLevel storageLevel = sourceLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                  if (storageLevel == null) {
                     return;
                  }

                  int amount = (int)Math.floor(num);
                  if (amount < 1) {
                     return;
                  }

                  double friendNum = player.getPersistentData().m_128459_("friend_num");
                  if (friendNum == (double)0.0F) {
                     friendNum = Math.random();
                     player.getPersistentData().m_128347_("friend_num", friendNum);
                  }

                  String storageKey = "";
                  String entityName = "";
                  double storageY = (double)0.0F;
                  int successfulCount = 0;

                  for(int i = 0; i < amount; ++i) {
                     Entity createdEntity = entityType.m_20615_(storageLevel);
                     if (createdEntity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity)createdEntity;
                        if (livingEntity instanceof Mob) {
                           Mob mob = (Mob)livingEntity;
                           mob.m_6518_(storageLevel, storageLevel.m_6436_(BlockPos.m_274561_((double)0.0F, (double)64.0F, (double)0.0F)), MobSpawnType.COMMAND, (SpawnGroupData)null, (CompoundTag)null);
                        }

                        if (storageKey.isEmpty()) {
                           entityName = livingEntity.m_7755_().getString();
                           if (entityName.isEmpty()) {
                              entityName = "No Name";
                           }

                           storageY = (double)64.0F + Math.random() * (double)64.0F;

                           for(int index = 1; index <= 10000; ++index) {
                              String checkedKey = "data_cursed_spirit_manipulation" + index;
                              double savedY = player.getPersistentData().m_128459_(checkedKey);
                              String savedName = player.getPersistentData().m_128461_(checkedKey + "_name");
                              if (savedY == (double)0.0F) {
                                 storageKey = checkedKey;
                                 break;
                              }

                              if (savedName.equals(entityName)) {
                                 storageKey = checkedKey;
                                 storageY = savedY;
                                 break;
                              }
                           }

                           if (storageKey.isEmpty()) {
                              livingEntity.m_146870_();
                              break;
                           }

                           player.getPersistentData().m_128347_(storageKey, storageY);
                           player.getPersistentData().m_128359_(storageKey + "_name", entityName);
                        }

                        livingEntity.getPersistentData().m_128359_("owner_name_data", player.m_7755_().getString());
                        livingEntity.getPersistentData().m_128359_("OWNER_UUID", player.m_20149_());
                        livingEntity.getPersistentData().m_128347_("friend_num", friendNum);
                        livingEntity.getPersistentData().m_128347_("friend_num_worker", friendNum);
                        livingEntity.m_20331_(true);
                        if (livingEntity instanceof Mob) {
                           Mob mob = (Mob)livingEntity;
                           mob.m_21530_();
                           mob.m_21557_(true);
                        }

                        livingEntity.m_7678_((double)0.0F, storageY, (double)0.0F, livingEntity.m_146908_(), livingEntity.m_146909_());
                        if (storageLevel.m_7967_(livingEntity)) {
                           ++successfulCount;
                        } else {
                           livingEntity.m_146870_();
                        }
                     } else if (createdEntity != null) {
                        createdEntity.m_146870_();
                     }
                  }

                  if (successfulCount > 0 && !storageKey.isEmpty()) {
                     Vec3 center = new Vec3((double)0.0F, storageY, (double)0.0F);
                     int storedEntityCount = storageLevel.m_6443_(Entity.class, (new AABB(center, center)).m_82400_((double)0.5F), (target) -> target.m_6084_() && target.m_7755_().getString().equals(entityName) && target.getPersistentData().m_128459_("friend_num_worker") == friendNum).size();
                     player.getPersistentData().m_128347_(storageKey + "_num", (double)storedEntityCount);
                     sourceLevel.m_5594_((Player)null, player.m_20183_(), SoundEvents.f_12321_, SoundSource.NEUTRAL, 1.0F, 0.5F);
                     return;
                  }

                  return;
               }

               return;
            }

            return;
         }
      }

   }
}
