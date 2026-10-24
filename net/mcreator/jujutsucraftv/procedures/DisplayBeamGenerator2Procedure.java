package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.StringReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.client.particle.ParticleDustTransitionOptions;
import net.minecraft.commands.arguments.ParticleArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Vector3f;

@EventBusSubscriber
public class DisplayBeamGenerator2Procedure {
   private static final int MAX_TOTAL_STEPS_PER_BEAM = 8192;
   private static final int MAX_RENDER_STEPS_PER_BEAM_PER_TICK = 512;
   private static final int MAX_RENDER_STEPS_GLOBAL_PER_TICK = 4096;
   private static final int MAX_BLOCK_ACTIONS_PER_BEAM_PER_TICK = 8;
   private static final int MAX_BLOCK_ACTIONS_GLOBAL_PER_TICK = 64;
   private static final int MAX_PENDING_BLOCK_ACTIONS = 2048;
   private static final long MAX_BEAM_LIFETIME_TICKS = 2400L;
   private static final ConcurrentLinkedQueue<BeamTask> PENDING_BEAMS = new ConcurrentLinkedQueue();
   private static final ArrayDeque<BeamTask> ACTIVE_BEAMS = new ArrayDeque();

   @SubscribeEvent
   public static void onServerTick(TickEvent.ServerTickEvent event) {
      if (event.phase == Phase.END) {
         BeamTask pending;
         while((pending = (BeamTask)PENDING_BEAMS.poll()) != null) {
            ACTIVE_BEAMS.addLast(pending);
         }

         if (!ACTIVE_BEAMS.isEmpty()) {
            TickBudget budget = new TickBudget(4096, 64);
            int taskCount = ACTIVE_BEAMS.size();

            for(int i = 0; i < taskCount; ++i) {
               BeamTask task = (BeamTask)ACTIVE_BEAMS.pollFirst();
               if (task == null) {
                  break;
               }

               boolean finished = task.tick(budget);
               if (!finished) {
                  ACTIVE_BEAMS.addLast(task);
               }
            }

         }
      }
   }

   @SubscribeEvent
   public static void onServerStopped(ServerStoppedEvent event) {
      PENDING_BEAMS.clear();
      ACTIVE_BEAMS.clear();
   }

   public static void execute(LevelAccessor world, Entity entity, boolean block_break, boolean move, boolean penetration, boolean attack, boolean end_pos, double act_time, double dis, double dis2, double height, double move_speed, double width, double x1, double x2, double y1, double y2, double z1, double z2, double zoomsize, String particle) {
      if (particle != null && world instanceof ServerLevel level) {
         if (entity != null && !entity.m_213877_()) {
            ParticleOptions options = getParticleFromString(particle, level);
            if (options == null) {
               return;
            }

            double rawDx = x2 - x1;
            double rawDy = y2 - y1;
            double rawDz = z2 - z1;
            double rawDist = Math.sqrt(rawDx * rawDx + rawDy * rawDy + rawDz * rawDz);
            Vec3 direction;
            if (rawDist >= 0.01) {
               direction = new Vec3(rawDx / rawDist, rawDy / rawDist, rawDz / rawDist);
            } else {
               direction = entity.m_20154_();
               if (direction.m_82556_() < 1.0E-4) {
                  direction = new Vec3((double)0.0F, (double)0.0F, (double)1.0F);
               } else {
                  direction = direction.m_82541_();
               }

               rawDist = (double)1.0F;
            }

            double endX;
            double endY;
            double endZ;
            if (penetration) {
               double beamRange = getPenetrationBeamRange(entity, rawDist);
               endX = x1 + direction.f_82479_ * beamRange;
               endY = y1 + direction.f_82480_ * beamRange;
               endZ = z1 + direction.f_82481_ * beamRange;
            } else {
               Vec3 requestedEnd = new Vec3(x2, y2, z2);
               BlockHitResult result = level.m_45547_(new ClipContext(new Vec3(x1, y1, z1), requestedEnd, Block.COLLIDER, Fluid.NONE, entity));
               if (result.m_6662_() == Type.BLOCK) {
                  Vec3 hit = result.m_82450_();
                  endX = hit.f_82479_;
                  endY = hit.f_82480_;
                  endZ = hit.f_82481_;
               } else {
                  endX = x2;
                  endY = y2;
                  endZ = z2;
               }
            }

            double dx = endX - x1;
            double dy = endY - y1;
            double dz = endZ - z1;
            double currentDist = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (currentDist < 0.01) {
               return;
            }

            double stepSize = Math.max(0.05, dis);
            int beamPointCount = (int)Math.max((double)1.0F, Math.ceil(currentDist / stepSize));
            beamPointCount = Math.min(beamPointCount, 8192);
            int attackInterval = (int)Math.max((double)1.0F, act_time);
            CompoundTag nbt = entity.getPersistentData();
            double damage = nbt.m_128459_("Damage");
            double range = nbt.m_128459_("Range");
            double knockback = nbt.m_128459_("knockback");
            double blockRange = nbt.m_128459_("BlockRange");
            double blockDamage = nbt.m_128459_("BlockDamage");
            boolean noEffect = nbt.m_128471_("noEffect");
            boolean noParticle = nbt.m_128471_("noParticle");
            BeamTask task = new BeamTask(level, entity, options, x1, y1, z1, dx, dy, dz, currentDist, beamPointCount, width, height, zoomsize, block_break, move, penetration, attack, end_pos, move_speed, attackInterval, damage, range, knockback, blockRange, blockDamage, noEffect, noParticle);
            PENDING_BEAMS.add(task);
            return;
         }
      }

   }

