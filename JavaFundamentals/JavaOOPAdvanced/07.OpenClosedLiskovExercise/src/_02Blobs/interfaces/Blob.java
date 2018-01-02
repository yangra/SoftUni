package _02Blobs.interfaces;

public interface Blob {

    int getHealth();

    void setHealth(int health);

    int getDamage();

    String getName();

    void setDamage(int currentDamage);

    void attack(Blob target);

    void update();

    void triggerBehavior();
}
