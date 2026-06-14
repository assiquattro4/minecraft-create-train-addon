package com.assiquattro4.create_train_addon.interaction;

import com.simibubi.create.content.trains.entity.Carriage;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.world.entity.Entity.RemovalReason; // Assicurati di importare questo
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CouplingHandler {

    private static final Map<UUID, Carriage> pendingCoupling = new HashMap<>();

    @SubscribeEvent
    public static void onWrenchClick(PlayerInteractEvent.EntityInteract event) {
        // ... (il tuo codice di interazione esistente) ...
        // Quando chiami il metodo, fallo così:
        // performManualCoupling(first, carriage);
    }

    private static void performManualCoupling(Carriage c1, Carriage c2) {
        Train train1 = c1.train;
        Train train2 = c2.train;

        if (train1 != null && train2 != null && train1 != train2) {
            // Sposta le carrozze dal train2 al train1
            for (Carriage carriage : train2.carriages) {
                carriage.train = train1;
                train1.carriages.add(carriage);
            }
            
            // Rimuovi il treno vecchio dal mondo
            // RemovalReason.DISCARDED è quello standard di Minecraft per entità rimosse via codice
            train2.remove(RemovalReason.DISCARDED);
            
            // Opzionale: notifica al mondo che la struttura del treno è cambiata
            // (se vedi che il rendering non si aggiorna subito)
            train1.manualRefresh();
        }
    }
}