   private static void renderStep(ServerLevel level, Entity entity, ParticleOptions options, double startX, double startY, double startZ, double dx, double dy, double dz, int index, int count, double ratio, double width, double height, double zoomSize, boolean penetration, boolean attack, boolean endPos, int attackInterval, double damage, double range, double knockback) {
      double px = startX + dx * ratio;
      double py = startY + dy * ratio;
      double pz = startZ + dz * ratio;
      double currentWidth = Math.max((double)0.0F, width + ratio * zoomSize);
      double currentHeight = Math.max((double)0.0F, height + ratio * zoomSize);
      int particleCount = (int)Math.max((double)1.0F, currentWidth * currentHeight * (double)15.0F);

      for(ServerPlayer player : level.m_6907_()) {
         level.m_8624_(player, options, true, px, py, pz, particleCount, currentWidth, currentHeight, currentWidth, (double)0.0F);
      }

      if (attack && entity != null && !entity.m_213877_() && (index % attackInterval == 0 || index == count)) {
         CompoundTag tag = entity.getPersistentData();
         tag.m_128347_("Damage", damage);
         tag.m_128347_("Range", range);
         tag.m_128347_("knockback", knockback);
         RangeAttackProcedure.execute(level, px, py, pz, entity);
      }

      if (endPos && !penetration && entity != null && !entity.m_213877_() && index == count) {
         BeamActEndPosProcedure.execute(level, entity, px, py, pz);
      }

   }

   private static DestroyTarget findDestroyTargetForSegment(ServerLevel level, Entity entity, double startX, double startY, double startZ, double dx, double dy, double dz, int index, int count, HashSet<Long> queuedPoints) {
      int previousIndex = Math.max(0, index - 1);
      double startRatio = (double)previousIndex / (double)count;
      double endRatio = (double)index / (double)count;
      Vec3 from = new Vec3(startX + dx * startRatio, startY + dy * startRatio, startZ + dz * startRatio);
      Vec3 to = new Vec3(startX + dx * endRatio, startY + dy * endRatio, startZ + dz * endRatio);
      double segmentDistance = from.m_82554_(to);
      int samples = (int)Math.max((double)1.0F, Math.ceil(segmentDistance / (double)0.25F));
      Vec3 difference = to.m_82546_(from);

      for(int sample = 0; sample <= samples; ++sample) {
         double localRatio = (double)sample / (double)samples;
         Vec3 point = from.m_82549_(difference.m_82490_(localRatio));
         BlockPos basePos = BlockPos.m_274446_(point);
         if (level.m_46805_(basePos)) {
            long key = basePos.m_121878_();
            if (!queuedPoints.contains(key)) {
               BlockPos destroyPos = findDestroyableBlockNear(level, entity, basePos);
               if (destroyPos != null) {
                  return new DestroyTarget(key, destroyPos);
               }
            }
         }
      }

      return null;
   }

