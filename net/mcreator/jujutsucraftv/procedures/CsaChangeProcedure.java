package net.mcreator.jujutsucraftv.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.CuriosApi;

public class CsaChangeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity lv = (LivingEntity)entity;
            CuriosApi.getCuriosHelper().findCurios(lv, (Item)JujutsucraftvModItems.TRAINED_CURSED_SPIRIT_ARMORY.get()).forEach((item) -> {
               ItemStack itemstackiterator = item.stack();
               ItemStack var10000;
               if (entity instanceof LivingEntity _livEnt) {
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ItemStack _setval = var10000;
               entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.slot_item_save = _setval.m_41777_();
                  capability.syncPlayerVariables(entity);
               });
               if (((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(int sltid, ItemStack _isc) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                     _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                     return (ItemStack)_retval.get();
                  }
               })).getItemStack((int)entity.getPersistentData().m_128459_("csa_change_count"), itemstackiterator).m_204117_(ItemTags.create(new ResourceLocation("forge:metallic")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_generic")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_generic")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F), false);
                  }
               }

               if (entity instanceof LivingEntity _entity) {
                  ItemStack _setstack = ((<undefinedtype>)(new Object() {
                     public ItemStack getItemStack(int sltid, ItemStack _isc) {
                        AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                        _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                        return (ItemStack)_retval.get();
                     }
                  })).getItemStack((int)entity.getPersistentData().m_128459_("csa_change_count"), itemstackiterator).m_41777_();
                  _setstack.m_41764_(((<undefinedtype>)(new Object() {
                     public ItemStack getItemStack(int sltid, ItemStack _isc) {
                        AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.f_41583_);
                        _isc.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> _retval.set(capability.getStackInSlot(sltid).m_41777_()));
                        return (ItemStack)_retval.get();
                     }
                  })).getItemStack((int)entity.getPersistentData().m_128459_("csa_change_count"), itemstackiterator).m_41613_());
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player _player) {
                     _player.m_150109_().m_6596_();
                  }
               }

               ItemStack _setstack = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).slot_item_save.m_41777_();
               int _sltid = (int)entity.getPersistentData().m_128459_("csa_change_count");
               _setstack.m_41764_(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).slot_item_save.m_41613_());
               itemstackiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
                     itemHandlerModifiable.setStackInSlot(_sltid, _setstack);
                  }

               });
               entity.getPersistentData().m_128347_("csa_change_count", entity.getPersistentData().m_128459_("csa_change_count") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("csa_change_count") > (double)8.0F) {
                  entity.getPersistentData().m_128347_("csa_change_count", (double)0.0F);
               }

            });
         }

      }
   }
}
