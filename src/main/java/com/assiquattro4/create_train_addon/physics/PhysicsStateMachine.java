package com.assiquattro4.create_train_addon.physics;

import com.assiquattro4.create_train_addon.init.ModSounds;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundSource;

public class PhysicsStateMachine {

    // Salviamo l'ultimo stato per sapere quando è cambiato
    private static String lastState = "NORMAL"; 

    public static void applyPhysicsState(double netThrust, Vec3 position, Level level) {
        String currentState = (netThrust < -0.1) ? "SLIPPING" : (Math.abs(netThrust) <= 0.1) ? "STALL" : "NORMAL";

        // Se lo stato è cambiato, suona l'effetto!
        if (!currentState.equals(lastState)) {
            if (currentState.equals("STALL")) {
                level.playSound(null, position.x, position.y, position.z, 
                                ModSounds.TRAIN_STALL_GROAN, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            if (currentState.equals("SLIPPING")) {
                level.playSound(null, position.x, position.y, position.z, 
                                ModSounds.WHEEL_SLIP, SoundSource.BLOCKS, 0.8f, 1.2f);
            }
            lastState = currentState;
        }
    }
}
