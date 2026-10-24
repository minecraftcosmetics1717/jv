package net.mcreator.jujutsucraftv.mixins;

import java.util.Map;
import java.util.WeakHashMap;
import net.mcreator.jujutsucraft.procedures.AIActive2Procedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.procedures.WeaponUseStartProcedure;
import net.mcreator.jujutsucraftv.procedures.WeaponUseStopProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {AIActive2Procedure.class},
   remap = false
)
public abstract class AIActive2ProcedureMixin {
   private static final String JJCV_CNT_WEAPON_MAIN = "jjcv_cnt_weapon_main";
   private static final String JJCV_CNT_WEAPON_OFF = "jjcv_cnt_weapon_off";
   private static final String JJCV_AI_CHARGE_FULL_ACTIVE = "jjcv_ai_charge_full_active";
   private static final String JJCV_AI_CHARGE_HAND = "jjcv_ai_charge_hand";
   private static final String JJCV_AI_CHARGE_COOLDOWN = "jjcv_ai_charge_cooldown";
   private static final String JJCV_AI_CHARGE_MISSING_TICKS = "jjcv_ai_charge_missing_ticks";
   private static final String JJCV_AI_CHARGE_FULL_REACHED = "jjcv_ai_charge_full_reached";
   private static final String JJCV_AI_CHARGE_AFTER_FULL_TICKS = "jjcv_ai_charge_after_full_ticks";
   private static final int MAX_MISSING_TICKS = 10;
   private static final int FULL_CHARGE_RELEASE_DELAY = 10;
   private static final int INSTANT_RELEASE_DELAY = 5;
   private static final Map<Entity, ItemStack> ACTIVE_CHARGE_STACKS = new WeakHashMap();
   private static final TagKey<Item> CHARGE_FULL = ItemTags.create(new ResourceLocation("forge", "charge_full"));
   private static final TagKey<Item> CHARGE_INSTANCE = ItemTags.create(new ResourceLocation("forge", "charge_instance"));

