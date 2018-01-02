package _02Blobs.models;

import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.interfaces.Blob;

public class BlobImpl implements Blob {

    private String name;
    private int initialHealth;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;

    public BlobImpl(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.initialHealth = health;
        this.currentHealth = health;

        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
    }

    @Override
    public int getHealth() {
        return this.currentHealth;
    }

    @Override
    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    @Override
    public void attack(Blob target) {
        if (this.currentHealth == 0 || target.getHealth() == 0) {
            return;
        }
        this.attack.execute(this, target);
    }

    @Override
    public void triggerBehavior() {
        this.behavior.trigger(this);
    }


    @Override
    public void update() {

        if (this.behavior.isTriggered() && this.currentHealth > 0) {
            this.behavior.applyRecurrentEffect(this);
        }
    }


    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.name);
        }

        return String.format("Blob %s: %s HP, %s Damage", this.name, this.getHealth(), this.getDamage());
    }
}
