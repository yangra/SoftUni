package _02Blobs.models.behavors;

import _02Blobs.interfaces.Blob;

public class Inflated extends AbstractBehavior {

    private static final int INFLATED_TRIGGER_HEALTH_ADD = 50;
    private static final int INFLATED_RECURRENT_HEALTH_DECREMENT = 10;

    @Override
    public void trigger(Blob blob) {
        super.setIsTriggered(true);
        blob.setHealth(blob.getHealth() + INFLATED_TRIGGER_HEALTH_ADD);
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {
        if (super.getUpdateRecurrently()) {
            blob.setHealth(blob.getHealth() - INFLATED_RECURRENT_HEALTH_DECREMENT);
        } else {
            super.setUpdateRecurrently(true);
        }
    }
}
