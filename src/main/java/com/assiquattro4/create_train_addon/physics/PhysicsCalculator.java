package com.assiquattro4.create_train_addon.physics;

import com.assiquattro4.create_train_addon.entity.RealisticTrain;

public class PhysicsCalculator {

    public static ForceResult calculateForces(RealisticTrain train) {
        double currentSpeed = train.speed;
        double mass = train.getTotalMass();
        
        // Esempio di logica fisica (Attrito + Potenza)
        double friction = -0.01 * currentSpeed; // Attrito proporzionale alla velocità
        double enginePower = 0.05; // Forza costante del motore
        
        double netThrust = enginePower + friction;
        
        return new ForceResult(netThrust);
    }

    // Record semplice per restituire i dati
    public record ForceResult(double netThrust) {}
}
