package rpg.interfaces;

import rpg.utilities.RandomProvider;

public interface Target {

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    Weapon giveLoot(RandomProvider random);
}
