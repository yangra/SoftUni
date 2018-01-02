package _02Blobs.factories;

import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.interfaces.Blob;
import _02Blobs.models.BlobImpl;

public final class BlobFactory {

    private BlobFactory() {
    }

    public static Blob createBlob(String name, int health, int damage, Behavior behavior, Attack attack){
        return  new BlobImpl(name,health,damage, behavior, attack);
    }
}
