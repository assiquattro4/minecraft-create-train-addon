package com.assiquattro4.create_train_addon;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;

// L'ID deve corrispondere esattamente al modId nel tuo mods.toml
@Mod("create_train_addon")
public class CreateTrainAddon {

    public CreateTrainAddon(IEventBus modEventBus) {
        // Questo è il punto di ingresso della tua mod.
        // Qui inizializzeremo i listener quando andremo a modificare il comportamento di Create.
        System.out.println("Create Train Addon inizializzato correttamente da AssiQuattro4!");
    }
}
