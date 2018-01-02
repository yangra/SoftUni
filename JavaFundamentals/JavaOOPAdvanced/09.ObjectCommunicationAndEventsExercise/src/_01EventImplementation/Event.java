package _01EventImplementation;

import java.util.EventObject;

public class Event extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(Dispatcher source) {
        super(source);
    }
}
