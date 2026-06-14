package com.assiquattro4.create_train_addon.physics;

import com.assiquattro4.create_train_addon.init.ModSounds;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.sounds.SoundSource;

public class CollisionHandler {

    public static void resolveCollision(Train trainA, Train trainB) {
        // 1. Calcolo Massa (n. di carrozze come approssimazione)
        double massA = trainA.carriages.size();
        double massB = trainB.carriages.size();

        // 2. Calcolo dello scambio di velocità (Conservation of Momentum)
        // v_final = (m1*v1 + m2*v2) / (m1 + m2)
        double totalMomentum = (massA * trainA.speed) + (massB * trainB.speed);
        double commonVelocity = totalMomentum / (massA + massB);

        // 3. Applichiamo la fisica di "buffering"
        // Invece di fonderli, trasferiamo il 70% della velocità verso l'altro treno
        double transferRate = 0.7;
        
        trainA.speed = (trainA.speed * (1 - transferRate)) + (commonVelocity * transferRate);
        trainB.speed = (trainB.speed * (1 - transferRate)) + (commonVelocity * transferRate);

        // 4. Feedback sonoro: Il CLANG dei respingenti
        playBufferClang(trainA);
    }

    private static void playBufferClang(Train train) {
        train.level.playSound(null, 
            train.carriages.get(0).getAnchorPosition().x, 
            train.carriages.get(0).getAnchorPosition().y, 
            train.carriages.get(0).getAnchorPosition().z, 
            ModSounds.WHEEL_SLIP, // Sostituisci con il tuo suono "CLANG"
            SoundSource.BLOCKS, 2.0f, 0.5f);
    }
}