   private static BlockPos findDestroyableBlockNear(ServerLevel level, Entity entity, BlockPos basePos) {
      if (!level.m_46805_(basePos)) {
         return null;
      } else {
         BlockState centerState = level.m_8055_(basePos);
         if (!centerState.m_60795_() && centerState.m_60819_().m_76178_()) {
            double x = (double)basePos.m_123341_() + (double)0.5F;
            double y = (double)basePos.m_123342_() + (double)0.5F;
            double z = (double)basePos.m_123343_() + (double)0.5F;
            if (canDestroyBlockAtPos(level, entity, basePos, x, y, z)) {
               return basePos;
            }
         }

         for(int ox = -1; ox <= 1; ++ox) {
            for(int oy = -1; oy <= 1; ++oy) {
               for(int oz = -1; oz <= 1; ++oz) {
                  if (ox != 0 || oy != 0 || oz != 0) {
                     BlockPos pos = basePos.m_7918_(ox, oy, oz);
                     if (level.m_46805_(pos)) {
                        BlockState state = level.m_8055_(pos);
                        if (!state.m_60795_() && state.m_60819_().m_76178_()) {
                           double x = (double)pos.m_123341_() + (double)0.5F;
                           double y = (double)pos.m_123342_() + (double)0.5F;
                           double z = (double)pos.m_123343_() + (double)0.5F;
                           if (canDestroyBlockAtPos(level, entity, pos, x, y, z)) {
                              return pos;
                           }
                        }
                     }
                  }
               }
            }
         }

         return null;
      }
   }

