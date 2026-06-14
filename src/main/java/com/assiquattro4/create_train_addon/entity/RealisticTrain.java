package com.assiquattro4.create_train_addon.entity;

// 1. Importa il profilo
import com.assiquattro4.create_train_addon.physics.TrainPhysicsProfile;
import com.simibubi.create.content.trains.entity.Train;
import net.minecraft.nbt.CompoundTag;

public class RealisticTrain extends Train {

    // 2. Dichiarazione dell'istanza
    public final TrainPhysicsProfile physicsProfile;

    public RealisticTrain(UUID id, UUID owner) {
        super(id, owner);
        // 3. Inizializzazione
        this.physicsProfile = new TrainPhysicsProfile();
    }

    @Override
    public void write(CompoundTag tag) {
        super.write(tag);
        // Salva usando l'istanza
        tag.put("PhysicsProfile", this.physicsProfile.save());
    }

    @Override
    public void read(CompoundTag tag) {
        super.read(tag);
        // Carica usando l'istanza
        if (tag.contains("PhysicsProfile")) {
            this.physicsProfile.load(tag.getCompound("PhysicsProfile"));
        }
    }
}
