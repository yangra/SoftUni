package _03Mediator.loggers;

import _03Mediator.enums.LogType;

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
