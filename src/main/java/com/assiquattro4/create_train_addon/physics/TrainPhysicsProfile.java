public class TrainPhysicsProfile {
    public double baseMass;
    public double dragCoefficient;
    public double maxSpeed;
    // ... ecc.

    // Metodo per serializzare i dati in NBT (Fondamentale per la persistenza)
    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("Mass", baseMass);
        tag.putDouble("Drag", dragCoefficient);
        return tag;
    }

    public void load(CompoundTag tag) {
        this.baseMass = tag.getDouble("Mass");
        this.dragCoefficient = tag.getDouble("Drag");
    }
}
