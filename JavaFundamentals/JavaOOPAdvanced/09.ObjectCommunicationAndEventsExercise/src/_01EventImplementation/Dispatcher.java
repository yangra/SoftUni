package _01EventImplementation;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.name = "";
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent(name);
    }

    void addNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.add(listener);
    }

    void removeNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.remove(listener);
    }

    void fireNameChangeEvent(String change){
        NameChange nameChange = new NameChange(change);
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
            nameChangeListener.handleChangedName(nameChange);
        }
    }
}
