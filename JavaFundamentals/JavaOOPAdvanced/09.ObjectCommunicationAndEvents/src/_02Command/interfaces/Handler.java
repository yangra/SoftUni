package _02Command.interfaces;

import _02Command.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
