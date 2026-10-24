package net.mcreator.jujutsucraftv.mixins;

import java.util.List;
import net.mcreator.jujutsucraft.item.BlackRopeItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({BlackRopeItem.class})
public abstract class BlackRopeItemMixin extends Item {
   public BlackRopeItemMixin(Item.Properties properties) {
      super(properties);
   }

   @Overwrite
   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      list.add(Component.m_237113_(Component.m_237115_("jjcv.item.special_cursedtool").getString()));
      list.add(Component.m_237113_(Component.m_237115_("jjcv.item.black_rope.description_0").getString()));
   }
}
