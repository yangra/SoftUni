package emergency.interfaces;

public interface Register {

    void enqueueEmergency(Emergency emergency);

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    boolean isEmpty();

    int size();
}
