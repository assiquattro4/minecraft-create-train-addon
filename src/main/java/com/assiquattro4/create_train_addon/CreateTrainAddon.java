package com.assiquattro4.create_train_addon;

import com.assiquattro4.create_train_addon.interaction.CouplingHandler;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;

@Mod("create_train_addon")
public class CreateTrainAddon {

    public CreateTrainAddon(IEventBus modEventBus) {
        // Registriamo l'handler per gli eventi di gioco (come i click del mouse)
        NeoForge.EVENT_BUS.register(CouplingHandler.class);
        
        System.out.println("Create Train Addon: Coupling Handler registrato.");
    }
}
