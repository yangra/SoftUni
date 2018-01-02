package _02Blobs.models.behavors;

import _02Blobs.interfaces.Behavior;
import _02Blobs.interfaces.Blob;
import _02Blobs.models.BlobImpl;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean updateRecurrently;

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    protected boolean getUpdateRecurrently() {
        return this.updateRecurrently;
    }

    protected void setUpdateRecurrently(boolean updateRecurrently) {
        this.updateRecurrently = updateRecurrently;
    }
}
