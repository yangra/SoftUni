package _04Observer.loggers;

import _04Observer.enums.LogType;

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
