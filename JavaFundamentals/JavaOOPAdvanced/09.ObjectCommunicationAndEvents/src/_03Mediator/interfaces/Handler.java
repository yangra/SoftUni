package _03Mediator.interfaces;

import _03Mediator.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
