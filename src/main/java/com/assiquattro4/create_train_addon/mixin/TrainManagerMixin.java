package com.assiquattro4.create_train_addon.mixin;

import com.assiquattro4.create_train_addon.entity.RealisticTrain;
import com.simibubi.create.content.trains.entity.Train;
import com.simibubi.create.content.trains.entity.TrainManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.UUID;

@Mixin(value = TrainManager.class, remap = false)
public class TrainManagerMixin {

    // Questo reindirizza la creazione di un NUOVO treno
    @Redirect(
        method = "create",
        at = @At(value = "NEW", target = "com/simibubi/create/content/trains/entity/Train")
    )
    private Train onNewTrain(UUID id, UUID owner) {
        return new RealisticTrain(id, owner);
    }

    // Questo reindirizza il CARICAMENTO da NBT (fondamentale per la stabilità)
    @Redirect(
        method = "read",
        at = @At(value = "NEW", target = "com/simibubi/create/content/trains/entity/Train")
    )
    private Train onLoadTrain(UUID id, UUID owner) {
        return new RealisticTrain(id, owner);
    }
}
