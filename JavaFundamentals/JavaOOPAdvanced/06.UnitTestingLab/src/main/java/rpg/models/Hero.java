package rpg.models;

import rpg.interfaces.Target;
import rpg.interfaces.Weapon;
import rpg.utilities.RandomProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon ) {
        this.name = name;
        this.weapon = weapon;
        this.experience = 0;
        this.inventory = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target, RandomProvider random) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.giveLoot(random));
        }
    }

    public Iterable<Weapon> getInventory(){
        return Collections.unmodifiableList(this.inventory);
    }
}
