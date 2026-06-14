package com.assiquattro4.create_train_addon.physics;

import net.minecraft.nbt.CompoundTag;

public class TrainPhysicsProfile {
    public double baseMass = 1000.0;
    public double dragCoefficient = 0.5;

    // Crea un nuovo tag NBT con i dati attuali
    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("BaseMass", this.baseMass);
        tag.putDouble("Drag", this.dragCoefficient);
        return tag;
    }

    // Carica i dati dal tag NBT
    public void load(CompoundTag tag) {
        if (tag.contains("BaseMass")) this.baseMass = tag.getDouble("BaseMass");
        if (tag.contains("Drag")) this.dragCoefficient = tag.getDouble("Drag");
    }
}
