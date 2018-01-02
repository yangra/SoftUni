package _02Blobs.factories;

import _02Blobs.interfaces.Attack;
import _02Blobs.models.attacks.Blobplode;
import _02Blobs.models.attacks.PutridFart;

public final class AttackFactory {

    private AttackFactory() {
    }

    public static Attack create(String type){
        if("Blobplode".equalsIgnoreCase(type)){
            return  new Blobplode();
        }else{
            return new PutridFart();
        }
    }
}
