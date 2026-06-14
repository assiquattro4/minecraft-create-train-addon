package com.assiquattro4.create_train_addon.entity;

// Importi la classe originale da Create (funziona grazie alle dipendenze nel build.gradle)
import com.simibubi.create.content.trains.entity.Train;
import java.util.UUID;

// La tua classe eredita tutto da quella originale
public class RealisticTrain extends Train {

    public RealisticTrain(UUID id, UUID owner) {
        super(id, owner);
    }

    // Qui dentro scriverai la TUA fisica personalizzata
    public void applyCustomPhysics() {
        // Esempio: calcolo massa, attrito, pendenze...
        System.out.println("Calcolo fisica realistica per questo treno!");
    }
}
