package com.assiquattro4.create_train_addon.mixin;

import com.assiquattro4.create_train_addon.physics.CollisionHandler;
import com.simibubi.create.content.trains.entity.Train;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Train.class, remap = false)
public class TrainCollisionMixin {

    /**
     * Intercettiamo la collisione. 
     * Nota: Il nome del metodo (es: "handleCollision") deve corrispondere 
     * esattamente a quello presente nel codice sorgente di Create 
     * che gestisce gli impatti. Verifica con un decompiler se il nome differisce.
     */
    @Inject(method = "handleCollision", at = @At("HEAD"), cancellable = true)
    private void onCollision(Train other, CallbackInfo ci) {
        // Annulliamo il crash di default di Create
        ci.cancel(); 
        
        // Eseguiamo la nostra logica di "buffering" / spinta
        CollisionHandler.resolveCollision((Train) (Object) this, other);
    }
}
