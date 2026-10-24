package net.mcreator.jujutsucraftv.item;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.client.model.Modelclothes_bagmusk;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public abstract class ClothesBagMuskItem extends ArmorItem {
   public ClothesBagMuskItem(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int m_266425_(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 0;
         }

         public int m_7366_(ArmorItem.Type type) {
            return (new int[]{0, 0, 0, 0})[type.m_266308_().m_20749_()];
         }

         public int m_6646_() {
            return 9;
         }

         public SoundEvent m_7344_() {
            return SoundEvents.f_271165_;
         }

         public Ingredient m_6230_() {
            return Ingredient.m_151265_();
         }

         public String m_6082_() {
            return "clothes_bag_musk";
         }

         public float m_6651_() {
            return 0.0F;
         }

         public float m_6649_() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Helmet extends ClothesBagMuskItem {
      public Helmet() {
         super(Type.HELMET, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            // $FF: synthetic field
            final ClothesBagMuskItem.Helmet this$0;

            {
               this.this$0 = this$0;
            }

            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorHead, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraftv:textures/entities/clothes_bagmusk.png";
      }
   }

   public static class Chestplate extends ClothesBagMuskItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            // $FF: synthetic field
            final ClothesBagMuskItem.Chestplate this$0;

            {
               this.this$0 = this$0;
            }

            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorBody, "left_arm", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorLeftArm, "right_arm", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorRightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraftv:textures/entities/clothes_bagmusk.png";
      }
   }

   public static class Leggings extends ClothesBagMuskItem {
      public Leggings() {
         super(Type.LEGGINGS, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            // $FF: synthetic field
            final ClothesBagMuskItem.Leggings this$0;

            {
               this.this$0 = this$0;
            }

            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("left_leg", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorLeftLeg, "right_leg", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorRightLeg, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraftv:textures/entities/clothes_bagmusk.png";
      }
   }

   public static class Boots extends ClothesBagMuskItem {
      public Boots() {
         super(Type.BOOTS, new Item.Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            // $FF: synthetic field
            final ClothesBagMuskItem.Boots this$0;

            {
               this.this$0 = this$0;
            }

            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("left_leg", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorLeftBoot, "right_leg", (new Modelclothes_bagmusk(Minecraft.m_91087_().m_167973_().m_171103_(Modelclothes_bagmusk.LAYER_LOCATION))).armorRightBoot, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.f_102817_ = living.m_6144_();
               armorModel.f_102609_ = defaultModel.f_102609_;
               armorModel.f_102610_ = living.m_6162_();
               return armorModel;
            }
         });
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "jujutsucraftv:textures/entities/clothes_bagmusk.png";
      }
   }
}
