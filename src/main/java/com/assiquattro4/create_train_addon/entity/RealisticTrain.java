package com.assiquattro4.create_train_addon.entity;

import com.assiquattro4.create_train_addon.physics.PhysicsCalculator;
import com.assiquattro4.create_train_addon.physics.PhysicsStateMachine;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.world.phys.Vec3;

public class RealisticTrain extends Train {

    @Override
    public void tick() {
        super.tick();

        // 1. Calcoli (come visto prima)
        double netThrust = PhysicsCalculator.calculateForces(...).netThrust();
        
        // 2. Applicazione della fisica
        // Usiamo la posizione del carrello per il fumo
        Vec3 pos = this.carriages.get(0).getAnchorPosition();
        
        PhysicsStateMachine.applyPhysicsState(netThrust, this.getTotalMass(), pos, this.level);
        
        // 3. Modifica effettiva della velocità del treno
        this.speed += (netThrust / this.getTotalMass());
    }
}
