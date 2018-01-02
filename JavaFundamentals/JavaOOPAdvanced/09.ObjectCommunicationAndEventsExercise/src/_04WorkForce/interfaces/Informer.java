package _04WorkForce.interfaces;

import java.util.List;

public interface Informer {
    List<ObservableAction> getFinished();

    void emptyNotifications();
}
