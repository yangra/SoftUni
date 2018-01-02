package _01Logger.loggers;

import _01Logger.interfaces.Handler;

public abstract class AbstractLogger implements Handler {

    private Handler successor;

    protected Handler getSuccessor() {
        return this.successor;
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }


}
