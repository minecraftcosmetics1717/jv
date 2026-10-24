package net.mcreator.jujutsucraftv.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.ForgeRegistries;

public class MusicDiscNostalgiaItem extends RecordItem {
   public MusicDiscNostalgiaItem() {
      super(0, () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:bgm_nostalgia")), (new Item.Properties()).m_41487_(1).m_41497_(Rarity.RARE), 1980);
   }
}
