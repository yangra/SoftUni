package _02Blobs.models.attacks;

import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Blob;

public class Blobplode implements Attack {
    private static final int ATTACKER_HEALTH_DIVIDE = 2;
    private static final int ATTACKER_DAMAGE_MULTIPLY = 2;

    @Override
    public void execute(Blob attacker, Blob target) {
        attacker.setHealth(attacker.getHealth() - attacker.getHealth() / ATTACKER_HEALTH_DIVIDE);
        target.setHealth(target.getHealth() - attacker.getDamage() * ATTACKER_DAMAGE_MULTIPLY);
    }
}