   private static boolean tryDestroyBeamPointAtPos(LevelAccessor world, ServerLevel level, Entity entity, BlockPos pos, double blockRange, double blockDamage, boolean noEffect, boolean noParticle) {
      if (entity != null && !entity.m_213877_()) {
         if (!level.m_46805_(pos)) {
            return false;
         } else {
            BlockState state = level.m_8055_(pos);
            if (!state.m_60795_() && state.m_60819_().m_76178_()) {
               double x = (double)pos.m_123341_() + (double)0.5F;
               double y = (double)pos.m_123342_() + (double)0.5F;
               double z = (double)pos.m_123343_() + (double)0.5F;
               BlockPos footPos = getFootBlockPos(entity);
               BlockState footState = level.m_8055_(footPos);
               boolean restoreFoot = shouldRestoreFootBlock(entity, footState, x, y, z);
               CompoundTag tag = entity.getPersistentData();
               tag.m_128347_("BlockRange", blockRange);
               tag.m_128347_("BlockDamage", blockDamage);
               tag.m_128379_("noEffect", noEffect);
               tag.m_128379_("noParticle", noParticle);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (restoreFoot) {
                  BlockState currentFoot = level.m_8055_(footPos);
                  if (currentFoot.m_60795_() || !currentFoot.equals(footState)) {
                     level.m_7731_(footPos, footState, 3);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static boolean canDestroyBlockAtPos(ServerLevel level, Entity entity, BlockPos pos, double x, double y, double z) {
      if (entity != null && !entity.m_213877_()) {
         if (!level.m_46805_(pos)) {
            return false;
         } else {
            BlockState state = level.m_8055_(pos);
            if (!state.m_60795_() && state.m_60819_().m_76178_()) {
               BlockPos footPos = getFootBlockPos(entity);
               return !pos.equals(footPos) || isAimedAtFoot(entity, x, y, z);
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static boolean shouldRestoreFootBlock(Entity entity, BlockState footState, double x, double y, double z) {
      if (!footState.m_60795_() && footState.m_60819_().m_76178_()) {
         return !isAimedAtFoot(entity, x, y, z);
      } else {
         return false;
      }
   }

   private static boolean isAimedAtFoot(Entity entity, double x, double y, double z) {
      double dx = x - entity.m_20185_();
      double dz = z - entity.m_20189_();
      double horizontalDistanceSqr = dx * dx + dz * dz;
      return horizontalDistanceSqr <= (double)2.25F && y <= entity.m_20186_() + 0.35;
   }

   private static BlockPos getFootBlockPos(Entity entity) {
      return BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() - 0.05, entity.m_20189_());
   }

   private static double getPenetrationBeamRange(Entity entity, double requestedDistance) {
      double beamRange = entity.getPersistentData().m_128459_("BeamRange");
      if (beamRange <= (double)0.0F) {
         beamRange = (double)256.0F;
      }

      return Math.max(requestedDistance, beamRange);
   }

   private static ParticleOptions getParticleFromString(String string, ServerLevel level) {
      if (string == null) {
         return null;
      } else {
         String text = string.trim();
         if (text.isEmpty()) {
            return null;
         } else {
            ParticleOptions options = tryReadParticle(text, level);
            if (options != null) {
               return options;
            } else {
               ParticleOptions transition = tryReadDustTransitionParticle(text);
               if (transition != null) {
                  return transition;
               } else {
                  String fixed = fixParticleText(text);
                  if (!fixed.equals(text)) {
                     options = tryReadParticle(fixed, level);
                     if (options != null) {
                        return options;
                     }

                     transition = tryReadDustTransitionParticle(fixed);
                     if (transition != null) {
                        return transition;
                     }
                  }

                  return null;
               }
            }
         }
      }
   }

   private static ParticleOptions tryReadParticle(String string, ServerLevel level) {
      try {
         StringReader reader = new StringReader(string);
         return ParticleArgument.m_247456_(reader, level.m_9598_().m_255025_(Registries.f_256890_));
      } catch (Exception var3) {
         return null;
      }
   }

   private static ParticleOptions tryReadDustTransitionParticle(String string) {
      try {
         String[] split = string.trim().split("\\s+");
         if (split.length != 8) {
            return null;
         } else {
            String name = split[0];
            if (!name.contains("dust_transition") && !name.contains("dust_color_transition")) {
               return null;
            } else {
               if (!name.contains(":")) {
                  name = "minecraft:" + name;
               }

               ResourceLocation id = new ResourceLocation(name);
               ParticleType<?> rawType = (ParticleType)ForgeRegistries.PARTICLE_TYPES.getValue(id);
               if (rawType != null && !(rawType instanceof SimpleParticleType)) {
                  float fromRed = Float.parseFloat(split[1]);
                  float fromGreen = Float.parseFloat(split[2]);
                  float fromBlue = Float.parseFloat(split[3]);
                  float scale = Float.parseFloat(split[4]);
                  float toRed = Float.parseFloat(split[5]);
                  float toGreen = Float.parseFloat(split[6]);
                  float toBlue = Float.parseFloat(split[7]);
                  return new ParticleDustTransitionOptions(rawType, new Vector3f(fromRed, fromGreen, fromBlue), scale, new Vector3f(toRed, toGreen, toBlue));
               } else {
                  return null;
               }
            }
         }
      } catch (Exception var13) {
         return null;
      }
   }

   private static String fixParticleText(String string) {
      String[] split = string.trim().split("\\s+", 2);
      if (split.length == 0) {
         return string;
      } else {
         String name = split[0];
         String rest = split.length >= 2 ? " " + split[1] : "";
         if (!name.contains(":")) {
            name = "minecraft:" + name;
         }

         return name + rest;
      }
   }

   private static class BeamTask {
      private final ServerLevel level;
      private final Entity entity;
      private final ParticleOptions particle;
      private final double startX;
      private final double startY;
      private final double startZ;
      private final double dx;
      private final double dy;
      private final double dz;
      private final double distance;
      private final int count;
      private final double width;
      private final double height;
      private final double zoomSize;
      private final boolean blockBreak;
      private final boolean move;
      private final boolean penetration;
      private final boolean attack;
      private final boolean endPos;
      private final double moveSpeed;
      private final int attackInterval;
      private final double damage;
      private final double range;
      private final double knockback;
      private final double blockRange;
      private final double blockDamage;
      private final boolean noEffect;
      private final boolean noParticle;
      private final long startGameTime;
      private int nextIndex = 0;
      private final HashSet<Long> queuedBeamPoints = new HashSet();
      private final ArrayDeque<DestroyTarget> pendingDestroyTargets = new ArrayDeque();

      private BeamTask(ServerLevel level, Entity entity, ParticleOptions particle, double startX, double startY, double startZ, double dx, double dy, double dz, double distance, int count, double width, double height, double zoomSize, boolean blockBreak, boolean move, boolean penetration, boolean attack, boolean endPos, double moveSpeed, int attackInterval, double damage, double range, double knockback, double blockRange, double blockDamage, boolean noEffect, boolean noParticle) {
         this.level = level;
         this.entity = entity;
         this.particle = particle;
         this.startX = startX;
         this.startY = startY;
         this.startZ = startZ;
         this.dx = dx;
         this.dy = dy;
         this.dz = dz;
         this.distance = distance;
         this.count = count;
         this.width = width;
         this.height = height;
         this.zoomSize = zoomSize;
         this.blockBreak = blockBreak;
         this.move = move;
         this.penetration = penetration;
         this.attack = attack;
         this.endPos = endPos;
         this.moveSpeed = Math.max(0.1, moveSpeed);
         this.attackInterval = attackInterval;
         this.damage = damage;
         this.range = range;
         this.knockback = knockback;
         this.blockRange = blockRange;
         this.blockDamage = blockDamage;
         this.noEffect = noEffect;
         this.noParticle = noParticle;
         this.startGameTime = level.m_46467_();
      }

      private boolean tick(TickBudget budget) {
         boolean sourceAlive = this.entity != null && !this.entity.m_213877_() && this.entity.m_9236_() == this.level;
         long elapsed = this.level.m_46467_() - this.startGameTime;
         if (elapsed > 2400L) {
            return true;
         } else {
            int localBlockActions = 0;
            if (sourceAlive) {
               localBlockActions = this.processPendingBlockActions(budget, 0);
            } else {
               this.pendingDestroyTargets.clear();
            }

            int dueIndex;
            if (this.move) {
               double reachableDistance = (double)elapsed * this.moveSpeed;
               double progress = reachableDistance / this.distance;
               progress = Math.max((double)0.0F, Math.min((double)1.0F, progress));
               dueIndex = (int)Math.floor(progress * (double)this.count);
            } else {
               dueIndex = this.count;
            }

            for(int renderedThisTick = 0; this.nextIndex <= dueIndex && this.nextIndex <= this.count && renderedThisTick < 512 && budget.renderSteps > 0; --budget.renderSteps) {
               double ratio = (double)this.nextIndex / (double)this.count;
               if (sourceAlive && this.blockBreak && this.pendingDestroyTargets.size() < 2048) {
                  DestroyTarget target = DisplayBeamGenerator2Procedure.findDestroyTargetForSegment(this.level, this.entity, this.startX, this.startY, this.startZ, this.dx, this.dy, this.dz, this.nextIndex, this.count, this.queuedBeamPoints);
                  if (target != null && this.queuedBeamPoints.add(target.key)) {
                     this.pendingDestroyTargets.addLast(target);
                  }
               }

               DisplayBeamGenerator2Procedure.renderStep(this.level, this.entity, this.particle, this.startX, this.startY, this.startZ, this.dx, this.dy, this.dz, this.nextIndex, this.count, ratio, this.width, this.height, this.zoomSize, this.penetration, this.attack && sourceAlive, this.endPos, this.attackInterval, this.damage, this.range, this.knockback);
               ++this.nextIndex;
               ++renderedThisTick;
            }

            if (sourceAlive) {
               this.processPendingBlockActions(budget, localBlockActions);
            } else {
               this.pendingDestroyTargets.clear();
            }

            return this.nextIndex > this.count && this.pendingDestroyTargets.isEmpty();
         }
      }

      private int processPendingBlockActions(TickBudget budget, int alreadyProcessed) {
         int processed;
         for(processed = alreadyProcessed; !this.pendingDestroyTargets.isEmpty() && processed < 8 && budget.blockActions > 0; --budget.blockActions) {
            DestroyTarget target = (DestroyTarget)this.pendingDestroyTargets.pollFirst();
            if (target == null) {
               break;
            }

            DisplayBeamGenerator2Procedure.tryDestroyBeamPointAtPos(this.level, this.level, this.entity, target.pos, this.blockRange, this.blockDamage, this.noEffect, this.noParticle);
            ++processed;
         }

         return processed;
      }
   }

   private static class TickBudget {
      private int renderSteps;
      private int blockActions;

      private TickBudget(int renderSteps, int blockActions) {
         this.renderSteps = renderSteps;
         this.blockActions = blockActions;
      }
   }

   private static class DestroyTarget {
      private final long key;
      private final BlockPos pos;

      private DestroyTarget(long key, BlockPos pos) {
         this.key = key;
         this.pos = pos;
      }
   }
}
