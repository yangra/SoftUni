package emergency.collection;


import emergency.interfaces.Emergency;
import emergency.interfaces.Register;


public class EmergencyRegister implements Register {

    private static final int INITIAL_SIZE = 16;

    private Emergency[] emergencyQueue;

    private int currentSize;

    private int nextIndex;

    public EmergencyRegister() {
        this.emergencyQueue = new Emergency[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        Emergency[] newArray = new Emergency[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }

    public void enqueueEmergency(Emergency emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }

    public Emergency dequeueEmergency() {
        Emergency removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize - 1; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    public Emergency peekEmergency() {
        Emergency peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int size(){ return this.currentSize; }
}
