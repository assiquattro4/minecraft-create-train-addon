package com.assiquattro4.create_train_addon.interaction;

import com.simibubi.create.content.trains.entity.Carriage;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CouplingHandler {

    // Salviamo l'ID del primo vagone cliccato associato al giocatore
    private static final Map<UUID, Carriage> pendingCoupling = new HashMap<>();

    @SubscribeEvent
    public static void onWrenchClick(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        
        // Verifica se l'entità cliccata è un vagone (Carriage)
        if (event.getTarget() instanceof Carriage carriage) {
            
            // Verifica se il giocatore ha in mano la wrench (usa l'ID dell'item corretto)
            if (player.getMainHandItem().getDisplayName().getString().contains("Wrench")) {
                
                if (!pendingCoupling.containsKey(player.getUUID())) {
                    // Primo click: salviamo il vagone
                    pendingCoupling.put(player.getUUID(), carriage);
                    player.displayClientMessage(net.minecraft.network.chat.Component.literal("Primo vagone selezionato!"), true);
                } else {
                    // Secondo click: eseguiamo l'accoppiamento
                    Carriage first = pendingCoupling.get(player.getUUID());
                    performManualCoupling(first, carriage);
                    
                    pendingCoupling.remove(player.getUUID());
                    player.displayClientMessage(net.minecraft.network.chat.Component.literal("Vagoni accoppiati manualmente!"), true);
                }
                event.setCanceled(true); // Impediamo a Create di fare il suo coupling automatico
            }
        }
    }

    private static void performManualCoupling(Carriage c1, Carriage c2) {
        // Qui scriverai la logica che unisce fisicamente i due vagoni
        // Usando i metodi interni di Create o la tua logica fisica
    }
}
