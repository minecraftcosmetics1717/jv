package net.mcreator.jujutsucraftv.init;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModAttributes {
   public static final DeferredRegister<Attribute> REGISTRY;
   public static final RegistryObject<Attribute> SET_TEXTURE;
   public static final RegistryObject<Attribute> DAMAGE_AMPLIFICATION;
   public static final RegistryObject<Attribute> ANIMATION_V_1;
   public static final RegistryObject<Attribute> ANIMATION_V_2;

   @SubscribeEvent
   public static void addAttributes(EntityAttributeModificationEvent event) {
      ((List)List.of((EntityType)JujutsucraftvModEntities.CLONE.get()).stream().filter(DefaultAttributes::m_22301_).map((entityType) -> entityType).collect(Collectors.toList())).forEach((entity) -> event.add(entity, (Attribute)SET_TEXTURE.get()));
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)DAMAGE_AMPLIFICATION.get()));
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_V_1.get()));
      event.getTypes().forEach((entity) -> event.add(entity, (Attribute)ANIMATION_V_2.get()));
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "jujutsucraftv");
      SET_TEXTURE = REGISTRY.register("set_texture", () -> (new RangedAttribute("attribute.jujutsucraftv.set_texture", (double)0.0F, (double)0.0F, (double)3.0F)).m_22084_(true));
      DAMAGE_AMPLIFICATION = REGISTRY.register("damage_amplification", () -> (new RangedAttribute("attribute.jujutsucraftv.damage_amplification", (double)0.0F, (double)-1000.0F, (double)1000.0F)).m_22084_(true));
      ANIMATION_V_1 = REGISTRY.register("animation_v_1", () -> (new RangedAttribute("attribute.jujutsucraftv.animation_v_1", (double)0.0F, (double)0.0F, (double)700.0F)).m_22084_(true));
      ANIMATION_V_2 = REGISTRY.register("animation_v_2", () -> (new RangedAttribute("attribute.jujutsucraftv.animation_v_2", (double)0.0F, (double)0.0F, (double)300.0F)).m_22084_(true));
   }

   @EventBusSubscriber
   public static class PlayerAttributesSync {
      @SubscribeEvent
      public static void playerClone(PlayerEvent.Clone event) {
         Player oldPlayer = event.getOriginal();
         Player newPlayer = event.getEntity();
         newPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get()).m_22115_());
         newPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get()).m_22115_());
         newPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_2.get()).m_22100_(oldPlayer.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_2.get()).m_22115_());
      }
   }
}