   @Inject(
      method = {"execute"},
      at = {@At("TAIL")},
      remap = false
   )
   private static void jjcv$useExtraWeaponItems(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null) {
         if (!handleFullChargeTick(world, entity)) {
            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (entity instanceof Mob) {
                  Mob mob = (Mob)entity;
                  LivingEntity targetEntity = mob.m_5448_();
                  boolean target = entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F && targetEntity instanceof LivingEntity;
                  if (target) {
                     entity.getPersistentData().m_128347_("jjcv_cnt_weapon_main", entity.getPersistentData().m_128459_("jjcv_cnt_weapon_main") + (double)1.0F);
                     entity.getPersistentData().m_128347_("jjcv_cnt_weapon_off", entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off") + (double)1.0F);
                     boolean using = false;
                     boolean using2 = false;
                     ItemStack mainItem = ItemStack.f_41583_;
                     ItemStack offItem = ItemStack.f_41583_;
                     if (entity.getPersistentData().m_128459_("jjcv_cnt_weapon_main") > (double)20.0F) {
                        entity.getPersistentData().m_128347_("jjcv_cnt_weapon_main", (double)0.0F);
                        entity.getPersistentData().m_128347_("jjcv_cnt_weapon_off", Math.min(entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off"), (double)100.0F));
                        if (Math.abs(entity.getPersistentData().m_128459_("jjcv_cnt_weapon_main") - entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off")) < (double)20.0F) {
                           entity.getPersistentData().m_128347_("jjcv_cnt_weapon_main", entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off") - (double)20.0F);
                        }

                        using = true;
                        if (entity instanceof LivingEntity) {
                           LivingEntity living = (LivingEntity)entity;
                           mainItem = living.m_21205_();
                        }
                     }

                     if (entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off") > (double)60.0F) {
                        entity.getPersistentData().m_128347_("jjcv_cnt_weapon_off", (double)40.0F);
                        if (Math.abs(entity.getPersistentData().m_128459_("jjcv_cnt_weapon_main") - entity.getPersistentData().m_128459_("jjcv_cnt_weapon_off")) < (double)20.0F) {
                           entity.getPersistentData().m_128347_("jjcv_cnt_weapon_off", entity.getPersistentData().m_128459_("jjcv_cnt_weapon_main") - (double)20.0F);
                        }

                        using2 = true;
                        if (entity instanceof LivingEntity) {
                           LivingEntity living = (LivingEntity)entity;
                           offItem = living.m_21206_();
                        }
                     }

                     if (using ^ using2) {
                        double cooldown = (double)0.0F;
                        double distance = GetDistanceProcedure.execute(entity);
                        if (using) {
                           cooldown = tryUseAiWeapon(world, entity, mainItem, InteractionHand.MAIN_HAND, distance);
                        } else if (using2) {
                           cooldown = tryUseAiWeapon(world, entity, offItem, InteractionHand.OFF_HAND, distance);
                        }

                        if (cooldown > (double)0.0F) {
                           if (using) {
                              applyWeaponCooldown(entity, InteractionHand.MAIN_HAND, cooldown);
                           } else {
                              applyWeaponCooldown(entity, InteractionHand.OFF_HAND, cooldown);
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }

   private static double tryUseAiWeapon(LevelAccessor world, Entity entity, ItemStack itemstack, InteractionHand currentHand, double distance) {
      if (itemstack.m_41619_()) {
         return (double)0.0F;
      } else if (!itemstack.m_204117_(CHARGE_INSTANCE) && !itemstack.m_204117_(CHARGE_FULL)) {
         return (double)0.0F;
      } else if (getAiUseHand(itemstack) != currentHand) {
         return (double)0.0F;
      } else if (distance >= getAiUseDistance(itemstack)) {
         return (double)0.0F;
      } else {
         double useCooldown = getItemCooldownTicks(itemstack);
         if (itemstack.m_204117_(CHARGE_INSTANCE)) {
            ItemStack backupStack = itemstack.m_41777_();
            startUsingHeldItem(entity, currentHand);
            WeaponUseStartProcedure.execute(world, entity, itemstack);
            JujutsucraftvMod.queueServerWork(5, () -> {
               ItemStack heldStack = getHeldItem(entity, currentHand);
               if (!heldStack.m_41619_() && heldStack.m_41720_() == backupStack.m_41720_()) {
                  releaseUsingHeldItem(world, entity, heldStack);
               } else {
                  releaseUsingHeldItem(world, entity, backupStack);
               }

            });
            return useCooldown;
         } else if (itemstack.m_204117_(CHARGE_FULL)) {
            entity.getPersistentData().m_128379_("jjcv_ai_charge_full_active", true);
            entity.getPersistentData().m_128379_("jjcv_ai_charge_full_reached", false);
            entity.getPersistentData().m_128347_("jjcv_ai_charge_after_full_ticks", (double)0.0F);
            entity.getPersistentData().m_128347_("jjcv_ai_charge_cooldown", useCooldown);
            entity.getPersistentData().m_128347_("jjcv_ai_charge_missing_ticks", (double)0.0F);
            entity.getPersistentData().m_128359_("jjcv_ai_charge_hand", currentHand == InteractionHand.MAIN_HAND ? "main" : "off");
            ACTIVE_CHARGE_STACKS.put(entity, itemstack.m_41777_());
            startUsingHeldItem(entity, currentHand);
            WeaponUseStartProcedure.execute(world, entity, itemstack);
            return (double)0.0F;
         } else {
            return (double)0.0F;
         }
      }
   }

   private static boolean handleFullChargeTick(LevelAccessor world, Entity entity) {
      if (!entity.getPersistentData().m_128471_("jjcv_ai_charge_full_active")) {
         return false;
      } else {
         InteractionHand hand = "off".equals(entity.getPersistentData().m_128461_("jjcv_ai_charge_hand")) ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
         ItemStack itemstack = getHeldItem(entity, hand);
         boolean missingOrChanged = itemstack.m_41619_() || !itemstack.m_204117_(CHARGE_FULL);
         if (missingOrChanged) {
            double missingTicks = entity.getPersistentData().m_128459_("jjcv_ai_charge_missing_ticks") + (double)1.0F;
            entity.getPersistentData().m_128347_("jjcv_ai_charge_missing_ticks", missingTicks);
            if (missingTicks <= (double)10.0F) {
               return true;
            } else {
               ItemStack backupStack = getActiveChargeStack(entity);
               double useCooldown = entity.getPersistentData().m_128459_("jjcv_ai_charge_cooldown");
               if (useCooldown <= (double)0.0F) {
                  useCooldown = getItemCooldownTicks(backupStack);
               }

               releaseUsingHeldItem(world, entity, backupStack);
               resetFullChargeState(entity);
               applyWeaponCooldown(entity, hand, useCooldown);
               return true;
            }
         } else {
            entity.getPersistentData().m_128347_("jjcv_ai_charge_missing_ticks", (double)0.0F);
            ACTIVE_CHARGE_STACKS.put(entity, itemstack.m_41777_());
            if (entity.getPersistentData().m_128471_("jjcv_ai_charge_full_reached")) {
               double afterFullTicks = entity.getPersistentData().m_128459_("jjcv_ai_charge_after_full_ticks") + (double)1.0F;
               entity.getPersistentData().m_128347_("jjcv_ai_charge_after_full_ticks", afterFullTicks);
               if (afterFullTicks >= (double)10.0F) {
                  double useCooldown = entity.getPersistentData().m_128459_("jjcv_ai_charge_cooldown");
                  if (useCooldown <= (double)0.0F) {
                     useCooldown = getItemCooldownTicks(itemstack);
                  }

                  releaseUsingHeldItem(world, entity, itemstack);
                  resetFullChargeState(entity);
                  applyWeaponCooldown(entity, hand, useCooldown);
               }

               return true;
            } else {
               double cnt6 = entity.getPersistentData().m_128459_("cnt6");
               if (cnt6 >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("jjcv_ai_charge_full_reached", true);
                  entity.getPersistentData().m_128347_("jjcv_ai_charge_after_full_ticks", (double)0.0F);
               }

               return true;
            }
         }
      }
   }

   private static double getItemCooldownTicks(ItemStack itemstack) {
      return !itemstack.m_41619_() && itemstack.m_41782_() && itemstack.m_41784_().m_128441_("cool_time") ? Math.max((double)0.0F, itemstack.m_41784_().m_128459_("cool_time")) : (double)0.0F;
   }

   private static void applyWeaponCooldown(Entity entity, InteractionHand hand, double cooldown) {
      if (!(cooldown <= (double)0.0F)) {
         if (hand == InteractionHand.MAIN_HAND) {
            entity.getPersistentData().m_128347_("jjcv_cnt_weapon_main", (double)21.0F - cooldown);
         } else {
            entity.getPersistentData().m_128347_("jjcv_cnt_weapon_off", (double)61.0F - cooldown);
         }

      }
   }

   private static ItemStack getActiveChargeStack(Entity entity) {
      ItemStack backupStack = (ItemStack)ACTIVE_CHARGE_STACKS.get(entity);
      return backupStack != null && !backupStack.m_41619_() ? backupStack.m_41777_() : ItemStack.f_41583_;
   }

   private static InteractionHand getAiUseHand(ItemStack itemstack) {
      return InteractionHand.MAIN_HAND;
   }

   private static double getAiUseDistance(ItemStack itemstack) {
      if (itemstack.m_41720_() == JujutsucraftvModItems.NOIS_SEVER_SCISSORS.get()) {
         return (double)24.0F;
      } else {
         return itemstack.m_41720_() == JujutsucraftvModItems.HEAVENS_CLEAVER.get() ? (double)30.0F : (double)24.0F;
      }
   }

   private static ItemStack getHeldItem(Entity entity, InteractionHand hand) {
      if (entity instanceof LivingEntity living) {
         return hand == InteractionHand.MAIN_HAND ? living.m_21205_() : living.m_21206_();
      } else {
         return ItemStack.f_41583_;
      }
   }

   private static void resetFullChargeState(Entity entity) {
      entity.getPersistentData().m_128379_("jjcv_ai_charge_full_active", false);
      entity.getPersistentData().m_128379_("jjcv_ai_charge_full_reached", false);
      entity.getPersistentData().m_128347_("jjcv_ai_charge_after_full_ticks", (double)0.0F);
      entity.getPersistentData().m_128347_("jjcv_ai_charge_cooldown", (double)0.0F);
      entity.getPersistentData().m_128347_("jjcv_ai_charge_missing_ticks", (double)0.0F);
      entity.getPersistentData().m_128359_("jjcv_ai_charge_hand", "");
      ACTIVE_CHARGE_STACKS.remove(entity);
   }

   private static void startUsingHeldItem(Entity entity, InteractionHand hand) {
      if (entity instanceof LivingEntity living) {
         living.m_6672_(hand);
      }

   }

   private static void releaseUsingHeldItem(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity instanceof LivingEntity living) {
         living.m_5810_();
      }

      if (!itemstack.m_41619_()) {
         WeaponUseStopProcedure.execute(world, entity, itemstack);
      }

   }
}
