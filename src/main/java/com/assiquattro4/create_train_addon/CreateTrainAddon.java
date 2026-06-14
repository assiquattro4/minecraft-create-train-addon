package com.assiquattro4.create_train_addon;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("create_train_addon") // Deve corrispondere al modId nel toml
public class TrainAddon {

    public TrainAddon(IEventBus modEventBus) {
        // Qui inizializziamo i registri della mod
        System.out.println("Modulo di fisica ferroviaria inizializzato!");
        
        // Se hai registrato suoni, blocchi o item, li colleghi qui:
        // ModSounds.SOUNDS.register(modEventBus);
    }
}
