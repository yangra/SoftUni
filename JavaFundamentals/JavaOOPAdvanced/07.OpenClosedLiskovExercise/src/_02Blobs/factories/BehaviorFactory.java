package _02Blobs.factories;

import _02Blobs.interfaces.Behavior;
import _02Blobs.models.behavors.Aggressive;
import _02Blobs.models.behavors.Inflated;

public final class BehaviorFactory {
    private BehaviorFactory() {
    }

    public static Behavior create(String type){
        if("Aggressive".equalsIgnoreCase(type)){
            return new Aggressive();
        }else{
            return new Inflated();
        }
    }
}
