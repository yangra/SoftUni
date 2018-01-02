package _01Logger.interfaces;

import _01Logger.enums.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
