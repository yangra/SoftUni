package _01Logger.loggers;

import _01Logger.enums.LogType;

public class CombatLogger extends AbstractLogger {
    @Override
    public void handle(LogType type, String message) {
        if(type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.println(type.name() + ": " + message);
        }else{
            super.getSuccessor().handle(type,message);
        }
    }

}
