package _04WorkForce.models;


import _04WorkForce.interfaces.ObservableAction;
import _04WorkForce.interfaces.ObservationInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ObserverImpl implements ObservationInfo {

    private static ObservationInfo observer;

    private List<ObservableAction> jobsDone;

    private ObserverImpl() {
        this.jobsDone = new ArrayList<>();
    }

     public static ObservationInfo instance(){
        if(observer==null){
            observer = new ObserverImpl();
        }
        return observer;
     }

    @Override
    public void notifyObserver(ObservableAction job){
        this.jobsDone.add(job);
    }

    @Override
    public List<ObservableAction> getFinished() {
        return Collections.unmodifiableList(this.jobsDone);

    }

    @Override
    public void emptyNotifications() {
        this.jobsDone.clear();

    }
}
