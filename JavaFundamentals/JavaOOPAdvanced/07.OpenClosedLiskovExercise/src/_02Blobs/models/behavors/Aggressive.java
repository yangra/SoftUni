package _02Blobs.models.behavors;

import _02Blobs.interfaces.Blob;

public class Aggressive extends AbstractBehavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int blobInitialDamage;

    @Override
    public void trigger(Blob blob) {
        super.setIsTriggered(true);
        this.blobInitialDamage = blob.getDamage();
        blob.setDamage(blob.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }


    @Override
    public void applyRecurrentEffect(Blob blob) {
        if (super.getUpdateRecurrently()) {
            blob.setDamage(blob.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

            if (blob.getDamage() <= this.blobInitialDamage) {
                blob.setDamage(this.blobInitialDamage);
            }
        }
        super.setUpdateRecurrently(true);
    }


}
