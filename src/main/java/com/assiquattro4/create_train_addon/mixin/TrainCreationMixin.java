package com.assiquattro4.create_train_addon.mixin;

import com.assiquattro4.create_train_addon.entity.RealisticTrain;
import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.entity.TrainAssembler; // Verifica che sia la classe giusta nei sorgenti
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import java.util.UUID;

@Mixin(value = TrainAssembler.class, remap = false)
public class TrainCreationMixin {

    // Intercetta la creazione del nuovo treno
    @Redirect(
        method = "assemble", 
        at = @At(value = "NEW", target = "com/simibubi/create/content/trains/entity/Train")
    )
    private Train replaceTrainCreation(UUID id, UUID owner) {
        // Restituisce la tua istanza invece di quella originale
        return new RealisticTrain(id, owner);
    }
}
