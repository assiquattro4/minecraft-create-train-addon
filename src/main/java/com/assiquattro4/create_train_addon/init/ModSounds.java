package com.assiquattro4.create_train_addon.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.Registry;

public class ModSounds {
    // Definizione del tuo suono
    public static final SoundEvent TRAIN_STALL_GROAN = registerSound("train_stall_groan");
    public static final SoundEvent WHEEL_SLIP = registerSound("wheel_slip");

    private static SoundEvent registerSound(String name) {
        ResourceLocation id = new ResourceLocation("create_train_addon", name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
}
