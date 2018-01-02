package _04Observer.loggers;

import _04Observer.enums.LogType;

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
