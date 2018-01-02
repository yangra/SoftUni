package _05KingsGambitExtended;

import _05KingsGambitExtended.interfaces.AttackableSubject;
import _05KingsGambitExtended.interfaces.Observer;

public class Handler {

  public void handleKill(Observer observer, AttackableSubject subject){
       if(observer.getHealth() <= 0) {
           subject.unregister(observer);
       }
    }
}
