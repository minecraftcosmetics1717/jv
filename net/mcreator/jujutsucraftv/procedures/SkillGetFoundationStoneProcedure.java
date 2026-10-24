package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillGetFoundationStoneProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack give_item = ItemStack.f_41583_;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill_dragonbreath")), SoundSource.NEUTRAL, 1.0F, 0.75F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill_dragonbreath")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
            give_item = (new ItemStack((ItemLike)JujutsucraftvModItems.FOUNDATION_STONE.get())).m_41777_();
            give_item.m_41784_().m_128359_("OWNER_UUID", entity.m_20149_());
            if ((new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.m_20149_()) instanceof LivingEntity) {
               String var10001 = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.m_20149_()).m_5446_().getString();
               give_item.m_41714_(Component.m_237113_(var10001 + Component.m_237115_("jjcv_word_s").getString() + (new ItemStack((ItemLike)JujutsucraftvModItems.FOUNDATION_STONE.get())).m_41611_().getString()));
               give_item.m_41784_().m_128347_("tex", ReturnEnergyColorVProcedure.execute(entity));
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = give_item.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
