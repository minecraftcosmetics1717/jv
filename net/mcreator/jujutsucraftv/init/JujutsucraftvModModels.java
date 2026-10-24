package net.mcreator.jujutsucraftv.init;

import net.mcreator.jujutsucraftv.client.model.ModelFourth_class_jurei;
import net.mcreator.jujutsucraftv.client.model.Modelbullet_bayer_knife;
import net.mcreator.jujutsucraftv.client.model.Modelbullet_paper_doll;
import net.mcreator.jujutsucraftv.client.model.Modelbullet_talisman;
import net.mcreator.jujutsucraftv.client.model.Modelclothes_bagmusk;
import net.mcreator.jujutsucraftv.client.model.Modelclothes_ebina;
import net.mcreator.jujutsucraftv.client.model.Modelclothes_yakumaru;
import net.mcreator.jujutsucraftv.client.model.Modelcuresdspirit_3_20;
import net.mcreator.jujutsucraftv.client.model.Modelcuresedspirit_3_23;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_antennae;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_apple;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_argonauta_hians;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_armoury;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_bard;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_brownwarm;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_dissatisfaction;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_eel;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_fatigue;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_greenwarm;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_maggot;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_mosh;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_perikan;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_renkon;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_specimen;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_spider;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_suture;
import net.mcreator.jujutsucraftv.client.model.Modelcurusedspirit_mouth;
import net.mcreator.jujutsucraftv.client.model.Modelflowery_costume;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftvModModels {
   @SubscribeEvent
   public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
      event.registerLayerDefinition(Modelcursedspirit_argonauta_hians.LAYER_LOCATION, Modelcursedspirit_argonauta_hians::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_perikan.LAYER_LOCATION, Modelcursedspirit_perikan::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_greenwarm.LAYER_LOCATION, Modelcursedspirit_greenwarm::createBodyLayer);
      event.registerLayerDefinition(Modelcuresdspirit_3_20.LAYER_LOCATION, Modelcuresdspirit_3_20::createBodyLayer);
      event.registerLayerDefinition(Modelclothes_ebina.LAYER_LOCATION, Modelclothes_ebina::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_specimen.LAYER_LOCATION, Modelcursedspirit_specimen::createBodyLayer);
      event.registerLayerDefinition(ModelFourth_class_jurei.LAYER_LOCATION, ModelFourth_class_jurei::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_dissatisfaction.LAYER_LOCATION, Modelcursedspirit_dissatisfaction::createBodyLayer);
      event.registerLayerDefinition(Modelcurusedspirit_mouth.LAYER_LOCATION, Modelcurusedspirit_mouth::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_suture.LAYER_LOCATION, Modelcursedspirit_suture::createBodyLayer);
      event.registerLayerDefinition(Modelclothes_bagmusk.LAYER_LOCATION, Modelclothes_bagmusk::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_armoury.LAYER_LOCATION, Modelcursedspirit_armoury::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_maggot.LAYER_LOCATION, Modelcursedspirit_maggot::createBodyLayer);
      event.registerLayerDefinition(Modelbullet_bayer_knife.LAYER_LOCATION, Modelbullet_bayer_knife::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_mosh.LAYER_LOCATION, Modelcursedspirit_mosh::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_eel.LAYER_LOCATION, Modelcursedspirit_eel::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_bard.LAYER_LOCATION, Modelcursedspirit_bard::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_antennae.LAYER_LOCATION, Modelcursedspirit_antennae::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_brownwarm.LAYER_LOCATION, Modelcursedspirit_brownwarm::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_fatigue.LAYER_LOCATION, Modelcursedspirit_fatigue::createBodyLayer);
      event.registerLayerDefinition(Modelcuresedspirit_3_23.LAYER_LOCATION, Modelcuresedspirit_3_23::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_apple.LAYER_LOCATION, Modelcursedspirit_apple::createBodyLayer);
      event.registerLayerDefinition(Modelbullet_talisman.LAYER_LOCATION, Modelbullet_talisman::createBodyLayer);
      event.registerLayerDefinition(Modelbullet_paper_doll.LAYER_LOCATION, Modelbullet_paper_doll::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_spider.LAYER_LOCATION, Modelcursedspirit_spider::createBodyLayer);
      event.registerLayerDefinition(Modelclothes_yakumaru.LAYER_LOCATION, Modelclothes_yakumaru::createBodyLayer);
      event.registerLayerDefinition(Modelflowery_costume.LAYER_LOCATION, Modelflowery_costume::createBodyLayer);
      event.registerLayerDefinition(Modelcursedspirit_renkon.LAYER_LOCATION, Modelcursedspirit_renkon::createBodyLayer);
   }
}
