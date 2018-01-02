package _03Mediator.loggers;

import _03Mediator.enums.LogType;

public class EventLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {
        if(type == LogType.EVENT ) {
            System.out.println(type.name() + ": " + message);
        }else{
            if(super.getSuccessor()!=null){
            super.getSuccessor().handle(type,message);}
        }
    }


}
