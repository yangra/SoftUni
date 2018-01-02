package rpg.models;

import rpg.interfaces.Target;
import rpg.interfaces.Weapon;
import rpg.utilities.RandomProvider;

import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon giveLoot(RandomProvider random){
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.possibleLoot.get(random.nextInt(this.possibleLoot.size()));
    }
}
