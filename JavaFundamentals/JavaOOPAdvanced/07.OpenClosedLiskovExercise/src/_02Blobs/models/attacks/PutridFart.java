package _02Blobs.models.attacks;

import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        target.setHealth(target.getHealth() - attacker.getDamage());
    }
}
