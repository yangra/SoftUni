package _04Observer.interfaces;

import _04Observer.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
