package com.assiquattro4.create_train_addon.physics;

import com.simibubi.create.content.contraptions.Contraption;
import net.minecraft.world.level.block.state.BlockState;

public class PhysicsCalculator {

    // Calcola la massa totale del treno basandosi sui blocchi del Contraption
    public static double calculateTotalMass(Contraption contraption) {
        double mass = 0;
        for (BlockState state : contraption.getBlocks().values().stream().map(d -> d.state).toList()) {
            // Qui assegni un peso arbitrario ai blocchi
            mass += getBlockWeight(state);
        }
        return mass;
    }

    // Esempio di logica per pesare i blocchi
    private static double getBlockWeight(BlockState state) {
        if (state.isAir()) return 0;
        // Puoi basarti sulla durezza del blocco (hardness)
        return state.getDestroySpeed(null, null) * 10; 
    }

    // Calcola la resistenza dovuta alla pendenza
    // slopeAngle: inclinazione in gradi (o radianti)
    public static double calculateSlopeResistance(double slopeAngle) {
        // Maggiore è l'inclinazione, maggiore è la resistenza
        return Math.sin(Math.toRadians(slopeAngle)) * 9.81; 
    }
    
    // Calcola l'attrito basandosi sulla superficie
    public static double calculateFriction(double currentSpeed) {
        // Esempio: l'attrito aumenta leggermente con la velocità
        return currentSpeed * 0.05;
    }
}
