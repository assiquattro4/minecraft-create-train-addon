package com.assiquattro4.create_train_addon.entity;

import com.assiquattro4.create_train_addon.physics.PhysicsCalculator;
import com.assiquattro4.create_train_addon.physics.PhysicsStateMachine;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.world.phys.Vec3;

public class RealisticTrain extends Train {
    
    // Il profilo fisico (il "DNA" del treno)
    public final TrainPhysicsProfile physicsProfile;

    public RealisticTrain(UUID id, UUID owner) {
        super(id, owner);
        // Inizializza con valori standard
        this.physicsProfile = new TrainPhysicsProfile();
        System.out.println("Treno Fisico istanziato con successo: " + id);
    }
    
    // Ricorda di aggiungere i metodi read/write per salvare physicsProfile
}

@Override
public void tick() {
    super.tick();

    // Se siamo sul server, calcoliamo la fisica
    if (!this.level.isClientSide) {
        // Passiamo 'this' per avere accesso a tutti i dati del treno
        var forces = PhysicsCalculator.calculateForces(this);
        
        // Applichiamo la fisica
        Vec3 pos = this.carriages.get(0).getAnchorPosition();
        PhysicsStateMachine.applyPhysicsState(forces.netThrust(), this.getTotalMass(), pos, this.level);
        
        // Modifica la velocità
        this.speed += (forces.netThrust() / this.getTotalMass());
    }
}

// Helper per calcolare la massa totale (Create non lo fa nativamente per tutte le carrozze)
public double getTotalMass() {
    double totalMass = 0;
    for (var carriage : this.carriages) {
        // Assumendo che ogni carrozza abbia un peso base + peso contenuto
        totalMass += 1000.0; // Esempio: 1000 unità di massa per carrozza
    }
    return totalMass;
}
