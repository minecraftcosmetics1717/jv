package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkillAttackGroundBiteProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double entity_height = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         entity.f_19789_ = 0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.m_20331_(true);
         entity_height = (double)(entity.m_20206_() * 3.0F + 1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") <= (double)2.0F) {
            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  entity.getPersistentData().m_128347_("y_pos", y);
               } else if (entity.getPersistentData().m_128459_("cnt1") > (double)200.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~5");
               }

               if (entity.m_146909_() > 80.0F) {
                  entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
               }
            } else {
               entity.m_6021_(x, y - (double)0.5F, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, y - (double)0.5F, z, entity.m_146908_(), entity.m_146909_());
               }

               y_pos = y - (double)1.0F;

               for(int index0 = 0; index0 < (int)Math.round(entity_height) && !(y_pos > entity.getPersistentData().m_128459_("y_pos")); ++index0) {
                  if (world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x, y_pos + (double)1.0F, z)).m_60815_()) {
                     world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + (double)0.5F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }

               if (y < entity.getPersistentData().m_128459_("y_pos") - entity_height) {
                  Vec3 _center = new Vec3(x, y, z);
                  List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)8.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
                  Iterator var18 = _entfound.iterator();
                  if (var18.hasNext()) {
                     Entity entityiterator = (Entity)var18.next();
                     if (entityiterator instanceof LivingEntity) {
                        label166: {
                           if (entityiterator instanceof Mob) {
                              Mob _mobEnt26 = (Mob)entityiterator;
                              if (_mobEnt26.m_5912_()) {
                                 LivingEntity var10000;
                                 if (entityiterator instanceof Mob) {
                                    Mob _mobEnt = (Mob)entityiterator;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 == entity) {
                                    x_pos = entityiterator.m_20185_();
                                    y_pos = entityiterator.m_20186_();
                                    z_pos = entityiterator.m_20189_();
                                    break label166;
                                 }
                              }
                           }

                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_();
                           y_pos = entityiterator.m_20186_();
                        }
                     } else {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                     }
                  }

                  for(int index1 = 0; index1 < 255; ++index1) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        entity.getPersistentData().m_128347_("y_pos", y_pos);
                        y_pos -= entity_height;
                        break;
                     }

                     --y_pos;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)3.0F);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt2") == (double)3.0F) {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            entity.m_6021_(x, y + (double)1.5F, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y + (double)1.5F, z, entity.m_146908_(), entity.m_146909_());
            }

            y_pos = y;

            for(int index2 = 0; index2 < 6 && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_(); ++index2) {
               if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + (double)1.0F, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y_pos, z, 5, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, 5, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                  }

                  world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + (double)0.5F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            entity.getPersistentData().m_128347_("Damage", (double)14.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.5F);
            entity.getPersistentData().m_128347_("Range", (double)3.0F * (SetEntitySizeProcedure.execute(entity) >= (double)1.0F ? SetEntitySizeProcedure.execute(entity) : (double)1.0F));
            entity.getPersistentData().m_128347_("effect", (double)1.0F);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackVProcedure.execute(world, x, y, z, entity);
            if (y > entity.getPersistentData().m_128459_("y_pos") + (double)2.0F) {
               entity.getPersistentData().m_128347_("cnt2", (double)4.0F);
            }

            if (entity.m_146909_() > -80.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") > (double)10.0F) {
               if (entity.getPersistentData().m_128459_("cnt3") > (double)20.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }

               if (entity.m_146909_() < -10.0F) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~10");
                  }
               } else if (entity.m_146909_() > 10.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-10");
               }
            } else if (entity.m_146909_() > -80.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         }

         entity.m_20331_(false);
         entity.getPersistentData().m_128347_("Damage", (double)0.0F);
      }
   }
}
