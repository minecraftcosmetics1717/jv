package net.mcreator.jujutsucraftv.mixins;

import java.util.List;
import net.mcreator.jujutsucraft.item.PlayfulCloudItem;
import net.mcreator.jujutsucraftv.procedures.WeaponUseProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({PlayfulCloudItem.class})
public abstract class PlayfulCloudItemMixin extends Item {
   public PlayfulCloudItemMixin(Item.Properties p_41383_) {
      super(p_41383_);
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      WeaponUseProcedure.execute(world, entity);
      return ar;
   }

   @Overwrite
   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      list.add(Component.m_237113_(Component.m_237115_("jjcv.item.special_cursedtool").getString()));
      list.add(Component.m_237113_(Component.m_237115_("jjcv.item.playful_cloud.description_0").getString()));
   }
}
