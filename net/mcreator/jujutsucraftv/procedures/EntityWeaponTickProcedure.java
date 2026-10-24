package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.GetWeaponSizeProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityWeaponTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double weaponsize = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double speed = (double)0.0F;
         double dis = (double)0.0F;
         double dx = (double)0.0F;
         double dy = (double)0.0F;
         double dz = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double smooth = (double)0.0F;
         double target_x = (double)0.0F;
         double target_y = (double)0.0F;
         double target_z = (double)0.0F;
         double new_x = (double)0.0F;
         double new_z = (double)0.0F;
         double new_y = (double)0.0F;
         double z_pos = (double)0.0F;
         double old_z = (double)0.0F;
         double old_x = (double)0.0F;
         double old_y = (double)0.0F;
         double getX = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double getY = (double)0.0F;
         double getZ = (double)0.0F;
         boolean hit_wall = false;
         boolean isback = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (entity.getPersistentData().m_128459_("cnt3") > (double)30.0F ? -0.0075 : 0.0075));
         weaponsize = GetWeaponSizeProcedure.execute(entity);
         double var10000 = entity.getPersistentData().m_128459_("cnt1");
         ItemStack var10003;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10003 = _livEnt.m_21205_();
         } else {
            var10003 = ItemStack.f_41583_;
         }

         if (var10000 % (double)Math.round((double)4.0F + (weaponsize + var10003.m_41784_().m_128459_("Power")) * 0.6) == (double)0.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  BlockPos var10002 = BlockPos.m_274561_(x, y, z);
                  SoundEvent var144 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                  SoundSource var10004 = SoundSource.NEUTRAL;
                  ItemStack var10008;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10008 = _livEnt.m_21205_();
                  } else {
                     var10008 = ItemStack.f_41583_;
                  }

                  _level.m_5594_((Player)null, var10002, var144, var10004, 3.0F, (float)(0.9 / (weaponsize + var10008.m_41784_().m_128459_("Power"))));
               } else {
                  SoundEvent var146 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                  SoundSource var10005 = SoundSource.NEUTRAL;
                  ItemStack var10009;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10009 = _livEnt.m_21205_();
                  } else {
                     var10009 = ItemStack.f_41583_;
                  }

                  _level.m_7785_(x, y, z, var146, var10005, 3.0F, (float)(0.9 / (weaponsize + var10009.m_41784_().m_128459_("Power"))), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         }

         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         entity.f_19789_ = 0.0F;
         entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("AXE_UUID"));
         if (entity_a instanceof LivingEntity && entity_a.m_6084_()) {
            if (entity.getPersistentData().m_128459_("cnt3") >= (double)20.0F || entity.getPersistentData().m_128459_("cnt4") >= (double)30.0F) {
               dx = entity_a.m_20185_() - entity.m_20185_();
               dy = entity_a.m_20186_() + (double)(entity_a.m_20206_() * 1.0F) - (entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F);
               dz = entity_a.m_20189_() - entity.m_20189_();
               distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
               if (distance < (double)3.0F) {
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 3.0F, 2.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 3.0F, 2.0F, false);
                     }
                  }

                  if (entity_a instanceof Player) {
                     if (entity_a instanceof Player) {
                        Player _player = (Player)entity_a;
                        ItemStack var138;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var138 = _livEnt.m_21205_();
                        } else {
                           var138 = ItemStack.f_41583_;
                        }

                        ItemStack _setstack = var138.m_41777_();
                        ItemStack var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21205_();
                        } else {
                           var10001 = ItemStack.f_41583_;
                        }

                        _setstack.m_41764_(var10001.m_41613_());
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (entity_a instanceof Player) {
                        Player _player = (Player)entity_a;
                        ItemCooldowns var139 = _player.m_36335_();
                        ItemStack var142;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var142 = _livEnt.m_21205_();
                        } else {
                           var142 = ItemStack.f_41583_;
                        }

                        var139.m_41524_(var142.m_41720_(), ((<undefinedtype>)(new Object() {
                           public boolean checkGamemode(Entity _ent) {
                              if (_ent instanceof ServerPlayer _serverPlayer) {
                                 return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                              } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                 return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                              } else {
                                 return false;
                              }
                           }
                        })).checkGamemode(entity_a) ? 20 : 200);
                     }
                  } else if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     ItemStack var140;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var140 = _livEnt.m_21205_();
                     } else {
                        var140 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var140.m_41777_();
                     ItemStack var143;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var143 = _livEnt.m_21205_();
                     } else {
                        var143 = ItemStack.f_41583_;
                     }

                     _setstack.m_41764_(var143.m_41613_());
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               }

               speed = (double)1.0F;
               smooth = 0.35;
               target_x = dx / distance * speed;
               target_y = dy / distance * speed;
               target_z = dz / distance * speed;
               old_x = entity.getPersistentData().m_128459_("x_power");
               old_y = entity.getPersistentData().m_128459_("y_power");
               old_z = entity.getPersistentData().m_128459_("z_power");
               new_x = old_x * ((double)1.0F - smooth) + target_x * smooth;
               new_y = old_y * ((double)1.0F - smooth) + target_y * smooth;
               new_z = old_z * ((double)1.0F - smooth) + target_z * smooth;
               entity.getPersistentData().m_128347_("x_power", new_x);
               entity.getPersistentData().m_128347_("y_power", new_y);
               entity.getPersistentData().m_128347_("z_power", new_z);
               isback = true;
            }

            for(int index0 = 0; index0 < 12; ++index0) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               x_power = entity.getPersistentData().m_128459_("x_power") * ((double)0.25F - entity.getPersistentData().m_128459_("cnt2"));
               y_power = entity.getPersistentData().m_128459_("y_power") * ((double)0.25F - entity.getPersistentData().m_128459_("cnt2"));
               z_power = entity.getPersistentData().m_128459_("z_power") * ((double)0.25F - entity.getPersistentData().m_128459_("cnt2"));
               if (!world.m_8055_(BlockPos.m_274561_(x_pos + x_power, y_pos, z_pos)).m_60815_()) {
                  entity.m_6021_(x_pos + x_power, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos + x_power, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               } else {
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * (double)-1.0F);
                  hit_wall = true;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + y_power, z_pos)).m_60815_()) {
                  entity.m_6021_(x_pos, y_pos + y_power, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos + y_power, z_pos, entity.m_146908_(), entity.m_146909_());
                  }
               } else {
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * (double)-1.0F);
                  hit_wall = true;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();
               if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos + z_power)).m_60815_()) {
                  entity.m_6021_(x_pos, y_pos, z_pos + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos + z_power, entity.m_146908_(), entity.m_146909_());
                  }
               } else {
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * (double)-1.0F);
                  hit_wall = true;
               }
            }

            if (hit_wall) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x, y, z, 20, (double)entity.m_20205_() * (double)0.5F, (double)0.0F, (double)entity.m_20205_() * (double)0.5F, 0.1);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.hurt")), SoundSource.NEUTRAL, 3.0F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.hurt")), SoundSource.NEUTRAL, 3.0F, 2.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), -0.075));
               entity.getPersistentData().m_128347_("cnt3", Math.min(entity.getPersistentData().m_128459_("cnt3"), (double)10.0F));
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + (double)1.0F);
            }

            entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_life") > (double)1.0F) {
               range = ReturnEntitySizeProcedure.execute(entity);
               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = entity.m_20185_() - x_pos;
               y_power = entity.m_20186_() - y_pos;
               z_power = entity.m_20189_() - z_pos;
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > (double)1.0F) {
                  x_power = x_power / dis / (double)1.0F;
                  y_power = y_power / dis / (double)1.0F;
                  z_power = z_power / dis / (double)1.0F;
               }

               y_pos = y_pos;

               for(int index1 = 0; index1 < (int)Math.round(Math.max(dis, (double)1.0F) * (double)1.0F); ++index1) {
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F);
                  entity.getPersistentData().m_128347_("Range", (double)(3.0F * entity.m_20205_() * 1.0F));
                  CompoundTag var141 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.m_21205_();
                  } else {
                     var10003 = ItemStack.f_41583_;
                  }

                  var141.m_128347_("knockback", 0.1 + var10003.m_41784_().m_128459_("Knockback") + (double)2.0F);
                  entity.getPersistentData().m_128347_("effect", (double)5.0F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("Damage", (double)8.0F);
                  entity.getPersistentData().m_128347_("Range", (double)(3.0F * entity.m_20205_() * 2.0F));
                  entity.getPersistentData().m_128347_("knockback", 0.05);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                  entity.getPersistentData().m_128347_("BlockRange", (double)(3.0F * entity.m_20205_()) * (double)1.5F);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (isback) {
                     entity.getPersistentData().m_128347_("BlockDamage", (double)18.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)entity.m_20205_() * (double)1.5F);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  for(int index2 = 0; index2 < 2; ++index2) {
                     for(int index3 = 0; index3 < 8; ++index3) {
                        DisplayparticleGeneratorCircleVProcedure.execute(world, (double)1.0F, (double)(entity.m_146909_() + -90.0F), Math.random() * (double)entity.m_20205_() * weaponsize, (double)1.0F, (double)0.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, "minecraft:crit");
                     }

                     DisplayparticleGeneratorCircleVProcedure.execute(world, (double)1.0F, (double)(entity.m_146909_() + -90.0F), (double)0.0F, (double)1.0F, weaponsize * (double)1.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, "minecraft:cloud");

                     for(int index4 = 0; index4 < 2; ++index4) {
                        DisplayparticleGeneratorCircleVProcedure.execute(world, (double)1.0F, (double)(entity.m_146909_() + -90.0F), (double)0.0F, (double)1.0F, weaponsize * (double)2.0F, x_pos, x_pos, y_pos, y_pos, (double)entity.m_146908_(), z_pos, z_pos, entity.getPersistentData().m_128461_("particle"));
                     }
                  }
               }
            }

            entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
            entity.getPersistentData().m_128347_("old_y", entity.m_20186_());
            entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
            getX = entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * (double)100.0F;
            getY = entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * (double)100.0F;
            getZ = entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * (double)100.0F;
            RotateEntityProcedure.execute(getX, getY, getZ, entity);
         }

      }
   }
}
