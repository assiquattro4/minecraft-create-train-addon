package com.assiquattro4.create_train_addon.physics;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PhysicsStateMachine {

    public static void applyPhysicsState(double netThrust, double massa, Vec3 position, Level level) {
        
        // 1. Treno che scivola all'indietro (Net Thrust < 0)
        if (netThrust < -0.1) {
            triggerWheelSmoke(level, position, true); // fumo intenso
            // logica: il treno perde velocità, la forza di gravità vince
        } 
        
        // 2. Treno bloccato/stallo (Net Thrust quasi 0)
        else if (Math.abs(netThrust) <= 0.1) {
            triggerWheelSmoke(level, position, false); // fumo leggero (burnout)
            // logica: il treno è in stallo, fumo alle ruote perché le ruote slittano
        } 
        
        // 3. Treno che sale/avanza (Net Thrust > 0)
        else {
            // logica: accelerazione normale
            // qui applichiamo la spinta del motore meno l'attrito
        }
    }

    private static void triggerWheelSmoke(Level level, Vec3 pos, boolean intense) {
        if (level.isClientSide) {
            // Genera particelle di fumo alle coordinate delle ruote
            level.addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, 0, 0.1, 0);
            if (intense) {
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.x, pos.y, pos.z, 0, 0.1, 0);
            }
        }
    }
}
